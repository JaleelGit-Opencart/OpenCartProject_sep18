package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='btn btn-primary']") WebElement lnk_Checkout_ele;
	@FindBy(how=How.XPATH, using =("//a[contains(text() , 'Estimate')]")) WebElement drop_Estimate_ele;
	@FindBy(how=How.XPATH , using="//select[@name='country_id']") WebElement drop_country_ele;
	@FindBy(how=How.XPATH , using="//select[@name='zone_id']") WebElement drop_zone_ele;
	@FindBy(how=How.XPATH , using="//*[@name='postcode']") WebElement txt_Pin_ele;
	@FindBy(how=How.XPATH , using="//*[@id='button-quote']") WebElement but_Quotes_ele;
	@FindBy(how=How.XPATH, using="//*[@type=\"radio\"]") WebElement radio_OnDialog_ele;
	@FindBy(how=How.XPATH, using="//*[@value=\"Apply Shipping\"]") WebElement applyShip_ele;
	@FindBy(how=How.XPATH, using="//h4[normalize-space ()='Please select the preferred shipping method to use on this order.']") WebElement msg_Ship_ele;
	@FindBy(how=How.XPATH, using="//div[@class='alert alert-success alert-dismissible']") WebElement SuccessMsg_ele;
	@FindBy(how=How.XPATH, using="//strong[normalize-space()='Flat Shipping Rate:']") WebElement ShippingRate_ele;
	@FindBy(how=How.XPATH, using="//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]") WebElement A_ele;
	@FindBy(how=How.XPATH, using="//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]") WebElement B_ele;
	@FindBy(how=How.XPATH, using="//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[2]") WebElement C_ele;
	
	
	public Boolean CheckoutOptionDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Chk=wait.until(ExpectedConditions.elementToBeClickable(lnk_Checkout_ele));
		Boolean kk=Chk.isDisplayed();
		return kk;
	}
	
	public void clickEstimate()
	{
		//WebDriver
		drop_Estimate_ele.click();
	}
	
	public void contryId()
	{
		drop_country_ele.click();
		Select clist = new Select(drop_country_ele);
		clist.selectByVisibleText("India");
		
	}
	
	public void zoneId()
	{
		drop_zone_ele.click();
		Select zlist=new Select(drop_zone_ele);
		zlist.selectByVisibleText("Andhra Pradesh");
	}
	
	public void pinCode()
	{
		txt_Pin_ele.clear();
		txt_Pin_ele.sendKeys("518196");
	}
	public void clickQuotesBut()
	{
		but_Quotes_ele.click();
	/*	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		alert.*/
	}
	
	public Boolean radioButtonNotSelected()
	{
		return radio_OnDialog_ele.isSelected();
	}
	public void radioShippingButton()
	{
		radio_OnDialog_ele.click();
	}
	public void clickApplyShipping()
	{
		applyShip_ele.click();
	}
	public void clickCheckout()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clickable=wait.until(ExpectedConditions.elementToBeClickable(lnk_Checkout_ele));
		clickable.click();
	}
	public Boolean ShipDialogDisplayed()
	{
		return msg_Ship_ele.isDisplayed();
	}
	
	public Boolean SuccessMsgDisplayed()
	{
		//return SuccessMsg_ele.getText();
		return SuccessMsg_ele.getText().contains("Success:");
		
	}
	public Boolean ShippingRateCreated()
	{
		return ShippingRate_ele.isDisplayed();
	}
	public Double AplusB()
	{
	     String a=A_ele.getText();
	     a=a.replaceAll("[^0-9.]", "");
	     Double d1= Double.parseDouble(a);
	     
	     String b=B_ele.getText();
	     b=b.replaceAll("[^0-9.]", "");
	     Double d2=Double.parseDouble(b);
	     
	     Double D = d1+d2;
	     return D;
	}
	
	public Double C()
	{
		String c= C_ele.getText();
		c=c.replaceAll("[^0-9.]", "");
		Double d3=Double.parseDouble(c);
		return d3;
	}
}
