package genericScripts;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	
	public static String getData(String path, String sheetName, int rowNum, int columnNum) throws Exception
	{
		FileInputStream fileInputStream = new FileInputStream(path);
		
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNum);
		
		Cell cell = row.getCell(columnNum);
		
		String cellValue = cell.getStringCellValue();
		
		return cellValue;
	}
}
