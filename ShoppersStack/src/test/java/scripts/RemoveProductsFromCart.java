package scripts;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.Cart;
import pom.Login;
import pom.Logout;

public class RemoveProductsFromCart extends OpenCloseApplication
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
			
			Cart cart = new Cart(driver);
			cart.goToCart();
			Thread.sleep(2000);
			cart.removeProducts();
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
