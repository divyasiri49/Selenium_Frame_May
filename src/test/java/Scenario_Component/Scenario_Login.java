package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import DataProvider_Component.DataProvider_loaddata;
import Generic_Component.Base_Class;
import PageObject_Component.Pf_HomePage;
import PageObject_Component.Pf_Signin;

public class Scenario_Login extends Base_Class{
	
	@Test(dataProvider="dp_InvalidLogin", dataProviderClass=DataProvider_Component.DataProvider_loaddata.class,groups={"smoke"})
	public void testInvalidLogin(Map<String,String> login) throws IOException
	{
		SoftAssert sAssert = new SoftAssert();
		Pf_HomePage pfHomePage = new Pf_HomePage(driver);
		pfHomePage.clickSignIn();
		
		String uname = login.get("Uname");
		String pswd = login.get("Pwd");
		String expRes = login.get("Exp_Result");
		String tc_id = login.get("TC_ID");
		String order_set = login.get("Order_Set");
		
		log.info("Execting the Testcase is "+tc_id+" Order Set is "+order_set);
		
		Pf_Signin pfSignIn = new Pf_Signin(driver);
		pfSignIn.cl_login(uname, pswd);
		String actRes = pfSignIn.getInvalid_msg();
		
		if(actRes.equals(expRes))
			log.info("Passed as actual result is "+actRes+" Expected result is "+expRes);
		else
		{
			log.info("Failed as actual result is "+actRes+" Expected result is "+expRes);
			CaptureScreenshot(tc_id, order_set);
			sAssert.fail("Failed as actual result is "+actRes+" Expected result is "+expRes);
			
		}
		sAssert.assertAll();
	}
	
	@Test(dataProvider="dp_ValidLogin", dataProviderClass=DataProvider_Component.DataProvider_loaddata.class,groups={"regression"})
	public void testValidLogin(Map<String,String> login) throws IOException
	{
		SoftAssert sAssert = new SoftAssert();
		Pf_HomePage pfHomePage = new Pf_HomePage(driver);
		pfHomePage.clickSignIn();
		
		String uname = login.get("Uname");
		String pswd = login.get("Pwd");
		String expRes = login.get("Exp_Result");
		String tc_id = login.get("TC_ID");
		String order_set = login.get("Order_Set");
		
		log.info("Execting the Testcase is "+tc_id+"Order Set is "+order_set);
		
		Pf_Signin pfSignIn = new Pf_Signin(driver);
		pfSignIn.cl_login(uname, pswd);
		String actRes = pfHomePage.getValidMsg();
		//System.out.println(actRes);
		
		if(actRes.contains(expRes))
			log.info("Passed as actual result is "+actRes+"Expected result is "+expRes);
		else
		{
			log.info("Failed as actual result is "+actRes+"Expected result is "+expRes);
			CaptureScreenshot(tc_id, order_set);
			sAssert.fail("Failed as actual result is "+actRes+"Expected result is "+expRes);
		}
		pfHomePage.clickSignOut();
		sAssert.assertAll();
	}

}
