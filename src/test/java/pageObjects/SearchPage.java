package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
// elements
	@FindBy(xpath = "//div[@class='caption']//a[text()='iMac']") WebElement item_iMac_ele;
	
// action methods
	
	public Boolean iMacDisplayed()
	{
		Boolean b =item_iMac_ele.isDisplayed();
		return b;
	}
	
	
	
}
