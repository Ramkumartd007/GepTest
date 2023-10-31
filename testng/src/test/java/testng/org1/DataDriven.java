package testng.org1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.logging.log4j.util.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
public static void main(String[] args) throws IOException{
	
	File f = new File("C:\\Users\\91991\\Desktop\\test.xlsx");
	
	
	FileInputStream fis = new FileInputStream(f);
	
	Workbook wb = new XSSFWorkbook(fis);
	
	Sheet firstSheet = wb.getSheetAt(0);
	
	int rowCount = firstSheet.getPhysicalNumberOfRows();
	
	for (int i = 0; i <= 2; i++) {
		Row Rowlocation = firstSheet.getRow(i);
	
		int cellCount = Rowlocation.getPhysicalNumberOfCells();
	for(int j = 0; j <= 2; j++) {
	
		Cell Data = Rowlocation.getCell(j);
	
		
		CellType cellType = Data.getCellType();
	if(cellType.equals(CellType.STRING)) {
		String stringCellValue = Data.getStringCellValue();
		System.out.println(stringCellValue);
	}
	else {
		double numericCellValue = Data.getNumericCellValue();
		System.out.println(numericCellValue);
		int numericData = (int) numericCellValue;
		System.out.println(numericData);
	     }
       }
	 }
System.out.println("------------------SpecificData-----------------");
double numericCellValue = wb.getSheetAt(0).getRow(5).getCell(3).getNumericCellValue();
int specificData = (int) numericCellValue;
System.out.println(specificData);

System.out.println("------------------WriteData-----------------");
Cell createCell = wb.getSheetAt(0).createRow(11).createCell(3);
createCell.setCellValue("Ramkumar");
FileOutputStream fos = new FileOutputStream(f);
wb.write(fos);
wb.close();
System.out.println("Value inserted Successfully");
}

}
