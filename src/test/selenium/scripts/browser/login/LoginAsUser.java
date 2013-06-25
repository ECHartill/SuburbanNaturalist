package test.selenium.scripts.browser.login;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import test.selenium.scripts.browser.parents.Login;

public class LoginAsUser extends Login
{
	//TODO: find random data generator
	protected String VALID_USER_USERNAME = "eric@eric.com";
	protected String INVALID_USER_USERNAME = "ericalphaone@gmail.com";
	protected String VALID_USER_PASSWORD = "1qweqwe";
	protected String INVALID_USER_PASSWORD = "ewqewq1";
	
	@Test
	public void validLogin()
	{
		username = browser.findElement(By.id(username_id));
		password = browser.findElement(By.id(password_id));
		username.sendKeys(VALID_USER_USERNAME);
		password.sendKeys(VALID_USER_PASSWORD);
		password.submit();
		successful_login = browser.findElement(By.id(successful_login_id));
		
		assert successful_login.getText().equals("Logout");
	}
	
	@Test
	public void invalidUsernameLogin()
	{
		username = browser.findElement(By.id(username_id));
		password = browser.findElement(By.id(password_id));
		username.sendKeys(INVALID_USER_USERNAME);
		password.sendKeys(VALID_USER_PASSWORD);
		password.submit();
		failed_login = browser.findElement(By.id(failed_login_id));
		
		assert failed_login.getText().equals("That user password combination was not found");
	}

	@Test
	public void invalidPasswordLogin()
	{
		username = browser.findElement(By.id(username_id));
		password = browser.findElement(By.id(password_id));
		username.sendKeys(VALID_USER_USERNAME);
		password.sendKeys(INVALID_USER_PASSWORD);
		password.submit();
		failed_login = browser.findElement(By.id(failed_login_id));
		
		assert failed_login.getText().equals("That user password combination was not found");
	}
	
}
