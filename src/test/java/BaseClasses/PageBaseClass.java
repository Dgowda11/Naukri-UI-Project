package BaseClasses;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;

import pageclasses.NaukriHomepage;
import pageclasses.NaukriRegPage;
import pageclasses.dologin;

public class PageBaseClass {

	public WebDriver driver;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty(
						"webdriver.chrome.driver",
						"C:\\Users\\Darshan Gowda\\workspace\\SeleniumPOMFramework\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("mozila")) {
				System.setProperty(
						"webdriver.gecko.driver",
						"C:\\Users\\Darshan Gowda\\workspace\\SeleniumPOMFramework\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {

				driver = new OperaDriver();
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	/********** OPen Application ********/
	public NaukriHomepage OpenApplication() {
		driver.get("https://www.naukri.com");
		return PageFactory.initElements(driver, NaukriHomepage.class);
	}

	/********* Get page title ******/
	public NaukriRegPage verifyTitle(String expectedTitle) {
	
			try {
				Assert.assertEquals(driver.getTitle(), expectedTitle);
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return PageFactory.initElements(driver, NaukriRegPage.class);
		}



	/***************** Window handle ********/
	public NaukriRegPage SwitchTab() {
		Set<String> WindowIDs = driver.getWindowHandles();
		Iterator<String> itr = WindowIDs.iterator();

		String mainPageID = itr.next();
		String RegPageID = itr.next();

		// Switching to new Tab/Window
		driver.switchTo().window(RegPageID);
		return PageFactory.initElements(driver, NaukriRegPage.class);
	}

	/******* Windowscroll down ******/
	public NaukriRegPage scrollDown() {
		
			
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,5000)");
			

			/*
			 * WebElement resumeLink= driver.findElement(By.linkText("Resume"));
			 * js.executeScript("arguments[0].scrollIntoView(true)",
			 * resumeLink);
			 */
		
		return PageFactory.initElements(driver, NaukriRegPage.class);

	}

	public void quitBrowser() {
			try {
				driver.quit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// return PageFactory.initElements(driver, NaukriRegPage.class);

	}

	private void tearDown() {
		driver.close();
		// return PageFactory.initElements(driver, NaukriRegPage.class);

	}

}