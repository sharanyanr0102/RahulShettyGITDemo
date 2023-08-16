package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericScripts.FetchProperty;

public class Login {
	WebDriver driver;
	
	@FindBy(xpath="//div[.='Welcome to ShoppersStack. Enjoy shopping with us.']")
	private WebElement welcometext;
	
	@FindBy(id="loginBtn")
	private WebElement loginBtn1;
	
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="Login")
	private WebElement loginBtn2;
	
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void welcomeTextVisible()
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, 100);
		webDriverWait.until(ExpectedConditions.visibilityOf(welcometext));
	}
	public void clickLogin1()
	{
		loginBtn1.click();
	}
	
	public void enterUsername() throws Exception
	{
		email.sendKeys(FetchProperty.fetchPropertyByName("./src/test/resources/data1.properties", "uname"));
	}
	
	public void enterPassword() throws Exception
	{
		password.sendKeys(FetchProperty.fetchPropertyByName("./src/test/resources/data1.properties", "pswd"));
	}
	
	public void clickLogin2()
	{
		loginBtn2.click();
	}
}
