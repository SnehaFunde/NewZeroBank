package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class PO_Common 
{
	//webdriver
			WebDriver driver;
			
			//parameterized constructr
			public PO_Common(WebDriver driver)
			{
				this.driver=driver;	
			}
			
			//page objects
			
			@FindBy(how=How.XPATH, using="//a[contains(text(),'Transfer Funds')]")
			private WebElement transfer_funds_link;
			
			public void clickTransferFunds()
			{
				try
				{
					transfer_funds_link.click();
					Reporter.log("Transfer fund is clicked",true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					Reporter.log("Unable to click on Transfer Funds. Exception as :"+e.toString());
				}
			}

			@FindBy(how=How.LINK_TEXT, using="Account Activity")
			private WebElement account_activity_link;

			public void clickAccountActivity()
			{
				try
				{
					account_activity_link.click();
					Reporter.log("Account activity is clicked",true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					Reporter.log("Unable to click on Account Activity. Exception as :"+e.toString());
				}
			}
			
			//Bill Pay
			@FindBy(how=How.XPATH, using="//a[contains(text(),'Bills')]")
			private WebElement bill_pay_link;
			
			public void clickBillPay()
			{
				try
				{
					bill_pay_link.click();
					Reporter.log("Bill Pay is clicked",true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					Reporter.log("Unable to click on Bill Pay. Exception as :"+e.toString());
				}
			}
			
			//My Money Map
			
			@FindBy(how=How.XPATH, using="//a[contains(text(),'My Money Map')]")
		    private WebElement my_money_map_link;
			
			public void clickMy_Money_Map()
			{
				try
				{
					my_money_map_link.click();
					Reporter.log("My money map is clicked",true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					Reporter.log("Unable to click on money map. Exception as :"+e.toString());
				}
			}

}
