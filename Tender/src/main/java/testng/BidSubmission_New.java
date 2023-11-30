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

	import net.sourceforge.tess4j.ITesseract;
	import net.sourceforge.tess4j.Tesseract;
	import net.sourceforge.tess4j.TesseractException;

	public class BidSubmission_New extends BaseClass {

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
					driver.findElement(By.id("UserName")).sendKeys("bidder7@nic.in");
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

		try {
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("PageLink_3")).click(); Thread.sleep(3000);
			driver.findElement(By.id("tenderId")).sendKeys("2023_NIC_10020_1");
			driver.findElement(By.id("submit")).click();Thread.sleep(2000);
			driver.findElement(By.id("Checkbox")).click();
			driver.findElement(By.id("save")).click();Thread.sleep(2000);
			System.out.println("Tender selected as favourite");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Tender is already moved to My Tenders");	
		}

		try {		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("PageLink_0_8")).click();Thread.sleep(3000);
			driver.findElement(By.id("TenderID")).sendKeys("2023_NIC_10020_1");
			driver.findElement(By.id("search")).click(); Thread.sleep(2000);	
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("DirectLink_0")).click();Thread.sleep(2000);/*
			driver.findElement(By.xpath("//img[@src='images/zipicon.png']")).click();
			Thread.sleep(1000);
			System.out.println("Tender document has been downloaded");*/
		}catch (NoSuchElementException e) {
			System.out.println("error");
		}

		WebElement BOQ = driver.findElement(By.xpath("//table[@id='tableView4']/tbody/tr[2]/td[3][text()[contains(.,'BOQ')]]"));
		Work_BOQ = BOQ.getText().replace(".xls","");	
		System.out.println(Work_BOQ);
		driver.findElement(By.xpath("//input[@class = 'customButton']")).click();
		
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.id("selectcheckbox")).isDisplayed()) {
				Thread.sleep(500);
			driver.findElement(By.id("selectcheckbox")).click();
			driver.findElement(By.id("Next")).click();
			System.out.println("Agreed the process");
			}
			} catch (NoSuchElementException e1) 
			{
			System.out.println("Already agreed");	
			}

			Thread.sleep(1000);
//GST Code			            
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(driver.findElement(By.id("gstCode")).isDisplayed())
				{
					try{
						Thread.sleep(500);
					selection(driver.findElement(By.id("gstCode")),"byValue", "1");Thread.sleep(200);
					driver.findElement(By.id("Next")).click();Thread.sleep(500);
					System.out.println("user profile updated");	
					} catch (NoSuchElementException e) {
						System.out.println(e);
					}
				}else {driver.findElement(By.id("Next")).click();Thread.sleep(500);}
				System.out.println("user profile updated");	
				Thread.sleep(500);
				
		} catch (NoSuchElementException e1) {
			System.out.println("User profile already updated");
			}
	
		Thread.sleep(1000);
		try {driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);driver.findElement(By.id("Next")).click();Thread.sleep(500);System.out.println("TenderExemp is no");} catch (NoSuchElementException e){System.out.println("No Tender Exemption");}
		Thread.sleep(500);
		try {driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);driver.findElement(By.id("Next")).click();Thread.sleep(500);System.out.println("EMDExemp is no");} catch (NoSuchElementException e){System.out.println("No Emd Exemption");}
		Thread.sleep(500);

		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				if(driver.findElement(By.id("oid")).isDisplayed())
				{
					driver.findElement(By.id("oid")).click();Thread.sleep(1000);
					driver.findElement(By.id("save")).click();Thread.sleep(500);
					System.out.println("Oid updated");
				}

			} catch (NoSuchElementException e1) {
			System.out.println("There is no oid");
			}

		
		
