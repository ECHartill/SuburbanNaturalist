package test.selenium.scripts.firefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestOneFFScript
{
	@Test public void testOne()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.id("gbqfq"));
		element.sendKeys("eric hartill");
		element = driver.findElement(By.id("gbqfba"));
		element.click();
		
		System.out.println(driver.getTitle());

	}
}
