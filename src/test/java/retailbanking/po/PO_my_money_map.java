package retailbanking.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class PO_my_money_map 
{
	WebDriver driver;
	
	public PO_my_money_map(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy(how=How.XPATH, using="//div[@class='x-panel x-grid-with-row-lines x-panel-default x-grid']//tr[@id='gridview-1015-bd-Deposits']//table[@class='x-grid-table x-grid-table-resizer']//tr")
	private List<WebElement> inflow_amount_values;
	
	public void check_amount_in_table()
	{
		for(int i=0;i<inflow_amount_values.size();i++)
		{
			String amount_in_inflow=inflow_amount_values.get(i).getText();
			Reporter.log("Values from inflow amount is "+amount_in_inflow);
			
		}
	}
}
