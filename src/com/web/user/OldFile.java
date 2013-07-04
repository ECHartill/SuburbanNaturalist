package com.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.helpers.FileUploadHelper;
import com.helpers.ValidationHelper;
import com.models.User;
import com.parents.SuburbanNaturalistHttpServlet;

public class OldFile //extends SuburbanNaturalistHttpServlet
{
	private static final long serialVersionUID = -8413948724519327277L;

//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//		this.doPost(request, response);
//	}
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//		User user = (User)request.getSession().getAttribute("user");
//		String action = request.getParameter("action");
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//
//		if(action == null)
//		{
//			this.forward(request, response, "/jsp/user/upload.jsp");
//		}
//		if(action != null && action.length() > 0)
//		{
//			if(isMultipart)
//			{
//			ValidationHelper vh = new ValidationHelper();
//			FileUploadHelper fuh = new FileUploadHelper();
//
//				//will continue validation when necessary - it may not be if we can resize images
//				//		    errors.addAll(vh.validateFileUpload(filePart));
//
//				if(errors.size() == 0)
//				{
//					try
//					{
//						errors.addAll(fuh.uploadFile(request, user));
//					}
//					catch(FileUploadException fue)
//					{
//						
//					}
//					catch(Exception e)
//					{
//						
//					}
//				}
//
//				if(errors.size() != 0)
//				{
//					this.forward(request, response, "/jsp/user/upload.jsp");
//				}
//				else
//				{
//					this.forward(request, response, "/");
//				}
//			}
//		}
//	}

}
