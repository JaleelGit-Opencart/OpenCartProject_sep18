package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;                                          //  valid  -- displayed  -- pass
import pageObjects.MyAccountPage;                                      // valid  -- no displayed  -- fail
import testBase.BaseTest;                                             // invalid -- displayed  -- fail
import utilities.DataProviders;                                      //  invalid -- not displayed  -- pass
        
public class TC_003_LoginDataDrivenTest extends BaseTest {
    
	@Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class)
	void LoginDDT(String mail, String pass , String status)
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(mail);
		lp.enterPassword(pass);
		lp.clickLogin();
		 MyAccountPage mp = new MyAccountPage(driver);
		 Boolean label = mp.MyAccDisplayed();
		if(status.equals("Valid"))
		{
			if(label==true)
			{
			mp.clickLogout();
			Assert.assertTrue(true);
			}else
			{
				Assert.fail();
			}
		}
		
		if(status.equals("Invalid"))
		{
			if(label==true)
			{
			mp.clickLogout();
			Assert.assertTrue(false);
			}else
			{
				Assert.assertTrue(true);
			}
			
		}
		
		
		 
	}
}
