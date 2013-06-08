package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.HibernateDatabaseManager;
import com.helpers.Encryptor;
import com.models.User;
import com.parents.SuburbanNaturalistException;
import com.parents.SuburbanNaturalistHttpServlet;

public class LoginServlet extends SuburbanNaturalistHttpServlet
{
	private static final long serialVersionUID = 8020498799316191565L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request,  response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		errors.clear();
		String action = request.getParameter("action");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Encryptor e = Encryptor.getInstance();
		HibernateDatabaseManager hdbm = new HibernateDatabaseManager();
		User user = (User)request.getSession().getAttribute("user");
		
		if(action == null && user != null)
		{
			//logged in, clicked logout link
			request.getSession().setAttribute("user", null);
			this.forward(request, response, "/");
		}
		else if(action == null && user == null)
		{
			this.forward(request, response, "/");
		}
		else if(action.equalsIgnoreCase("login"))
		{
			if(username == null || username.length() == 0)
			{
				errors.add("You must enter a username");
			}
			if(password == null || password.length() == 0)
			{
				errors.add("You must enter a password");
			}
			if(errors.size() > 0)
			{
				this.forward(request, response, "/");
			}
			else
			{
				try
				{
					user = hdbm.login(username, e.encrypt(password));
				}
				catch (SuburbanNaturalistException we)
				{
					System.out.println("Error logging in: " + we.getMessage());
					errors.add("That user password combination was not found");
				}
				
				request.getSession().setAttribute("user", user);
				if(errors.size() > 0)
				{
					this.forward(request, response, "/");
				}
				else
				{
					this.forward(request, response, "/jsp/user/home.jsp");
				}
			}
		}
	}
}
