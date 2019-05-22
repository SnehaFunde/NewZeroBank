package core.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Utils 
{
	public static WebDriver invoke_browser(String browserType , String url)
	{
		try
		{
			WebDriver driver = null;
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\chromedriver.exe");
			Reporter.log("path is set");
			 driver=new ChromeDriver();
			Reporter.log("browser is invoked");
			/*if(browserType.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\chromedriver.exe");
				Reporter.log("path is set");
				 driver=new ChromeDriver();
				Reporter.log("browser is invoked");
			}
			else if(browserType.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Selenium Webdriver\\geckodriver.exe");
				Reporter.log("path is set");
				 driver=new FirefoxDriver();
				Reporter.log("browser is invoked");
			}*/
			
			driver.manage().window().maximize();
			Reporter.log("window is maximized");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Reporter.log("implicit wait");
			driver.get(url);
			return driver;
			
		}
		catch(Exception e)
		{
			e.getMessage();
			Reporter.log("Exception caught");
			return null;
		}
		
	}



}
