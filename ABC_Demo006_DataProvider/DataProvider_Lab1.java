package ABC_Demo006_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Lab1 {
	
	static WebDriver driver;
	
	
	@DataProvider(name="Test_Case1")
	public static Object[][] Test1() throws Exception {
		
		return new Object[][]   {
			
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium1","Selenium11","Selenium111"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium2","Selenium12","Selenium112"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium3","Selenium13","Selenium113"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium4","Selenium14","Selenium114"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium5","Selenium15","Selenium115"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium6","Selenium16","Selenium116"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium7","Selenium17","Selenium117"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium8","Selenium18","Selenium118"}
			
			
		};
		
		
		
	}
	
		
  @Test(dataProvider = "Test_Case1")
  public void Test1(String TestURL, String UserName, String Password, String JobTitle, String JobDiscription, String JobNote) throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(TestURL);
	  
	  findElement(By.id("txtUsername")).sendKeys(UserName);
		 findElement(By.id("txtPassword")).sendKeys(Password);
		 findElement(By.id("btnLogin")).click();
		
			  
		 findElement(By.linkText("Admin")).click();
		 findElement(By.linkText("Job")).click();
		 findElement(By.linkText("Job Titles")).click();
		 findElement(By.id("btnAdd")).click();
		 findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		 findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDiscription);
		 findElement(By.id("jobTitle_note")).sendKeys(JobNote);
		 findElement(By.id("btnSave")).click();
		 
		 
		 driver.close();
		 
  
		  }

  public  WebElement findElement(By by) throws Exception {

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
	 
		}
		return elem;

}
}


 
