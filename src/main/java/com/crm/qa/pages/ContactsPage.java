package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactslabel;	
	
	@FindBy(xpath="//button[@class='ui linkedin button']/i[@class='edit icon']")
	WebElement newContactsbtn;
	
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//div[@name='company']/input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="(//input[@name='value' and @type='text'])[1]")
	WebElement email;


	@FindBy(xpath="//button[text()='Save']")
	WebElement savebtn;
	
	
	
	
//	@FindBy(xpath="//td[text()='Pradhyumna Madhusudan']//preceding-sibling::td/div//input]")
//	WebElement userdisplay;
//	
	
	
	//Initializing the page objects
			public ContactsPage() {
				PageFactory.initElements(driver, this);
			}
			
			public String verfifyContactsLabel() {
				return contactslabel.getText();
			}
			
		    public void selectContactsByName(String name) {
			WebElement checkbox=driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td/div//input[@type='checkbox']"));
			TestUtil.clickElementByJS(checkbox, driver);
			}
	
		    
		    public void clickOnNewContacts() {
		    	newContactsbtn.click();
		    }
		    
		    
		    public void createNewContact(String ftname,String ltname,String comp,String emailadd) {
		    	
		    	firstName.sendKeys(ftname);
		    	lastname.sendKeys(ltname);
		    	email.sendKeys(emailadd);
		    	company.sendKeys(comp);
		    	savebtn.click();
		    	
		    }
		    
		
}




