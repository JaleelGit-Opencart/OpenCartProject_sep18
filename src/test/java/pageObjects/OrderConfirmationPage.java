package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']") WebElement Message_OrderConfirmed_ele;
	
	public String OrderConfirmed()
	{
		return Message_OrderConfirmed_ele.getText();
	}
	
}
