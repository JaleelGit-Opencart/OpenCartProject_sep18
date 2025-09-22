package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC_002_LoginTest extends BaseTest {

	
	@Test(groups = {"Sanity", "Master"})
	public void TestLogin()
	{
		logger.info("**** Login Test started ****");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("clicked on Login from dropdown");
		LoginPage lp = new LoginPage(driver);
		
		lp.enterEmail(rb.getString("email"));
		lp.enterPassword(rb.getString("password"));
		logger.info("entered credentials");
		lp.clickLogin();
		logger.info("clicked on login");
		MyAccountPage mp = new MyAccountPage(driver);
		Boolean status= mp.MyAccDisplayed();
		Assert.assertEquals(status, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Login Test ended ****");
	}
}
