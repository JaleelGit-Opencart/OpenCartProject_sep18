package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public Logger logger;  // declaring Logger variable
	public ResourceBundle rb;
	
	@BeforeClass(groups = {"Sanity", "Regression", "Master"})
	@Parameters ({"browser"})
	public void SetUp(String br)
	{
		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());  // creating logger for this page
	//	WebDriverManager.chromedriver().setup();
		
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}else if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}else
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.manage().window().maximize();
		driver.get(rb.getString("appUrl"));
		
		
	}
	
	@AfterClass(groups = {"Sanity", "Regression", "Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String alpha()
	{
		String s =RandomStringUtils.randomAlphabetic(5);
		return (s);
	}
	
	public String numeric()
	{
		String n =RandomStringUtils.randomNumeric(10);
		return(n);
	}
	
	public String alphanumeric()
	{
	   String an =RandomStringUtils.randomAlphanumeric(10);
	   return (an);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

	
}
