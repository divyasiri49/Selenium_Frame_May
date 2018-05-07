package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pf_Signin {
	//2nd section
	@FindBy(name="logid")
	public WebElement txtbox_uname;
	@FindBy(name="pswd")
	public WebElement txtbox_pswd;
	@FindBy(xpath="//input[@value='Login']")
	public WebElement btn_login;
	@FindBy(xpath="//b[contains(text(),'Sorry we were unable to complete this step because :')]")
	public WebElement invalid_msg;
	
	
	//1st section
	public Pf_Signin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3rd section
	public void cl_login(String uname, String pswd)
	{
		txtbox_uname.sendKeys(uname);
		txtbox_pswd.sendKeys(pswd);
		btn_login.click();
	}
	
	public String getInvalid_msg()
	{
		return invalid_msg.getText();
	}
}
