package test.selenium.scripts.browser.parents;

import org.openqa.selenium.WebElement;


public class Login extends SubNatBrowserTest
{
	protected String url = "http://localhost:8080/SubNat/login";
	protected String username_id = "login_username";
	protected String password_id = "login_password";
	protected String successful_login_id = "logout_div";
	protected String failed_login_id = "error_list_1";
	
	protected WebElement username;
	protected WebElement password;
	protected WebElement successful_login;
	protected WebElement failed_login;

}