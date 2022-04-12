package ABC_Demo005_Advance_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OR_AND_Xpath {
	
	WebDriver driver;
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String Username_Xpath="//*[@type='text' or @name='txtUsername']"; not working
	//String Password_Xpath="//*[@type='text' or @name='txtPassword']";
	
	
	String Login_Xpath="//*[@type='submit' or @id='btnLogin']";

	
	
	
  @Test
  public void Or_And()throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\Chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(TestURL);
	  
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.xpath(Login_Xpath)).click();
	  
	  driver.close();
	  
	  
  }
}
