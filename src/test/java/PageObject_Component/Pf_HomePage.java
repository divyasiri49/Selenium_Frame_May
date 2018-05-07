package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pf_HomePage {

	//2nd section
	@FindBy(linkText="Sign In")
	public WebElement lnk_signIn;
	
	@FindBy(className="proper")
	public WebElement valid_msg;
	
	@FindBy(partialLinkText="Out")
	public WebElement lnk_signout;
	
	@FindBy(name="srchword")
	public WebElement txtbox_srchword;
	
	@FindBy(className="newsrchbtn")
	public WebElement btn_search;
	
	@FindBy(className="sorrymsg")
	public WebElement invalid_searchmsg;
	
	@FindBy(id="find")
	public WebElement valid_searchmsg;
	
	@FindBy(xpath="//a[contains(text(),'Ravinder Singh')]")
	public WebElement cart_element;
	
	@FindBy(className="f16")
	public WebElement valid_cartElement;
	
	@FindBy(xpath="//div[@class='bookbox'][1]//img")
	public WebElement img_book;
	
	
	//1st section
	public Pf_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); //Be on that page
	}
	
	//3rd section
	public void clickSignIn()
	{
		lnk_signIn.click();
	}
	
	public String getValidMsg()
	{
		return valid_msg.getText();
	}
	
	public void clickSignOut()
	{
		lnk_signout.click();
	}
	
	public void ClickSearch(String inputSearch)
	{
		txtbox_srchword.sendKeys(inputSearch);
		btn_search.click();		
	}
	public String getInvalidSearchMsg()
	{
		return invalid_searchmsg.getText();
	}
	
	public String getValidSearchMsg()
	{
		return valid_searchmsg.getText();
	}
	public void ClickCartElement()
	{
		cart_element.click();
	}
	
	public String getValidcartElementMsg()
	{
		return valid_cartElement.getText();
	}
	
	public void Click_Book()
	{
		img_book.click();
	}
}
