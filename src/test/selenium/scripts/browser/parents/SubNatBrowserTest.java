package test.selenium.scripts.browser.parents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SubNatBrowserTest
{
	protected String url = "http://localhost:8080/SubNat";
	protected WebDriver browser;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void gotoJoinPage(String testBrowser)
	{
		if("firefox".equalsIgnoreCase(testBrowser))
		{
			browser = new FirefoxDriver();
		}
		else if("htmlunit".equalsIgnoreCase(testBrowser))
		{
			browser = new HtmlUnitDriver();
		}
		
		browser.get(url);
	}

	@AfterMethod
	public void closeBrowser()
	{
		browser.close();
	}
	
	protected void sleep(long millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch(InterruptedException ie){}
	}
}
