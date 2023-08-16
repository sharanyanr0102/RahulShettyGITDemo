package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericScripts.FetchProperty;

public class SearchProduct {
	WebDriver driver;
	
	@FindBy(id="search")
	private WebElement searchTxt;
	
	@FindBy(id="searchBtn")
	private WebElement searchBtn;
	
	public SearchProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterSearchKeyword() throws Exception
	{
		searchTxt.sendKeys(FetchProperty.fetchPropertyByName("./src/test/resources/data1.properties", "product"));
	}
	
	public void clickSearchButton() 
	{
		searchBtn.click();
	}
}
