package pageclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.PageBaseClass;

public class NaukriHomepage extends PageBaseClass{
   
	/********All webelements on Homepage and associated operations*******/
	public NaukriHomepage(WebDriver driver){
	this.driver=driver;
	}
	
	
	
	/**
	 * 
	 */
	@FindBy(xpath="//div[contains(text(),'Register')]")
	private WebElement RegisterLink;
	
	public WebElement getRegisterLink() {
		return RegisterLink;
	}

	public void setRegisterLink(WebElement registerLink) {
		RegisterLink = registerLink;
	}

	public NaukriRegPage ClickRegisterLink(){
		RegisterLink.click();
		return PageFactory.initElements(driver, NaukriRegPage.class);
	
	}

}
