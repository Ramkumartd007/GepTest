package testng.com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Captcha {
	
public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

	System.setProperty("webdriver.gecko.driver",
			"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://demoetenders.tn.nic.in/pretenderv2/app");
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
	
	
  ITesseract image = new Tesseract();
  String imagetest = image.doOCR(new File ("C:\\Users\\91991\\eclipse-workspace\\com\\Screenshot\\Captcha.png"));
  String x= imagetest.replaceAll("[^a-z0-9A-Z :\r^]","").replaceAll(" ", "");
  System.out.println(x);
  
  	
}

}

