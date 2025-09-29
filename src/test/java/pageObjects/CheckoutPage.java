package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
 
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@value=\"guest\"]") WebElement radio_Guest_ele;
	@FindBy(xpath="//input[@id='button-account']") WebElement but_ContinueGuest_ele;
	@FindBy(xpath="//legend[normalize-space()='Your Personal Details']") WebElement label_PersonalDetails_ele;
	@FindBy(xpath="//input[@id='input-payment-firstname']") WebElement txt_fname_ele;
	@FindBy(xpath="//input[@id='input-payment-lastname']") WebElement txt_Lname_ele;
	@FindBy(xpath="//input[@id='input-payment-email']") WebElement txt_Mail_ele;
	@FindBy(xpath="//input[@id='input-payment-telephone']") WebElement txt_Phone_ele;
	@FindBy(xpath="//input[@id='input-payment-address-1']") WebElement txt_Address_ele;
	@FindBy(xpath="//input[@id='input-payment-city']") WebElement txt_City_ele;
	@FindBy(xpath="//input[@name='shipping_address']") WebElement check_ShipAddress_ele;
	@FindBy(xpath="//input[@id='button-guest']") WebElement but_PersonalDetailContinue_ele;
	@FindBy(xpath="//textarea[@name='comment']") WebElement txt_TextArea_ele;
	@FindBy(xpath="//input[@id='button-shipping-method']") WebElement but_AfterTextArea_ele;
	@FindBy(xpath="//input[@value='bank_transfer']") WebElement radio_BankTransfer_ele;
	@FindBy(xpath="//input[@name='agree']") WebElement check_Agree_ele;
	@FindBy(xpath="//input[@id='button-payment-method']") WebElement but_PaymentModeNext_ele;
	@FindBy(xpath="//input[@id='button-confirm']") WebElement lnk_FinalAgree_ele;
	
	
	public Boolean GuestButtonSelected()
	{
		return radio_Guest_ele.isSelected();
	}
	
	public void SelectGuestButton()
	{
		radio_Guest_ele.click();
	}
	
	public void SelectContinueGuestButton()
	{
		but_ContinueGuest_ele.click();
	}
	
	public Boolean PersonalDetailsLabelDisplayed()
	{
		return label_PersonalDetails_ele.isDisplayed();
	}
	
	public void SetFname(String fname)
	{
		txt_fname_ele.sendKeys(fname);
	}
	public void SetLname(String Lname)
	{
		txt_Lname_ele.sendKeys(Lname);
	}
	public void SetMail(String mail)
	{
		txt_Mail_ele.sendKeys(mail);
	}
	public void SetPhone(String phone)
	{
		txt_Phone_ele.sendKeys(phone);
	}
	
	public void SetAddress(String address)
	{
		txt_Address_ele.sendKeys(address);
	}
	public void SetCity(String city)
	{
		txt_City_ele.sendKeys(city);
	}
	
	public Boolean ShipAddressSelected()
	{
		return check_ShipAddress_ele.isSelected();
	}
	public void ShipAddressClick()
	{
		check_ShipAddress_ele.click();
	}
	public void PersonalDetailContinueClick()
	{
		but_PersonalDetailContinue_ele.click();
	}
	public void TextArea()
	{
		txt_TextArea_ele.sendKeys("The Product is good...");
	}
	public void ClickTextAreaNext()
	{
		but_AfterTextArea_ele.click();
	}
	public Boolean IsBankTransferModeSelected()
	{
		return radio_BankTransfer_ele.isSelected();
	}
	public void ClickAgree()
	{
		check_Agree_ele.click();
	}
	public void ClickNextAgree()
	{
		but_PaymentModeNext_ele.click();
	}
	public void ClickFinalAgree()
	{
		lnk_FinalAgree_ele.click();
	}
}
