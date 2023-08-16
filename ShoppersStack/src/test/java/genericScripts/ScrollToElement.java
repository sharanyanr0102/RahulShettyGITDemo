package genericScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToElement {
	public static void scrollTo(WebDriver driver, WebElement element) throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		Point point = element.getLocation();
		int x = point.getX();
		int y = point.getY();
		
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
}
