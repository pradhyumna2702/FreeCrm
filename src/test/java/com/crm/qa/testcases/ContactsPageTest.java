package com.crm.qa.testcases;

import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;

	String sheetName = "contactspage";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsLink();
		driver.navigate().refresh();
	}

	@Test(priority = 1)
	public void verfifyContactsLabelTest() {
		String contacts = contactspage.verfifyContactsLabel();
		System.out.println(contacts);
		Assert.assertEquals(contacts, "Contacts");
	}

	@Test(priority = 2)
	public void selectSingleContactTest() {

		contactspage.selectContactsByName("Pradhyumna Madhusudan");

	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactspage.selectContactsByName("Pradhyumna Madhusudan");
		contactspage.selectContactsByName("Ranjeetha Shadakshari");
	}

	@DataProvider
	public Object[][] getTestDataFromExcel() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getTestDataFromExcel")
	public void createNewContactsTest(String firstname, String lastname, String company, String email) {
		contactspage.clickOnNewContacts();
		contactspage.createNewContact(firstname, lastname, company, email);

	}

	// @AfterMethod
	// public void tearDown() {
	// driver.quit();
	// }

}
