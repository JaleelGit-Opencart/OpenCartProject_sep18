package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
// calling constructor from BasePage
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
//    elements   
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_Email_ele;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Password_ele;
	@FindBy(xpath="//input[@value='Login']") WebElement but_login_ele;
	
// action methods
	
	public void enterEmail(String mail)
	{
		txt_Email_ele.sendKeys(mail);
	}
	
	public void enterPassword(String pass)
	{
		txt_Password_ele.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		but_login_ele.click();
	}
}
