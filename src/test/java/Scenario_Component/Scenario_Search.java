package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.Pf_HomePage;


public class Scenario_Search extends Base_Class {
	
	@Test(dataProvider="dp_ValidSearch", dataProviderClass=DataProvider_Component.DataProvider_loaddata.class,groups={"regression"})
	public  void testValidSearchItem(Map<String, String> search) throws IOException
	{
		SoftAssert sAssert = new SoftAssert();
		String tc_id = search.get("TC_ID");
		String order_set = search.get("Order_Set");
		String search_item = search.get("Search_Item");
		String expRes = search.get("Exp_Result").replace(".0","");
		
		log.info("Executing the testcase "+tc_id+" order set is "+order_set);
		
		Pf_HomePage pfHomePage = new Pf_HomePage(driver);
		pfHomePage.ClickSearch(search_item);
		String actRes = pfHomePage.getValidSearchMsg();
		
		if(actRes.equals(expRes))
		{
			//System.out.println("Passed as Actual result is "+actRes+" "+"Expected Result "+expRes);
			log.info("Passed as Actual result is "+actRes+" "+"Expected Result "+expRes);
		}
		else
		{
			//System.out.println("Passed as Actual result is "+actRes+" "+"Expected Result "+expRes);
			log.info("Failed as Actual result is "+actRes+" "+"Expected Result "+expRes);
			CaptureScreenshot(tc_id, order_set);
			sAssert.fail("Failed as Actual result is "+actRes+" "+"Expected Result "+expRes);
		}
			
		sAssert.assertAll();
		
	}

	@Test(dataProvider="dp_InvalidSearch", dataProviderClass=DataProvider_Component.DataProvider_loaddata.class,groups={"smoke"})
	public  void testInvalidSearchItem(Map<String, String> search) throws IOException
	{
		SoftAssert sAssert = new SoftAssert();
		String tc_id = search.get("TC_ID");
		String order_set = search.get("Order_Set");
		String search_item = search.get("Search_Item");
		String expRes = search.get("Exp_Result");
		
		log.info("Executing the testcase "+tc_id+" order set is "+order_set);
		
		Pf_HomePage pfHomePage = new Pf_HomePage(driver);
		pfHomePage.ClickSearch(search_item);
		String actRes = pfHomePage.getInvalidSearchMsg();
		
		if(actRes.equals(expRes))
		{
			//System.out.println("Passed as Actual result is "+actRes+" "+"Expected Result "+expRes);
			log.info("Passed as Actual result is "+actRes+" "+"Expected Result "+expRes);
		}
		else
		{
			//System.out.println("Passed as Actual result is "+actRes+" "+"Expected Result "+expRes);
			log.info("Failed as Actual result is "+actRes+" "+"Expected Result "+expRes);
			CaptureScreenshot(tc_id, order_set);
			sAssert.fail("Failed as Actual result is "+actRes+" "+"Expected Result "+expRes);
		}
			
		sAssert.assertAll();
		
	
	}
}
