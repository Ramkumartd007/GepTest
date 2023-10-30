package testng;


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

	public class EnableIteGteTCA extends BaseClass {

		public static WebDriver driver;
		private static int i;
		public static void main(String[] args) throws InterruptedException, AWTException, IOException, TesseractException, ParseException {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://demoeproc.nic.in/nicgep/app");
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
					driver.findElement(By.id("UserName")).sendKeys("appadmin@nic.in");
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
					Thread.sleep(4000);
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
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("PageLink_0_3")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		selection(driver.findElement(By.id("orgCombo")), "byVisibleText", "Department of Employment and Training");
		Thread.sleep(2000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(2000);
		
		/*
		//Auto - Extension Enabling against the Organisation chain
		for(i=1;i<31;i++) {
			driver.findElement(By.xpath("//td[text()='"+i+"']//following-sibling::td//a")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//td[text()='Auction properties']//following-sibling::td//a")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			selection(driver.findElement(By.id("bidAutoExtnInMins")), "byValue", "2");
			selection(driver.findElement(By.id("elapseTimeIntervalInMins")), "byValue", "1");
			driver.findElement(By.id("maxSealPercentage")).clear();
			driver.findElement(By.id("maxSealPercentage")).sendKeys("50");
			Thread.sleep(1500);
			driver.findElement(By.id("Save")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("PageLink_2")).click();
			Thread.sleep(2000);
			if(i==10||i==20||i==30) {
				driver.findElement(By.id("linkFwd")).click();
				Thread.sleep(1500);
				
			}
			}*/
		for(i=67;i<992;i++) {
			
			try {Thread.sleep(2000);
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			while(driver.findElement(By.xpath("//td[text()='"+i+"']//following-sibling::td//a")).isDisplayed())
			{
 	 	   System.out.println(i);
 	 	   	driver.findElement(By.xpath("//td[text()='"+i+"']//following-sibling::td//a")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			//driver.findElement(By.xpath("//td[text()='Critical Dates validation Desc']//following-sibling::td//a")).click();
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//selection(driver.findElement(By.id("templateName")), "byVisibleText", "SameDayOpening");Thread.sleep(500);
			//driver.findElement(By.id("Save")).click();
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			
			driver.findElement(By.xpath("//td[text()='Tender Work Flow']//following-sibling::td//a")).click();
			Thread.sleep(500);
			
	//		driver.findElement(By.xpath("//input[@id='techBidStatus'][2]")).click();Thread.sleep(500);
	//		driver.findElement(By.xpath("//input[@id='finBidStatus'][2]")).click();Thread.sleep(500);
	//		driver.findElement(By.id("numberOfPacketContentsAllowed")).clear();
	//		driver.findElement(By.id("numberOfPacketContentsAllowed")).sendKeys("28"); Thread.sleep(500);
										
			driver.findElement(By.id("allowGTEYes")).click();Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='itePropertyId'][2]")).click();Thread.sleep(500);
			driver.findElement(By.id("Save")).click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
			driver.findElement(By.id("PageLink_2")).click();
			Thread.sleep(2000);
			i++;
				}
			} 
	   		  catch (NoSuchElementException e) {
	   			driver.findElement(By.id("linkFwd")).click();
				Thread.sleep(1500);		
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
			robot.mouseMove(450, 470);
			robot.delay(3000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			robot.delay(3000);

		}
}