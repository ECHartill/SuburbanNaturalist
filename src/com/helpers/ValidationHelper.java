package com.helpers;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Part;

public class ValidationHelper
{
	public void validateSignup(HashMap<String, String> params, ArrayList<String> errors)
	{
		boolean pwd = true;
		boolean pwdcfm = true;
		
		if(params.get("firstname") == null || params.get("firstname").length() == 0)
		{
			errors.add("First Name cannot be empty");
		}
		if(params.get("lastname") == null || params.get("lastname").length() == 0)
		{
			errors.add("Last Name cannot be empty");
		}
		if(params.get("email") == null || params.get("email").length() == 0)
		{
			errors.add("Email cannot be empty");
		}
		else
		{
			// check that emal is well-formed
			if(!params.get("email").contains("@") || !params.get("email").contains("."))
			{
				errors.add("The email is not well formed");
			}
			
		}
		if(params.get("password") == null || params.get("password").length() == 0)
		{
			pwd = false;
			errors.add("Password cannot be empty");
		}
		if(params.get("confirm") == null || params.get("confirm").length() == 0)
		{
			pwdcfm = false;
			errors.add("Password Confirm cannot be empty");
		}
		if(pwd && pwdcfm && !params.get("password").equals(params.get("confirm")))
		{
			errors.add("The passwords do not match");
		}
	}

	public ArrayList<String> validateFileUpload(Part part)
	{
		ArrayList<String> errors = new ArrayList<String>();
		
	    if(part.getSize() > 2000000)
	    {
	    	errors.add("The image size must be less than 2MB");
	    }

	    return errors;
	}
}