//Offline Payment		
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			if(driver.findElement(By.id("offLine")).isDisplayed()) 
					{
					driver.findElement(By.id("offLine")).click();Thread.sleep(1000);
					driver.findElement(By.id("confirm")).click();
					}
			
					try {
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					driver.switchTo().alert().accept();
					Thread.sleep(500);
					} catch (NoAlertPresentException e) 
					{
						System.out.println("Already Confirm for the payment");
					}
					Thread.sleep(1000);

					String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
					Calendar cal1 = Calendar.getInstance();
					cal1.setTime(new SimpleDateFormat("dd/MM/YYYY").parse(date));
					cal1.add(Calendar.DATE, 0);
					String DATE5 = new SimpleDateFormat("dd/MM/YYYY").format(cal1.getTime());
					 while(driver.findElement(By.id("instrumentType")).isDisplayed())
					{
						 
						Thread.sleep(500);
						driver.findElement(By.id("DirectLink_1")).click();
						Thread.sleep(500);
//Tender Fee						
							selection(driver.findElement(By.id("instrumentType")), "byValue", "0");
							driver.findElement(By.id("instNumber")).sendKeys("132456789"); 
							driver.findElement(By.id("dptIssued")).sendKeys("01/10/2023");Thread.sleep(100);  
							driver.findElement(By.id("dptExpired")).sendKeys("01/09/2024");
							WebElement id = 
									driver.findElement(By.xpath("//table[@cellspacing='1'][@cellpadding='2']/tbody[1]/tr[5]/td[2]/b"));
							String Amount = id.getText().replace(",","");
							driver.findElement(By.id("amount")).sendKeys(Amount);
							driver.findElement(By.id("issuerDetail")).sendKeys("SBI");
							System.out.println("Amount Paid");
							driver.findElement(By.id("cmdSave")).click(); Thread.sleep(500);
							System.out.println("Tender Fee Updated");
							driver.findElement(By.id("DirectLink_1")).click();
							Thread.sleep(100);
						
//EMD Fee
						
						Thread.sleep(500);
						selection(driver.findElement(By.id("instrumentType")), "byValue", "0");
						driver.findElement(By.id("instNumber")).sendKeys("132456789"); 
						driver.findElement(By.id("dptIssued")).sendKeys("01/10/2023");  Thread.sleep(100);
						driver.findElement(By.id("dptExpired")).sendKeys("01/09/2024");
						WebElement id1 = driver.findElement(By.xpath("//table[@cellspacing='1'][@cellpadding='2']/tbody[1]/tr[5]/td[2]/b"));
						String Amount1 = id1.getText().replace(",","");
						driver.findElement(By.id("amount")).sendKeys(Amount1);
						driver.findElement(By.id("issuerDetail")).sendKeys("SBI");
						System.out.println("Amount Paid");
						driver.findElement(By.id("Save")).click(); Thread.sleep(500);
						System.out.println("EMD Fee Updated");
						driver.findElement(By.id("DirectLink_1")).click();
					    driver.findElement(By.id("Save")).click(); Thread.sleep(500);
						System.out.println("Save");
						break;
					}
				}
			
			catch (NumberFormatException e2)
					{
					System.out.println("Throws NumberFormatException");
					}
			Thread.sleep(500);
		
		
		
		System.out.println("GTE Process");
//GTE Process		
		try {
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if (driver.findElement(By.xpath(("//a[@title='GTE Details']//following-sibling::img[@src='images/action.png']"))).isDisplayed()) {
				System.out.println("GTE is Present");
				Thread.sleep(500);
				driver.findElement(By.xpath(("//a[@title='GTE Details']//following-sibling::img[@src='images/action.png']"))).click();
				
				Thread.sleep(1500);
				System.out.println("GTE is Under Processing");
				try {
					List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tabList_1']/tbody/tr"));
					int rcoun = rows.size();
					int rcount = rcoun+1;
					System.out.println("ROW COUNT : "+rcount);	
					for(int i=3;i<rcount;i++) {	
							System.out.println("SL.NO: "+i);
							String Expected = driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+String.valueOf(i)+"]/td[3]")).getText();
							System.out.println(Expected);
							Boolean x = Expected.contains("Yes");
							try {
								if (x)
								{
									selection(driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+String.valueOf(i)+"]/td[4]/span/select")),"byVisibleText",Expected);Thread.sleep(200);
								}else
								{
									driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+String.valueOf(i)+"]/td[4]/span/input")).sendKeys(Expected); Thread.sleep(200);
								}
							} catch (NoSuchElementException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
														
							}
					driver.findElement(By.id("save")).click(); Thread.sleep(500);
					driver.findElement(By.id("save")).click();
												
				} catch (NoSuchElementException e) {
					e.printStackTrace();				
				}
			}
		
		} catch (NoSuchElementException e1) {
			// TODO Auto-generated catch block
			System.out.println("Already GTE is Updated");
		}
		try {
			if(driver.findElement(By.xpath("//tbody/tr[1]/td[text() ='Bidder Item Wise Evaluation']")).isDisplayed()) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tabList_1']/tbody/tr"));
			int rcoun = rows.size();
			int rcount = rcoun+1;
			System.out.println("ROW COUNT : "+rcount);	
			for(int i=2;i<rcount;i++) {	
					System.out.println("SL.NO: "+i);
					
					try {
							selection(driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+String.valueOf(i)+"]/td[6]/span/select")),"byVisibleText","Yes");Thread.sleep(200);
						
					} catch (NoSuchElementException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
												
					}
			driver.findElement(By.id("save")).click(); Thread.sleep(500);
			driver.findElement(By.id("save")).click();
			}				
		} catch (NoSuchElementException e) {
			e.printStackTrace();				
		}
