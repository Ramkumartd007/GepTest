package demoeproc;

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
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.jexl2.internal.AbstractExecutor.Set;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
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

public class TC_NormalFlow_TenderItemRate extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException, ParseException {
		 String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
		 String timeH= new SimpleDateFormat("HH").format(new Date());
		 String timem= new SimpleDateFormat("mm").format(new Date());
		 Calendar cal = Calendar.getInstance();
	 	 cal.add(Calendar.DATE, 1);
		 String DATE1 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());
		 cal.add(Calendar.DATE, 1);
		 String DATE2 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());
		 
		 int timeHH = Integer.valueOf(timeH);
		 int timemr = ((((Integer.valueOf(timem)/10)+1)*10));
	  	 int timemr5 = ((((Integer.valueOf(timem)/10)+1)*10)+20);
	  	 
	   String timeH1 = String.valueOf(timeHH+1);
	   String timer = String.valueOf(timemr);
	   String timer15 = String.valueOf(timemr5);
	   String timer50 = String.valueOf(timemr-50);
	   String timer60 = String.valueOf(timemr-60);
	   String timer560 = String.valueOf(timemr5-60);
	  	 
	    //String Title = "Ver.20/ATP/Works/TypeofCor/AOC";
	   	//String Title = " Ver.20/ITE/SF/CD/eAgre/LOA/AOC";
	   	//String Title = "Ver.20/Status/bidder/Dept/Home";
	      String Title = "Ver.20/Coal/AOC/Revoc/AOCcorri";
	   
	   	String tenderType = "Open Tender";
		String formContract = "Supply";
		String noOfPackets = "2";
		String tenderCategory = "Services";
		String bidOpenerType = "1";
	  	 
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\itemwise\\config.properties");
		prop.load(input);
		System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.get("https://demoetenders.tn.nic.in/nicgep/app");
		driver.get("https://demoeproc.nic.in/nicgep/app");
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
				driver.findElement(By.id("UserName")).sendKeys("venkat@nic.in");
				driver.findElement(By.id("Password")).sendKeys("Ven2490$");
				
				//driver.findElement(By.id("UserName")).sendKeys("deptuser4@nic.in");
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
				Thread.sleep(1000);
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
				Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Create Tender')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("bd")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("tenderRefNo")).sendKeys(Title);
		selection(driver.findElement(By.name("tenderType")), "ByVisibleText", tenderType);
		selection(driver.findElement(By.id("formContract")), "ByVisibleText", formContract);
		selection(driver.findElement(By.name("noOfPackets")), "ByValue", noOfPackets);
		selection(driver.findElement(By.name("tenderCategory")), "ByVisibleText",tenderCategory );
		selection(driver.findElement(By.name("bidOpenerType")), "ByIndex", bidOpenerType);
		try {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//input[@value='1'])")).click();
		} catch (NoSuchElementException e) {
		
			// TODO Auto-generated catch block
			System.out.println("Automation is Disabled");
		}
		/*
		try {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.id("multiCurYes")).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Multicurrency is Disabled");
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
			Thread.sleep(1000);
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
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.id("Next")).click();
			Thread.sleep(300);
			System.out.println("Sucessful - Cover details");
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
			System.out.println("Unsucessful - Cover details");
		}
		
		// NIT Document
		try
		{
		 Thread.sleep(1000);
		driver.findElement(By.id("DirectLink_2")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("description")).sendKeys("NIT");
		UploadNit();
		Thread.sleep(1000);
		driver.findElement(By.id("save")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("DirectLink_0")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("checkbox4")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("Verifysave")).click();
		Thread.sleep(500);
		driver.findElement(By.id("DirectLink_3")).click();
		System.out.println("Sucessful - NIT Document verified");
	 	}
		
		catch (NoSuchElementException e) {
			{ System.out.println(e);
		}
		 	}
					
		// Work/Item Details
		Thread.sleep(1500);
		try {
			driver.findElement(By.id("txtTenderTitle")).sendKeys(Title);
			driver.findElement(By.id("txtWorkDesc")).sendKeys(Title);
			driver.findElement(By.id("txtPreQual")).sendKeys(Title);
			driver.findElement(By.id("txtProductSubcategory")).sendKeys("ProductSubcategory");
			
			driver.findElement(By.id("tenderValue")).clear();driver.findElement(By.id("tenderValue")).sendKeys("1300000");Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.id("showTenderValueYes")).click();
			driver.findElement(By.id("txtLocation")).sendKeys("Chennai");
			driver.findElement(By.id("pinCodeLocation")).sendKeys("600000");		
			driver.findElement(By.id("bidOpeningPlace")).sendKeys("Chennai");
			driver.findElement(By.id("invitingOfficer")).sendKeys("Officer");
			driver.findElement(By.id("invitingOfficerAddress")).sendKeys("Address");
			driver.findElement(By.id("expireDays")).sendKeys("45");
			driver.findElement(By.id("allowMediaPublishDateNo")).click();
			driver.findElement(By.id("allowTenderBulletinDateNo")).click();
		/*	driver.findElement(By.id("showBidderConsentYes")).click(); 
			driver.findElement(By.id("alloweAgreementOptionYes")).click();
			driver.findElement(By.id("privilegeBidderYes")).click();Thread.sleep(500);
			driver.findElement(By.id("instrumentCheckBox_0")).click();
			driver.findElement(By.id("instrumentCheckBox_1")).click();
			driver.findElement(By.id("instrumentCheckBox_2")).click();
					
			driver.findElement(By.id("gteDetailsAllowedYes")).click();Thread.sleep(1000);
		*/
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Select issue");
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
			selection(driver.findElement(By.id("productCategory")), "ByVisibleText", "Air-Conditioner");
			selection(driver.findElement(By.id("contractType")), "ByVisibleText", "Tender");
			selection(driver.findElement(By.id("secValidDays")), "ByVisibleText", "120");
			selection(driver.findElement(By.id("TendererClass")), "ByVisibleText", "ALL");
			} 
			catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			if(driver.findElement(By.id("gteDetailsAllowedYes")).isSelected()) {
			driver.findElement(By.id("DirectLink_1")).click();
			System.out.println("GTE Selected");
			}
			Thread.sleep(3000);
			}
		 	catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 	}
		try {
			driver.findElement(By.id("Next")).click();
			System.out.println("Sucessful - Work/Item Details");
			}
			catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 	}
		
		// Fee Details
		try {
			Thread.sleep(500);
			driver.findElement(By.id("TenderFee")).clear();
			driver.findElement(By.id("EMDFiexedAmt")).clear(); Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.id("TenderFee")).sendKeys("100");
			driver.findElement(By.id("EMDFiexedAmt")).sendKeys("1000");
			driver.findElement(By.id("Next")).click();
			System.out.println("Sucessful - Fee Details");
			} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} finally {
			System.out.println("Any other issue");
			}
		
		// Critical Dates
		
	    
	  	 
	  	  	 
	  	 try {
			if(timeHH < 9) {   	
				 System.out.println(" Tender Creation Before: 9 am");
				driver.findElement(By.id("publishDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidSubStartDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidSubCloseDate")).sendKeys(date); Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidOpenDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    	    
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
			    System.out.println(" Tender Created Before: 9 am");
			}
			 
			 else if (timeHH >18) {  
				 System.out.println(" Tender Creation after: 7 pm");
				driver.findElement(By.id("publishDate")).sendKeys(DATE1);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("documentSaleStartDate")).sendKeys(DATE1);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidSubStartDate")).sendKeys(DATE1);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE2); Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidOpenDate")).sendKeys(DATE2);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    	    
			    selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", "09");
			    selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", "09");
			    selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", "09");
			    selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", "10");
			    selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", "10");
			    
			    selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", "05");
			    selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", "05");
			    selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", "05");
			    selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", "20");
			    selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", "20");	 
			    
			    Thread.sleep(2000);
			 System.out.println(" Tender Created after: 7 pm");}
			 
			 else {
			    
			 if(timemr <= 50 && timemr5 <= 60 ) {
				 
				System.out.println("timemr <= 50 && timemr5 <= 60 ");
				 
				System.out.println("Going to publishingDateMin: " +date+" - " +timeH+":"+timer);
				System.out.println("Going to documentSaleStartDateMin: " +date+" - " +timeH+":"+timer);
				System.out.println("Going to bidSubmissionClosingDateMin: "+date+" - " +timeH+":"+timer);
				System.out.println("Going to bidSubmissionClosingDateMin: "+DATE1+" - " +timeH+":"+timer);
				System.out.println("Going to bidOpeningDateMin: "+DATE1+" - " +timeH+":"+timer);
				    
				 
			    driver.findElement(By.id("publishDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidSubStartDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE1);Thread.sleep(300); driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidOpenDate")).sendKeys(DATE1);Thread.sleep(300);
			    	    
			    selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", timeH);
			    selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", timeH);
			    selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", timeH);
			    selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", timeH);
			    selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", timeH);
			    
			    selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", timer);
			    selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", timer);
			    selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", timer);
			    selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", timer);
			    selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", timer);
			    
			    System.out.println("Marked as publishingDateMin: " +date+" - " +timeH+":"+timer);
			    System.out.println("Marked as documentSaleStartDateMin: " +date+" - " +timeH+":"+timer);
			    System.out.println("Marked as bidSubmissionClosingDateMin: "+date+" - " +timeH+":"+timer);
			    System.out.println("Marked as bidSubmissionClosingDateMin: "+DATE1+" - " +timeH+":"+timer);
			    System.out.println("Marked as bidOpeningDateMin: "+DATE1+" - " +timeH+":"+timer);
			    
			   Thread.sleep(5000);
				 
			 }
			else if(timemr >= 60 && timemr5 >= 60 ) {
				
				System.out.println("timemr >= 60 && timemr5 >= 60");
				
				System.out.println("Going to publishingDateMin: " +date+" - " +timeH1+":" +timer60);
			    System.out.println("Going to documentSaleStartDateMin: " +date+" - " +timeH1+":" +timer60);
			    System.out.println("Going to bidSubmissionStartDateMin: "+date+" - " +timeH1+":"+timer60);
			    System.out.println("Going to bidSubmissionClosingDateMin: "+DATE1+" - " +timeH1+":"+timer60);
			    System.out.println("Going to bidOpeningDateMin :"+DATE1+" - " +timeH1+":"+timer60);
			    
				 
				driver.findElement(By.id("publishDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidSubStartDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE1); Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    driver.findElement(By.id("bidOpenDate")).sendKeys(DATE1);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			    	    
			    selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", timeH1);
			    selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", timeH1);
			    selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", timeH1);
			    selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", timeH1);
			    selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", timeH1);
			    
			    selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", timer60);
			    selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", timer60);
			    selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", timer60);
			    selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", timer60);
			    
			    selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", timer60);
			    
			    System.out.println("Marked as publishingDateMin: " +date+" - " +timeH1+":" +timer60);
			    System.out.println("Marked as documentSaleStartDateMin: " +date+" - " +timeH1+":" +timer60);
			    System.out.println("Marked as bidSubmissionStartDateMin: "+date+" - " +timeH1+":"+timer60);
			    System.out.println("Marked as bidSubmissionClosingDateMin: "+DATE1+" - " +timeH1+":"+timer60);
			    System.out.println("Marked as bidOpeningDateMin :"+DATE1+" - " +timeH1+":"+timer60);
			    
			   Thread.sleep(5000);
				 
			 }else if(timemr >= 50 && timemr5 >=60 ) {
				 System.out.println("timemr >= 50 && timemr5 >=60");
				 driver.findElement(By.id("publishDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			 	 driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			 	 driver.findElement(By.id("bidSubStartDate")).sendKeys(date);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			 	 driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE1); Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			 	 driver.findElement(By.id("bidOpenDate")).sendKeys(DATE1);Thread.sleep(300);driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			 	    	    
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
			 	 
			 	System.out.println("publishingDateMin :"+timer50);
			    System.out.println("documentSaleStartDateMin :"+timer50);
			    System.out.println("bidSubmissionStartDateMin :"+timer50);
			    System.out.println("bidSubmissionClosingDateMin :"+timer560);
			    System.out.println("bidOpeningDateMin :"+timer560);
			 	 
			 	Thread.sleep(5000);
			   		 
			 }
			     }
		} catch (InvalidSelectorException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
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
		driver.findElement(By.xpath("//td[text()='deptuser27@nic.in']//following-sibling::td//input")).click();
		driver.findElement(By.xpath("//td[text()='kevin@gmail.com']//following-sibling::td//input")).click();
		//driver.findElement(By.xpath("//td[text()='sakthi@nic.in']//following-sibling::td//input")).click();
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
	
		try {
			driver.findElement(By.id("DirectLink_3")).click();
			Thread.sleep(1500);
			Select Bdt = new Select(driver.findElement(By.id("documentType")));
			Bdt.selectByVisibleText("BOQ");
			driver.findElement(By.id("description")).sendKeys("BOQ - Price Bid");
			Thread.sleep(1500);
			ItemWiseTemplate();
			System.out.println("sucessful - BOQ Upload ");
			System.out.println("sucessful - BOQ Signed");
						
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.id("save")).click();
			System.out.println("sucessful - BOQ Saved ");
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.id("DirectLink_1")).click();
			Thread.sleep(1500);
			//driver.findElement(By.id("ViewBOQCheck")).click();
			//System.out.println("sucessful - BOQ Checked");s
			//Thread.sleep(1500);
			driver.findElement(By.id("checkbox4")).click();
			driver.findElement(By.id("Verifysave")).click();
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(By.id("DirectLink_4")).click();
			System.out.println("sucessful - BOQ Uploading Stage Completed");
			Thread.sleep(1500);
		} catch (NoSuchElementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

	    // GeMARPTS ID
	    try {
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	if(driver.findElement(By.xpath("//td[text()='GeMARPTS']")).isDisplayed())
	    	{
	    	driver.findElement(By.id("gemArptsRadioNo")).click(); 
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			selection(driver.findElement(By.id("gemArptsIdNotAvailingReason")),"byIndex","3");
			driver.findElement(By.id("gemArptsRemarks")).sendKeys("GeMARPTS ID is not available for this tender");
	    	driver.findElement(By.id("gemReasonBtn")).click(); Thread.sleep(500);
	    	driver.findElement(By.id("nxtReason")).click(); Thread.sleep(500);
	    	System.out.println("GempArpts Updated Successfully");
	    	}
	    	
	    } catch (NoSuchElementException e3)
	    {
	    	System.out.println("No GemArpts");
	    }
	    
	    try {
	    	 
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	if(driver.findElement(By.xpath("//td[text()='TIA Undertaking']")).isDisplayed())
	    	{
			selection(driver.findElement(By.id("tendercomplyingorder")),"byVisibleText","Agree");
			selection(driver.findElement(By.id("tendercomplyingorder_0")),"byVisibleText","Agree");
			selection(driver.findElement(By.id("tendercomplyingorder_1")),"byVisibleText","Agree"); Thread.sleep(500);
	    	driver.findElement(By.id("next")).click(); Thread.sleep(500);
	    	System.out.println("TIA Undertaking Updated Successfully");
	    	}
	    } catch (NoSuchElementException e3)
	    {
	    	System.out.println("TIA Undertaking");
	    }
	    String Tenderid= null;
	    try {
			driver.findElement(By.id("Submit")).click();
			System.out.println("sucessful - Tender Send to Publish");
			Thread.sleep(1500);
			WebElement id = driver.findElement(By.xpath("//table[@class='message_box']/tbody/tr[9]/td/b/span/span/b"));
			Tenderid = id.getText();
			System.out.println("id:"+Tenderid);
			Thread.sleep(1500);
		} catch (NoSuchElementException e) {
			System.out.println("NOT found of submit button");
		}
	    
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
		robot.mouseMove(465, 530);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(276, 156);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(2000);
		robot.mouseMove(465, 495);
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
	
	public static void ItemWiseTemplate() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(900, 490);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		setClipboardData("C:\\Users\\91991\\Documents\\BOQ\\V3_BOQ_ItemWiseGST_HSN.xls");	
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);	
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.mouseMove(933, 490);
		robot.delay(200);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(8000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);

	}
	public static void UploadNit() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(970, 515);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1000);	
		setClipboardData("C:\\Users\\91991\\Documents\\TenderDocument.pdf");	
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);	
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.mouseMove(995, 515);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(10000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
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
