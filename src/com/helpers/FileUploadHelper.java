package com.helpers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.http.Part;

import com.database.HibernateDatabaseManager;
import com.models.Image;
import com.models.User;
import com.parents.SuburbanNaturalistException;

public class FileUploadHelper
{

	public ArrayList<String> uploadFile(Part part, String fileName, User user)
	{
		ArrayList<String> errors = new ArrayList<String>();
		Image image = new Image();
		HibernateDatabaseManager hdbm = new HibernateDatabaseManager();
	    Date now = new Date(new GregorianCalendar().getTimeInMillis());
		int userId = user.getId();
	    //need to append imageId after image is saved (do this in hdbm)
	    String imagePath = "/" + userId;
		
	    if(fileName == null || fileName.length() == 0)
	    {
	    	fileName = "file " + now.toString();
	    }
	    image.setUserId(user.getId());
	    image.setFileName(fileName);
	    image.setImagePath(imagePath);
	    image.setUploaded(now);
	    image.setLastEdited(now);

		try
		{
			hdbm.saveImage(image);
		}
		catch(SuburbanNaturalistException sne)
		{
			errors.add("There was a problem uploading the image");
			System.out.println("ERROR: " + sne.getMessage());
			sne.printStackTrace();
		}

		return errors;
	}
}
