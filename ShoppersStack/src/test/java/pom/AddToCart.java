package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericScripts.TakePhoto;

public class AddToCart {
	WebDriver driver;
	@FindBy(xpath="//*[.='add to cart']")
	private WebElement cartBtn;
	
	@FindBy(id="cart")
	private WebElement cartLink;
	
	@FindBy(xpath="//button[.='Remove from cart']")
	private WebElement removecartBtn;
	
	@FindBy(xpath="(//h3[.='Remove Product'])[1]/../following-sibling::div/button[.='Yes']")
	private WebElement yes;
	
	@FindBy(xpath="//button[.='Buy Now']")
	private WebElement buyNow;
	
	@FindBy(xpath="//input[@type='radio']")
	private WebElement addressRadioButton;
	
	@FindBy(xpath="//button[.='Proceed']")
	private WebElement proceed;
	
	@FindBy(xpath="//input[@type='radio' and @value='COD']")
	private WebElement cod;
	
	public AddToCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAddToCart() throws Exception
	{
		cartBtn.click();
	}
	
	public void goToCart() throws Exception
	{
		cartLink.click();
	}
	
	public void clickBuyNow() throws Exception
	{
		buyNow.click();
	}
	
	
	public void selectAddress() throws Exception
	{
		addressRadioButton.click();
	}
	
	public void clickProceed() throws Exception
	{
		proceed.click();
	}
	
	public void selectPayment() throws Exception
	{
		cod.click();
	}
	
	public void removeFromCart() throws Exception
	{
		removecartBtn.click();
	}
	
	
	public void confirmRemovalFromCart() throws Exception
	{
		yes.click();
	}
	
	public void takeScreenShotOfCart() throws Exception
	{
		TakePhoto.takePhoto(driver);
	}
}
