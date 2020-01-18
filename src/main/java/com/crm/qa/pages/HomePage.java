package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//div[@class='header item']")
	WebElement homepagelogo;	
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userdisplay;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//span[contains(text(),'Companies')]")
	WebElement companieslink;
	
	//Initializing the page objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		
		public boolean validateHomePageLogo() {
		  return homepagelogo.isDisplayed();	 
		}
		
		
		public String validateUserName() {
			return userdisplay.getText();	
		}
		
		public ContactsPage clickOnContactsLink() {
			contactslink.click();
			return new ContactsPage();
		}
		
		
		public DealsPage clickOnDealsLink() {
			dealslink.click();
			return new DealsPage();
		}

		public CompaniesPage clickOnCompaniesLink() {
			companieslink.click();
			return new CompaniesPage();
			}
		
		
		
		
		

}
