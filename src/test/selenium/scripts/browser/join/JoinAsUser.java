package test.selenium.scripts.browser.join;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.selenium.scripts.browser.parents.Join;

public class JoinAsUser extends Join
{
	protected String USER_FIRSTNAME = "Eric";
	protected String USER_LASTNAME = "One";
	protected String USER_EMAIL = "ericalphaone@yahoo.com";
	protected String INVALID_EMAIL_ONE = "ericalphaone@yahoo";
	protected String INVALID_EMAIL_TWO = "ericalphaoneyahoo.com";
	protected String INVALID_EMAIL_THREE = "ericalphaoneyahoocom";
	protected String USER_PASSWORD = "1qweqwe1";
	protected String OTHER_PASSWORD = "ewqewq";

	@BeforeTest
	public void gotoJoinPage()
	{
		browser = new HtmlUnitDriver();
		browser.get(url);
	}

	//	@Test
	//TODO: find random data generator
	public void userJoinsSubNat()
	{
		firstname.sendKeys(USER_FIRSTNAME);
		lastname.sendKeys(USER_LASTNAME);
		email.sendKeys(USER_EMAIL);
		password.sendKeys(USER_PASSWORD);
		confirm.sendKeys(USER_PASSWORD);
		confirm.submit();

	}

	@Test
	public void userJoinsMissingFields()
	{
		System.out.println("User Join missing fields");
		for(int x = 0; x < 5; x++)
		{
			//need to find elements again after each page load
			firstname = browser.findElement(By.id(firstname_id));
			lastname = browser.findElement(By.id(lastname_id));
			email = browser.findElement(By.id(email_id));
			password = browser.findElement(By.id(password_id));
			confirm = browser.findElement(By.id(confirm_id));

			firstname.clear();
			lastname.clear();
			email.clear();
			password.clear();
			confirm.clear();

			firstname.sendKeys(USER_FIRSTNAME);
			lastname.sendKeys(USER_LASTNAME);
			email.sendKeys(USER_EMAIL);
			password.sendKeys(USER_PASSWORD);
			confirm.sendKeys(USER_PASSWORD);
			
			switch (x)
			{
			case 0:
				firstname.clear();
				confirm.submit();
				error = browser.findElement(By.id(errors_id));
				assert error.getText().equals("First Name cannot be empty");
				break;
			case 1:
				lastname.clear();
				confirm.submit();
				error = browser.findElement(By.id(errors_id));
				assert error.getText().equals("Last Name cannot be empty");
				break;
			case 2:
				email.clear();
				confirm.submit();
				error = browser.findElement(By.id(errors_id));
				assert error.getText().equals("Email cannot be empty");
				break;
			case 3:
				password.clear();
				confirm.submit();
				error = browser.findElement(By.id(errors_id));
				assert error.getText().equals("Password cannot be empty");
				break;
			case 4:
				confirm.clear();
				confirm.submit();
				error = browser.findElement(By.id(errors_id));
				assert error.getText().equals("Password Confirm cannot be empty");
				break;
			}
		}
	}

	@Test
	public void userJoinsPasswordsDoNotMatch()
	{
		firstname = browser.findElement(By.id(firstname_id));
		lastname = browser.findElement(By.id(lastname_id));
		email = browser.findElement(By.id(email_id));
		password = browser.findElement(By.id(password_id));
		confirm = browser.findElement(By.id(confirm_id));

		firstname.sendKeys(USER_FIRSTNAME);
		lastname.sendKeys(USER_LASTNAME);
		email.sendKeys(USER_EMAIL);
		password.sendKeys(USER_PASSWORD);
		confirm.sendKeys(OTHER_PASSWORD);
		confirm.submit();

		error = browser.findElement(By.id(error_id + "1"));
		assert error.getText().equals("The passwords do not match");
	}

	@Test
	public void userJoinsInvalidEmail()
	{
		for(int x = 0; x < 3; x++)
		{
			firstname = browser.findElement(By.id(firstname_id));
			lastname = browser.findElement(By.id(lastname_id));
			email = browser.findElement(By.id(email_id));
			password = browser.findElement(By.id(password_id));
			confirm = browser.findElement(By.id(confirm_id));

			firstname.clear();
			lastname.clear();
			email.clear();
			password.clear();
			confirm.clear();

			firstname.sendKeys(USER_FIRSTNAME);
			lastname.sendKeys(USER_LASTNAME);
			password.sendKeys(USER_PASSWORD);
			confirm.sendKeys(USER_PASSWORD);

			switch(x)
			{
			case 0:
				email.sendKeys(INVALID_EMAIL_ONE);
				break;
			case 1:
				email.sendKeys(INVALID_EMAIL_TWO);
				break;
			case 2:
				email.sendKeys(INVALID_EMAIL_THREE);
				break;
			}
			confirm.submit();

			error = browser.findElement(By.id(error_id + "1"));
			assert error.getText().equals("The email is not well formed");
		}
	}

}
