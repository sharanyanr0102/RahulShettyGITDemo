package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	WebDriver driver;
	
	@FindBy(xpath="//button[@aria-label='Account settings']")
	private WebElement accSettings;
	
	@FindBy(xpath="//li[.='Logout']")
	private WebElement loginButton;
	
	public Logout(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void accountSettingsClickable() throws InterruptedException
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, 100);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(accSettings));
		Thread.sleep(10000);
	}
	
	public void clickAccountSettings()
	{
		accSettings.click();
	}
	
	public void clickLogout()
	{
		loginButton.click();
	}
}
