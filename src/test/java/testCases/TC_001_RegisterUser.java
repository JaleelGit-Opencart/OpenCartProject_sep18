package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseTest;

public class TC_001_RegisterUser extends BaseTest{

	
	
	@Test(groups = {"Regression" , "Master"})
	public void Register()
	{
		logger.debug("*** application defects ***");
		logger.info(" **** The test TC_001_RegisterUser has started **** ");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on My Account");
		hp.clickRegister();  
		logger.info("clicked on Register");
		RegisterPage rp = new RegisterPage(driver);
		logger.info("Entering the details of customer");
		rp.FirstName(alpha());
		rp.LastName(alpha());
		rp.Email(alpha()+"@gmail.com");
		rp.Phone(numeric());
		String pwd=alphanumeric();
		rp.Password(pwd);
		rp.ConfirmPass(pwd);
		Thread.sleep(3000);
		rp.Agree();
		rp.Submit();
		logger.info("validating the exxpected success message");
		String exp_msg = "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(rp.ConfirmMsg(), exp_msg , "Confirm messages are not matching");
		}
		catch(Exception e)
		{
			logger.error("Test is failed");
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
		
	}

