package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
// elements
	@FindBy(xpath = "//div[@class='caption']//a[text()='iMac']") WebElement item_iMac_ele;
	@FindBy(xpath="//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]") WebElement but_AddCart_ele;
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]//a[2]") WebElement lnk_cart_ele;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement txt_success_ele;
	@FindBy(xpath="//i[@class='fa fa-check-circle']") WebElement msg_success_ele;
	
	
	
// action methods
	
	public Boolean iMacDisplayed()
	{
		Boolean b =item_iMac_ele.isDisplayed();
		return b;
		
	}
	
	public void addToCart()
	{
		but_AddCart_ele.click();
	}
	
	public Boolean cartSuccessMsg()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement msg=wait.until(ExpectedConditions.visibilityOf(txt_success_ele));
		Boolean status =msg.getText().contains("Success");
		return status;
		/*
		return(txt_success_ele.isDisplayed());  */
	}
	
	public void goToCart()
	{
		WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds(10));
		wai.until(ExpectedConditions.elementToBeClickable(lnk_cart_ele)).click();
		/*
		lnk_cart_ele.click();   */
	}
}
