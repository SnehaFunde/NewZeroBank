package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class PO_pay_bills 
{
	WebDriver driver;

	public PO_pay_bills(WebDriver driver)
	{
		this.driver=driver;

	}

	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Make payments to your saved payees')]")
	private WebElement header_make_payments_to_your_saved_payees;

	@FindBy(how=How.ID, using="sp_payee")
	private WebElement txtbx_payee;

	@FindBy(how=How.ID, using="sp_account")
	private WebElement txtbx_account;

	@FindBy(how=How.ID, using="sp_amount")
	private WebElement txtbx_amount ;

	@FindBy(how=How.ID, using="sp_date")
	private WebElement txtbx_date ;
	
	@FindBy(how=How.ID, using="(//a[@class='ui-state-default'])[15]")
	private WebElement select_date ;

	@FindBy(how=How.ID, using="sp_description")
	private WebElement txtbx_description ;

	//Pay saved payee
	public void make_payment_form(String value)
	{
		try
		{
			//select value from fropdown
			Select payee_values=new Select(txtbx_payee);
			payee_values.selectByValue(value);
			Reporter.log("Value get selected as "+value+" from dropdown",true);

			//checkpoint for page title
			String expected="Zero - Pay Bills";
			String actual=driver.getTitle();
			Assert.assertEquals(expected, actual);
			Reporter.log("Page title is correct",true);

			//chckpoint for form title
			expected=header_make_payments_to_your_saved_payees.getText();
			actual="Make payments to your saved payees";
			Assert.assertEquals(expected, actual);
			Reporter.log("Form title is correct",true);

		}
		catch(Exception e)
		{
			e.printStackTrace();

			Reporter.log("Unable to select Value as "+value+" from dropdown");
		}
	}

	public void make_payment_form_account(String value)
	{
		try
		{
			//select value from fropdown
			Select account_values=new Select(txtbx_account);
			account_values.selectByValue(value);
			Reporter.log("Value get selected as "+value+" from dropdown",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Reporter.log("Unable to select Value as "+value+" from dropdown");
		}
	}
	
	public void make_payment_form_amount(String value)
	{
		try
		{
			txtbx_amount.sendKeys(value);
			
			Reporter.log("Value get selected as "+value+" from dropdown",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Reporter.log("Unable to select Value as "+value+" from dropdown");
		}
	}
	
	public void make_payment_form_date()
	{
		try
		{
			txtbx_date.click();
			select_date.click();     
			Reporter.log("Date get selected as from calendar",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();

			Reporter.log("Unable to select date as from calendar");
		}
	}
}
