package test.selenium.scripts.browser.parents;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class SubNatBrowserTest
{
	protected String url = "http://localhost:8080/SubNat";
	protected WebDriver browser;
	
	@AfterMethod
	public void closeBrowser()
	{
		browser.close();
	}
}
