package com.AderantOmega.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AderantOmega.qa.base.TestBase;
import com.AderantOmega.qa.pages.CRMSFA;
import com.AderantOmega.qa.pages.HomePage;
import com.AderantOmega.qa.pages.LeadsPage;
import com.AderantOmega.qa.pages.LoginPage;
import com.AderantOmega.qa.util.TestUtil;

public class LeadsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CRMSFA crmsfaPage;
	LeadsPage leadPage;
	
	String sheetName="leads";
	
	public LeadsPageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
		leadPage=new LeadsPage();
		loginPage=new LoginPage();
		homePage=new HomePage();
		crmsfaPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		crmsfaPage.clickOnCRMSFALink();
	}
	
	@DataProvider
	
	public Object[][] getAderantOmegaTestData() {
		Object[][] data=TestUtil.getTestData(sheetName);
		
		return data;
	}
	
	@Test(dataProvider="getAderantOmegaTestData")
	
	public void validateCreateLead(String companyName,String firstName,String lastName) {
		homePage.clickOnLeadsTab();
		leadPage.createLead();
		leadPage.createNewLead(companyName,firstName,lastName);
	}
	
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}

}
