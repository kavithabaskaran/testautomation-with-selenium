package testautomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class addComputer{
	public WebDriver driver;
	public WebElement addComputer;
	String URL = "http://computer-database.herokuapp.com/computers";
	
	@BeforeClass
	public void testSetUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Personal\\Kavi\\testautomate\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("launch chrome browser");
	}
	@Test(priority=1)
	public void newComputer() {
		driver.get(URL);
		driver.findElement(By.linkText("Add a new computer")).click();
		System.out.println("CLicked on Add computer");
		String getTitle = driver.getCurrentUrl();
		Assert.assertEquals(getTitle,URL+"/new");
		System.out.println("Add Computer page");
	}
	@Test(priority=2)
	public void addComputerdetails() {
		driver.findElement(By.name("name")).sendKeys("Dell inpire");
		driver.findElement(By.name("introduced")).sendKeys("1999-08-12");
		driver.findElement(By.name("discontinued")).sendKeys("2001-09-21");
		
		Select dropcompany = new Select(driver.findElement(By.id("company")));
		dropcompany.selectByVisibleText("IBM");
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input")).submit();
		System.out.println("title of page is: " + driver.getTitle());
		// Switching to Alert        
        driver.findElement(By.className("alert-message"));
        System.out.println("new computer added");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
}
