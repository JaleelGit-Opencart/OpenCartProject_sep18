package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseTest;

public class TC_004_Search extends BaseTest {

	@Test
	void iMacExists()
	{
		logger.info("*** searching product starts ***");
		try {
		
		HomePage hp = new HomePage(driver);
		SearchPage sp = new SearchPage(driver);
		logger.info("entering the product name");
		hp.searchItem(rb.getString("product"));
		hp.searchButton();
		Boolean product =sp.iMacDisplayed();
		Assert.assertEquals(product, true);
		logger.info("product displayed");
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** searching product ended ***");
	}
	
	
	
	
	
}
