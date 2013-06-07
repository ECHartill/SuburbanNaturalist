package test.selenium.scripts.htmlunit.login;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class LoginUser extends Login
{
	//TODO: find random data generator
	protected String VALID_USER_USERNAME = "erichartill@gmail.com";
	protected String INVALID_USER_USERNAME = "ericalphaone@gmail.com";
	protected String VALID_USER_PASSWORD = "1qweqwe";
	protected String INVALID_USER_PASSWORD = "ewqewq1";
	
	@Test
	public void validLogin()
	{
		browser = new HtmlUnitDriver();
		browser.get(url);
		username = browser.findElement(By.id(username_id));
		password = browser.findElement(By.id(password_id));
		username.sendKeys(VALID_USER_USERNAME);
		password.sendKeys(VALID_USER_PASSWORD);
		password.submit();
		successful_login = browser.findElement(By.id(successful_login_id));
		
		assert successful_login.getText().equals("HELLO!");
	}
	
	@Test
	public void invalidUsernameLogin()
	{
		browser = new HtmlUnitDriver();
		browser.get(url);
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
		browser = new HtmlUnitDriver();
		browser.get(url);
		username = browser.findElement(By.id(username_id));
		password = browser.findElement(By.id(password_id));
		username.sendKeys(VALID_USER_USERNAME);
		password.sendKeys(INVALID_USER_PASSWORD);
		password.submit();
		failed_login = browser.findElement(By.id(failed_login_id));
		
		assert failed_login.getText().equals("That user password combination was not found");
	}
}
