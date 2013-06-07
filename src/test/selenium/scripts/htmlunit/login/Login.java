package test.selenium.scripts.htmlunit.login;

import org.openqa.selenium.WebElement;

import test.selenium.scripts.htmlunit.SubNatBaseScript;

public class Login extends SubNatBaseScript
{
	protected String url = "http://localhost:8080/SuburbanNaturalist/";
	protected String username_id = "login_username";
	protected String password_id = "login_password";
	protected String successful_login_id = "hello";
	protected String failed_login_id = "error_list_1";
	
	protected WebElement username;
	protected WebElement password;
	protected WebElement successful_login;
	protected WebElement failed_login;

}