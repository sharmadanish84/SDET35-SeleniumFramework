package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetWriteTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("ExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.createCell(5);
		cell.setCellValue("Ninja H2R");
		FileOutputStream fos = new FileOutputStream("ExcelData.xlsx");
		wb.write(fos);
		wb.close();

	}

}
