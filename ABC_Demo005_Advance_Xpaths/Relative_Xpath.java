package ABC_Demo005_Advance_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Relative_Xpath {
	
	WebDriver driver;
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String Username="Admin";
	String Password="admin123";

	
  @Test
  public void RealativeXpath()throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(TestURL);
	  
	  driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(Username);
	  driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(Password);
	  driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	  
	  driver.close();
	  
	  
	  
	  
  }
}
