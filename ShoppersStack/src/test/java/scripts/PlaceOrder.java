package scripts;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.AddToCart;
import pom.Login;
import pom.Logout;
import pom.Orders;
import pom.ProductView;
import pom.SearchProduct;

public class PlaceOrder extends OpenCloseApplication
{
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
		login.clickLogin2();
		Thread.sleep(2000);
		
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.enterSearchKeyword();
		Thread.sleep(2000);
		searchProduct.clickSearchButton();
		Thread.sleep(2000);
		
		ProductView productView = new ProductView(driver);
		productView.clickOnProduct();
		Thread.sleep(2000);
		
		AddToCart addToCart = new AddToCart(driver);
		addToCart.clickOnAddToCart();
		Thread.sleep(2000);
		addToCart.goToCart();
		Thread.sleep(2000);
		addToCart.takeScreenShotOfCart();
		Thread.sleep(2000);
		
		/*
		addToCart.removeFromCart();
		Thread.sleep(2000);
		addToCart.confirmRemovalFromCart();
		Thread.sleep(2000);
		addToCart.takeScreenShotOfCarton(driver);
		Thread.sleep(2000);
		*/
		
		addToCart.clickBuyNow();
		Thread.sleep(2000);
		
		addToCart.selectAddress();
		Thread.sleep(2000);
		
		addToCart.clickProceed();
		Thread.sleep(2000);
		
		addToCart.selectPayment();
		Thread.sleep(2000);
		
		addToCart.clickProceed();
		Thread.sleep(2000);
		
		addToCart.takeScreenShotOfCart();
		Thread.sleep(2000);
		
		Orders orders = new Orders(driver);
		orders.accountSettingsClickable();
		Thread.sleep(2000);
		orders.clickAccountSettings();
		Thread.sleep(2000);
		orders.clickOrders();
		Thread.sleep(2000);
		orders.takeScreenShotOfOrders();
		Thread.sleep(2000);
		
		Logout logout = new Logout(driver);
		logout.accountSettingsClickable();
		Thread.sleep(2000);
		logout.clickAccountSettings();
		Thread.sleep(2000);
		logout.clickLogout();
		Thread.sleep(2000);
	}
}
