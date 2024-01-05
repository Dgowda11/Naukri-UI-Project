package pageclasses;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.RegUser;
import BaseClasses.PageBaseClass;

public class NaukriRegPage extends PageBaseClass{

	/********All webelements on Registraionpage and associated operations*******/
	WebDriver driver;
	
	//create constructor for webdriver
		public NaukriRegPage(WebDriver driver){
		this.driver= driver ;	//This passes the driver instance created in Homepage to RegPage
	}
		
		
	//Find placeholder
		@FindBy(xpath="//input[@id='name']")
		public WebElement Enter_fullname;
		
		@FindBy(xpath="//input[@id='email']")
		public WebElement Enter_email;
		
		@FindBy(xpath="//input[@id='password']")
		public WebElement Enter_pass;
		
		@FindBy(xpath="//input[@id='mobile']")
		public WebElement Enter_phno;
		
		@FindBy(xpath="//*[@data-val='fresher']")
		public WebElement Click_Fresher;	
		
		@FindBy(xpath="//span[contains(text(),'Bangalore/Bengaluru')]")
		public WebElement Enter_city;
		
		@FindBy(id="resumeUpload")
		public WebElement Resume_upload;
		
		//send keys
      	public  dologin login(String Name, String Email, String Password, String Phno, String Workstatus, String Currentcity ){
		Enter_fullname.sendKeys(Name);
		Enter_email.sendKeys(Email);
		Enter_pass.sendKeys(Password);
		Enter_phno.sendKeys(Phno);
		Click_Fresher.click();
		Enter_city.click();
		
	  return PageFactory.initElements(driver, dologin.class);
      	}
      	
      	public dologin upload(String UploadRsme){
      		WebElement uploadBtn = driver.findElement(By.id("resumeUpload"));
    		String filePath = "C:\\Users\\Darshan Gowda\\OneDrive\\Desktop\\docs\\Darshangowda_Resume.pdf" ;
    		uploadBtn.sendKeys(filePath);
    		
    		return PageFactory.initElements(driver, dologin.class);
	  
	  
	   
	  
	  
	  
		

	   
	}
	
		

  }
