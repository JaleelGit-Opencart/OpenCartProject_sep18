package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseTest;

public class TC_007_Checkout extends BaseTest {

	@Test
	public void ProductCheckout()
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
		Boolean shipMsg=cp.ShipDialogDisplayed();
		Assert.assertTrue(shipMsg);
		logger.info("Shipping Dialog displayed");
		Boolean radio=cp.radioButtonNotSelected();
		Assert.assertEquals(radio, false);
		logger.info("Radio button not selected by default");
		cp.radioShippingButton();
		cp.clickApplyShipping();
		logger.info("Radio button selected and clicked on apply shipping");
		Boolean success=cp.SuccessMsgDisplayed();
		Assert.assertTrue(success);
		logger.info("Success msg displayed");
		Boolean ShipRateCrted=cp.ShippingRateCreated();
		Assert.assertTrue(ShipRateCrted);
		logger.info("Shipping rate included in table");
		System.out.println("A plus B is "+cp.AplusB()+" and C is "+cp.C());
		Assert.assertEquals(cp.AplusB(), cp.C());
		logger.info("Total price is calculated correctly including Shipping rate");
		logger.info("*** Test Ends ***");
		}catch(Exception e)
		{
			System.out.println("The test failed and the cause is :"+e.getMessage());
			Assert.fail();
		}
		
	
		
		
	}
}
