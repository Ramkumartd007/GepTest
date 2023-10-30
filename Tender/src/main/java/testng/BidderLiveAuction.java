	package testng;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.hamcrest.core.IsEqual;
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

	public class BidderLiveAuction extends BaseClass {
		private static int QuotedPrice;
		public static int IncrementQuotedPrice;
		public static int DecrementPrice;
		public static int DecrementQuotedPrice;
		public static int IncrementPrice;
		private static int QuotedPrice1;
				public static WebDriver driver;
				public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException, ParseException {
				
					System.setProperty("webdriver.gecko.driver",
							"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
					WebDriver driver = new FirefoxDriver();
					driver.get("https://demoeproc.nic.in/nicgep/app");
					driver.manage().window().maximize();
					Thread.sleep(2000);
					driver.findElement(By.id("login")).click(); 
					Thread.sleep(2000);
					String tenderid = "2023_NICTD_85065_1";
					try {  
						     while(driver.findElement(By.id("UserName")).isDisplayed())
							    	 {
						    	 Thread.sleep(1000);
					    	 	   try {
					    	Thread.sleep(2000);
					    	driver.findElement(By.id("UserName")).clear();
							driver.findElement(By.id("Password")).clear();
							driver.findElement(By.id("UserName")).sendKeys("bidder2@nic.in");
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
							Thread.sleep(2000);
					    	  } 
						   		  catch (NoSuchElementException e) {
					    			System.out.println("Login attempt 1");		
						   		  }Thread.sleep(1000);
							    	 }
							     }
						   		  catch (NoSuchElementException e) {
						    			System.out.println("Login attempt 2");	
						  		
				 }
				Thread.sleep(2000);
				Robot1();
				Thread.sleep(5000);
				
				System.out.println("Sucessful - Second Login");
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//a[text()='Live Auctions']")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("TenderId")).sendKeys(tenderid);
				driver.findElement(By.id("search")).click();Thread.sleep(2000);
				driver.findElement(By.xpath("//td[text()='"+tenderid+"']//following-sibling::td//img")).click();Thread.sleep(2000);
				Thread.sleep(2000);
				
				
				List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tabList_1']/tbody/tr"));
				int rcount = rows.size();
				System.out.println("ROW COUNT : "+rcount);				
				
				for(int j=1;j<5;j++) {
					for(int i=3;i<rcount;i++) {	
						System.out.println("Round "+i);
						Thread.sleep(3000);
						driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+String.valueOf(i)+"]/td[8]//img")).click();
						Thread.sleep(3000);
						System.out.println("Round 1 "+i);
						WebElement StartPirce = driver.findElement(By.xpath("//td[contains(text(),'Start Price')]//following-sibling::td"));
						
						//WebElement MyLatestValue = driver.findElement(By.xpath("//td[text()='My Latest Value in ₹ : ']//following-sibling::td"));
						
						
						int Startingprice = Integer.valueOf(StartPirce.getText().replace(",",""));
						
						
						try {
							driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							
							if(driver.findElement(By.xpath("//td[contains(text(),'Increment')]//following-sibling::td")).isDisplayed()) {
							WebElement IncrementalPrice = driver.findElement(By.xpath("//td[contains(text(),'Increment')]//following-sibling::td"));
							IncrementPrice = Integer.valueOf(IncrementalPrice.getText().replace(",",""));
							System.out.println("Increment Price Value:" +IncrementPrice);
							} 
						else if(driver.findElement(By.xpath("//td[contains(text(),'Decrement')]//following-sibling::td")).isDisplayed()){
							driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							WebElement DecrementalPrice = driver.findElement(By.xpath("//td[text()='Decrement Price in ₹ :']//following-sibling::td"));
							int DecrementPrice = Integer.valueOf(DecrementalPrice.getText().replace(",",""));		
							System.out.println("Decrement Price Value: " +DecrementPrice);
						}	
						}
						catch (Exception e1)
							{
							driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							WebElement DecrementalPrice = driver.findElement(By.xpath("//td[contains(text(),'Decrement')]//following-sibling::td"));
							int DecrementPrice = Integer.valueOf(DecrementalPrice.getText().replace(",",""));		
							System.out.println("Decrement Price Value: " +DecrementPrice);
							}
						
						System.out.println("Starting price:" +Startingprice);
						
						try {
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							WebElement CurrentPrice = driver.findElement(By.xpath("//td[contains(text(),'Current')]//following-sibling::td"));
							int  findCurrentPrice = Integer.valueOf(CurrentPrice.getText().replace(",",""));
							System.out.println(findCurrentPrice);
							if(findCurrentPrice>0) {
							try {
								if(driver.findElement(By.xpath("//td[contains(text(),'Increment')]//following-sibling::td")).isDisplayed()) {
							IncrementQuotedPrice = findCurrentPrice+IncrementPrice;
							QuotedPrice = IncrementQuotedPrice;
							System.out.println("IncrementQuotedPrice: " +DecrementPrice);}
							else {
								DecrementQuotedPrice = findCurrentPrice-DecrementPrice;	
								QuotedPrice = DecrementQuotedPrice;
								System.out.println("DecrementQuotedPrice: " +DecrementQuotedPrice);
							}
							}
							catch(NoSuchElementException e5)							
							{
							DecrementQuotedPrice = findCurrentPrice-DecrementPrice;	
							QuotedPrice = DecrementQuotedPrice;
							System.out.println("DecrementQuotedPrice:" +DecrementQuotedPrice);
							}
								System.out.println(IncrementPrice);
					//String enterprice = String.valueOf(QuotedPrice)
						Robot robot = new Robot();	
						robot.delay(3000);
						setClipboardData(""+QuotedPrice);	
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_V);
						robot.keyRelease(KeyEvent.VK_V);
						robot.delay(3000);
						robot.mouseMove(940, 675);
						robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						robot.delay(3000);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);	
						robot.delay(3000);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						
						Thread.sleep(2000);
						driver.findElement(By.id("Submit")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//a[@title='Back']")).click();
						Thread.sleep(2000);
					} 
						}
					catch (NumberFormatException e) {
						
						try {
							WebElement IncrementalPrice = driver.findElement(By.xpath("//td[contains(text(),'Increment')]//following-sibling::td"));
							IncrementPrice = Integer.valueOf(IncrementalPrice.getText().replace(",",""));
							if(driver.findElement(By.xpath("//td[text()='Increment Price in ₹ :']//following-sibling::td")).isDisplayed()) 
							{
							QuotedPrice1 = Startingprice+IncrementPrice;
							System.out.println(QuotedPrice1);
							}
						}
						catch (NoSuchElementException e3)
						{
							WebElement DecrementalPrice = driver.findElement(By.xpath("//td[contains(text(),'Decrement')]//following-sibling::td"));
							int DecrementPrice = Integer.valueOf(DecrementalPrice.getText().replace(",",""));		
							if(driver.findElement(By.xpath("//td[contains(text(),'Decrement')]//following-sibling::td")).isDisplayed()) 
							{ 
							QuotedPrice1 = Startingprice-DecrementPrice;
							System.out.println(QuotedPrice1);
							}
						}
						System.out.println("QuotedPrice1"+ QuotedPrice1);
						//String enterprice = String.valueOf(QuotedPrice)
				Robot robot = new Robot();	
						robot.delay(3000);
						setClipboardData(""+QuotedPrice1);	
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_V);
						robot.keyRelease(KeyEvent.VK_V);
						robot.delay(3000);
						robot.mouseMove(940, 630);
						robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						robot.delay(3000);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);	
						robot.delay(3000);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						
						Thread.sleep(2000);
						driver.findElement(By.id("Submit")).click();
						Thread.sleep(4000);
						driver.findElement(By.xpath("//a[@title='Back']")).click();
						Thread.sleep(2000);
					}
				}		
				}	
				}
				public static void Robot1() throws AWTException {
					Robot robot = new Robot();
					robot.mouseMove(480, 500);
					robot.delay(1500);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(3000);
					robot.mouseMove(276, 156);
					robot.delay(1500);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(2000);
					robot.mouseMove(460, 470);
					robot.delay(5000);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(3000);

				}
				public static void setClipboardData(String filePath) {
				    StringSelection stringSelection = new StringSelection( filePath );
				    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				}
	}