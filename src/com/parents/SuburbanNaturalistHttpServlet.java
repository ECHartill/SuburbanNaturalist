package com.parents;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuburbanNaturalistHttpServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6063276226361967817L;
	protected ArrayList<String> errors = new ArrayList<String>();
	
	protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException
	{
		//Always set the errors
		request.setAttribute("errors", errors);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
