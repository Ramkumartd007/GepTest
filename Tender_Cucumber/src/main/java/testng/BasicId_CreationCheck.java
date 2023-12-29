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

public class BasicId_CreationCheck extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args)
			throws InterruptedException, AWTException, IOException, TesseractException, ParseException {
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
		String bidOpenerType = "1";

		String EMD = null;
		String TFexmpt = null;
		String EMDexmpt = null;
		String TF = null;
		String e_BG = null;
		String Tenderid = null;
		String BasicId = "2023_NIC_10078";

		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\itemwise\\config.properties");
		prop.load(input);
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
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
		
			{
				
				driver.findElement(By.xpath("//a[text() = 'Create Tender / Tender List']")).click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				System.out.println(BasicId);
				driver.findElement(By.xpath("//td[text()='"+BasicId+"']//following-sibling::td//a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Add New']")).click();
				Thread.sleep(1000);
			}
			// Work/Item Details
			Thread.sleep(1500);
			
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
