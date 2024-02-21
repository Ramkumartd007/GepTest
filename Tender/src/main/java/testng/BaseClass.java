package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class BaseClass {
	public static WebDriver driver;
	//public static Properties prop;
	public static WebDriver getDriver(String browserName) {
		
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + ("\\Driver\\chromedriver.exe"));
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + ("\\Driver\\IEDriverServer.exe"));
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + ("\\Driver\\geckodriver.exe"));
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void getUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void sleep() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}

	public static void Captcha() throws IOException, TesseractException {
		try {
	WebElement capt = driver.findElement(By.xpath("//img[@id='captchaImage']"));
	String Csrc = capt.getAttribute("src");
	String base64Image = Csrc.split(",")[1];
	byte[] image = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
	BufferedImage img = ImageIO.read(new ByteArrayInputStream(image));
	File outputfile = new File("C:\\Users\\91991\\eclipse-workspace\\Tender\\Screenshot\\Captcha1.png");
	ImageIO.write(img, "png", outputfile);
	ITesseract image1 = new Tesseract();
	String imagetest = image1.doOCR(new File("C:\\Users\\91991\\eclipse-workspace\\Tender\\Screenshot\\Captcha1.png"));
	String captcha = imagetest.replaceAll("[^a-z0-9A-Z]", "");
	System.out.println(captcha);
	driver.findElement(By.id("CaptchaText")).sendKeys(captcha);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void currentUrl() {
		driver.getCurrentUrl();

	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void backward() {
		driver.navigate().back();

	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void close() {
		driver.close();

	}

	public static void quite() {
		driver.quit();
	}

	public static void getTitle() {
		driver.getTitle();
	}

	public static void enabled(WebElement element) {
		element.isEnabled();
	}

	public static void displayed(WebElement element) {
		element.isDisplayed();
	}

	public static void selected(WebElement element) {
		element.isSelected();
	}

	public static void screenshot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinateFile = new File(path);
		FileUtils.copyFileToDirectory(sourceFile, destinateFile);

	}

	public static void selection(WebElement element, String Option, String value) {
		Select sc = new Select(element);

		try {
			if (Option.equalsIgnoreCase("byIndex")) {
				int parseInt = Integer.parseInt(value);
				sc.selectByIndex(parseInt);
			} else if (Option.equalsIgnoreCase("byValue")) {
				sc.selectByValue(value);
			} else if (Option.equalsIgnoreCase("byVisibleText")) {
				sc.selectByVisibleText(value);
			} else {
				System.out.println("Invalid option");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void sendkeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void clearOnElement(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void simpleAlert() {
		driver.switchTo().alert().accept();

	}

	public static void confirmAlert(String ok, String cancel) {
		if (ok.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();

		} else if (cancel.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();

		}
	}

	public static void promptAlert(String ok, String value, String cancel) {
		if (ok.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();

		} else if (cancel.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();

		}
	}

	public static void actionMethod(WebElement Element) {
		Actions ac = new Actions(driver);
		ac.contextClick(Element).build().perform();

	}

 	public static void moveToElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();

	}

	public static void drogDrop(WebElement Element, WebElement Element1) {
		Actions ad = new Actions(driver);
		ad.dragAndDrop(Element, Element1).build().perform();

	}

	public static void robotClass() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void pageUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	public static void pageDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	public static void frameMethod(String option, String value, WebElement element) {
		try {
			if (option.equalsIgnoreCase("byIndex")) {
				int index = Integer.parseInt(value);
				driver.switchTo().frame(index);
			} else if (option.equalsIgnoreCase("byElement")) {
				driver.switchTo().frame(element);

			} else if (option.equalsIgnoreCase("byString")) {
				driver.switchTo().frame(value);
			} else {
				System.out.println("Invalid selection");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void elementClear(WebElement element) {
		element.clear();
	}

	public static void windowHandles() {
		Set<String> element = driver.getWindowHandles();

		for (String st : element) {
			String title = driver.switchTo().window(st).getTitle();
			System.out.println(title);
		}

	}
	public static void captchaimg() throws IOException, TesseractException, InterruptedException {
	try {  
	     while(driver.findElement(By.id("captchaImage")).isDisplayed())
	    	 {
	 	   try {
	WebElement capt = driver.findElement(By.xpath("//img[@id='captchaImage']"));
	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	BufferedImage fullImg = ImageIO.read(screenshot);
	Point point = capt.getLocation();
	int eleWidth = capt.getSize().getWidth();
	int eleHeight = capt.getSize().getHeight();
	BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
	ImageIO.write(eleScreenshot, "png", screenshot);
	File screenshotLocation = new File("C:\\Users\\91991\\eclipse-workspace\\Tender\\Screenshot\\Captcha.png");
	FileUtils.copyFile(screenshot, screenshotLocation);
	ITesseract image = new Tesseract();
	String imagetest = image
			.doOCR(new File("C:\\Users\\91991\\eclipse-workspace\\Tender\\Screenshot\\Captcha.png"));
	String x = imagetest.replaceAll("[^a-z0-9A-Z]", "");
	System.out.println(x);
	driver.findElement(By.id("CaptchaText")).sendKeys(x);
	driver.findElement(By.id("Submit")).click();
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
}
	public static void captchaimg1() throws IOException, TesseractException, InterruptedException {
		try {  
		     while(driver.findElement(By.id("captchaImage")).isDisplayed())
		    	 {
		 	   try {
	    driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("UserName")).sendKeys("biddereproc@nic.in");
		driver.findElement(By.id("Password")).sendKeys("Admin123$");
		WebElement capt = driver.findElement(By.xpath("//img[@id='captchaImage']"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);
		Point point = capt.getLocation();
		int eleWidth = capt.getSize().getWidth();
		int eleHeight = capt.getSize().getHeight();
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		File screenshotLocation = new File("C:\\Users\\91991\\eclipse-workspace\\Tender\\Screenshot\\Captcha.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		ITesseract image = new Tesseract();
		String imagetest = image
				.doOCR(new File("C:\\Users\\91991\\eclipse-workspace\\Tender\\Screenshot\\Captcha.png"));
		String x = imagetest.replaceAll("[^a-z0-9A-Z]", "");
		System.out.println(x);
		driver.findElement(By.id("CaptchaText")).sendKeys(x);
		driver.findElement(By.id("submitSHA")).click();
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
	}
	
	
}
