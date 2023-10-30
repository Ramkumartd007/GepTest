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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TenderItemWise extends BaseClass {

	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException, ParseException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\itemwise\\config.properties");
		prop.load(input);
		getDriver(prop.getProperty("browser"));	
		getUrl(prop.getProperty("url"));
		Thread.sleep(2000);
		Pom2 p = new Pom2(driver);					
		
		Thread.sleep(3000);
		
		p.getLogin().click(); 
		Thread.sleep(3000);
		
				     try {
				    while(p.getUserName().isDisplayed())
				    	 {
		    	 	   try {
		    	 		  Thread.sleep(500);
		    	p.getUserName().clear();
				p.getPassword().clear();
				p.getUserName().sendKeys(prop.getProperty("LoginId"));
				p.getPassword().sendKeys(prop.getProperty("Password"));
				WebElement capt = p.getCaptimg();
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
				p.getCaptchaText().sendKeys(x);
				Thread.sleep(1000);
				p.getLoginsubmit().click();
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
        Thread.sleep(1000);		    
		Robot1();
		Thread.sleep(1000);		
		try{
		while(!driver.findElement(By.xpath("//a[contains(text(),'Create Tender')]")).isDisplayed())
		{ 
			try{
				Robot robot = new Robot();
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(4000);
			} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		}
		}catch (NoSuchElementException e) {
						e.printStackTrace();
		}
		System.out.println("Sucessful - Second Login");
		Thread.sleep(3000);
		
		p.getCreateTender().click();
		Thread.sleep(3000);
		p.getCallTender().click();
		Thread.sleep(3000);
		p.getTenderRefNo().sendKeys(prop.getProperty("TenderRefNo"));
        selection(p.getTendertype(), "byVisibleText", prop.getProperty("Tendertype"));
        selection(p.getFormContract(), "byVisibleText", prop.getProperty("FormofContract"));
        selection(p.getNoOfPackets(), "byVisibleText", prop.getProperty("NoOfPackets"));
        selection(p.getTenderCategory(), "byVisibleText", prop.getProperty("TenderCategory"));
        selection(p.getBidOpenerType(), "byIndex", prop.getProperty("BidOpenerType"));
		// driver.findElement(By.xpath("(//input[@value='1'])")).click();
		// driver.findElement(By.id("multiCurYes")).click();
		p.getNext().click();
		System.out.println("Sucessful - Basic details");
		Thread.sleep(3000);
		// CoverDetails - Technical cover
        p.getOne().click();
        Thread.sleep(3000);
        p.getDocDesc().sendKeys(prop.getProperty("TDocDesc"));
        selection(p.getDocType(), "byVisibleText", prop.getProperty("TdocType"));
        p.getSave().click();
        p.getDirectLink_1().click();
        Thread.sleep(3000);
  
        // FinancialDetails
        p.getOne_0().click();
        Thread.sleep(3000);
        p.getDocDesc().sendKeys(prop.getProperty("FdocDesc"));
        selection(p.getDocType(), "byVisibleText", prop.getProperty("FdocType"));
        p.getSave().click();
        p.getDirectLink_1().click();Thread.sleep(3000);
        p.getNext().click();Thread.sleep(3000);
   		System.out.println("Sucessful - Cover details");
	
   		// NIT Document
   		p.getDirectLink_0().click();
   		Thread.sleep(3000);
		p.getCheckbox4().click();
		p.getVerifysave().click();
		Thread.sleep(3000);
		p.getDirectLink_2().click();
		Thread.sleep(3000);
		System.out.println("Sucessful - NIT Document verified");
		
		// Work/Item Details
		p.getTxtTenderTitle().sendKeys(prop.getProperty("Ttitle") + prop.getProperty("TenderCategory"));
		p.getTxtWorkDesc().sendKeys(prop.getProperty("Ttitle")+prop.getProperty("Tendertype")+prop.getProperty("productCategory"));
		p.getTxtPreQual().sendKeys(prop.getProperty("PreQual"));
		
		selection(p.getProductCategory(), "byVisibleText", prop.getProperty("productCategory"));
		p.getTxtProductSubcategory().sendKeys(prop.getProperty("ProductSubcategory"));
		selection(p.getContractType(), "byVisibleText", prop.getProperty("ContractType"));
		p.getTenderValue().sendKeys(prop.getProperty("tenderValue"));
		p.getShowTenderValueYes().click();
		selection(p.getSecValidDays(), "byIndex", prop.getProperty("secValidDays"));
		p.getTxtLocation().sendKeys(prop.getProperty("txtLocation"));
		p.getPinCodeLocation().sendKeys(prop.getProperty("pinCodeLocation"));
		p.getBidOpeningPlace().sendKeys(prop.getProperty("bidOpeningPlace"));
		selection(p.getTendererClass(), "byVisibleText", prop.getProperty("TendererClass"));
		
		
		p.getInvitingOfficer().sendKeys(prop.getProperty("invitingOfficer"));
		p.getInvitingOfficerAddress().sendKeys(prop.getProperty("invitingOfficerAddress"));
		p.getExpireDays().sendKeys(prop.getProperty("expireDays"));
		//driver.findElement(By.xpath("//input[@name='mclServiceAllowed']")).click();
		p.getNext().click();
		Thread.sleep(3000);
		System.out.println("Sucessful - Work/Item Details");
		
		// Fee Details
		p.getNotApplicable().click();
		p.getNext().click();
		Thread.sleep(3000);
		System.out.println("Sucessful - Fee Details");
		
		// Critical Dates
		 String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
		 String timeH= new SimpleDateFormat("HH").format(new Date());
		 String timem= new SimpleDateFormat("mm").format(new Date());
		 Calendar cal = Calendar.getInstance();
	    	cal.setTime(new SimpleDateFormat("mm").parse(timem));
	    	 cal.add(Calendar.MINUTE, 5);
	    	 String timem5 = new SimpleDateFormat("mm").format(cal.getTime());
	    	 int timemr = ((((Integer.valueOf(timem5)/10)+1)*10)-5);
	    	 int timemr5 = ((((Integer.valueOf(timem5)/10)+1)*10));
	    	 String timer = String.valueOf(timemr);
	    	 String timer5 = String.valueOf(timemr5);
	    	 try {
	    p.getPublishDate().sendKeys(date);
		selection(p.getPublishingDateHour(), "selectByVisibleText", timeH);
		selection(p.getPublishingDateMin(), "selectByVisibleText", timer);
		p.getDocumentSaleStartDate().sendKeys(date);
		selection(p.getDocumentSaleStartDateHour(), "selectByVisibleText", timeH);
		selection(p.getDocumentSaleStartDateMin(), "selectByVisibleText", timer);
		p.getBidSubStartDate().sendKeys(date);
		selection(p.getBidSubmissionStartDateHour(), "selectByVisibleText", timeH);
		selection(p.getBidSubmissionStartDateMin(), "selectByVisibleText", timer);
		p.getBidSubCloseDate().sendKeys(date);
		selection(p.getBidSubmissionClosingDateHour(), "selectByVisibleText", timeH);
		selection(p.getBidSubmissionClosingDateMin(), "selectByVisibleText", timer5);	
		p.getBidOpenDate().sendKeys(date);
		selection(p.getBidOpeningDateHour(), "selectByVisibleText", timeH);
		selection(p.getBidOpeningDateMin(), "selectByVisibleText", timer5);
		Thread.sleep(20000);
	    	 }catch (NoSuchElementException e) {
	 			System.out.println(e);
	    	 }
		Thread.sleep(15000);
		p.getNext().click();
		try {
		driver.switchTo().alert().accept();
		}catch (NoSuchElementException e1) {
			System.out.println(e1);		
 		  }
		Thread.sleep(3000);
		System.out.println("Sucessful - Critical Date");
		
		// Bid openers List
		p.getSelectbox_0().click();
		p.getSelectbox_1().click();
		p.getSelectbox_4().click();
		p.getSubmit().click();
		System.out.println("Sucessful - Bid openers List");
		Thread.sleep(3000);
//driver.findElement(By.xpath("//table[contains(text()='depteproc@nic.in')]/parent::td//preceding-sibling::td//input[@type()='checkbox']")).click();
//td[text()='depteproc@nic.in'][@type='checkbox']

		// Work/item Documents - BoQ
		p.getDirectLink_2().click();
		Thread.sleep(3000);
		selection(p.getDocumentType(), "selectByVisibleText", prop.getProperty("DocumentType"));
		
		p.getDescription().sendKeys(prop.getProperty("Description"));
		Thread.sleep(3000);
		ItemRateTemplate();
		System.out.println("sucessful - BOQ Upload ");
		Thread.sleep(3000);
		Signingpdf();
		System.out.println("sucessful - BOQ Signed");
		Thread.sleep(3000);
		p.getSave().click();
		System.out.println("sucessful - BOQ Saved ");
		Thread.sleep(3000);
		p.getDirectLink_1().click();
		Thread.sleep(3000);
		p.getViewBOQCheck().click();
		System.out.println("sucessful - BOQ Checked");
		Thread.sleep(3000);
		p.getCheckbox4().click();
		p.getVerifysave().click();
		Thread.sleep(3000);
		p.getDirectLink_3().click();
		System.out.println("sucessful - BOQ Uploading Stage Completed");
		Thread.sleep(3000);

		// OID Documents List
		p.getSave().click();
		System.out.println("sucessful - OID Stage Completed");
		Thread.sleep(3000);

		// Send to Publish
	    p.getSubmit().click();
	    System.out.println("sucessful - Tender Send to Publish");
	    Thread.sleep(3000);
	    WebElement id = driver.findElement(By.xpath("//table[@class='message_box']/tbody/tr[9]/td/b/span/span/b"));
	    String Tenderid = id.getText();
	    System.out.println("id:"+Tenderid);
	    Thread.sleep(3000);
	    
	    // Publish Tender
	    p.getPageLink_0_9().click();
	    Thread.sleep(1500);
	    p.getTenderid().sendKeys(Tenderid);
	    p.getSearch().click();
	    Thread.sleep(1500);
	    p.getView().click();
	    Thread.sleep(1500);
	    p.getSubmit().click();
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
