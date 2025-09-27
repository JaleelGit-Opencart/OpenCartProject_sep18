package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseTest;

public class TC_006_AddToCart extends BaseTest{
	@Test
	public void AddingToCart()
	{
		try
		{
		logger.info("***  Test Starts ***");
		HomePage hp=new HomePage(driver);
		SearchPage sp = new SearchPage(driver);
		CartPage cp=new CartPage(driver);
		hp.searchItem(rb.getString("product"));
		hp.searchButton();
		sp.addToCart();
		Boolean successMsg=sp.cartSuccessMsg();
		Assert.assertTrue(successMsg,  "Success message not displayed.");
		logger.info("Product added to cart successfuly and message diaplayed");
		sp.goToCart();
		logger.info("re-directed to cart page");
		Boolean checkOutPresent =cp.CheckoutOptionDisplayed();
		Assert.assertTrue(checkOutPresent);
		logger.info("Checkout option displayed");
		}catch(Exception e)
		{
			
			System.out.println("Test is failed and the cause is :"+e.getMessage());
			Assert.fail();
		}
		
		
	}
	
}
