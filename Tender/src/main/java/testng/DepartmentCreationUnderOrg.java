package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class DepartmentCreationUnderOrg extends BaseClass {
	public static void main(String[] args)  throws InterruptedException, AWTException, TesseractException, IOException  {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Xls_Reader reader = new Xls_Reader("C:\\Users\\91991\\Documents\\HRANC\\HRANC.xls");
		
		
		String sheetName = "HRANCN";
		String Org;
		String Dept;
		String Div;
		String Sdiv;
		
		
			//String url2 = reader.getCellData(sheetName, "URL2" , j);
			driver.get("https://demoeproc.nic.in/nicgep/app");
			//List<WebElement> rows = driver.findElements(By.xpath("//table_1[@id='tabList_1']/tr"));
			//System.out.println("total number of rows = "+ rows.size());
			//int rowCount = rows.size();  //table_1[@id='tabList_1']
		   	
		    driver.manage().window().maximize();
			Thread.sleep(1000);
			driver.findElement(By.id("login")).click(); 
			Thread.sleep(1000);
			
					     try {  
					    	 Thread.sleep(1000);
					     while(driver.findElement(By.id("captchaImage")).isDisplayed())
					    	 {
					    	 try {  
					 	   
			    	driver.findElement(By.id("UserName")).clear();
					driver.findElement(By.id("Password")).clear();
					driver.findElement(By.id("UserName")).sendKeys("appadmin@nic.in");
					driver.findElement(By.id("Password")).sendKeys("Admin123$");
					WebElement capt = driver.findElement(By.xpath("//img[@id='captchaImage']"));
					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					BufferedImage fullImg = ImageIO.read(screenshot);
					Point point = capt.getLocation();
					int eleWidth = capt.getSize().getWidth();
					int eleHeight = capt.getSize().getHeight();
					BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
					ImageIO.write(eleScreenshot, "png", screenshot);
					File screenshotLocation = new File("C:\\Users\\91991\\eclipse-workspace\\com\\Screenshot\\Captcha.png");
					FileUtils.copyFile(screenshot, screenshotLocation);
					ITesseract image = new Tesseract();
					String imagetest = image
							.doOCR(new File("C:\\Users\\91991\\eclipse-workspace\\com\\Screenshot\\Captcha.png"));
					String x = imagetest.replaceAll("[^a-z0-9A-Z]", "");
					System.out.println(x);
					driver.findElement(By.id("CaptchaText")).sendKeys(x);
					Thread.sleep(2000);
					driver.findElement(By.id("submitSHA")).click();
					System.out.println("Sucessful - First Login");
					System.out.println("Available");
					Thread.sleep(2000);
					    	 }
					   		  catch (NoSuchElementException e) {
					    			System.out.println(e);	
					  		
			 }
					    	 }
					     }
				   		  catch (NoSuchElementException e) {
				    			System.out.println(e);	
				  		
		 }
	    Thread.sleep(2000);
		
		Robot1();
		Thread.sleep(8000);
		
		driver.findElement(By.id("PageLink_0_3")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selection(driver.findElement(By.id("orgCombo")), "byVisibleText", "Hindu Religious and Charitable Endowments");
		Thread.sleep(2000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(2000);
					
					
		for (int j = 2; j <= 7; j++) {
			Dept = reader.getCellData(sheetName,"Dept", j);
			Div = reader.getCellData(sheetName,"Div", j);
			Sdiv = reader.getCellData(sheetName,"Sdiv", j);
			try {
				driver.findElement(By.id("bd")).click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//	driver.findElement(By.id("deptLevelOption")).click();	Thread.sleep(500);
			//	driver.findElement(By.id("divLevelOption")).click();	Thread.sleep(1000);
				driver.findElement(By.id("subDivLevelOption")).click();	Thread.sleep(500);		
				driver.findElement(By.id("add")).click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				selection(driver.findElement(By.id("orgCombo")), "byVisibleText", "Hindu Religious and Charitable Endowments");Thread.sleep(5000);
				selection(driver.findElement(By.id("deptCombo")), "byVisibleText", Dept);Thread.sleep(100);
				selection(driver.findElement(By.id("divCombo")), "byVisibleText", Sdiv);Thread.sleep(2000);
				driver.findElement(By.id("organisationName")).sendKeys(Div);
				Thread.sleep(500);
				//driver.findElement(By.id("orgCode")).sendKeys("orgg");Thread.sleep(500);
				driver.findElement(By.id("save")).click(); Thread.sleep(500);
				
				driver.findElement(By.xpath("//td[text()='Tender Work Flow']//following-sibling::td//a")).click();
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				
				driver.findElement(By.id("allowGTEYes")).click();	Thread.sleep(500);
				reader.setCellData("HRANCN", "GTE", j, "Success");
				driver.findElement(By.xpath("//input[@id='itePropertyId'][2]")).click();	Thread.sleep(500);
				reader.setCellData("HRANCN", "ITE", j, "Success");
				driver.findElement(By.id("Save")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//td[text()='Auction properties']//following-sibling::td//a")).click();
				Thread.sleep(2000);
				
				selection(driver.findElement(By.id("bidAutoExtnInMins")), "byVisibleText", "10");
				Thread.sleep(500);
				selection(driver.findElement(By.id("elapseTimeIntervalInMins")), "byVisibleText", "05");
				Thread.sleep(500);
				driver.findElement(By.id("maxSealPercentage")).clear();
				driver.findElement(By.id("maxSealPercentage")).sendKeys("50");   
				Thread.sleep(500);
				reader.setCellData("HRANCN", "AUCTION", j, "Success");
				driver.findElement(By.id("Save")).click();Thread.sleep(500);
				
				
				driver.findElement(By.id("save")).click();
				reader.setCellData("HRANCN", "Status", j, "Success");
				System.out.println(Div+" - Success");
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(Div+" - fail");
				reader.setCellData("HRANCN", "Status", j, "Failed");
				reader.setCellData("HRANCN", "GTE", j, "Failed");
				reader.setCellData("HRANCN", "ITE", j, "Failed");
			}
								
	    
		Thread.sleep(2000);
		
		
		}
		}
		
		
	
	public static void Robot1() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(489, 526);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(276, 156);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(2000);
		robot.mouseMove(460, 492);
		robot.delay(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(4000);

	}
}