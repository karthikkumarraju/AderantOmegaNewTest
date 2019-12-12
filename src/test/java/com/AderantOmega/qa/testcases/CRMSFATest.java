package com.AderantOmega.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AderantOmega.qa.base.TestBase;
import com.AderantOmega.qa.pages.CRMSFA;
import com.AderantOmega.qa.pages.HomePage;
import com.AderantOmega.qa.pages.LoginPage;

public class CRMSFATest extends TestBase{
	
	
	LoginPage loginPage;
	CRMSFA crmsfaPage;
	
	public CRMSFATest() {
		super();
	}
	
	@BeforeMethod
	
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		crmsfaPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	@Test
	public void clickOnCRMSFALinkTest() {
		
		crmsfaPage.clickOnCRMSFALink();
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.close();
	}

}
