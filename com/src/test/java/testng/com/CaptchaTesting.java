package testng.com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CaptchaTesting {
	
public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

System.setProperty("webdriver.gecko.driver","C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.get("https://demoeproc.nic.in/nicgep/app");
driver.manage().window().maximize(); Thread.sleep(1000);

  driver.findElement(By.id("login")).click(); Thread.sleep(3000);
  driver.findElement(By.id("UserName")).sendKeys("deptuser2@nic.in");
  driver.findElement(By.id("Password")).sendKeys("Admin123$"); Thread.sleep(3000);
      
  WebElement capt = driver.findElement(By.xpath("//img[@id='captchaImage']"));

  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  BufferedImage  fullImg = ImageIO.read(screenshot);
  Point point = capt.getLocation();

  // Get width and height of the element
  int eleWidth = capt.getSize().getWidth();
  int eleHeight = capt.getSize().getHeight();

  // Crop the entire page screenshot to get only element screenshot
  BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
  ImageIO.write(eleScreenshot, "png", screenshot);

  // Copy the element screenshot to disk
  File screenshotLocation = new File("C:\\Users\\91991\\eclipse-workspace\\Selenium\\Screenshot\\capt.png");
  FileUtils.copyFile(screenshot, screenshotLocation);
  Thread.sleep(2000);
  
  ITesseract image = new Tesseract();
  String imagetest = image.doOCR(new File ("C:\\Users\\91991\\eclipse-workspace\\Selenium\\Screenshot\\capt.png"));
  String x= imagetest.replaceAll("[^a-z0-9A-Z]","");
  System.out.println(x);
  
  
  //String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
 // driver.findElement(By.id("CaptchaText")).sendKeys(x);
  //driver.findElement(By.id("submitSHA")).click(); Thread.sleep(3000);
  //System.out.println("Sucessful - First Login");
  //driver.findElement(By.id("appAuth")).click();Thread.sleep(1000);
 // Robot1();
  /*Robot robot = new Robot(); 
  robot.mouseMove(276,156); robot.delay(1500);
  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); robot.delay(3000);
  robot.mouseMove(451,492); robot.delay(3000);
  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); robot.delay(3000);
  System.out.println("Sucessful - Second Login");Thread.sleep(10000);
  driver.findElement(By.xpath("//a[contains(text(),'Create Tender')]")).click();Thread.sleep(2000);
  driver.findElement(By.id("bd")).click();Thread.sleep(2000);
  driver.findElement(By.name("tenderRefNo")).sendKeys("TestAavin");
  Select OT = new Select(driver.findElement(By.name("tenderType"))); OT.selectByVisibleText("Open Tender");
  Select fC = new Select(driver.findElement(By.id("formContract"))); fC.selectByVisibleText("Item Rate");
  Select nP = new Select(driver.findElement(By.id("noOfPackets")));  nP.selectByValue("2");
  Select tC = new Select(driver.findElement(By.id("tenderCategory"))); tC.selectByVisibleText("Services");
  Select bO = new Select(driver.findElement(By.id("bidOpenerType"))); bO.selectByIndex(2);    
  driver.findElement(By.xpath("(//input[@value='1'])")).click();
 // driver.findElement(By.id("multiCurYes")).click();
  System.out.println("Sucessful - Basic details");
  driver.findElement(By.id("Next")).click();Thread.sleep(2000);
  //CoverDetails - Technical cover
  driver.findElement(By.id("one")).click();Thread.sleep(1000);
  driver.findElement(By.id("docDesc")).sendKeys("Technical");
  Select dT = new Select(driver.findElement(By.id("docType"))); dT.selectByVisibleText(".pdf");
  driver.findElement(By.id("Save")).click();
  driver.findElement(By.id("DirectLink_1")).click();Thread.sleep(1000);
  //FinancialDetails
  driver.findElement(By.id("one_0")).click();Thread.sleep(1000);
  driver.findElement(By.id("docDesc")).sendKeys("Finance");
  Select dF = new Select(driver.findElement(By.id("docType"))); dF.selectByVisibleText(".xls");
  driver.findElement(By.id("Save")).click();
  driver.findElement(By.id("DirectLink_1")).click();Thread.sleep(1000);
  driver.findElement(By.id("Next")).click();Thread.sleep(1000);	
  System.out.println("Sucessful - Cover details");
  //NIT Document
  driver.findElement(By.id("DirectLink_0")).click();Thread.sleep(1000);
  driver.findElement(By.id("checkbox4")).click();
  driver.findElement(By.id("Verifysave")).click();Thread.sleep(1000);
  driver.findElement(By.id("DirectLink_2")).click();Thread.sleep(1000);
  System.out.println("Sucessful - NIT Document verified"); 
  //Work/Item Details
  driver.findElement(By.id("txtTenderTitle")).sendKeys("checkflow");
  driver.findElement(By.id("txtWorkDesc")).sendKeys("checkflow");
  driver.findElement(By.id("txtPreQual")).sendKeys("checkflow");
  Select pC = new Select(driver.findElement(By.id("productCategory"))); pC.selectByVisibleText("Manpower Supply");
  driver.findElement(By.id("txtProductSubcategory")).sendKeys("checkflow");
  Select cT = new Select(driver.findElement(By.id("contractType"))); cT.selectByVisibleText("Tender");
  driver.findElement(By.id("tenderValue")).sendKeys("1100000");
  driver.findElement(By.id("showTenderValueYes")).click();
  Select bV = new Select(driver.findElement(By.id("secValidDays"))); bV.selectByVisibleText("120");
  driver.findElement(By.id("txtLocation")).sendKeys("Chennai");
  driver.findElement(By.id("pinCodeLocation")).sendKeys("600000");
  driver.findElement(By.id("bidOpeningPlace")).sendKeys("Chennai");
  Select tCl = new Select(driver.findElement(By.id("TendererClass"))); tCl.selectByVisibleText("OTHERS"); 
  driver.findElement(By.id("invitingOfficer")).sendKeys("Officer");
  driver.findElement(By.id("invitingOfficerAddress")).sendKeys("Address");
  driver.findElement(By.id("Next")).click();Thread.sleep(1000);
  System.out.println("Sucessful - Work/Item Details");
  // Fee Details
  driver.findElement(By.id("NotApplicable")).click();
  driver.findElement(By.id("Next")).click();Thread.sleep(1000);
  System.out.println("Sucessful - Fee Details");
  //Critical Dates
 String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
  driver.findElement(By.id("publishDate")).sendKeys(date);
  Select pDH = new Select(driver.findElement(By.id("publishingDateHour"))); pDH.selectByVisibleText("17");
  Select pDM = new Select(driver.findElement(By.id("publishingDateMin"))); pDM.selectByVisibleText("50");
  driver.findElement(By.id("documentSaleStartDate")).sendKeys(date);
  Select dSSDH = new Select(driver.findElement(By.id("documentSaleStartDateHour"))); dSSDH.selectByVisibleText("17");
  Select dSSDM = new Select(driver.findElement(By.id("documentSaleStartDateMin"))); dSSDM.selectByVisibleText("50");
  driver.findElement(By.id("bidSubStartDate")).sendKeys(date);
  Select bSSDH = new Select(driver.findElement(By.id("bidSubmissionStartDateHour"))); bSSDH.selectByVisibleText("17");
  Select bSSDM = new Select(driver.findElement(By.id("bidSubmissionStartDateMin"))); bSSDM.selectByVisibleText("50");
  driver.findElement(By.id("bidSubCloseDate")).sendKeys(date);
  Select bSCDH = new Select(driver.findElement(By.id("bidSubmissionClosingDateHour"))); bSCDH.selectByVisibleText("18");
  Select bSCDM = new Select(driver.findElement(By.id("bidSubmissionClosingDateMin"))); bSCDM.selectByVisibleText("40");
  driver.findElement(By.id("bidOpenDate")).sendKeys(date);
  Select bODH = new Select(driver.findElement(By.id("bidOpeningDateHour"))); bODH.selectByVisibleText("18");
  Select bODM = new Select(driver.findElement(By.id("bidOpeningDateMin"))); bODM.selectByVisibleText("45");
  driver.findElement(By.id("Next")).click();
  driver.switchTo().alert().accept();
  Thread.sleep(1000);
  System.out.println("Sucessful - Critical Date");
  //Bid openers List
  driver.findElement(By.id("selectbox_51")).click();
  driver.findElement(By.id("selectbox_50")).click();
  driver.findElement(By.id("selectbox_21")).click();
  driver.findElement(By.id("Submit")).click();  
  System.out.println("Sucessful - Bid openers List");
//driver.findElement(By.xpath("//table[contains(text()='depteproc@nic.in')]/parent::td//preceding-sibling::td//input[@type()='checkbox']")).click();
  
  
  //td[text()='depteproc@nic.in'][@type='checkbox']
  }	
public static void Robot1() throws AWTException {
	Robot robot = new Robot(); 
	  robot.mouseMove(276,156); robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); robot.delay(3000);
	  robot.mouseMove(451,492); robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); robot.delay(3000);
	
}*/
}
}

