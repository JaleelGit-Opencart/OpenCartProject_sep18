package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
//elements    
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement lab_MyAccount_ele;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement opt_Logout_ele;
	
	
	
// action methods
	
	public Boolean MyAccDisplayed() 
	{
	
	try
	{
		return(lab_MyAccount_ele.isDisplayed());
	}
	catch(Exception e)
	{
		return(false);
	}
	}
	
	public void clickLogout()
	{
		opt_Logout_ele.click();
	}
	
	
	
}
