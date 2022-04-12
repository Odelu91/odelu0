package ABC_Demo007_DataProvider2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class DataProvider_Lab2_2 {
	
	static WebDriver driver;
	
	 
	 @DataProvider(name = "TestDataProvider3")
	 public Object[] myDataProvider() {
	      
	     Object data[][]=  new Object[3][5];
	     // First student details
	     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[0][1]= "Admin";
	     data[0][2]= "admin123";
	     data[0][3]= "Java10";
	     data[0][4]= "Java10 descr";
	      
	     // Second student details
	     data[1][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[1][1]= "Admin";
	     data[1][2]= "admin123";
	     data[1][3]= "Java11";
	     data[1][4]= "Java11 descr";
	     
	     data[2][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[2][1]= "Admin";
	     data[2][2]= "admin123";
	     data[2][3]= "Java9";
	     data[2][4]= "Java9 descr";
	     
	      return data;
	   	 }
	 
	 @DataProvider(name = "TestDataProvider4")
	 
	 public static Object[][] Authentication1() throws Exception {
		 
		 ExcelApiTest4 T3 = new ExcelApiTest4();
		 Object[][] testObjArray = T3.getTableArray("F://Selinium Automation Testing//Softwares//OrangeHRM11//HTML Report//OrangeHRM6//TC01_Skills78.xlsx", "Sheet1");
		 		System.out.println(testObjArray.length);
		 return (testObjArray);
		 
		 
	 }
	 
  @Test(dataProvider ="TestDataProvider4")
  public void Test_Lab_Case2(String TestURL, String Username, String Password, String SkillName, String SkillDescription) throws Exception {
 
	  DataProvider_Lab2_2 T1 = new DataProvider_Lab2_2();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);
	  T1.Login(Username,Password);
	  T1.AddSkills(SkillName,SkillDescription);
	  
  }
  
	  public void OpenChromeBrowser() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  
	  }
	  
	  public void OpenOrangeHRM(String TestURL) throws Exception {
	  
           driver.get(TestURL);
	  }
	  
	  public void Login(String Username, String Password) throws Exception {
	  
	  
  findElement(By.id("txtUsername")).sendKeys(Username);
	findElement(By.id("txtPassword")).sendKeys(Password);
	findElement(By.id("btnLogin")).click();
	  }
	  
	  public void AddSkills(String SkillName, String SkillDescription) throws Exception {
	
	findElement(By.id("menu_admin_viewAdminModule")).click();
	findElement(By.id("menu_admin_Qualifications")).click();
	findElement(By.id("menu_admin_viewSkills")).click();
	findElement(By.id("btnAdd")).click();
	findElement(By.id("skill_name")).sendKeys(SkillName);
	findElement(By.id("skill_description")).sendKeys(SkillDescription);
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
  
  

