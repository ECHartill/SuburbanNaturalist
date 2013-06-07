package com.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.HibernateDatabaseManager;
import com.helpers.Encryptor;
import com.helpers.ValidationHelper;
import com.models.User;
import com.parents.SuburbanNaturalistException;
import com.parents.SuburbanNaturalistHttpServlet;

public class SignupServlet extends SuburbanNaturalistHttpServlet
{
	private static final long serialVersionUID = 4557984748642459582L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request,  response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		errors.clear();
		User user = (User) request.getSession().getAttribute("user");
		String action = request.getParameter("action");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		HashMap<String, String> params = new HashMap<String, String>();
		ValidationHelper vh = new ValidationHelper();
		HibernateDatabaseManager hdbm = new HibernateDatabaseManager();

		if(user != null)
		{
			this.forward(request, response, "/");
		}
		else
		{
			if(action == null)
			{
				//not logged in, clicked signup link
				this.forward(request, response, "/jsp/user/signup.jsp");
			}
			else if(action.equalsIgnoreCase("submit"))
			{
				params.put("firstname", firstname);
				params.put("lastname", lastname);
				params.put("email", email);
				params.put("password", password);
				params.put("confirm", confirm);
				vh.validateSignup(params, errors);

				if(errors.size() > 0)
				{
					request.setAttribute("firstname", firstname);
					request.setAttribute("lastname", lastname);
					request.setAttribute("email", email);
					request.setAttribute("password", password);
					request.setAttribute("confirm", confirm);
					this.forward(request, response, "/jsp/user/signup.jsp");
				}
				else
				{
					//create and save the user, and add to session
					User u = new User();
					Encryptor e = Encryptor.getInstance();

					u.setFirstname(firstname);
					u.setLastname(lastname);
					u.setUsername(email);
					u.setPassword(e.encrypt(password));
					try
					{
						hdbm.saveUser(u);
					}
					catch(SuburbanNaturalistException we)
					{
						System.out.println("Error saving user: " + we.getMessage());
						we.printStackTrace();
						errors.add("There was a problem saving the user");
					}

					if(errors.size() > 0)
					{
						request.setAttribute("firstname", firstname);
						request.setAttribute("lastname", lastname);
						request.setAttribute("email", email);
						request.setAttribute("password", password);
						request.setAttribute("confirm", confirm);
						this.forward(request, response, "/jsp/user/signup.jsp");
					}
					else
					{
						request.getSession().setAttribute("user", u);
						this.forward(request, response, "/");
					}
				}
			}
		}	//end of user == null
	}
}
