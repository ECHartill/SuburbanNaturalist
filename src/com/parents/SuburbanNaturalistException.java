package com.parents;

public class SuburbanNaturalistException extends Exception
{
	private static final long serialVersionUID = -3599803706330685108L;

	public SuburbanNaturalistException(String message)
	{
		super(message);
	}
	public SuburbanNaturalistException(Exception e)
	{
		super(e);
	}
}
