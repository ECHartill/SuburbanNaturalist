package com.models;

import java.sql.Date;

public class Image
{
	private Integer id;
	private Integer userId;
	private String imagePath;
	private String fileName;
	private Date uploaded;
	private Date shared;
	private Date lastEdited;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public String getImagePath()
	{
		return imagePath;
	}
	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}
	public String getfileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public Date getUploaded()
	{
		return uploaded;
	}
	public void setUploaded(Date uploaded)
	{
		this.uploaded = uploaded;
	}
	public Date getShared()
	{
		return shared;
	}
	public void setShared(Date shared)
	{
		this.shared = shared;
	}
	public Date getLastEdited()
	{
		return lastEdited;
	}
	public void setLastEdited(Date lastEdited)
	{
		this.lastEdited = lastEdited;
	}
	
}
