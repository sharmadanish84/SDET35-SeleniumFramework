package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataExcelTest {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		for (int i = 0; i <=6; i++) 
		{
			Row row = sheet.getRow(i);
			for (int j = 0; j <=1; j++) {
				Cell cell = row.getCell(j);
				String data = cell.getStringCellValue();
				System.out.print(data + " ");
			}
			System.out.println(" ");	
		}
		
		

	}

}
