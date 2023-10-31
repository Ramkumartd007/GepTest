package testng.org1;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
public static void main(String[] args) throws Exception {
	String src = "D:\\TestData.xlsx";
	XSSFWorkbook wb = new XSSFWorkbook(src);
	XSSFSheet sheet = wb.getSheetAt(0);
	XSSFRow row = sheet.getRow(1);
	XSSFCell cell = row.getCell(0);
	String Value = cell.getStringCellValue();
	//String data0 = sheet1.getRow(0).getCell(1).getStringCellValue(); 
	System.out.println("Data from Excel is" + Value);
} 
}