//GTE Completed	
		
		//ITE Process		
				try {
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if (driver.findElement(By.xpath(("//a[@title='ITE Details']//following-sibling::img[@src='images/action.png']"))).isDisplayed()) {
						System.out.println("ITE is Present");
						Thread.sleep(500);
						driver.findElement(By.xpath(("//a[@title='ITE Details']//following-sibling::img[@src='images/action.png']"))).click();
						
						Thread.sleep(1500);
						System.out.println("GTE is Under Processing");
						try {
							List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tabList_1']/tbody/tr"));
							int rcoun = rows.size();
							int rcount = rcoun+1;
							System.out.println("ROW COUNT : "+rcount);	
							for(int i=2;i<rcount;i++) {	
									System.out.println("SL.NO: "+i);
									try {
										selection(driver.findElement(By.xpath("//table[@id='tabList_1']/tbody/tr["+String.valueOf(i)+"]/td[6]/span/select")),"byVisibleText","Yes");Thread.sleep(200);
										
									} catch (NoSuchElementException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
																
									}
							driver.findElement(By.id("save")).click(); Thread.sleep(500);
							driver.findElement(By.id("save")).click();
														
						} catch (NoSuchElementException e) {
							e.printStackTrace();				
						}
					}
				} catch (NoSuchElementException e1) {
					// TODO Auto-generated catch block
					System.out.println("Already GTE is Updated");
				}
		//ITE Completed			
		
		
//Avail Preferential Bidder Option		
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if (driver.findElement(By.xpath(("//a[@title='Avail Preferential Bidder Option']//following-sibling::img[@src='images/action.png']"))).isDisplayed()) {
						System.out.println("Avail Preferential Bidder Option is Present");
						driver.findElement(By.xpath(("//a[@title='GTE Details']//following-sibling::img[@src='images/action.png']"))).click();Thread.sleep(500);
						System.out.println("Avail Preferential Bidder Option is under Processing");
						try {
							driver.findElement(By.id("privilegeBidderYes")).click();Thread.sleep(2000);
							Avail_PrefentialBidder_Document();
							driver.findElement(By.id("save")).click(); Thread.sleep(500);
							} catch (NoSuchElementException e) {
							e.printStackTrace();				
						}
					}
				} catch (NoSuchElementException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//Avail Preferential Bidder Option Completed
		
		
		
		try {
			driver.findElement(By.id("encryptUpload")).click();  Thread.sleep(1000);  
			try
			{
				driver.switchTo().alert().accept();
			}
			catch (Exception e) {
				System.out.println("No Alert");
			}
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
			robot.delay(1000);
			robot.mouseMove(276, 156);
			robot.delay(1500);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(1000);
			robot.mouseMove(450, 470);
			robot.delay(6000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(2000);

		}
		
		public static void Avail_PrefentialBidder_Document() throws AWTException {
			Robot robot = new Robot();
			robot.mouseMove(1210, 387);
			robot.delay(1500);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(1000);
			setClipboardData("C:\\Users\\admin\\Documents\\TenderDocument.pdf");	
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(10000);	
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(12000);
			robot.mouseMove(1242, 387);
			robot.delay(1500);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
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
