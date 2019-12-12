package com.AderantOmega.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AderantOmega.qa.base.TestBase;

public class CRMSFA extends TestBase{
	
	//Page Factory or Object Repository
	
	@FindBy(linkText="CRM/SFA") WebElement crmLink;
	
	//initialization
	
	public CRMSFA() {
		
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public HomePage clickOnCRMSFALink() {
		
		crmLink.click();
		
		return new HomePage();
		
	}
	

}
