package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	CompaniesPage companiespage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		companiespage = new CompaniesPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void validateHomePageLogoTest() {
		boolean logo = homepage.validateHomePageLogo();
		Assert.assertTrue(logo);
	}

	@Test(priority = 2)
	public void validateUserNameTest() {
		String username = homepage.validateUserName();
		System.out.println(username);
		Assert.assertEquals(username, "Pradhyumna Madhusudan", "username not matched");
	}

	@Test
	public void clickOnContactsLinkTest() {
		contactspage = homepage.clickOnContactsLink();
	}

	@Test
	public void clickOnDealsLinkTest() {
		dealspage = homepage.clickOnDealsLink();
	}

	@Test
	public void clickOnCompaniesLinkTTest() {
		companiespage = homepage.clickOnCompaniesLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
