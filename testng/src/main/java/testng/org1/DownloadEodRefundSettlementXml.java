package testng.org1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadEodRefundSettlementXml {
	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91991\\eclipse-workspace\\testng\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String beforeXpath_company =  "//*[@id='customers']/tbody/tr[";
		String afterXpath_company = "]/td[1]";
		
		String beforeXpath_contact =  "//*[@id='customers']/tbody/tr[";
		String afterXpath_contact = "]/td[2]";
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("total number of rows = "+ rows.size());
		int rowCount = rows.size();
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\91991\\Desktop\\test.xlsx");
		
		if(!reader.isSheetExist("TableData"))
		{
			reader.addSheet("TableData");			
		}
	
	//	reader.addColumn("TableData", "CompanyName");
	//	reader.addColumn("TableData", "ContactName");
		
		for (int i = 2; i <= rowCount; i++) {
		String actualXpath_company = beforeXpath_company+i+afterXpath_company;
		String companyname = driver.findElement(By.xpath(actualXpath_company)).getText();
		System.out.println(companyname);
		reader.setCellData("TableData", "CompanyName", i, companyname);
			
		String actualXpath_contact = beforeXpath_contact+i+afterXpath_contact;
		String contactname = driver.findElement(By.xpath(actualXpath_contact)).getText();
		System.out.println(contactname);
		reader.setCellData("TableData", "ContactName", i, companyname);
		
		}
		}
		
}
