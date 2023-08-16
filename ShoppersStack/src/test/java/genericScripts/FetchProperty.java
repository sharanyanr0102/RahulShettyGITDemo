package genericScripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FetchProperty {
	
	public static String fetchPropertyByName(String path, String pname) throws Exception
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fis);
		String value = properties.getProperty(pname);
		return value;
	}
}
