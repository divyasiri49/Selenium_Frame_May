package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pf_ProductDetails {
	
	@FindBy(className="buynowbtnbig")
	public WebElement btn_buynow;
	
	public Pf_ProductDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void click_buyNow()
	{
		btn_buynow.click();
	}
}
