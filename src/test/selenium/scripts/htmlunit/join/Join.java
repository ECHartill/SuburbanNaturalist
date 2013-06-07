package test.selenium.scripts.htmlunit.join;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import test.selenium.scripts.htmlunit.SubNatBaseScript;

public class Join extends SubNatBaseScript
{
	protected String url = "http://localhost:8080/SuburbanNaturalist/signup";
	protected String firstname_id = "signup_firstname";
	protected String lastname_id = "signup_lastname";
	protected String email_id = "signup_email";
	protected String password_id = "signup_password";
	protected String confirm_id = "signup_confirm";
	//for individual errors; need to append counter (counter starts at 1)
	protected String error_id = "error_list_";
	protected String errors_id = "errors_list";

	protected WebElement firstname;
	protected WebElement lastname;
	protected WebElement email;
	protected WebElement password;
	protected WebElement confirm;
	protected WebElement error;
	protected ArrayList<WebElement> errors;
}
