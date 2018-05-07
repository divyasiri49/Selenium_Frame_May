package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Base_Class {
	
	public WebDriver driver;
	
	public static Logger log = Logger.getLogger(Base_Class.class);
	
	Utility_Class c1= new Utility_Class();

	@BeforeMethod(groups={"smoke","regression"})
	public void LaunchApp() throws IOException
	{
		String browserType = c1.Reading_properties("bType");
		if(browserType.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(browserType.equals("firefox"))
		{
		driver = new FirefoxDriver();
		}
		else if(browserType.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\IEdriver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		}
		driver.get(c1.Reading_properties("URL"));
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public void CaptureScreenshot(String TC_ID, String Order_set) throws IOException
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		String timeStamp = sdf.format(date)+".png";
		
		TakesScreenshot screenshot =  (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\SkillBytes\\Selenium_Proj_Framework\\Screenshot\\"+ TC_ID+"_"+Order_set+"_"+timeStamp));
	}
	@AfterMethod(groups={"smoke","regression"})
	public void CloseApp()
	{
		driver.quit();
	}
}
