package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseClasses.PageBaseClass;
import pageclasses.NaukriHomepage;
import pageclasses.NaukriRegPage;

public class RegUser  {

	NaukriHomepage NaukriHomePage;
	NaukriRegPage NaukriRegPage;
	pageclasses.dologin dologin;

	@Test
	public void RegisterUser() {

		PageBaseClass pageBase = new PageBaseClass();
		pageBase.invokeBrowser("chrome");

		NaukriHomePage = pageBase.OpenApplication();

		NaukriRegPage = NaukriHomePage.ClickRegisterLink();

		NaukriRegPage = NaukriHomePage.SwitchTab();

		dologin = NaukriRegPage.login("Darshan", "dgowda112000@gmail.com",
				"Qwerty@123", "8431979510", null, null);
		
		dologin = NaukriRegPage.upload(null);

		NaukriRegPage
				.verifyTitle("Register on Naukri.com: Apply to Millions of Jobs Online");
		
		

		NaukriRegPage.quitBrowser();

		
		}

	}


