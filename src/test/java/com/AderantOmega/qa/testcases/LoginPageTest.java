package com.AderantOmega.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AderantOmega.qa.base.TestBase;
import com.AderantOmega.qa.pages.CRMSFA;
import com.AderantOmega.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	
	CRMSFA crmsfaPage;
	
	public LoginPageTest() {
		
	super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		loginPage=new LoginPage();
	}
	
	@Test
	
	public void loginTest()
	{
		crmsfaPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
