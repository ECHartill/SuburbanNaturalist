package test.selenium.scripts.browser.parents;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;


public class Join extends SubNatBrowserTest
{
	protected String url = "http://localhost:8080/SubNat/signup";
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
	
	@BeforeMethod
	public void findElements()
	{
		browser.findElement(By.id("signup_link")).click();
		firstname = browser.findElement(By.id(firstname_id));
		lastname = browser.findElement(By.id(lastname_id));
		email = browser.findElement(By.id(email_id));
		password = browser.findElement(By.id(password_id));
		confirm = browser.findElement(By.id(confirm_id));
	}
}
