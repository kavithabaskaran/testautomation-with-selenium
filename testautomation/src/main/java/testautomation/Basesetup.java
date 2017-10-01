package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Basesetup {
	public WebDriver driver;
	public WebElement computerName;
	String URL = "http://computer-database.herokuapp.com/computers";
	
	@Test
	public void testSetUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Personal\\Kavi\\testautomate\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("launch chrome browser");
	}
	
	@Test
	public void verifyUrl() {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		String returnurl = driver.getCurrentUrl();
		Assert.assertEquals(returnurl, URL);
		System.out.println("open application url");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
}
