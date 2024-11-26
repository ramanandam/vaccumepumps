package com.flowserve.vaccumepump.webservice.exception;

public class VaccumePumpsException extends Exception {

	

	private final int status;

	public VaccumePumpsException(String message)
	{
		this(0, message);
	}

	public VaccumePumpsException(String message, Throwable cause)
	{
		this(0, message, cause);
	}

	public VaccumePumpsException(int status, String message)
	{
		super(message);

		this.status = status;
	}

	public VaccumePumpsException(int status, String message, Throwable cause)
	{
		super(message, cause);

		this.status = status;
	}

	public int getStatus()
	{
		return status;
	}

	
}
