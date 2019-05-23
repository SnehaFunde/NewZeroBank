package retailbanking.po;

import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(how=How.ID, using="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	private WebElement btn_datepicker_next ;

	@FindBy(how=How.ID, using="//span[@class='ui-icon ui-icon-circle-triangle-w']")
	private WebElement btn_datepicker_prev ;

	@FindBy(how=How.ID, using="//span[@class='ui-datepicker-month' and contains(text(),'May')]")
	private WebElement current_month ;

	@FindBy(how=How.ID, using="sp_description")
	private WebElement txtbx_description ;

	@FindBy(how=How.ID, using="pay_saved_payees")
	private WebElement btn_pay ;

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
		txtbx_date.click();

		String ExpMonth="October";
		String month=current_month.getText();
		String currentMonth=month;


		btn_datepicker_next.click();
		/*if(ExpMonth.equals(currentMonth))
		{
			System.out.println("month is already selected");
		}
		else
		{
			for(int i=1;i<7;i++)
			{
				btn_datepicker_next.click();
				Reporter.log(month+"month is expected");
				if(ExpMonth.equalsIgnoreCase(currentMonth))
				{
					System.out.println("month is selected");
					break;
				}
			}

		}*/
	}

	public void description_in_pay_bills(String value)
	{
		txtbx_description.sendKeys(value);
	}

	public void click_pay_btn()
	{
		btn_pay.click();
	}



	///Add New Payee
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Add New Payee')]")
	private WebElement add_new_payee_field;

	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Who are you paying?')]")
	private WebElement text_header ;

	@FindBy(how=How.ID, using="np_new_payee_name")
	private WebElement txtbx_payee_name ;

	@FindBy(how=How.XPATH, using="//label[contains(text(),'Payee Name')]")
	private WebElement payee_name ;

	@FindBy(how=How.ID, using="np_new_payee_address")
	private WebElement txtbx_payee_address ;

	@FindBy(how=How.ID, using="np_new_payee_account")
	private WebElement txtbx_payee_account ;

	@FindBy(how=How.ID, using="np_new_payee_details")
	private WebElement txtbx_payee_details ;

	@FindBy(how=How.ID, using="add_new_payee")
	private WebElement btn_add ;

	public void click_add_new_payee()
	{
		try
		{
			add_new_payee_field.click();
			Reporter.log("Add New Payee is clickd ",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to click on Add New Payee");

		}
	}


	public void payee_name(String name)
	{
		try
		{
			txtbx_payee_name.sendKeys(name);
			Reporter.log("Add New Payee is clickd ",true);
			String expected="Who are you paying?";
			String actual=text_header.getText();
			Assert.assertEquals(expected, actual);
			Reporter.log("Title is correct");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to type name");

		}
	}

	public void payee_address(String address)
	{
		try
		{
			txtbx_payee_address.sendKeys(address);
			Reporter.log("Add New Payee is clickd ",true);
			String expected="Payee Name";
			String actual=payee_name.getText();
			Assert.assertEquals(expected, actual);
			Reporter.log("Field name 'Payee Name' is correct");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to Add address");

		}
	}

	public void payee_amount(String amount)
	{
		try
		{
			txtbx_payee_account.sendKeys(amount);
			Reporter.log("Amount is "+amount+"in field ",true);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to Add amount");

		}
	}

	public void payee_details(String details)
	{
		try
		{
			txtbx_payee_details.sendKeys(details);
			Reporter.log("Payee details is "+details,true);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to Add amount");

		}
	}

	public void click_add_btn()
	{
		try
		{
			btn_add.click();
			Reporter.log("Payee details is ",true);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to Add amount");

		}
	}

	public void KW_po_bill_pay_Add_New_Payee(String name,String address,String amount,String details)
	{
		click_add_new_payee();
		payee_name(name);
		payee_address(address);
		payee_amount(amount);
		payee_details(details);
		click_add_btn();
	}

	//Purchase forign currency cash

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Purchase Foreign Currency')]")
	private WebElement click_purchase_foreign_currency;

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Purchase Foreign Currency')]")
	private WebElement click_purchase_foreign_currency_cash;

	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Purchase foreign currency cash')]")
	private WebElement txt_header;

	@FindBy(how=How.ID, using="pc_currency")
	private WebElement select_currency ;

	@FindBy(how=How.ID, using="pc_amount")
	private WebElement txtbx_amount_for;

	@FindBy(how=How.ID, using="sp_sell_rate")
	private WebElement sell_rate ;

	@FindBy(how=How.ID, using="pc_inDollars_true")
	private WebElement radio_btn_us_dollar ;

	@FindBy(how=How.ID, using="pc_inDollars_false")
	private WebElement selected_currency ;

	@FindBy(how=How.ID, using="pc_calculate_costs")
	private WebElement btn_calculate_cost ;

	@FindBy(how=How.ID, using="pc_conversion_amount")
	private WebElement conversion_amount ;

	@FindBy(how=How.ID, using="purchase_cash")
	private WebElement purchase_cash ;

	@FindBy(how=How.ID, using="alert_content")
	private WebElement purchase_suceessfull ;

	@FindBy(how=How.XPATH, using="//span[contains(text(),'1 franc (CHF) = 1.1383 U.S. dollar (USD)')]")
	private WebElement switzerland ;

	public void click_purchase_foreign_currency()
	{
		try
		{
			click_purchase_foreign_currency.click();
			Reporter.log("Purchase Foreign Currency is clickd ",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to click on Purchase Foreign Currency");

		}
	}

	public void select_currency(String currency)
	{
		try
		{
			Select select=new Select(select_currency);
			select.selectByValue(currency);

			String expected="1 franc (CHF) = 1.1383 U.S. dollar (USD)";
			String actual=switzerland.getText();
			Assert.assertEquals(expected, actual);
			Reporter.log("Sell rate is correct corresponding to selected currency",true);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Sell rate is not correct corresponding to selected currency");

		}
	}

	public void pay_forgn_currncy_amount(String amount)
	{
		try
		{
			txtbx_amount_for.sendKeys(amount);
			Reporter.log("Amount is "+amount+" in txtbx ",true);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to Add amount");

		}
	}

	public void check_radio_btn_selected_currency()
	{
		try
		{
			selected_currency.click();
			boolean radio_currency=selected_currency.isSelected();
			Reporter.log("Radio button for selected currency is selected",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Radio button for selected currency is selected");
		}
	}
	
	public void calculate_cost()
	{
		try
		{
			btn_calculate_cost.click();
			Reporter.log("Calculate cost is clicked",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Calculate cost is not clicked");
		}
	}
	
	public void conversion_amount()
	{
		try
		{
			String expected="100.00 franc (CHF) = 113.83 U.S. dollar (USD)";
			String actual=conversion_amount.getText();
			Reporter.log("Conversion is correct",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to convert currency");
		}
	}
	
	public void click_on_purcase_btn()
	{
		try
		{
			purchase_cash.click();
			Reporter.log("Button is clicked",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to click on purchase button");
		}
	}
	
	public void purchase_success_msg()
	{
		try
		{
			String expected="Foreign currency cash was successfully purchased.";
		    String actual=purchase_suceessfull.getText();
		    Assert.assertEquals(expected, actual);
			Reporter.log("Purchase is successull ",true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Unable to purchase currency");
		}
	}
}
