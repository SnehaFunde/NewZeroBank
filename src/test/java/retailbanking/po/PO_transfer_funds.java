package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class PO_transfer_funds
{
	//webdriver
		WebDriver driver;
		
		//parameterized constructr
		public PO_transfer_funds(WebDriver d)
		{
			this.driver=d;	
		}
		
		//page objects
		
		@FindBy(how=How.XPATH, using="//a[contains(text(),'Transfer Funds')]")
		private WebElement transfer_funds_link;
		
		@FindBy(how=How.ID,using="tf_fromAccountId")
		private WebElement list_from_account;

		@FindBy(how=How.ID,using="tf_toAccountId")
		private WebElement list_to_account;

		@FindBy(how=How.ID,using="tf_amount")
		private WebElement txtbx_amount;

		@FindBy(how=How.ID,using="tf_description")
		private WebElement description ;
		
		@FindBy(how=How.ID,using="btn_submit")
		private WebElement btn_continue;
		
		@FindBy(how=How.XPATH,using="//button[@type='submit']")
		private WebElement btn_submit;
		
		@FindBy(how=How.XPATH,using="//h2[@class='board-header']")
		private WebElement txt_success_header;
		
		
		public void selct_from_account(String value)
		{
			try
			{
				Select selectFromAccount=new Select(list_from_account);
				selectFromAccount.selectByValue(value);
				Reporter.log("Selected value as "+value +"from dropdown",true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("Unable to Select as value"+value+ "from dropdown"+e.toString());
			}
		}
		
		public void selct_to_account(String value)
		{
			try
			{
				Select selectToAccount=new Select(list_to_account);
				selectToAccount.selectByValue(value);
				Reporter.log("Selected value as "+value +"to dropdown",true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("Unable to Select as value"+value+ "to dropdown"+e.toString());
			}
		}
		
		public void setamount(String amount)
		{
			try
			{
				
				txtbx_amount.sendKeys(amount);
				Reporter.log("Selected value as "+amount +"in amount textbx",true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("Unable to Select as value"+amount+ "in amount txtbx"+e.toString());
			}
		}
		
		public void set_description(String value)
		{
			try
			{
				description.sendKeys(value);
				Reporter.log("Description is '"+value +" 'in description textbx",true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("Unable to Set description "+value+ "in description txtbx"+e.toString());
			}
		}
		
		public void click_continue_btn()
		{
			try
			{
				btn_continue.click();
				Reporter.log("Continue bttn is clicked",true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("Continue bttn is not clicked"+e.toString());
			}
		}
		
		public void click_on_submit_button()
		{
			try
			{
				btn_submit.click();
				Reporter.log("submit button is clicked",true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("Submit button is not clicked"+e.toString());
			}
		}
		
		public void KW_FillTranferFundPageAndSubmitted(String from,String to,String amount,String desc )
		{
			try
			{
				selct_from_account(from);
				selct_to_account(to);
				setamount(amount);
				set_description(desc);
				click_continue_btn();
				
				//validation points
				Assert.assertEquals(btn_submit.isDisplayed(),true);
				Assert.assertEquals(list_from_account.isEnabled(),false);
				Reporter.log("Page navigated to transfer funds Vrify", true);
				
				click_on_submit_button();
				
				
				//chckpoint to validate the expected vs actual
				String expected=txt_success_header.getText();
				String actual="Transfer Money & Make Payments - Confirm";
				Assert.assertEquals(expected, actual);	
				Reporter.log("Page navigated to transfer Money and Funds : Conformed", true);
				
				//checkpoint for amount
				//String xpath="//div[@class='span3' and contains(text(),'"+amount+"')]";
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("fill transfer funds page and not submitted"+e.toString());
			}
		}
		

}
