package ABC_Demo006_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DtaProvider_Lab1_static {
	
	
static WebDriver driver;
	
	static String Username = "Admin", Password= "admin123";
	static String JobTitle="Selenium01", JobDiscription = "Selenium011", JobNote = "Selenium0111";
	
	
	@DataProvider(name="Test_Case1")
	public static Object[][] Test1() throws Exception {
		
		return new Object[][]   {
			
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium01","Selenium011","Selenium0111"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium02","Selenium012","Selenium0112"},
			{"https://opensource-demo.orangehrmlive.com/","Admin","admin123","Selenium03","Selenium013","Selenium0113"},
			
			
		};
		
		
		
	}
	
		
  @Test(dataProvider = "Test_Case1")
  public void Test1(String TestURL, String UserName, String Password, String JobTitle, String JobDiscription, String JobNote) throws Exception {
	  
	  DtaProvider_Lab1_static.OpenChromeBrowser();
	  DtaProvider_Lab1_static.OpenOrangeHRM(TestURL);
	  DtaProvider_Lab1_static.Login(UserName, Password);
	  DtaProvider_Lab1_static.Addjobs(JobTitle, JobDiscription, JobNote);
	 
  }
    
	  public static void OpenChromeBrowser() throws Exception{
		  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  }
	  
	  public static void OpenOrangeHRM(String TestURL) throws Exception {
	  
		  driver.get(TestURL);
	  
	  }
	  
	  public static void Login(String UserName, String Password) throws Exception {
	  
		  findElement(By.id("txtUsername")).sendKeys(UserName);
		  findElement(By.id("txtPassword")).sendKeys(Password);
		  findElement(By.id("btnLogin")).click();
		
	  }
	  
	  public static void Addjobs(String JobTitle, String JobDiscription, String JobNote) throws Exception {
			  
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

  public static  WebElement findElement(By by) throws Exception {

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
	 
		}
		return elem;

}
}


  
