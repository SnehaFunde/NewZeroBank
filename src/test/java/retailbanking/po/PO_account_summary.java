package retailbanking.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class PO_account_summary 
{
	WebDriver driver;
	
	public PO_account_summary(WebDriver driver)
	{
		this.driver=driver;
	}
	

	//Show transaction header
	@FindBy(how=How.XPATH, using="//h2[contains(text(),'Cash Accounts')]")
	private WebElement header_cash_account;

	@FindBy(how=How.XPATH,using="//table[@class='table']//td[1]")
	private List<WebElement> account_type ;

	@FindBy(how=How.XPATH,using="//table[@class='table']//td[3]")
	private List<WebElement> balance ;
	
	@FindBy(how=How.XPATH,using="//table[@class='table']//td[2]")
	private List<WebElement> type_of_transaction ;

	
	
	public void fetch_account()
	{
		List<WebElement> list_of_balance=balance;
		for(int i=0;i<list_of_balance.size();i++)
		{
		WebElement fetch_list_of_balance=list_of_balance.get(i);
		String account_list_balance=fetch_list_of_balance.getText();
		if(account_list_balance.equals("savings"))
		{
			fetch_list_of_balance.getText();
		}
		Reporter.log("List of Balace is ");
		System.out.println(account_list_balance);
		Reporter.log("list is fetched" +account_list_balance);
		}
		
		
		
		List<WebElement> list_account=account_type;
		for(int i=0;i<list_account.size();i++)
		{
		WebElement fetch_list=list_account.get(i);
		String account_list=fetch_list.getText();
		Reporter.log("List of Account is ");
		System.out.println(account_list);
		Reporter.log("list is fetched" +account_list);
		}
		
		List<WebElement> list_type_of_transaction=type_of_transaction;
		for(int i=0;i<list_type_of_transaction.size();i++)
		{
		WebElement fetch_list=list_type_of_transaction.get(i);
		String account_list=fetch_list.getText();
		Reporter.log("List of transfer type is ");
		System.out.println(account_list);
		Reporter.log("list is fetched" +account_list);
		}
	}
}
