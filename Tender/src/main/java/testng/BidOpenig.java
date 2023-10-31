package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
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

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.jexl2.internal.AbstractExecutor.Set;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import org.apache.logging.log4j.*;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class BidOpenig extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException, ParseException {
		 String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
		 String timeH= new SimpleDateFormat("HH").format(new Date());
		 String timem= new SimpleDateFormat("mm").format(new Date());
		 Calendar cal = Calendar.getInstance();
	 	 cal.add(Calendar.DATE, 1);
		 String DATE1 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());
		 
		 int timeHH = Integer.valueOf(timeH);
		 int timemr = ((((Integer.valueOf(timem)/10)+1)*10));
	  	 int timemr5 = ((((Integer.valueOf(timem)/10)+1)*10)+20);
	  	 
	   String timeH1 = String.valueOf(timeHH+1);
	   String timer = String.valueOf(timemr);
	   String timer15 = String.valueOf(timemr5);
	   String timer50 = String.valueOf(timemr-50);
	   String timer60 = String.valueOf(timemr-60);
	   String timer560 = String.valueOf(timemr5-60);
	  	 
	    String Tenderid = "2023_NICT_9824_1";
	  	
	  	 
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\itemwise\\config.properties");
		prop.load(input);
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoetenders.tn.nic.in/nicgep/app");
		//driver.get("https://demoeproc.nic.in/nicgep/app");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("login")).click(); 
		Thread.sleep(3000);
		try {  
				     while(driver.findElement(By.id("UserName")).isDisplayed())
				    	 {Thread.sleep(1000);
		    	 	   try {
		    	Thread.sleep(1000);
		    	driver.findElement(By.id("UserName")).clear();
				driver.findElement(By.id("Password")).clear();
				driver.findElement(By.id("UserName")).sendKeys("deptuser4@nic.in");
				driver.findElement(By.id("Password")).sendKeys("Admin123$");
				//driver.findElement(By.id("UserName")).sendKeys("venkat@nic.in");
				//driver.findElement(By.id("Password")).sendKeys("Ven2490$");
				
				//driver.findElement(By.id("UserName")).sendKeys("kevin@gmail.com");
				//driver.findElement(By.id("Password")).sendKeys("Admin123$");
				
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
				Thread.sleep(1500);
				driver.findElement(By.id("submitSHA")).click();
				System.out.println("Sucessful - First Login");
				System.out.println("Available");
				Thread.sleep(3000);
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
	Thread.sleep(2000);
	
	try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Tenders to be Opened']")).click(); Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("TenderId")).sendKeys(Tenderid); Thread.sleep(200); 
		driver.findElement(By.id("search")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//td[text()='"+Tenderid+"']//following-sibling::td//a")).click();	Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//table[@class='grid grid_body']/tbody/tr/td/span/a[@title='Decrypt']")).click(); Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@title='Open Bids']")).click(); Thread.sleep(200);
		} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		
		}
	
	
	System.out.println("Quick Bid Opening is Under Processing");
	try {
		Thread.sleep(300);
		List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='tabList_1']/tbody/tr"));
		int rcoun1 = rows1.size();
		int rcount1 = rcoun1+1;
		System.out.println("ROW COUNT : "+rcount1);	
		
		for(int i=3;i<rcount1;i++) {	
			Thread.sleep(300);
			System.out.println("SL.NO: "+i);	
			try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				if(driver.findElement(By.xpath("//img[@src = 'images/bo_quick.png']")).isDisplayed()) {
				driver.findElement(By.xpath("//img[@src = 'images/bo_quick.png']")).click(); Thread.sleep(200);
				driver.findElement(By.id("Next")).click();	Thread.sleep(500);	
				System.out.println("Bids: " +i);
				
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				driver.findElement(By.id("Next")).click();Thread.sleep(500);
			}
		}
		
	driver.findElement(By.id("Submit")).click(); Thread.sleep(500);
	driver.findElement(By.id("Next")).click(); Thread.sleep(500);
	driver.findElement(By.id("txtSummary")).sendKeys("Today we have open the Technical Opening Summary and Found "+rcount1+" Bids");
	driver.findElement(By.id("Submit")).click(); Thread.sleep(500);			
	driver.findElement(By.id("DirectLink_3")).click();
	
	} catch (NoSuchElementException e) {
		e.printStackTrace();				
	}
		
	driver.findElement(By.xpath("//a[text()='Technical Evaluation']")).click(); Thread.sleep(500);
	
	driver.findElement(By.id("TenderId")).sendKeys(Tenderid); 
	driver.findElement(By.id("search")).click(); Thread.sleep(1000);
	driver.findElement(By.xpath("//td[text()='"+Tenderid+"']//following-sibling::td//a")).click();	Thread.sleep(500);

	try {
		List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='tabList_1']/tbody/tr"));
		int rcoun1 = rows1.size();
		int rcount1 = rcoun1+1;
		System.out.println("ROW COUNT : "+rcount1);	
		
		for(int i=2;i<rcount1;i++) {	
			Thread.sleep(300);
			System.out.println("SL.NO: "+i);
			
// GTE			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(driver.findElement(By.xpath("//td[text() = 'GTE']")).isDisplayed()) {
			driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+i+"]/td[4]/a[@title='General Technical Evaluation']")).click(); Thread.sleep(200);
			driver.findElement(By.id("reject")).click(); Thread.sleep(200);
			driver.findElement(By.id("Save")).click(); 
					}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No GTE");
			
			}
			
// Avail Preferential bidder			
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+i+"]/td[5]/a")).click(); Thread.sleep(200);
				driver.findElement(By.xpath("//input[@class ='customButton']")).click(); driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.findElement(By.id("save")).click();
				
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("No GTE");
				
				}
			try {selection(driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+i+"]/td[8]/a")), "ByVisibleText", "Responsive");} catch (NoSuchElementException e) {System.out.println(e);}
		    Thread.sleep(200);
		    driver.findElement(By.id("reason")).clear();
		    driver.findElement(By.id("reason")).sendKeys("Accepted");
		    
			}
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.id("Submit")).click(); Thread.sleep(200);
	driver.findElement(By.id("txtChairpersonExternal")).sendKeys("Chairperson");
	
	
	
	}
	
	public static void Robot1() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(480, 515);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(276, 156);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(2000);
		robot.mouseMove(450, 485);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);

	}

	public static void Signingpdf() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(933, 490);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(680, 390);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
	}
	public static void setClipboardData(String filePath) {
	    StringSelection stringSelection = new StringSelection( filePath );
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
}
