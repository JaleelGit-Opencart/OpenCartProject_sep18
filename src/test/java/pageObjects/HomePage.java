package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

	// calling the constructor
	 
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	// page elements
	
	    //element 1: "My Account" dropdown
	
	   @FindBy(xpath = "//span[normalize-space()='My Account']") WebElement lnk_MyAccount_ele ;
	
	    //element 2: "Register" link
	   @FindBy(how=How.XPATH , using = "//a[normalize-space()='Register']") WebElement lnk_Register_ele;
	   
	   // element3 : login
	   
	   @FindBy(xpath = "//a[normalize-space()='Login']") WebElement but_login_ele;
	   @FindBy(name = "search") WebElement txt_Search_ele;
		@FindBy(xpath = "//span/button[@type=\"button\"]") WebElement but_Search_ele;
	   
	 // action methods
	   //method 1:  clicking dropdown
	   public void clickMyAccount()
	   {
		   lnk_MyAccount_ele.click();
	   }
	   
	   // method 2 : clicking "Register"
       public void clickRegister()
       {
    	   lnk_Register_ele.click();
       }
       
       public void clickLogin()
       {
    	   but_login_ele.click();       
    	   
       }
       
       public void searchItem(String item)
   	{
   		txt_Search_ele.sendKeys(item);;
   		
   	}
   	
   	public void searchButton()
   	{
   		but_Search_ele.click();
   	}
}
