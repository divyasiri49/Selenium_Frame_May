package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pf_Cart{
	@FindBy(xpath ="//span[@id='currentcartdiv']/form/div/ul[1]/li[2]/cite[3]/span[2]")
	public WebElement Addcart_msg;
	
	@FindBy(id="frmCart")
	public WebElement frm_cart;
	
	//*[@id="currentcartdiv"]/form/div/ul[1]/li[2]/cite[3]/span[2]
	//"//span[contains(text(),'Can Love Happen Twice? (English) (Paperback)']"
	
	public Pf_Cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public String getAddCartMsg()
	{
		return Addcart_msg.getText();
	}
}
