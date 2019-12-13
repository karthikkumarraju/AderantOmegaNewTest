package com.AderantOmega.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AderantOmega.qa.base.TestBase;
import com.AderantOmega.qa.pages.CRMSFA;
import com.AderantOmega.qa.pages.HomePage;
import com.AderantOmega.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CRMSFA crmsfaPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		crmsfaPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		crmsfaPage.clickOnCRMSFALink();
	}
	
	@Test(priority=1,retryAnalyzer=com.AderantOmega.qa.analyzer.RetryAnalyzer.class)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle=homePage.verifyHomePageTitle();
		System.out.println("Home page title is: "+homePageTitle);
		Assert.assertEquals(homePageTitle,"My Home | opentaps CRM","Home Page title not matched");
	}
	
	@Test(priority=2)
	
	public void clickOnMyHomeTabTest() {
		homePage.clickOnMyHomeTab();
	}
	
	@Test(priority=3)
	
	public void verifyMyHomeTitle() {
		Assert.assertTrue(homePage.verifyMyHomeTitle());
	}
	
	@Test(priority=4)
	
	public void clickOnLeadsTabTest() {
		homePage.clickOnLeadsTab();
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}

}
