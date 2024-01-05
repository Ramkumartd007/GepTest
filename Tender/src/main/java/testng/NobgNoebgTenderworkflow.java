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
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.jexl2.internal.AbstractExecutor.Set;
import org.apache.logging.log4j.LogManager;
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
import org.apache.logging.log4j.*;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class NobgNoebgTenderworkflow extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args)
			throws InterruptedException, AWTException, IOException, TesseractException, ParseException, WebDriverException {
		String date = new SimpleDateFormat("dd/MM/YYYY").format(new Date());
		String timeH = new SimpleDateFormat("HH").format(new Date());
		String timem = new SimpleDateFormat("mm").format(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String DATE1 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());
		cal.add(Calendar.DATE, 10);
		String DATE2 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());

		int timeHH = Integer.valueOf(timeH);
		int timemr = ((((Integer.valueOf(timem) / 10) + 1) * 10));
		int timemr5 = ((((Integer.valueOf(timem) / 10) + 1) * 10) + 20);

		String timeH1 = String.valueOf(timeHH + 1);
		String timer = String.valueOf(timemr);
		String timer15 = String.valueOf(timemr5);
		String timer50 = String.valueOf(timemr - 50);
		String timer60 = String.valueOf(timemr - 60);
		String timer560 = String.valueOf(timemr5 - 60);

		// String Title = "Ver.20/ATP/Works/TypeofCor/AOC";
		// String Title = " Ver.20/ITE/SF/CD/eAgre/LOA/AOC";

		// String Title = "Ver.20/Status/bidder/Dept/Home";

		String tenderType = "Open Tender";
		String formContract = "Supply";
		String noOfPackets = "2";
		String tenderCategory = "Goods";
		String bidOpenerType = "2";

		String EMD = null;
		String TFexmpt = null;
		String EMDexmpt = null;
		String TF = null;
		String PF = null;
		String e_BG = null;
		String Tenderid = null;
		String MDP = null;
		//String BasicId = null;
	    String BasicId = "2024_NIT_10236";

		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\itemwise\\config.properties");
		prop.load(input);
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Xls_Reader reader = new Xls_Reader("D:\\Test_Scenario_Excel\\EBG_TestCase.xls");
		
		
		String sheetName = "Offile_nobg_noEBG";
		String TenderFee;
		String TenderFeewithEX;
		String ProcessingFee;
		String EMDFee;
		String EMDFeewithEX;
		String eBG;
		String MDP0;
		String EBGmdp;
		String Case;
		
		driver.get("https://demoetenders.tn.nic.in/nicgep/app");
		// driver.get("https://demoeproc.nic.in/nicgep/app");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		try {

			while (driver.findElement(By.id("UserName")).isDisplayed()) {
				Thread.sleep(500);
				try {
					Thread.sleep(500);
					driver.findElement(By.id("UserName")).clear();
					driver.findElement(By.id("Password")).clear();
					// driver.findElement(By.id("UserName")).sendKeys("venkat@nic.in");
					// driver.findElement(By.id("Password")).sendKeys("Ven2490$");

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
					File screenshotLocation = new File(
							"C:\\Users\\91991\\eclipse-workspace\\com\\Screenshot\\Captcha.png");
					FileUtils.copyFile(screenshot, screenshotLocation);
					ITesseract image = new Tesseract();
					String imagetest = image
							.doOCR(new File("C:\\Users\\91991\\eclipse-workspace\\com\\Screenshot\\Captcha.png"));
					String x = imagetest.replaceAll("[^a-z0-9A-Z]", "");
					System.out.println(x);
					driver.findElement(By.id("CaptchaText")).sendKeys(x);
					Thread.sleep(500);
					driver.findElement(By.id("submitSHA")).click();
					System.out.println("Successful - First Login");
					System.out.println("Available");
					Thread.sleep(3000);
				} catch (NoSuchElementException e) {
					System.out.println(e);
					Thread.sleep(200);
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);

		}
		Thread.sleep(2000);
		Robot1();
		for (int i = 2; i < 20; i++) {
			Thread.sleep(500);
			
			TenderFee = reader.getCellData(sheetName,"Tender FEE", i);
			TenderFeewithEX = reader.getCellData(sheetName,"Tender FEE Exempt", i);
			ProcessingFee = reader.getCellData(sheetName,"Processing FEE", i);
			EMDFee = reader.getCellData(sheetName,"EMD FEE", i);
			EMDFeewithEX = reader.getCellData(sheetName,"EMD FEE Exempt", i);
			
			eBG = reader.getCellData(sheetName,"E-BG", i);
			MDP0 = reader.getCellData(sheetName,"MDP", i);
			EBGmdp = reader.getCellData(sheetName,"E-BG", i);
			Case = reader.getCellData(sheetName, "Case", i);
			System.out.println(TenderFee+TenderFeewithEX+ProcessingFee+EMDFee+EMDFeewithEX);
//Tender Fee				
			try {
				if (TenderFee.equals("YES")) {
					TF = "TF-Yes";
				} else if (TenderFee.equals("NO")) {
					TF = "TF-No";
				}
			
//Processing Fee				
				
				if (ProcessingFee.equals("YES")) {
					PF = "PF-Yes";
				} else if (ProcessingFee.equals("NO")) {
					PF = "PF-No";
				}

//Tender Fee Exemption				
				if (TenderFeewithEX.equals("YES")) {
					TFexmpt = "TF Exempt-Yes";
				} else if (TenderFeewithEX.equals("NO")) {
					TFexmpt = "TF Exempt-No";
				}

//EMD Fee
				if (EMDFee.equals("YES")) {
					EMD = "EMD-Yes";
				} else if (EMDFee.equals("NO")) {
					EMD = "EMD-No";
				}

//EMD Fee Exemption	
				if (EMDFeewithEX.equals("YES")) {
					EMDexmpt = "EMD Exempt-Yes";
				} else if (EMDFeewithEX.equals("NO")) {
					EMDexmpt = "EMD Exempt-No";
				}
/*
//e-BG 	
				if (eBG.equals("YES")) {
					e_BG = "eBG-Yes";
				} else if (eBG.equals("NO")) {
					e_BG = "eBG-No";
				}
//MDP 	
				if (MDP0.equals("eBG = 0")) {
					e_BG = "MDP-Yes";
				} else if (MDP0.equals("eBG> 0")) {
					e_BG = "MDP-No";
				}
				
*/
			//String Title = "Ver.21/ " + date + " /e-BG/" + TF + "/ " + TFexmpt + "/ " + EMD + "/ " + EMDexmpt + "/ " + e_BG + "/ " + "TestScenario_" + i;
			String Title = reader.getCellData(sheetName, "Case", i);
				String TRef = "Ver.21/ " + date + " /NObg/Noebg" + "/ TestScenario";
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[text() = 'Create Tender / Tender List']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(i==2)
			{
			driver.findElement(By.id("bd")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.name("tenderRefNo")).sendKeys(TRef);
			selection(driver.findElement(By.name("tenderType")), "ByVisibleText", tenderType);
			selection(driver.findElement(By.id("formContract")), "ByVisibleText", formContract);
			selection(driver.findElement(By.name("noOfPackets")), "ByValue", noOfPackets);
			selection(driver.findElement(By.name("tenderCategory")), "ByVisibleText", tenderCategory);
			selection(driver.findElement(By.name("bidOpenerType")), "ByIndex", bidOpenerType);
		/*	try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@id='mclAllowed'][@value = '1']")).click();
			} catch (NoSuchElementException e) {
				System.out.println("Automation is Disabled");
			}

			try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@id='twoStageAllowed'][@value = '1']")).click();
			} catch (NoSuchElementException e) {

				System.out.println("Two Stage Bidding is Disabled");
				;
			}
			
			 * try { driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			 * driver.findElement(By.id("multiCurYes")).click(); } catch
			 * (NoSuchElementException e) {
			 * 
			 * System.out.println("Multicurrency is Disabled"); }
			 */

			try {
				driver.findElement(By.id("Next")).click();
				System.out.println("Successful - Basic details");
				Thread.sleep(1000);
			} catch (Exception e4) {

				e4.printStackTrace();
			}
			// CoverDetails - Technical cover

			try {
				Thread.sleep(1000);
				driver.findElement(By.id("one")).click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.id("docDesc")).sendKeys("Technical");
				selection(driver.findElement(By.id("docType")), "ByVisibleText", ".pdf");
				Thread.sleep(500);
				driver.findElement(By.id("Save")).click();
				Thread.sleep(500);
				driver.findElement(By.id("DirectLink_2")).click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				// FinancialDetails
				driver.findElement(By.id("one_0")).click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.id("docDesc")).sendKeys("Finance");
				selection(driver.findElement(By.id("docType")), "ByVisibleText", ".xls");
				Thread.sleep(500);
				driver.findElement(By.id("Save")).click();
				Thread.sleep(500);
				driver.findElement(By.id("DirectLink_2")).click();
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.findElement(By.id("Next")).click();
				Thread.sleep(300);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				System.out.println("Successful - Cover details");
			} catch (Exception e3) {

				e3.printStackTrace();
				System.out.println("UnSuccessful - Cover details");
			}

			// NIT Document
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (driver.findElement(By.id("DirectLink_2")).isDisplayed()) {
					Thread.sleep(1000);
					/*
					 * driver.findElement(By.id("DirectLink_2")).click();
					 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					 * driver.findElement(By.id("description")).sendKeys("NIT"); UploadNit();
					 * Thread.sleep(1000); driver.findElement(By.id("save")).click();
					 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					 */
					driver.findElement(By.id("DirectLink_0")).click();
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.id("checkbox4")).click();
					Thread.sleep(200);
					driver.findElement(By.id("Verifysave")).click();
					Thread.sleep(500);
					driver.findElement(By.id("DirectLink_3")).click();
					System.out.println("Successful - NIT Document verified");
				}
			} catch (NoSuchElementException e) {
				driver.findElement(By.id("DirectLink_0")).click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.id("checkbox4")).click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.id("Verifysave")).click();
				Thread.sleep(500);
				driver.findElement(By.id("DirectLink_3")).click();
				System.out.println("Successful - NIT Document verified");
			}
			}
			else
			{
				Thread.sleep(500);
				System.out.println(BasicId);
				driver.findElement(By.xpath("//td[text()='"+BasicId+"']//following-sibling::td//a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Add New']")).click();
				Thread.sleep(1000);
			}
			// Work/Item Details
			Thread.sleep(1500);
			try {
				Thread.sleep(200);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.id("txtTenderTitle")).sendKeys(Title);
				driver.findElement(By.id("txtWorkDesc")).sendKeys(Title + " - Desc");
				driver.findElement(By.id("txtPreQual")).sendKeys("Pre Qualification");
				driver.findElement(By.id("txtProductSubcategory")).sendKeys("ProductSubcategory");

				driver.findElement(By.id("tenderValue")).clear();
				driver.findElement(By.id("tenderValue")).sendKeys("1300000");
				Thread.sleep(300);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.findElement(By.id("showTenderValueYes")).click();
				driver.findElement(By.id("txtLocation")).sendKeys("Chennai");
				driver.findElement(By.id("pinCodeLocation")).sendKeys("600000");
				driver.findElement(By.id("bidOpeningPlace")).sendKeys("Chennai");
				driver.findElement(By.id("invitingOfficer")).sendKeys("Officer");
				driver.findElement(By.id("invitingOfficerAddress")).sendKeys("Address");
				driver.findElement(By.id("expireDays")).sendKeys("45");
				
				driver.findElement(By.id("allowMediaPublishDateNo")).click();
				driver.findElement(By.id("allowTenderBulletinDateNo")).click();
				/*
				 * driver.findElement(By.id("showBidderConsentYes")).click(); //LOA
				 * driver.findElement(By.id("alloweAgreementOptionYes")).click(); //E-Agreement
				 * 
				 * try { //Preferential Bidder driver.manage().timeouts().implicitlyWait(5,
				 * TimeUnit.SECONDS);
				 * driver.findElement(By.xpath("//input[@id='privilegeBidderYes'][@value = '1']"
				 * )).click(); Thread.sleep(500);
				 * driver.findElement(By.id("instrumentCheckBox_0")).click(); //Preferential
				 * Category - 1 driver.findElement(By.id("instrumentCheckBox_1")).click();
				 * //Preferential Category - 2
				 * driver.findElement(By.id("instrumentCheckBox_2")).click(); //Preferential
				 * Category - 3 } catch (NoSuchElementException e) {
				 * 
				 * 
				 * System.out.println("privilegeBidderYes is Disabled"); }
				 * 
				 * //
				 * driver.findElement(By.id("gteDetailsAllowedYes")).click();Thread.sleep(2000);
				 * //GTE
				 */

			} catch (Exception e1) {

				System.out.println("Select issue");
			}

			/*
			 * //Service Experience try { driver.manage().timeouts().implicitlyWait(5,
			 * TimeUnit.SECONDS);
			 * driver.findElement(By.xpath("//input[@id='mclServiceAllowed'][@value = '1']")
			 * ).click(); System.out.println("mclServiceAllowed is Enabled"); } catch
			 * (NoSuchElementException e) {
			 * 
			 * 
			 * System.out.println("mclServiceAllowed is Disabled"); } //Resource Details try
			 * { driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 * driver.findElement(By.xpath("//input[@id='mclFleetAllowed'][@value = '1']")).
			 * click(); System.out.println("mclFleetAllowed is Enabled"); } catch
			 * (NoSuchElementException e) {
			 * 
			 * 
			 * System.out.println("mclFleetAllowed is Disabled"); }
			 * 
			 * //Working Capital try { driver.manage().timeouts().implicitlyWait(5,
			 * TimeUnit.SECONDS); driver.findElement(By.
			 * xpath("//input[@id='mclWorkingCapitalAllowed'][@value = '1']")).click();
			 * System.out.println("mclWorkingCapitalAllowed is Enabled"); } catch
			 * (NoSuchElementException e) {
			 * 
			 * 
			 * System.out.println("mclWorkingCapitalAllowed is Disabled"); }
			 */

			try {
				selection(driver.findElement(By.id("productCategory")), "ByVisibleText", "Aviation");
				selection(driver.findElement(By.id("contractType")), "ByVisibleText", "Tender");
				selection(driver.findElement(By.id("secValidDays")), "ByVisibleText", "120");
				selection(driver.findElement(By.id("TendererClass")), "ByVisibleText", "ALL");
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			/*
			 * try { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 * if(driver.findElement(By.id("gteDetailsAllowedYes")).isSelected()) {
			 * driver.findElement(By.id("DirectLink_1")).click();
			 * System.out.println("GTE Selected"); } Thread.sleep(3000); } catch (Exception
			 * e1) {
			 * 
			 * e1.printStackTrace(); }
			 */
			try {
				driver.findElement(By.id("Next")).click();
				System.out.println("Successful - Work/Item Details");
			} catch (Exception e1) {

				e1.printStackTrace();
			}

			// Fee Details
			
			try {
				Thread.sleep(500);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			//	driver.findElement(By.id("chkOffLine")).click();
				//driver.findElement(By.id("chkOnLine")).click();
				Thread.sleep(200);
			/*	if(i==9||(i>=43&&i<=66))
				{
					driver.findElement(By.id("chkOnLine")).click();
					driver.findElement(By.id("NotApplicable")).click();	
				}
*/
//Tender Fee
				if (TenderFee.equals("YES")) {
					driver.findElement(By.id("TenderFee")).clear();
					driver.findElement(By.id("TenderFee")).sendKeys("5000");
					Thread.sleep(200);
					System.out.println(" Tender Fee as YES ");
				} else if (TenderFee.equals("NO")) {
					driver.findElement(By.id("TenderFee")).clear();
					driver.findElement(By.id("TenderFee")).sendKeys("0");
					Thread.sleep(200);
					System.out.println(" Tender Fee as No ");
				}

//Processing Fee
				
				if (ProcessingFee.equals("YES")) {
					driver.findElement(By.id("ProcessingFee")).clear();
					driver.findElement(By.id("ProcessingFee")).sendKeys("5000");
					Thread.sleep(200);
					System.out.println(" Processing Fee as YES ");
				} else if (ProcessingFee.equals("NO")) {
					driver.findElement(By.id("ProcessingFee")).clear();
					driver.findElement(By.id("ProcessingFee")).sendKeys("0");
					Thread.sleep(200);
					System.out.println(" Processing Fee as No ");
				}

//Tender Fee Exemption				
				if (TenderFeewithEX.equals("YES")) {
					driver.findElement(By.id("optTenderFull")).click();
					Thread.sleep(200);
					System.out.println(" Tender Fee Exemption as Yes ");
				} if (TenderFeewithEX.equals("NO")) {
					driver.findElement(By.id("optTenderNone")).click();
					Thread.sleep(200);
					System.out.println(" Tender Fee Exemption as No ");
				}

//EMD Fee
				if (EMDFee.equals("YES")) {
					driver.findElement(By.id("EMDFiexedAmt")).clear();
					driver.findElement(By.id("EMDFiexedAmt")).sendKeys("50000");
					Thread.sleep(200);
					System.out.println(" EMD Fee as Yes ");
				} else if (EMDFee.equals("NO")) {
					driver.findElement(By.id("EMDFiexedAmt")).clear();
					driver.findElement(By.id("EMDFiexedAmt")).sendKeys("0");
					Thread.sleep(200);
					System.out.println(" EMD Fee as No ");
				}

//EMD Fee Exemption	
				if (EMDFeewithEX.equals("YES")) {
					driver.findElement(By.id("optEmdFull")).click();
					Thread.sleep(200);
					System.out.println(" EMD Fee Exemption as Yes ");
				} else if (EMDFeewithEX.equals("NO")) {
					driver.findElement(By.id("optEmdNone")).click();
					Thread.sleep(200);
					System.out.println(" EMD Fee Exemption as No ");
				}
/*
//e-BG 	
				if (eBG.equals("YES")) {
					driver.findElement(By.xpath("//td[text()='eBG Required']//following-sibling::td//input[1]")).click();
					Thread.sleep(500);
					driver.findElement(By.id("minDirectAmount")).clear();
					driver.findElement(By.id("minDirectAmount")).sendKeys("0");
					Thread.sleep(200);
					System.out.println(" E-BG as Yes ");
				} else if (eBG.equals("NO")) {
					driver.findElement(By.xpath("//td[text()='eBG Required']//following-sibling::td//input[2]")).click();
					Thread.sleep(200);
					System.out.println(" E-BG as No ");
				}

//MDP				
				
				if (MDP0.equals("eBG = 0")) {
					driver.findElement(By.id("minDirectAmount")).clear();
					driver.findElement(By.id("minDirectAmount")).sendKeys("0");
					Thread.sleep(200);
					System.out.println(" E-BG as 0 ");
				} else if (MDP0.equals("eBG> 0")) {
					Thread.sleep(200);
					driver.findElement(By.id("minDirectAmount")).clear();
					driver.findElement(By.id("minDirectAmount")).sendKeys("3000");
					System.out.println(" E-BG is max ");
				}
*/
				Thread.sleep(200);
				driver.findElement(By.id("Next")).click();
				System.out.println("Successful - Fee Details");

			} catch (NoSuchElementException e) {
				e.printStackTrace();
			} 
			catch (InvalidElementStateException e) {
				e.printStackTrace();
			}finally {
				System.out.println("Any other issue");
			}

			// Critical Dates
/*
			try {
				if (timeHH < 9) {
					System.out.println(" Tender Creation Before: 9 am");
					driver.findElement(By.id("publishDate")).sendKeys(date);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.findElement(By.id("bidSubStartDate")).sendKeys(date);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE2);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.findElement(By.id("bidOpenDate")).sendKeys(DATE2);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

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

				else if (timeHH > 18) {
					System.out.println(" Tender Creation after: 7 pm");
					driver.findElement(By.id("publishDate")).sendKeys(DATE1);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.findElement(By.id("documentSaleStartDate")).sendKeys(DATE1);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.findElement(By.id("bidSubStartDate")).sendKeys(DATE1);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE2);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.findElement(By.id("bidOpenDate")).sendKeys(DATE2);
					Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

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
					System.out.println(" Tender Created after: 7 pm");
				}

				else {

					if (timemr <= 50 && timemr5 <= 60) {

						System.out.println("timemr <= 50 && timemr5 <= 60 ");

						System.out.println("Going to publishingDateMin: " + date + " - " + timeH + ":" + timemr);
						System.out.println("Going to documentSaleStartDateMin: " + date + " - " + timeH + ":" + timemr);
						System.out
								.println("Going to bidSubmissionClosingDateMin: " + date + " - " + timeH + ":" + timemr);
						System.out.println(
								"Going to bidSubmissionClosingDateMin: " + DATE2 + " - " + timeH + ":" + timemr);
						System.out.println("Going to bidOpeningDateMin: " + DATE2 + " - " + timeH + ":" + timemr);

						driver.findElement(By.id("publishDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidSubStartDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE2);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys(DATE2);
						Thread.sleep(300);

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

						System.out.println("Marked as publishingDateMin: " + date + " - " + timeH + ":" + timer);
						System.out.println("Marked as documentSaleStartDateMin: " + date + " - " + timeH + ":" + timer);
						System.out.println(
								"Marked as bidSubmissionClosingDateMin: " + date + " - " + timeH + ":" + timer);
						System.out.println(
								"Marked as bidSubmissionClosingDateMin: " + DATE2 + " - " + timeH + ":" + timer);
						System.out.println("Marked as bidOpeningDateMin: " + DATE2 + " - " + timeH + ":" + timer);

						Thread.sleep(5000);

					} else if (timemr >= 60 && timemr5 >= 60) {

						System.out.println("timemr >= 60 && timemr5 >= 60");

						System.out.println("Going to publishingDateMin: " + date + " - " + timeH1 + ":" + timer60);
						System.out
								.println("Going to documentSaleStartDateMin: " + date + " - " + timeH1 + ":" + timer60);
						System.out.println(
								"Going to bidSubmissionStartDateMin: " + date + " - " + timeH1 + ":" + timer60);
						System.out.println(
								"Going to bidSubmissionClosingDateMin: " + DATE2 + " - " + timeH1 + ":" + timer60);
						System.out.println("Going to bidOpeningDateMin :" + DATE2 + " - " + timeH1 + ":" + timer60);

						driver.findElement(By.id("publishDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidSubStartDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE2);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys(DATE2);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

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

						System.out.println("Marked as publishingDateMin: " + date + " - " + timeH1 + ":" + timer60);
						System.out.println(
								"Marked as documentSaleStartDateMin: " + date + " - " + timeH1 + ":" + timer60);
						System.out.println(
								"Marked as bidSubmissionStartDateMin: " + date + " - " + timeH1 + ":" + timer60);
						System.out.println(
								"Marked as bidSubmissionClosingDateMin: " + DATE2 + " - " + timeH1 + ":" + timer60);
						System.out.println("Marked as bidOpeningDateMin :" + DATE2 + " - " + timeH1 + ":" + timer60);

						Thread.sleep(5000);

					} else if (timemr >= 50 && timemr5 >= 60) {

						System.out.println("timemr >= 50 && timemr5 >=60");
						driver.findElement(By.id("publishDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidSubStartDate")).sendKeys(date);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidSubCloseDate")).sendKeys(DATE2);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys(DATE2);
						Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

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

						System.out.println("publishingDateMin :" + timer50);
						System.out.println("documentSaleStartDateMin :" + timer50);
						System.out.println("bidSubmissionStartDateMin :" + timer50);
						System.out.println("bidSubmissionClosingDateMin :" + timer560);
						System.out.println("bidOpeningDateMin :" + timer560);

						Thread.sleep(5000);

					}
				}
			} catch (InvalidSelectorException e2) {

				e2.printStackTrace();
			}*/
			
			try	{
				System.out.println(" Default Creation Timings");
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.findElement(By.id("publishDate")).sendKeys("05/01/2024");Thread.sleep(300);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.findElement(By.id("documentSaleStartDate")).sendKeys("05/01/2024");Thread.sleep(300);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.findElement(By.id("bidSubStartDate")).sendKeys("05/01/2024");Thread.sleep(300);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				
				if(i<=5) {
					driver.findElement(By.id("bidSubCloseDate")).sendKeys("10/01/2024");Thread.sleep(300);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("10/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=10) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("11/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("11/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=15) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("12/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("12/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=20) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("13/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("18/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=25) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("15/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("15/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=30) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("16/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("16/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=35) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("17/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("17/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=40) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("10/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("10/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=45) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("11/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("11/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=50) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("12/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("12/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=55) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("12/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("12/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=60) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("13/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("13/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=65) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("15/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("15/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=70) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("16/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("16/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=75) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("17/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("17/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=80) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("18/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("18/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=85) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("10/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("10/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					else if(i<=90) {
						driver.findElement(By.id("bidSubCloseDate")).sendKeys("11/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.findElement(By.id("bidOpenDate")).sendKeys("11/01/2024");Thread.sleep(300);
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					}
					
				selection(driver.findElement(By.id("publishingDateHour")), "byVisibleText", "12");
				selection(driver.findElement(By.id("documentSaleStartDateHour")), "byVisibleText", "12");
				selection(driver.findElement(By.id("bidSubmissionStartDateHour")), "byVisibleText", "13");
				selection(driver.findElement(By.id("bidSubmissionClosingDateHour")), "byVisibleText", "09");
				selection(driver.findElement(By.id("bidOpeningDateHour")), "byVisibleText", "09");

				selection(driver.findElement(By.id("publishingDateMin")), "byVisibleText", "10");
				selection(driver.findElement(By.id("documentSaleStartDateMin")), "byVisibleText", "10");
				selection(driver.findElement(By.id("bidSubmissionStartDateMin")), "byVisibleText", "40");
				selection(driver.findElement(By.id("bidSubmissionClosingDateMin")), "byVisibleText", "40");
				selection(driver.findElement(By.id("bidOpeningDateMin")), "byVisibleText", "40");
				Thread.sleep(1000);
				System.out.println(" Tender Created for ebg"+i);
			}
		catch (NoSuchElementException e) {
			e.getStackTrace();
		}
			
			Thread.sleep(500);
			driver.findElement(By.id("Next")).click();

			try {
				Thread.sleep(500);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				System.out.println("Alert accepted");
			} catch (NoAlertPresentException e) {
				System.out.println("No Alert");
			}

			Thread.sleep(1500);
			System.out.println("Successful - Critical Date");

			// Bid openers List
			try {
				driver.findElement(By.xpath("//td[text()='deptuser7@nic.in']//following-sibling::td//input")).click();
			//	driver.findElement(By.xpath("//td[text()='deptuser3@nic.in']//following-sibling::td//input")).click();
				driver.findElement(By.xpath("//td[text()='deptuser4@nic.in']//following-sibling::td//input")).click();
				driver.findElement(By.xpath("//td[text()='deptuser8@nic.in']//following-sibling::td//input")).click();
				driver.findElement(By.id("Submit")).click();
				System.out.println("Successful - Bid openers List");
			} catch (NoSuchElementException e) {

				System.out.println("No Bid Openers");
			}
			finally {
				Thread.sleep(1000);
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
				System.out.println("Successful - BOQ Upload ");
				System.out.println("Successful - BOQ Signed");

				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.findElement(By.id("save")).click();
				System.out.println("Successful - BOQ Saved ");
				Thread.sleep(500);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.findElement(By.id("DirectLink_1")).click();
				Thread.sleep(1500);
				// driver.findElement(By.id("ViewBOQCheck")).click();
				// System.out.println("Successful - BOQ Checked");s
				// Thread.sleep(1500);
				driver.findElement(By.id("checkbox4")).click();
				driver.findElement(By.id("Verifysave")).click();
				Thread.sleep(500);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.findElement(By.id("DirectLink_4")).click();
				System.out.println("Successful - BOQ Uploading Stage Completed");
				Thread.sleep(1500);
			} catch (NoSuchElementException e1) {

				e1.printStackTrace();
			} catch (AWTException e1) {

				e1.printStackTrace();
			}
			try {
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
			} catch (NoAlertPresentException e) {

				System.out.println("No Alert");
				
			}
			Thread.sleep(1000);
			/*
			try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if (driver.findElement(By.xpath("//td/span[text()='Resource Master (Fleet / Equipment / Manpower)']"))
						.isDisplayed()) {
					driver.findElement(By.xpath("//table[@id='tableView']/tbody/tr[10]/td[8]/input")).click();
					String Rm = driver.findElement(By.xpath("//table[@id='tableView']/tbody/tr[10]/td[5]")).getText();
					System.out.println("Resource master: " + Rm);
					driver.findElement(By.xpath("//table[@id='tableView']/tbody/tr[10]/td[9]/input")).sendKeys(Rm);
					Thread.sleep(200);
					driver.findElement(By.id("Submit")).click();
					Thread.sleep(200);
					driver.findElement(By.xpath("//a[@value ='Next']")).click();
					Thread.sleep(200);
				}

			} catch (NoSuchElementException e) {
				System.out.println("No Resource Master");
			}

			// OID Documents List
			try {
				driver.findElement(By.id("save")).click();
				System.out.println("Successful - OID Stage Completed");
				Thread.sleep(500);
			} catch (NoSuchElementException e) {
				driver.findElement(By.id("Next")).click();
				System.out.println("Successful - OID Stage Completed");
			}
			Thread.sleep(1500);
*/
			// GeMARPTS ID
			try {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (driver.findElement(By.xpath("//td[text()='GeMARPTS']")).isDisplayed()) {
					driver.findElement(By.id("gemArptsRadioNo")).click();
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					selection(driver.findElement(By.id("gemArptsIdNotAvailingReason")), "byIndex", "3");
					driver.findElement(By.id("gemArptsRemarks"))
							.sendKeys("GeMARPTS ID is not available for this tender");
					driver.findElement(By.id("gemReasonBtn")).click();
					Thread.sleep(500);
					driver.findElement(By.id("nxtReason")).click();
					Thread.sleep(500);
					System.out.println("GempArpts Updated Successfully");
				}

			} catch (NoSuchElementException e3) {
				System.out.println("No GemArpts");
			}

			try {

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (driver.findElement(By.xpath("//td[text()='TIA Undertaking']")).isDisplayed()) {
					selection(driver.findElement(By.id("tendercomplyingorder")), "byVisibleText", "Agree");
					selection(driver.findElement(By.id("tendercomplyingorder_0")), "byVisibleText", "Agree");
					selection(driver.findElement(By.id("tendercomplyingorder_1")), "byVisibleText", "Agree");
					Thread.sleep(500);
					driver.findElement(By.id("next")).click();
					Thread.sleep(500);
					System.out.println("TIA Undertaking Updated Successfully");
				}
			} catch (NoSuchElementException e3) {
				System.out.println("TIA Undertaking");
			}
			
			try {
				Thread.sleep(200);
		//		Tenderid = driver.findElement(By.xpath("//td[text()='Tender ID']//following-sibling::td[1]")).getText();
		//		reader.setCellData("Test_Cases", "Tender ID", i, Tenderid);
				driver.findElement(By.id("Submit")).click();
			
			try {
					Thread.sleep(200);
					driver.switchTo().alert().accept();
					Thread.sleep(200);
				} catch (NoAlertPresentException e) {

					System.out.println("No Alert");
				}
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebElement id = driver
						.findElement(By.xpath("//table[@class='message_box']/tbody/tr[9]/td/b/span/span/b"));
				Tenderid = id.getText();
				System.out.println("id:" + Tenderid);
				System.out.println("Successful - Tender Send to Publish");
				Thread.sleep(1500);
				Thread.sleep(1500);
			} catch (NoSuchElementException e) {
				System.out.println("NOT found of submit button");
			}

			// Publish Tender
			driver.findElement(By.xpath("//a[text() = 'Publish Tender']")).click();
			Thread.sleep(1500);
			driver.findElement(By.id("TenderId")).sendKeys(Tenderid);
			driver.findElement(By.id("search")).click();
			Thread.sleep(1500);
			driver.findElement(By.id("view")).click();
			Thread.sleep(1500);
			driver.findElement(By.id("Submit")).click();
			try {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				Thread.sleep(200);
			} catch (NoAlertPresentException e) {

				System.out.println("No Alert");
			}
			try {
			if(i==2) {
				BasicId = Tenderid.substring(0, Tenderid.length() - 2);
				System.out.println(BasicId);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			Thread.sleep(1000);
			} catch (NoSuchElementException e) {

				e.printStackTrace();
			}catch (InvalidElementStateException e1)
			{
				e1.printStackTrace();
			}
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
		robot.delay(5000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(5000);

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
		robot.delay(5000);
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
		robot.delay(3000);

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
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}
}
