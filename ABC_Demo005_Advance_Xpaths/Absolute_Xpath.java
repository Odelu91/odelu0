package ABC_Demo005_Advance_Xpaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Absolute_Xpath {
	
	WebDriver driver;
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	
	
  @Test
  public void AbsoluteXpath()throws Exception{
  
  driver=TestBrowser.OpenChromeBrowser();
  driver.get(TestURL);
  
  //we copy full xpath from Copy-option
  driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("Admin");
  driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[3]/input")).sendKeys("admin123");
  driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[5]/input")).click();
  
  driver.close();
  
  
  }
 
	  
	  
  }

