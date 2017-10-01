package testautomation;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

 
public class homePage extends Basesetup{
		
	@Test(priority=1)
	public void verifyHomePageTittle(){
		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, "Computers database");
		System.out.println("Title of web page");
	}
	
	@Test(priority=2)
	public void searchComputerName() throws InterruptedException{
		computerName = driver.findElement(By.id("searchbox"));
		computerName.clear();
		computerName.sendKeys("ARRA");
		driver.findElement(By.xpath("//*[@id=\"searchsubmit\"]")).click();
		String resultText = driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr/td[1]")).getText();
		Assert.assertEquals("ARRA", resultText);
		System.out.println("Search Computer finished");
   }
    
	
	
}
 
 