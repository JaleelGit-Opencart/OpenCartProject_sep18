package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Checkout']") WebElement lnk_Checkout_ele;
	
	public Boolean CheckoutOptionDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Chk=wait.until(ExpectedConditions.elementToBeClickable(lnk_Checkout_ele));
		Boolean kk=Chk.isDisplayed();
		return kk;
	}
}
