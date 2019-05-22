package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

public class PO_login_functionality 
{
	//initialise webdriver
	WebDriver driver;
	
	
	//parameterized constructor
	public PO_login_functionality(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	
	@FindBy(how=How.ID,using="user_login")
	private WebElement textbx_username;
	
	@FindBy(how=How.ID,using="user_password")
	private WebElement textbx_password;

	@FindBy(how=How.NAME,using="submit")
	private WebElement login_button;

	//reusable method under try catch
	public void setUername(String uname)
	{
		try
		{
			textbx_username.sendKeys(uname);
			Reporter.log("username set with value as uname "+ uname ,true);
		}
		catch(Exception e)
		{
			e.getMessage();
			Reporter.log("username is unable to set as value u "+uname +"Runtime "+ e.toString());
		}
	}
	public void setPassword(String password)
	{
		try
		{
			textbx_password.sendKeys(password);
		}
		catch(Exception e)
		{
			e.getMessage();
			Reporter.log("password field is not working");
		}
	}
	public void click_on_sign_in_button()
	{
		try
		{
			login_button.click();
			Reporter.log("submit button clicked",true);
			
		}
		catch(Exception e)
		{
			e.getMessage();
			Reporter.log("Unable to click on submit button" + "runtime Exception is : "+ e.toString());
		}
		
	}
	
	public void KW_login_into_application(String uname, String password)
	{
		try
		{
			setUername(uname);
			setPassword(password);
			click_on_sign_in_button();
			Reporter.log("Username and password are set and submit button is clicked",true);
			String expected="Zero - Account Summary";
			String actual=driver.getTitle();
			Assert.assertEquals(expected, actual);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("unable to click on sign in button "+"Runtime exception is : "+e.toString());
		}
		
		
	}



}
