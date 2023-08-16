package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericScripts.FetchProperty;
import genericScripts.FrameworkConstants;
import genericScripts.TakePhoto;
import pom.Login;

public class LoginParallelExecution implements FrameworkConstants
{
	public WebDriver driver;

	@Parameters({"browser"})
	@BeforeMethod
	public void openApplication(String browser) throws Exception
	{
		if(browser.equals("chrome"))
		{
			System.setProperty(chrome_key, chrome_value);
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			System.setProperty(edge_key, edge_value);
			driver = new EdgeDriver();
		}
		else
		{
			System.setProperty(firefox_key, firefox_value);
			driver = new FirefoxDriver();
		}
		
		Reporter.log("Launched "+browser);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String url = FetchProperty.fetchPropertyByName("./src/test/resources/data1.properties", "url");
		
		driver.get(url);
	}
	
	@Test
	public void runner() throws Exception
	{
		Login login = new Login(driver);
		login.welcomeTextVisible();
		Thread.sleep(2000);
		login.clickLogin1();
		Thread.sleep(2000);
		login.enterUsername();
		Thread.sleep(2000);
		login.enterPassword();
		Thread.sleep(2000);
		
		TakePhoto.takePhoto(driver);
		login.clickLogin2();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeApplication() 
	{
		driver.close();
	}
}
