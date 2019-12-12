package com.AderantOmega.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AderantOmega.qa.base.TestBase;

public class LeadsPage extends TestBase{
	
	//PageFactory
	@FindBy(xpath="(//input[@name='companyName'])[2]") WebElement companyName;
	@FindBy(xpath="(//input[@name='firstName'])[3]") WebElement firstName;
	@FindBy(xpath="(//input[@name='lastName'])[3]") WebElement lastName;
	@FindBy(xpath="//input[@ name=\"submitButton\"]") WebElement createLeadButton;
	@FindBy(xpath="//a[text()='Create Lead']") WebElement createLeadOption;
	
	//initialization
	
	public LeadsPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public void createLead() {
		createLeadOption.click();
	}
	
	public void createNewLead(String compName,String fName,String lName) {
		companyName.sendKeys(compName);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		createLeadButton.click();
	}
	
	
	
	
	
	
	
}
