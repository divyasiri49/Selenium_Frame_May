package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.Pf_Cart;
import PageObject_Component.Pf_HomePage;
import PageObject_Component.Pf_ProductDetails;

public class Scenario_Cart extends Base_Class {

	@Test(dataProvider="dp_Addcart", dataProviderClass=DataProvider_Component.DataProvider_loaddata.class)
	public void TestAddCart(Map<String,String> addCart) throws IOException
	{

		SoftAssert sAssert = new SoftAssert();
		
		String expRes = addCart.get("Exp_Result");
		String tc_id = addCart.get("TC_ID");
		String order_set = addCart.get("Order_Set");
		Pf_HomePage pfHomePage = new Pf_HomePage(driver);
		Pf_ProductDetails pfProdDetails = new Pf_ProductDetails(driver);
		Pf_Cart pfCart = new Pf_Cart(driver);
		
		log.info("Executing the testcase "+tc_id+" order set is "+order_set);
		
		pfHomePage.ClickCartElement();
		String expCartElementMsg ="12";
		String validcartElementMsg = pfHomePage.getValidcartElementMsg();
		System.out.println(validcartElementMsg);
		if(validcartElementMsg.contains(expCartElementMsg))
		{
			pfHomePage.Click_Book();
			pfProdDetails.click_buyNow();
			
			driver.switchTo().frame(pfCart.frm_cart);
			String actRes = pfCart.getAddCartMsg();
			
			if(actRes.contains(expRes))
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
}
