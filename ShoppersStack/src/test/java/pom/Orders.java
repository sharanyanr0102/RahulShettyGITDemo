package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import genericScripts.TakePhoto;

public class Orders {
	WebDriver driver;

	@FindBy(xpath = "//button[@aria-label='Account settings']")
	private WebElement accSettings;

	@FindBy(xpath = "//li[.='My Orders']")
	private WebElement ordersButton;

	@FindBy(xpath = "//button[.='Cancel Order']")
	private List<WebElement> cancelOrdersButton;

	@FindBy(xpath = "//div[contains(@class,'MuiDialogActions')]/button[.='Yes']")
	private WebElement yesButton;

	@FindBy(xpath = "(//div[.='Order has been Cancelled'])[5]")
	private WebElement confirmationMessage;

	public Orders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void accountSettingsClickable() throws Exception {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 100);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(accSettings));
		Thread.sleep(10000);
	}

	public void clickAccountSettings() {
		accSettings.click();
	}

	public void clickOrders() {
		ordersButton.click();
	}

	public void takeScreenShotOfOrders() throws Exception {
		TakePhoto.takePhoto(driver);
	}

	public void cancelOrders() throws Exception {
		for (WebElement cancelOrders : cancelOrdersButton) 
		{
			cancelOrders.click();
			Thread.sleep(2000);
			yesButton.click();
			Thread.sleep(2000);
			Assert.assertEquals(confirmationMessage.isDisplayed(), true);
			Thread.sleep(2000);
		}
	}
}
