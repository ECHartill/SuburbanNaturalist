package com.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.helpers.FileUploadHelper;
import com.helpers.ValidationHelper;
import com.models.User;
import com.parents.SuburbanNaturalistHttpServlet;

@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class UploadServlet extends SuburbanNaturalistHttpServlet
{
	private static final long serialVersionUID = -8413948724519327277L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Part filePart;
		String fileName = "";
	    User user = (User)request.getSession().getAttribute("user");
	    String action = request.getParameter("action");
		
		if(action == null)
		{
			this.forward(request, response, "/jsp/user/upload.jsp");
		}
		if(action != null && action.length() > 0)
		{
			FileUploadHelper fuh = new FileUploadHelper();
			ValidationHelper vh = new ValidationHelper();
			
		    filePart = request.getPart("file");
		    fileName = request.getParameter("filename");

		    //will continue validation when necessary - it may not be if we can resize images
//		    errors.addAll(vh.validateFileUpload(filePart));
		    
		    if(errors.size() == 0)
		    {
		    	errors.addAll(fuh.uploadFile(filePart, fileName, user));
		    }
		    
			if(errors.size() != 0)
			{
				this.forward(request, response, "/jsp/user/upload.jsp");
			}
			else
			{
				this.forward(request, response, "/");
			}
		}
	}
	
}
