package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.jexl2.internal.AbstractExecutor.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import groovyjarjarantlr4.v4.parse.ANTLRParser.parserRule_return;

import org.apache.logging.log4j.*;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class MIS_Report_RSPaymentCheck extends BaseClass {

	public static WebDriver driver;
	private static String Tenderid;
	private static String parent;
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException,
			ParseException, WebDriverException {
		//Xls_Reader reader = new Xls_Reader("D:\\Test_Scenario_Excel\\AOC_Kerala.xls");
		Xls_Reader reader = new Xls_Reader("D:\\Test_Scenario_Excel\\AOC_WB.xls");
		String sheetName = "AOC_Tender";
		String aocbid;
		
		

		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\itemwise\\config.properties");
		prop.load(input);
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get((prop.getProperty("url")));
		Thread.sleep(500); 


		try {

			while (driver.findElement(By.id("username")).isDisplayed()) {
				Thread.sleep(500);

				try {
					Thread.sleep(1000);
					driver.findElement(By.id("username")).sendKeys("appspt1@nic.in");
					driver.findElement(By.id("username")).clear();
					driver.findElement(By.id("username")).sendKeys("apprag@nic.in");
				    driver.findElement(By.id("password")).sendKeys("Apprag123$$");
					WebElement capt = driver.findElement(By.xpath("//img[@id='captchaimg']"));
					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					BufferedImage fullImg = ImageIO.read(screenshot);
					Point point = capt.getLocation();
					int eleWidth = capt.getSize().getWidth();
					int eleHeight = capt.getSize().getHeight();
					BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
					ImageIO.write(eleScreenshot, "png", screenshot);
					File screenshotLocation = new File(
							"C:\\Users\\91991\\eclipse-workspace\\com\\Screenshot\\Captcha.png");
					FileUtils.copyFile(screenshot, screenshotLocation);
					ITesseract image = new Tesseract();
					String imagetest = image
							.doOCR(new File("C:\\Users\\91991\\eclipse-workspace\\com\\Screenshot\\Captcha.png"));
					String captcha = imagetest.replaceAll("[^a-z0-9A-Z]", "");
					System.out.println(captcha);
					driver.findElement(By.name("captcha")).sendKeys(captcha);
					driver.findElement(By.id("login")).click();
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					try
					{
					 driver.switchTo().alert().accept();
					 Thread.sleep(500);
					 }catch (NoAlertPresentException e)
					{
						System.out.println(e);
						
					}
					Thread.sleep(200);				
					
				} catch (NoSuchElementException e) {

					System.out.println(e);
					Thread.sleep(1000);
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);

		}
		
		Thread.sleep(12000);
		driver.findElement(By.xpath("//span[text()='Tender Management Reports']")).click();Thread.sleep(200);
		for (int i = 4; i < 30000; i++) {
			Thread.sleep(300);
		driver.findElement(By.xpath("//a[text()='Tender Discursive Report']")).click();Thread.sleep(1000);
		Tenderid = reader.getCellData(sheetName,"workitemrefno", i);
	//	aocbid = reader.getCellData(sheetName,"aocbidders", i);
		System.out.println(Tenderid);
		driver.findElement(By.id("tenderId")).sendKeys(Tenderid);Thread.sleep(500);
		driver.findElement(By.id("search")).click();Thread.sleep(1500);
	//	String TID = driver.findElement(By.xpath("(//table[@id='result']/tbody/tr/td)[2]")).getText();
	//	reader.setCellData(sheetName, "Tstatus", i, TID);
		try {
		driver.findElement(By.xpath("//img[@src='images/view.png']")).click();Thread.sleep(500);
		driver.findElement(By.xpath("(//td[text()='Bank Information']//following-sibling::td//img)[1]")).click();
		Thread.sleep(500);
		String parent = driver.getWindowHandle();
		Set<String> Child_id = driver.getWindowHandles();
		Iterator<String> win2 =Child_id.iterator();
	     String Childid1 = win2.next();
	     String Childid2 = win2.next();
	     driver.switchTo().window(Childid2);
	     System.out.println("so 1: "+driver.getTitle());
	     driver.manage().window().maximize();
	     Thread.sleep(5000);
/*
	     List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='bidderpayment']/tr"));
	     int Tbidcount = rows.size(); String Stbidcount = String.valueOf(Tbidcount);
	     List<WebElement> row1 = driver.findElements(By.xpath("//tbody[@id='bidderpayment']/tr/td[5][text()='NA']"));
	     int NaBid = row1.size(); String SNaBid = String.valueOf(NaBid);
	     System.out.println(SNaBid);
	     int Valid_Bid = Tbidcount-NaBid;
	     reader.setCellData(sheetName, "Total Bid", i, Stbidcount);
	     reader.setCellData(sheetName, "Invalid Bid", i, SNaBid);
	     reader.setCellData(sheetName, "Invalid Bid", i, SNaBid);
	     try {
			WebElement TO = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='TechnicalOpening']"));
			 WebElement TO_FO = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='Tech/Fin Opening']"));
			 WebElement FO = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='FinancialOpening']"));
			 WebElement TE = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='TechnicalEvaluation']"));
			 WebElement FE = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='FinancialEvaluation']"));
			 WebElement AOC = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='AOC']"));
			 WebElement Retender = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='Retender']"));
			 WebElement Cancelled = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='Cancelled']"));
			 WebElement Admin_Refund = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr/td[2][text()='AdminRefund']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
	     System.out.println("Total Bid Count: "+Tbidcount);
	     System.out.println("Invalid Bid Count: "+SNaBid);
	     for (int j=1;j<=Tbidcount;j++) {
	    	 String loginid = driver.findElement(By.xpath("//tbody[@id='refSettle']/tr[j]/td[2]")).getText().trim();
	    	 List<WebElement> loginidl = driver.findElements(By.xpath("//tbody[@id='refSettle']/tr/td[2]"));	 
	    	 if (loginidl.contains(loginid)) {
	    		 String bidrs = driver.findElement(By.xpath("//td[text()='"+loginid+"']//following-sibling::td[6][text()='Refunded']")).getText();
	    		
	    		if(bidrs == "Refunded")
		  		 {
	    			System.out.println("Refunded");
		  		 }else 
		  		 {
		  			reader.setCellData(sheetName, "rs status", i, "issue in the RS");
		  			break;
		  		 }
	    		 }
	     
	     }
	     */
	     SavePdf();
	     Thread.sleep(500);
	     driver.close();
	     driver.switchTo().window(parent);
	     System.out.println("Parent : "+driver.getTitle());
	     i++;
		}catch (NoSuchElementException e12){
			i++;
		}
	     
		/*}catch (Exception e) {
			System.out.println(e);
			reader.setCellData(sheetName, "Bank Information", i, "No Bank Information");
		}	
		*/
		}
		
	}
	public static void SavePdf() throws AWTException {
		Robot robot = new Robot();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(5000);
		setClipboardData("D:\\Test_Scenario_Excel\\AOC_WB\\"+Tenderid+".pdf");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);	
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(5000);
		}
	public static void setClipboardData(String filePath) {
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
}
