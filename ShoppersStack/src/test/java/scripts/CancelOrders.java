package scripts;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.Login;
import pom.Logout;
import pom.Orders;

public class CancelOrders extends OpenCloseApplication
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
		
		Orders orders = new Orders(driver);
		orders.accountSettingsClickable();
		Thread.sleep(2000);
		orders.clickAccountSettings();
		Thread.sleep(2000);
		orders.clickOrders();
		Thread.sleep(2000);
		orders.cancelOrders();
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
