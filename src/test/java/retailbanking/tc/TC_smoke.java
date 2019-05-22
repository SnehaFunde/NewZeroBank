package retailbanking.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core.utils.Utils;
import retailbanking.po.PO_Common;
import retailbanking.po.PO_account_activity;
import retailbanking.po.PO_account_summary;
import retailbanking.po.PO_login_functionality;
import retailbanking.po.PO_pay_bills;

public class TC_smoke 
{
	PO_login_functionality po_login;
	/*@Parameters({"url","browser"})
	@Test
	public void tc_01_validate_login_functionality(String url, String browserType)
	{
		try
		{
			//String url="http://zero.webappsecurity.com/login.html";
			WebDriver driver= Utils.invoke_browser(browserType, url);
			po_login=PageFactory.initElements(driver, PO_login_functionality.class);
			po_login.KW_login_into_application("username", "password");

		}
		catch(Exception e)
		{
			Reporter.log("Test faied ",true);
			Assert.assertFalse(false);
		}
	}
	@Parameters({"url","browser"})
	@Test
	public void tc_02_check_transfer_funds(String url,String browserType)
	{
		WebDriver driver=Utils.invoke_browser(browserType, url);
		//login into page
		po_login=PageFactory.initElements(driver, PO_login_functionality.class);
		po_login.KW_login_into_application("username", "password");

		//click on transfer funds
		PO_Common po_common=PageFactory.initElements(driver, PO_Common.class);
		po_common.clickTransferFunds();

		//Transfer funds
		PO_transfer_funds transfer_funds=PageFactory.initElements(driver, PO_transfer_funds.class);
		String from="1";
		String to="2";
		String amount="10";
		String desc="test";
		transfer_funds.KW_FillTranferFundPageAndSubmitted(from,to,amount,desc);

	}
	*/
	/*@Parameters({"url","browser"})
	@Test()
	public void tc_03_check_account_activity(String url, String browserType)
	{
		//invoke browser through utlis 
		WebDriver driver=Utils.invoke_browser(browserType, url);
		
		//login into page
		po_login=PageFactory.initElements(driver, PO_login_functionality.class);
		po_login.KW_login_into_application("username", "password");
		
		//click on account activity field
		PO_Common common=PageFactory.initElements(driver, PO_Common.class);
		common.clickAccountActivity();
		
		//Account activites
		PO_account_activity account_activity=PageFactory.initElements(driver, PO_account_activity.class);
		account_activity.account_dropdown("2");
		account_activity.description_for_checking();
		
	}*/


	@Parameters({"url","browser"})
	@Test()
	public void tc_04_check_account_summary(String url, String browserType)
	{
		//invoke browser through utils 
		WebDriver driver=Utils.invoke_browser(browserType, url);
		
		//login into page
		po_login=PageFactory.initElements(driver, PO_login_functionality.class);
		po_login.KW_login_into_application("username", "password");
		
		//click on account activity field
		/*PO_Common common=PageFactory.initElements(driver, PO_Common.class);
		common.clickAccountActivity();*/
		
		//Account activites
		/*PO_account_summary summary=PageFactory.initElements(driver, PO_account_summary.class);
		summary.fetch_account();*/
		
		//Pay Bills
		PO_pay_bills pay_bills=PageFactory.initElements(driver, PO_pay_bills.class);
		PO_Common common=PageFactory.initElements(driver, PO_Common.class);
		common.clickBillPay();
		pay_bills.make_payment_form("apple");
		pay_bills.make_payment_form_account("2");
		pay_bills.make_payment_form_date();
		
		
	}
}
