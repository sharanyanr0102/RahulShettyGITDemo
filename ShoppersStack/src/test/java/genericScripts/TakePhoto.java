package genericScripts;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakePhoto 
{
	public static void takePhoto(WebDriver driver) throws Exception
	{
		Date d = new Date();
		String date = d.toString();
		date = date.replace(' ', '_');
		date = date.replace(':', '-');
		String format = ".png";
		String path = "./photos/"+date+format;
		
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileHandler.copy(src, dest);
	}
}
