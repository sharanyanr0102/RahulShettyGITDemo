package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductView {
	@FindBy(xpath="//div[contains(@class,'featuredProducts')]/img")
	private WebElement featuredProduct;
	
	public ProductView(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnProduct() throws Exception
	{
		featuredProduct.click();
	}
}
