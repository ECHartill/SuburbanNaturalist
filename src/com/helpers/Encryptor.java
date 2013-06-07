package com.helpers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Encryptor
{
	private static Encryptor instance = null;
	private MessageDigest md = null;

	private Encryptor(){}
	
	public synchronized String encrypt(String text)
	{
		try
		{
			md = MessageDigest.getInstance("SHA");
			md.update(text.getBytes("UTF-8"));
		}
		catch(NoSuchAlgorithmException nsae)
		{
			System.out.println("Error getting encryption algorithm: " + nsae.getMessage());
			nsae.printStackTrace();
		}
		catch(UnsupportedEncodingException uee)
		{
			System.out.println("Error encoding string: " + uee.getMessage());
			uee.printStackTrace();
		}
		
		byte raw[] = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		
		return hash;
	}

	public static Encryptor getInstance()
	{
		if(Encryptor.instance == null)
		{
			instance = new Encryptor();
		}
		return Encryptor.instance;
	}
}
