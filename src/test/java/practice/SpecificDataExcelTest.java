package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SpecificDataExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			String data = cell.getStringCellValue();
			System.out.println(data);
			if (data!=null) {
				Cell cell1 = row.getCell(2);
				System.out.println(cell1.getStringCellValue());
				
			} else {
				System.out.println("");

			}
			

	}

}
