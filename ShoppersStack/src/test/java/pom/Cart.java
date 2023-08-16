package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cart {
	WebDriver driver;
	
	@FindBy(id="cart")
	private WebElement cartLink;
	
	@FindBy(xpath="//div[contains(@class,'cart_productDetails')]/h3")
	private List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[.='Remove from cart']")
	private List<WebElement> removecartBtn;
	
	@FindBy(xpath = "//div[contains(@class,'MuiDialogActions')]/button[.='Yes']")
	private WebElement yesButton;
	
	private ArrayList<String> productNames;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToCart() throws Exception
	{
		cartLink.click();
	}
	
	public void removeProducts() throws Exception 
	{
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.visibilityOfAllElements(cartProducts));
		Thread.sleep(3000);
		
		for (WebElement product : cartProducts) 
		{
			productNames.add(product.getText());
		}
		
		for (String product : productNames) {
			System.out.println(product);
		}
		
		int index=0;
		for (WebElement removeProduct : removecartBtn) 
		{
			index = removecartBtn.indexOf(removeProduct);
			removeProduct.click();
			Thread.sleep(2000);
			yesButton.click();
			Thread.sleep(2000);
			
			Assert.assertEquals(cartProducts.get(index).isDisplayed(), false);
			Thread.sleep(2000);
		}
	}
}
