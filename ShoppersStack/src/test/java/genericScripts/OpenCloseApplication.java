package genericScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCloseApplication implements FrameworkConstants
{
	public WebDriver driver;
	
	@BeforeMethod
	public void openApplication() throws Exception
	{
		System.setProperty(chrome_key, chrome_value);
		
//		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String url = FetchProperty.fetchPropertyByName("./src/test/resources/data1.properties", "url");
		
		driver.get(url);
	}
	
	@AfterMethod
	public void closeApplication() 
	{
		driver.close();
	}
	
}
