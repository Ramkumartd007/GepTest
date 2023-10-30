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

	public class Old_BidSubmission extends BaseClass {

		public static WebDriver driver;
		private static String Work_BOQ;
		public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException, ParseException {

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
					    	 {
				    	 Thread.sleep(1000);
			    	 	   try {
			    	Thread.sleep(2000);
			    	driver.findElement(By.id("UserName")).clear();
					driver.findElement(By.id("Password")).clear();
					driver.findElement(By.id("UserName")).sendKeys("bidder1@nic.in");
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
		Thread.sleep(10000);
		
		System.out.println("Sucessful - Second Login");
		Thread.sleep(2000);
		
			try {
					driver.findElement(By.id("PageLink_3")).click(); Thread.sleep(3000);
					driver.findElement(By.id("tenderId")).sendKeys("2023_NICTD_81590_1");
					driver.findElement(By.id("submit")).click();Thread.sleep(3000);
					driver.findElement(By.id("Checkbox")).click();
					driver.findElement(By.id("save")).click();Thread.sleep(2000);
					System.out.println("Tender selected as favourite");
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Tender is already moved to My Tenders");	
			}
		
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		if(driver.findElement(By.id("PageLink_0_5")).isDisplayed()) {
					
				driver.findElement(By.id("PageLink_0_5")).click();Thread.sleep(2000);
				driver.findElement(By.id("TenderID")).sendKeys("2023_NICTD_81590_1");
				driver.findElement(By.id("search")).click();	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.id("DirectLink_0")).click();Thread.sleep(2000);
				driver.findElement(By.xpath("//img[@src='images/zipicon.png']")).click();
				Thread.sleep(5000);
				System.out.println("Tender document has been downloaded");
			
		}
		
		WebElement BOQ = driver.findElement(By.xpath("//table[@id='tableView4']/tbody/tr[2]/td[3][text()[contains(.,'BOQ')]]"));
		Work_BOQ = BOQ.getText().replace(".xls","");
		try {
				driver.findElement(By.id("proceedBid")).click();Thread.sleep(2000);
				System.out.println("Proceed for bidding");
				System.out.println(Work_BOQ);Thread.sleep(4000);
				
		} catch (NoSuchElementException e1) {
			// TODO Auto-generated catch block
			driver.findElement(By.id("continueBid")).click();Thread.sleep(2000);
			System.out.println("continue for Biddng");
			System.out.println(Work_BOQ);Thread.sleep(4000);
		}
		
			try {
				if(driver.findElement(By.id("selectcheckbox")).isDisplayed()) {
				driver.findElement(By.id("selectcheckbox")).click();
				driver.findElement(By.id("Next")).click();	
				System.out.println("Agreed the process");
				}
			} catch (NoSuchElementException e1) {
				// TODO Auto-generated catch block
				System.out.println("Already agreed");	
			}
			
			Thread.sleep(2000);
			            
            try {
                if(driver.findElement(By.id("gstCode")).isDisplayed()) {    
                
                selection(driver.findElement(By.id("gstCode")), "byValue", "1");
                driver.findElement(By.id("Next")).click();
                System.out.println("user profile updated");	
                }
            } catch (NoSuchElementException e1) {
                // TODO Auto-generated catch block	
            	System.out.println("User profile already updated");	
            }
            /*
            Thread.sleep(2000);
            try {driver.findElement(By.id("Next")).click();Thread.sleep(2000);} catch (NoSuchElementException e) 
            {System.out.println("No Tender Exemption");}
            try {driver.findElement(By.id("Next")).click();Thread.sleep(2000);} catch (NoSuchElementException e) 
            {System.out.println("No Emd Exemption");}
            Thread.sleep(3000);
            
            try {
				if(driver.findElement(By.id("oid")).isDisplayed()) {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.id("oid")).click();Thread.sleep(2000);
				driver.findElement(By.id("save")).click();Thread.sleep(2000);
				}
			} catch (NoSuchElementException e1) {
				// TODO Auto-generated catch block
				System.out.println("There is no oid");
			}
            
            try {
				if(driver.findElement(By.id("offLine")).isDisplayed()) {
				
				driver.findElement(By.id("offLine")).click();Thread.sleep(3000);
				
				try {
				driver.findElement(By.id("confirm")).click();	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				} catch (NoSuchElementException e) {System.out.println("Already Confirm for the payment");}
				}
				Thread.sleep(3000);
				
				String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
				Calendar cal1 = Calendar.getInstance();
				 cal1.setTime(new SimpleDateFormat("dd/MM/YYYY").parse(date));
				  cal1.add(Calendar.DATE, 0);
				  String DATE5 = new SimpleDateFormat("dd/MM/YYYY").format(cal1.getTime());
				  
				  
				 try {  
				     while(driver.findElement(By.id("instrumentType")).isDisplayed())
					    	 {
				    	 Thread.sleep(1000);
				    	 try {
				    		 
				    	Thread.sleep(3000);
				    	driver.findElement(By.id("DirectLink_1")).click();
				    	Thread.sleep(3000);
				    	if(driver.findElement(By.xpath("//span[@class='error']")).isDisplayed()){
				    	Thread.sleep(2000);
				        selection(driver.findElement(By.id("instrumentType")), "byValue", "0");
				        driver.findElement(By.id("instNumber")).sendKeys("132456789"); 
				        driver.findElement(By.id("dptIssued")).sendKeys("01/12/2023");  
				        driver.findElement(By.id("dptExpired")).sendKeys(DATE5);
				        WebElement id = driver.findElement(By.xpath("//table[@cellspacing='1'][@cellpadding='2']/tbody[1]/tr[5]/td[2]/b"));
				        String Amount = id.getText().replace(",","");
				        driver.findElement(By.id("amount")).sendKeys(Amount);
				        driver.findElement(By.id("issuerDetail")).sendKeys("SBI");
				        try {
							driver.findElement(By.id("Save")).click(); Thread.sleep(500);
						} catch (NoSuchElementException e) {
							driver.findElement(By.id("cmdSave")).click(); Thread.sleep(500);
						}
				        driver.findElement(By.id("DirectLink_1")).click();
				      }
			       
				} catch (NoSuchElementException e) {
					driver.findElement(By.id("DirectLink_1")).click();
					System.out.println("Details already filled");
				}
					    	 }
			     }
		   		  catch (NoSuchElementException e) {
		    			System.out.println("Fees Paid");	
		  		
		   		  }
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("There is no Offile fee");
			}        
            
            */
            
            Thread.sleep(2000);
            try {
				driver.findElement(By.id("encryptUpload")).click();  Thread.sleep(4000);           
				driver.findElement(By.id("DirectLink_2")).click();  Thread.sleep(5000);
				if(driver.findElement(By.id("bidEngender")).isDisplayed()) {
					TenchnicalDocumentUpload();
				}
				Thread.sleep(6000);
				driver.findElement(By.id("DirectLink_2")).click();Thread.sleep(4000);
				if(driver.findElement(By.id("bidEngender")).isDisplayed()) {
					FinancialDocumentUpload();
				}
			} catch (NoSuchElementException e) {
				driver.findElement(By.id("encryptUpload")).click();  Thread.sleep(4000);           
				driver.findElement(By.id("DirectLink_1")).click();  Thread.sleep(5000);
				if(driver.findElement(By.id("bidEngender")).isDisplayed()) {
					TenchnicalDocumentUpload();
				}
				Thread.sleep(3000);
				driver.findElement(By.id("DirectLink_2")).click();Thread.sleep(4000);
				if(driver.findElement(By.id("bidEngender")).isDisplayed()) {
					FinancialDocumentUpload();
				}
			} 
            Thread.sleep(3000);
            driver.findElement(By.id("next")).click();Thread.sleep(4000);
            driver.findElement(By.id("freeze")).click();Thread.sleep(4000);
                        
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
			robot.mouseMove(450, 470);
			robot.delay(3000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(3000);

		}
		public static void TenchnicalDocumentUpload() throws AWTException {
			
			Robot robot = new Robot();
			robot.mouseMove(1071, 399);
			robot.delay(3000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(3000);
			robot.mouseMove(674, 464);
			robot.delay(3000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(3000);
			
			setClipboardData("C:\\Users\\91991\\Documents\\testing.pdf");	
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(10000);	
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(12000);
			robot.mouseMove(1053, 686);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(10000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
				}
		public static void FinancialDocumentUpload() throws AWTException {
			
			Robot robot = new Robot();
			robot.mouseMove(1071, 399);
			robot.delay(3000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(3000);
			robot.mouseMove(674, 464);
			robot.delay(3000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(3000);
			String boq = "work_76401";
			setClipboardData("C:\\Users\\91991\\Documents\\000boq\\"+Work_BOQ+"\\"+Work_BOQ+".xls");	
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(10000);	
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(3000);
			robot.mouseMove(456, 290);
			robot.delay(3000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);			
			robot.delay(12000);
			robot.mouseMove(1053, 686);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(10000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
				}
		
		public static void setClipboardData(String filePath) {
		    StringSelection stringSelection = new StringSelection( filePath );
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	}
