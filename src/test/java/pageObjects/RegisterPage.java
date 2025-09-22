package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends BasePage {

	// calling constructor
	public RegisterPage(WebDriver driver) 
	{
		super(driver);
		
	}

	// elements
	  @FindBy(xpath = ("//input[@id='input-firstname']")) WebElement txt_FirstName_ele;
	  @FindBy(xpath = ("//input[@id='input-lastname']")) WebElement txt_LastName_ele;
	  @FindBy(xpath = "//input[@id='input-email']") WebElement txt_email_ele;
	  @FindBy(xpath = "//input[@id='input-telephone']") WebElement txt_phone_ele;
	  @FindBy(xpath = "//input[@id='input-password']") WebElement txt_pass_ele;
	  @FindBy(xpath = "//input[@id='input-confirm']") WebElement txt_confirmPass_ele;
	  @FindBy(xpath = "//input[@name='agree']") WebElement check_agree_ele;
	  @FindBy(xpath = "//input[@value='Continue']") WebElement but_Continue_ele;
	  @FindBy(xpath="//p[contains(text(),'Congratulations! Your new account has been success')]") WebElement msg_Confirm_ele;
// action methods
	  
	  public void FirstName(String fname)
	  {
		  txt_FirstName_ele.sendKeys(fname);
	  }
	  
	  public void LastName(String lname)
	  {
		  txt_LastName_ele.sendKeys(lname);
	  }
	  
	  public void Email(String email)
	  {
		  txt_email_ele.sendKeys(email);
	  }
	  
	  public void Phone(String num)
	  {
		  txt_phone_ele.sendKeys(num);
	  }  
	  
	  public void Password(String pass)
	  {
		  txt_pass_ele.sendKeys(pass);
	  }
	  
	  public void ConfirmPass(String pass2)
	  {
		  txt_confirmPass_ele.sendKeys(pass2);
	  }   
	  
	  public void Agree()
	  {
		  check_agree_ele.click();
	  }
	  
	  public void Submit()
	  {
		  but_Continue_ele.click();
	  }
	  
	  public String ConfirmMsg()
	  {
		  try {
		  return(msg_Confirm_ele.getText());
		  }
		  catch(Exception e)
		  {
			  return(e.getMessage());
		  }
	  }
}
