package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
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

public class TenderItemRate extends BaseClass {

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
	  	 
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\itemwise\\config.properties");
		prop.load(input);
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoetenders.tn.nic.in/nicgep/app");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("login")).click(); 
		Thread.sleep(2000);
		try {  
				     while(driver.findElement(By.id("UserName")).isDisplayed())
				    	 {Thread.sleep(1000);
		    	 	   try {
		    	Thread.sleep(2000);
		    	driver.findElement(By.id("UserName")).clear();
				driver.findElement(By.id("Password")).clear();
				driver.findElement(By.id("UserName")).sendKeys("deptuser4@nic.in");
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
			for(int i=1;i<10;i++) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Create Tender')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("bd")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("tenderRefNo")).sendKeys("TDRflow"+date);
		selection(driver.findElement(By.name("tenderType")), "ByVisibleText", "Open Tender");
		selection(driver.findElement(By.id("formContract")), "ByVisibleText", "Supply");
		selection(driver.findElement(By.name("noOfPackets")), "ByValue", "2");
		selection(driver.findElement(By.name("tenderCategory")), "ByVisibleText", "Services");
		selection(driver.findElement(By.name("bidOpenerType")), "ByIndex", "2");
			
		/*
		try {
			driver.findElement(By.xpath("(//input[@value='1'])")).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Automation is Disabled");;
		}
		
		try {
			driver.findElement(By.id("multiCurYes")).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Multicurrency is Disabled");;
		}
		*/
		
		try {
			driver.findElement(By.id("Next")).click();
			System.out.println("Sucessful - Basic details");
			Thread.sleep(1000);
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		// CoverDetails - Technical cover
		
		try {
			driver.findElement(By.id("one")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("docDesc")).sendKeys("Technical");
			selection(driver.findElement(By.id("docType")), "ByVisibleText", ".pdf");Thread.sleep(500);
			driver.findElement(By.id("Save")).click(); Thread.sleep(500);
			driver.findElement(By.id("DirectLink_2")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			// FinancialDetails
			driver.findElement(By.id("one_0")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("docDesc")).sendKeys("Finance");
			selection(driver.findElement(By.id("docType")), "ByVisibleText", ".xls");Thread.sleep(500);
			driver.findElement(By.id("Save")).click();Thread.sleep(500);
			driver.findElement(By.id("DirectLink_2")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("Next")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Sucessful - Cover details");
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		// NIT Document
		try {
			driver.findElement(By.id("DirectLink_0")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("checkbox4")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("Verifysave")).click();
			Thread.sleep(500);
			driver.findElement(By.id("DirectLink_3")).click();
			System.out.println("Sucessful - NIT Document verified");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		// Work/Item Details
		Thread.sleep(1500);
		try {
			driver.findElement(By.id("txtTenderTitle")).sendKeys("checkflow");
			driver.findElement(By.id("txtWorkDesc")).sendKeys("checkflow");
			driver.findElement(By.id("txtPreQual")).sendKeys("checkflow");
			driver.findElement(By.id("txtProductSubcategory")).sendKeys("checkflow");
			driver.findElement(By.id("tenderValue")).sendKeys("1300000");
			driver.findElement(By.id("showTenderValueYes")).click();
			driver.findElement(By.id("txtLocation")).sendKeys("Chennai");
			driver.findElement(By.id("pinCodeLocation")).sendKeys("600000");
			driver.findElement(By.id("bidOpeningPlace")).sendKeys("Chennai");
			driver.findElement(By.id("invitingOfficer")).sendKeys("Officer");
			driver.findElement(By.id("invitingOfficerAddress")).sendKeys("Address");
			driver.findElement(By.id("expireDays")).sendKeys("45");
			driver.findElement(By.id("allowMediaPublishDateNo")).click();
			driver.findElement(By.id("allowTenderBulletinDateNo")).click();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		try {
			driver.findElement(By.xpath("//input[@name='mclServiceAllowed']")).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("No Service completion");
		}
		*/
		try {
			selection(driver.findElement(By.id("productCategory")), "ByVisibleText", "Manpower Supply");
			selection(driver.findElement(By.id("contractType")), "ByVisibleText", "Tender");
			selection(driver.findElement(By.id("secValidDays")), "ByVisibleText", "120");
			selection(driver.findElement(By.id("TendererClass")), "ByVisibleText", "OTHERS");
				
			driver.findElement(By.id("Next")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Sucessful - Work/Item Details");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Fee Details
		try {
			driver.findElement(By.id("NotApplicable")).click();
			driver.findElement(By.id("Next")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Sucessful - Fee Details");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Critical Dates
		
	    
	  	 
	  	  	 
	  	 if(timeHH < 9) {   	
	  	
	  		driver.findElement(By.id("publishDate")).sendKeys(date);Thread.sleep(200);
		    driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);Thread.sleep(200);
		    driver.findElement(By.id("bidSubStartDate")).sendKeys(date);Thread.sleep(200);
		    driver.findElement(By.id("bidSubCloseDate")).sendKeys(date); Thread.sleep(200);
		    driver.findElement(By.id("bidOpenDate")).sendKeys(date);Thread.sleep(200);
		    	    
		    selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", "09");
		    selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", "09");
		    selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", "09");
		    selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", "09");
		    selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", "09");
		    
		    selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", "05");
		    selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", "05");
		    selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", "05");
		    selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", "20");
		    selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", "20");	 
		    
		    Thread.sleep(5000);
	     System.out.println(" Tender Creation Before: 9 am");}
	  	 
	 	 else if (timeHH >19) {  
	 		
	 		driver.findElement(By.id("publishDate")).sendKeys(DATE1);Thread.sleep(200);
		    driver.findElement(By.id("documentSaleStartDate")).sendKeys(DATE1);Thread.sleep(200);
		    driver.findElement(By.id("bidSubStartDate")).sendKeys(DATE1);Thread.sleep(200);
		    driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE1); Thread.sleep(200);
		    driver.findElement(By.id("bidOpenDate")).sendKeys(DATE1);Thread.sleep(200);
		    	    
		    selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", "09");
		    selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", "09");
		    selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", "09");
		    selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", "09");
		    selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", "09");
		    
		    selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", "05");
		    selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", "05");
		    selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", "05");
		    selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", "20");
		    selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", "20");	 
		    
		    Thread.sleep(2000);
	     System.out.println(" Tender Creation after: 7 pm");}
	  	 
	 	 else {
	   	    
	   	 if(timemr <= 50 && timemr5 <= 60 ) {
	   		 
	   	    driver.findElement(By.id("publishDate")).sendKeys(date);Thread.sleep(200);
	 	    driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);Thread.sleep(200);
	 	    driver.findElement(By.id("bidSubStartDate")).sendKeys(date);Thread.sleep(200);
	 	    driver.findElement(By.id("bidSubCloseDate")).sendKeys(date); Thread.sleep(200);
	 	    driver.findElement(By.id("bidOpenDate")).sendKeys(date);Thread.sleep(200);
	 	    	    
	 	    selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", timeH);
	 	    selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", timeH);
	 	    selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", timeH);
	 	    selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", timeH);
	 	    selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", timeH);
	 	    
	 	    selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", timer);
	 	    selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", timer);
	 	    selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", timer);
	 	    selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", timer15);
	 	    selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", timer15);
	 	    
	 	   Thread.sleep(5000);
	  		 
	  	 }
	   	else if(timemr >= 60 && timemr5 >= 60 ) {
	 		 
	 		driver.findElement(By.id("publishDate")).sendKeys(date);Thread.sleep(200);
	 	    driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);Thread.sleep(200);
	 	    driver.findElement(By.id("bidSubStartDate")).sendKeys(date);Thread.sleep(200);
	 	    driver.findElement(By.id("bidSubCloseDate")).sendKeys(date); Thread.sleep(200);
	 	    driver.findElement(By.id("bidOpenDate")).sendKeys(date);Thread.sleep(200);
	 	    	    
	 	    selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", timeH1);
	 	    selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", timeH1);
	 	    selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", timeH1);
	 	    selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", timeH1);
	 	    selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", timeH1);
	 	    
	 	    selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", timer60);
	 	    selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", timer60);
	 	    selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", timer60);
	 	    selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", timer560);
	 	    selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", timer560);
	 	    
	 	   Thread.sleep(5000);
	   		 
	   	 }else if(timemr >= 50 && timemr5 >=60 ) {
	 		 	 		 
	 		 driver.findElement(By.id("publishDate")).sendKeys(date);Thread.sleep(200);
		 	 driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);Thread.sleep(200);
		 	 driver.findElement(By.id("bidSubStartDate")).sendKeys(date);Thread.sleep(200);
		 	 driver.findElement(By.id("bidSubCloseDate")).sendKeys(date); Thread.sleep(200);
		 	 driver.findElement(By.id("bidOpenDate")).sendKeys(date);Thread.sleep(200);
		 	    	    
		 	 selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", timeH1);
		 	 selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", timeH1);
		 	 selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", timeH1);
		 	 selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", timeH1);
		 	 selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", timeH1);
		 	    
		 	 selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", timer50);
		 	 selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", timer50);
		 	 selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", timer50);
		 	 selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", timer560);
		 	 selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", timer560);
		 	 
		 	Thread.sleep(5000);
		   		 
	   	 }
	         }
	  	Thread.sleep(500);		
		driver.findElement(By.id("Next")).click();
		
		try {
			Thread.sleep(500);
			driver.switchTo().alert().accept();Thread.sleep(2000);
			driver.findElement(By.id("Next")).click();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.out.println("No Alert");;
		}
		Thread.sleep(1500);
		System.out.println("Sucessful - Critical Date");
		
		// Bid openers List
		try {
		driver.findElement(By.xpath("//td[text()='venkat@nic.in']//following-sibling::td//input")).click();
		driver.findElement(By.xpath("//td[text()='kevin@gmail.com']//following-sibling::td//input")).click();
		driver.findElement(By.xpath("//td[text()='deptuser27@nic.in']//following-sibling::td//input")).click();
		driver.findElement(By.id("Submit")).click();
		System.out.println("Sucessful - Bid openers List");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("No Bid Openers");;
		}
		Thread.sleep(1500);
//driver.findElement(By.xpath("//table[contains(text()='depteproc@nic.in')]/parent::td//preceding-sibling::td//input[@type()='checkbox']")).click();
//td[text()='depteproc@nic.in'][@type='checkbox']

		// Work/item Documents - BoQ
		/*
		driver.findElement(By.id("DirectLink_3")).click();
		Thread.sleep(1500);
		Select Bdt = new Select(driver.findElement(By.id("documentType")));
		Bdt.selectByVisibleText("BOQ");
		driver.findElement(By.id("description")).sendKeys("BOQ - Price Bid");
		Thread.sleep(1500);
		ItemRateTemplate();
		System.out.println("sucessful - BOQ Upload ");
		Thread.sleep(1500);
		Signingpdf();
		System.out.println("sucessful - BOQ Signed");
		Thread.sleep(1500);
		driver.findElement(By.id("save")).click();
		System.out.println("sucessful - BOQ Saved ");
		Thread.sleep(1500);
		*/
		driver.findElement(By.id("DirectLink_1")).click();
		Thread.sleep(1500);
	    //driver.findElement(By.id("ViewBOQCheck")).click();
		//System.out.println("sucessful - BOQ Checked");
		//Thread.sleep(1500);
		driver.findElement(By.id("checkbox4")).click();
		driver.findElement(By.id("Verifysave")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("DirectLink_5")).click();
		System.out.println("sucessful - BOQ Uploading Stage Completed");
		Thread.sleep(1500);
		try {
			driver.switchTo().alert().accept();Thread.sleep(2000);
			} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.out.println("No Alert");;
		}
		Thread.sleep(1000);
		// OID Documents List
		try {
			driver.findElement(By.id("save")).click();
			System.out.println("sucessful - OID Stage Completed");
			Thread.sleep(500);
		} catch (NoSuchElementException e) {
			driver.findElement(By.id("Next")).click();
			System.out.println("sucessful - OID Stage Completed");
		}
		Thread.sleep(1500);

		// Send to Publish
	    driver.findElement(By.id("Submit")).click();
	    System.out.println("sucessful - Tender Send to Publish");
	    Thread.sleep(1500);
	    WebElement id = driver.findElement(By.xpath("//table[@class='message_box']/tbody/tr[9]/td/b/span/span/b"));
	    String Tenderid = id.getText();
	    System.out.println("id:"+Tenderid);
	    Thread.sleep(1500);
	    
	    // Publish Tender
	    driver.findElement(By.id("PageLink_0_13")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.id("TenderId")).sendKeys(Tenderid);
	    driver.findElement(By.id("search")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.id("view")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.id("Submit")).click();
	    Thread.sleep(500);
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
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);

	}

	public static void ItemRateTemplate() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(900, 490);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(456, 290);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(800, 530);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(456, 290);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(800, 530);
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
}
