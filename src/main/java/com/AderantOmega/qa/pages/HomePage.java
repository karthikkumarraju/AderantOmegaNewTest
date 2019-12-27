// Author sendhil kumar

package com.AderantOmega.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AderantOmega.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page factory
	
	//@FindBy(xpath="//a[text()='My Home']") WebElement myHomeTab;
	
	@FindBy(xpath="//a[contains(text(),'My Home')]") WebElement myHomeTab;
	@CacheLookup
	
	@FindBy(xpath="//div[contains(text(),'My Home')]") WebElement myHomeTitle;
	
	@FindBy(xpath="//a[@href='/crmsfa/control/leadsMain']") WebElement leadsTab;
	
	//initialization
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public void clickOnLeadsTab() {
		leadsTab.click();
	}
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public void clickOnMyHomeTab() {
		
		myHomeTab.click();
		//return new HomePage();
	}
	
	public boolean verifyMyHomeTitle() {
		
		return myHomeTitle.isDisplayed();
		
	}
	
	public void clickOnLeadTab() {
		leadsTab.click();
	}

}
