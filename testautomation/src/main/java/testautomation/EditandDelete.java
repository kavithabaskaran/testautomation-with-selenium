package testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditandDelete {
	public WebDriver driver;
	public WebElement element;
	String URL = "http://computer-database.herokuapp.com/computers";
	
	@BeforeClass
	public void testSetUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Personal\\Kavi\\testautomate\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("launch chrome browser");
	}
	
	@Test(priority=1)
	public void editComputer() throws Exception{
		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[9]/td[1]/a")).click();
		if(driver.findElement(By.xpath("//*[@id=\"main\"]/h1")).getText()== "Edit computer") {
			String computerName=driver.findElement(By.name("name")).getAttribute("value");
			String introducedDate=driver.findElement(By.name("introduced")).getAttribute("value");
			String discontinuedDate=driver.findElement(By.name("discontinued")).getAttribute("value");
			if((computerName).isEmpty()) {
				driver.findElement(By.name("name")).sendKeys("Dell inpire new black");
			}else {
				driver.findElement(By.name("name")).getAttribute("value");
			}
			if((introducedDate).isEmpty()) {
				driver.findElement(By.name("introduced")).sendKeys("2010-02-12");
			}else {
				driver.findElement(By.name("introduced")).getAttribute("value");
			}
			if((discontinuedDate).isEmpty()) {
				driver.findElement(By.name("discontinued")).sendKeys("2010-02-12");
			}else {
				driver.findElement(By.name("discontinued")).getAttribute("value");
			}
			driver.findElement(By.xpath("//*[@id=\"main\"]/form[1]/div/input")).submit();
			System.out.println("Submit Saved Computer details ");
		}else {
			System.out.println("wrong details page");
		}
		System.out.println("Saved Computer details");
   }
	
	@Test(priority=2)
	public void deleteComputer() throws Exception{
		driver.get(URL);
		//find 7th element from the list of computers and click
		driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[7]/td[1]/a")).click();
		//Go to computer details page and click on delete button
		driver.findElement(By.xpath("//*[@id=\"main\"]/form[2]/input")).submit();
		String bodyText = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]")).getText();
		System.out.println("Deleted" + bodyText);
		Assert.assertEquals(bodyText, "Done! Computer has been deleted");
	 }
	
	@AfterClass
	public void tearDown(){
		driver.quit();
		
	}

}
