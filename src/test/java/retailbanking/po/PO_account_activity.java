package retailbanking.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PO_account_activity 
{
	//initialize wbdriver
		WebDriver driver;
		
		//parameterized constructor
		public PO_account_activity(WebDriver driver)
		{
			this.driver=driver;
		}
		
		//Show transaction header
		@FindBy(how=How.XPATH, using="//h2[@class='board-header']")
		private WebElement header_show_transaction;
		
		@FindBy(how=How.ID,using="aa_accountId")
		private WebElement drpdwn_account;

		@FindBy(how=How.XPATH,using="//table[@class='table table-condensed table-hover']//td[3]")
		private List<WebElement> deposite ;

		@FindBy(how=How.XPATH,using="//div[@id='all_transactions_for_account']//td[3]")
		private List<WebElement> deposite_for_3 ;
		
		@FindBy(how=How.XPATH,using="//table[@class='table table-condensed table-hover']//td[4]")
		private WebElement list_of_withdrawal ;

		@FindBy(how=How.XPATH,using="//table[@class='table table-condensed table-hover']//td[2]")
		private List<WebElement> list_of_description ;
		
		@FindBy(how=How.XPATH,using="//table[@class='table table-condensed table-hover']//td[1]")
		private WebElement list_of_date;
		
		
		public void account_dropdown(String value)
		{
			try
			{
				Select account_type=new Select(drpdwn_account);
				account_type.selectByValue(value);
				Reporter.log("Value is selected as "+ value+"from account dropdown",true);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("Unable to select value as "+ value+" from account dropdown");
				
			}
		}
		
		public void list_of_deposite_from_webtable()
		{
			try
			{
				
				List<WebElement> list_of_deposite=deposite_for_3;
				for(int i=0; i<list_of_deposite.size();i++)
				{
					WebElement list1=list_of_deposite.get(i);
					String text1=list1.getText();
					
					System.out.println(text1);
					Reporter.log(" List of Deposite is : "+text1);
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log("Unable to find list of deposite. and Exception as : "+e.toString());
				
			}
			
		}
		
		public void description_for_checking()
		{
			try
			{
				List<WebElement> description_list=list_of_description;
				for(int i=0; i<description_list.size();i++)
				{
				WebElement list2=description_list.get(i);
				String text2=list2.getText();
				System.out.println(text2);
				Reporter.log(" List of Description is " +text2);
				
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Reporter.log(" Unable to find Description is " + e.toString());
			}
			
		}


}
