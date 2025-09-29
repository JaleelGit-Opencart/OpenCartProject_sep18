package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseTest;

public class TC_008_Payment_OrderPlaced extends BaseTest{

	@Test
	public void PaymentAndOrderPlaced()
	{
		try
		{
		logger.info("*** Test Begins ***");
		HomePage hp=new HomePage(driver);
		logger.info("Searching for item Imac");
		hp.searchItem(rb.getString("product"));
		hp.searchButton();
		logger.info("Clicked on Search Button");
		SearchPage sp=new SearchPage(driver);
		sp.addToCart();
		logger.info("added to cart");
		sp.goToCart();
		logger.info("re-directed to cart");
		CartPage cp=new CartPage(driver);
		cp.clickEstimate();
		cp.contryId();
		cp.zoneId();
		cp.pinCode();
		logger.info("Details entered");
		cp.clickQuotesBut();
		logger.info("Shipping Dialog displayed");
		cp.radioShippingButton();
		cp.clickApplyShipping();
		logger.info("Radio button selected and clicked on apply shipping");
		cp.clickCheckout();
		logger.info("clicked on checkout button");
		CheckoutPage check= new CheckoutPage(driver);
		Boolean guest=check.GuestButtonSelected();
		if(!guest)
		{
			check.SelectGuestButton();
			logger.info("Guest button not selected by default. now selected");
		}
		
		Assert.assertTrue(check.GuestButtonSelected());
		logger.info("assertion passed. Guest button selected");
		check.SelectContinueGuestButton();
		Assert.assertTrue(check.PersonalDetailsLabelDisplayed());
		logger.info("Personal Details label displayed..");
		logger.info("Entering the details fname, lname...");
		check.SetFname(alpha());
		check.SetLname(alpha());
		check.SetMail(alphanumeric()+"@gmail.com");
		check.SetPhone(alpha());
		check.SetAddress(alpha()+"/1258");
		check.SetCity(rb.getString("city"));
		logger.info("Personal detailes entered successfully..");
		Boolean sb=check.ShipAddressSelected();
		if(!sb)
		{
			check.ShipAddressClick();
			logger.info("Shipping Address radio button not selected by default. no selected");
		}
		Assert.assertTrue(check.ShipAddressSelected());
		logger.info("Shippping address radio button selected by default");
		check.PersonalDetailContinueClick();
		logger.info("*** Test Ends ***");
		}catch(Exception e)
		{
			System.out.println("The test failed and the cause is :"+e.getMessage());
			Assert.fail();
		}
	}
}
