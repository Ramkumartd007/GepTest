package testng.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.commons.collections4.functors.FalsePredicate;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CaptchaTest {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException, ParseException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoeproc.nic.in/nicgep/app");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("login")).click(); Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				     try {  
				     while(driver.findElement(By.id("UserName")).isDisplayed())
				    	 {
		    	 	   try {
		    	driver.findElement(By.id("UserName")).clear();
				driver.findElement(By.id("Password")).clear();
				driver.findElement(By.id("UserName")).sendKeys("deptuser2@nic.in");
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
				Thread.sleep(3000);
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
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Robot1();

		try{
		while(!driver.findElement(By.xpath("//a[contains(text(),'Create Tender')]")).isDisplayed())
		{ 
			try{
				Robot robot = new Robot();
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(4000);
			} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sucessful - Second Login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Create Tender')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("bd")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("tenderRefNo")).sendKeys("GTETesting");
		Select OT = new Select(driver.findElement(By.name("tenderType")));
		OT.selectByVisibleText("Open Tender");
		Select fC = new Select(driver.findElement(By.id("formContract")));
		fC.selectByVisibleText("Item Rate");
		Select nP = new Select(driver.findElement(By.id("noOfPackets")));
		nP.selectByValue("2");
		Select tC = new Select(driver.findElement(By.id("tenderCategory")));
		tC.selectByVisibleText("Services");
		Select bO = new Select(driver.findElement(By.id("bidOpenerType")));
		bO.selectByIndex(2);
		// driver.findElement(By.xpath("(//input[@value='1'])")).click();
		// driver.findElement(By.id("multiCurYes")).click();
		driver.findElement(By.id("Next")).click();
		System.out.println("Sucessful - Basic details");
		Thread.sleep(3000);
		// CoverDetails - Technical cover
		
		driver.findElement(By.id("one")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("docDesc")).sendKeys("Technical");
		Select dT = new Select(driver.findElement(By.id("docType")));
		dT.selectByVisibleText(".pdf");
		driver.findElement(By.id("Save")).click();
		driver.findElement(By.id("DirectLink_1")).click();
		Thread.sleep(3000);
		// FinancialDetails
		driver.findElement(By.id("one_0")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("docDesc")).sendKeys("Finance");
		Select dF = new Select(driver.findElement(By.id("docType")));
		dF.selectByVisibleText(".xls");
		driver.findElement(By.id("Save")).click();
		driver.findElement(By.id("DirectLink_1")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Next")).click();
		Thread.sleep(3000);
		System.out.println("Sucessful - Cover details");
		// NIT Document
		driver.findElement(By.id("DirectLink_0")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("checkbox4")).click();
		driver.findElement(By.id("Verifysave")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("DirectLink_2")).click();
		Thread.sleep(3000);
		System.out.println("Sucessful - NIT Document verified");
		// Work/Item Details
		driver.findElement(By.id("txtTenderTitle")).sendKeys("checkflow");
		driver.findElement(By.id("txtWorkDesc")).sendKeys("checkflow");
		driver.findElement(By.id("txtPreQual")).sendKeys("checkflow");
		Select pC = new Select(driver.findElement(By.id("productCategory")));
		pC.selectByVisibleText("Manpower Supply");
		driver.findElement(By.id("txtProductSubcategory")).sendKeys("checkflow");
		Select cT = new Select(driver.findElement(By.id("contractType")));
		cT.selectByVisibleText("Tender");
		driver.findElement(By.id("tenderValue")).sendKeys("1300000");
		driver.findElement(By.id("showTenderValueYes")).click();
		Select bV = new Select(driver.findElement(By.id("secValidDays")));
		bV.selectByVisibleText("120");
		driver.findElement(By.id("txtLocation")).sendKeys("Chennai");
		driver.findElement(By.id("pinCodeLocation")).sendKeys("600000");
		driver.findElement(By.id("bidOpeningPlace")).sendKeys("Chennai");
		Select tCl = new Select(driver.findElement(By.id("TendererClass")));
		tCl.selectByVisibleText("OTHERS");
		driver.findElement(By.id("invitingOfficer")).sendKeys("Officer");
		driver.findElement(By.id("invitingOfficerAddress")).sendKeys("Address");
		driver.findElement(By.id("expireDays")).sendKeys("45");
		driver.findElement(By.xpath("//input[@name='mclServiceAllowed']")).click();
		driver.findElement(By.id("Next")).click();
		Thread.sleep(3000);
		System.out.println("Sucessful - Work/Item Details");
		
		// Fee Details
		driver.findElement(By.id("NotApplicable")).click();
		driver.findElement(By.id("Next")).click();
		Thread.sleep(3000);
		System.out.println("Sucessful - Fee Details");
		
		// Critical Dates
		 String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
		 String timeH= new SimpleDateFormat("HH").format(new Date());
		 String timem= new SimpleDateFormat("mm").format(new Date());
		 Calendar cal = Calendar.getInstance();
	    	cal.setTime(new SimpleDateFormat("mm").parse(timeH));
	    	 cal.add(Calendar.MINUTE, 5);
	    	 String timem5 = new SimpleDateFormat("mm").format(cal.getTime());
	    driver.findElement(By.id("publishDate")).sendKeys(date);
		
		Select pDH = new Select(driver.findElement(By.id("publishingDateHour")));
		pDH.selectByVisibleText(timeH);
		Select pDM = new Select(driver.findElement(By.id("publishingDateMin")));
		pDM.selectByVisibleText(timem);
		driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);
		Select dSSDH = new Select(driver.findElement(By.id("documentSaleStartDateHour")));
		dSSDH.selectByVisibleText(timeH);
		Select dSSDM = new Select(driver.findElement(By.id("documentSaleStartDateMin")));
		dSSDM.selectByVisibleText(timem);
		driver.findElement(By.id("bidSubStartDate")).sendKeys(date);
		Select bSSDH = new Select(driver.findElement(By.id("bidSubmissionStartDateHour")));
		bSSDH.selectByVisibleText(timeH);
		Select bSSDM = new Select(driver.findElement(By.id("bidSubmissionStartDateMin")));
		bSSDM.selectByVisibleText(timem);
		driver.findElement(By.id("bidSubCloseDate")).sendKeys(date);
		Select bSCDH = new Select(driver.findElement(By.id("bidSubmissionClosingDateHour")));
		bSCDH.selectByVisibleText(timeH);
		Select bSCDM = new Select(driver.findElement(By.id("bidSubmissionClosingDateMin")));
		bSCDM.selectByVisibleText(timem5);
		driver.findElement(By.id("bidOpenDate")).sendKeys(date);
		Select bODH = new Select(driver.findElement(By.id("bidOpeningDateHour")));
		bODH.selectByVisibleText(timeH);
		Select bODM = new Select(driver.findElement(By.id("bidOpeningDateMin")));
		bODM.selectByVisibleText("timem5");
		driver.findElement(By.id("Next")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println("Sucessful - Critical Date");
		
		// Bid openers List
		driver.findElement(By.id("selectbox_51")).click();
		driver.findElement(By.id("selectbox_50")).click();
		driver.findElement(By.id("selectbox_20")).click();
		driver.findElement(By.id("Submit")).click();
		System.out.println("Sucessful - Bid openers List");
		Thread.sleep(3000);
//driver.findElement(By.xpath("//table[contains(text()='depteproc@nic.in')]/parent::td//preceding-sibling::td//input[@type()='checkbox']")).click();
//td[text()='depteproc@nic.in'][@type='checkbox']

		// Work/item Documents - BoQ
		driver.findElement(By.id("DirectLink_2")).click();
		Thread.sleep(3000);
		Select Bdt = new Select(driver.findElement(By.id("documentType")));
		Bdt.selectByVisibleText("BOQ");
		driver.findElement(By.id("description")).sendKeys("BOQ - Price Bid");
		Thread.sleep(3000);
		ItemRateTemplate();
		System.out.println("sucessful - BOQ Upload ");
		Thread.sleep(3000);
		Signingpdf();
		System.out.println("sucessful - BOQ Signed");
		Thread.sleep(3000);
		driver.findElement(By.id("save")).click();
		System.out.println("sucessful - BOQ Saved ");
		Thread.sleep(3000);
		driver.findElement(By.id("DirectLink_1")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ViewBOQCheck")).click();
		System.out.println("sucessful - BOQ Checked");
		Thread.sleep(3000);
		driver.findElement(By.id("checkbox4")).click();
		driver.findElement(By.id("Verifysave")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("DirectLink_3")).click();
		System.out.println("sucessful - BOQ Uploading Stage Completed");
		Thread.sleep(3000);

		// OID Documents List
		driver.findElement(By.id("save")).click();
		System.out.println("sucessful - OID Stage Completed");
		Thread.sleep(3000);

		// Send to Publish
	    driver.findElement(By.id("Submit")).click();
	    System.out.println("sucessful - Tender Send to Publish");
	    Thread.sleep(3000);
	    WebElement id = driver.findElement(By.xpath("//table[@class='message_box']/tbody/tr[9]/td/b/span/span/b"));
	    String Tenderid = id.getText();
	    System.out.println("id:"+Tenderid);
	    Thread.sleep(3000);
	    
	    // Publish Tender
	    driver.findElement(By.id("PageLink_0_9")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.id("TenderId")).sendKeys(Tenderid);
	    driver.findElement(By.id("search")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.id("view")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.id("Submit")).click();
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
		robot.delay(2000);

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
