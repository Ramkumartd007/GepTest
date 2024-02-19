package testng;
import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;



public class TeseBase64 {
	public static WebDriver driver;

	public static void main(String[] args)
			throws InterruptedException, AWTException, IOException, TesseractException, ParseException, WebDriverException {
	

	System.setProperty("webdriver.gecko.driver",
			"C:\\Users\\91991\\eclipse-workspace\\com\\Driver\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://demoeproc.nic.in/nicgep/app");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.findElement(By.id("login")).click(); Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebElement capt = driver.findElement(By.xpath("//img[@id='captchaImage']"));
	String Csrc = capt.getAttribute("src");
	String base64Image = Csrc.split(",")[1];
	byte[] image = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
	BufferedImage img = ImageIO.read(new ByteArrayInputStream(image));
	File outputfile = new File("C:\\Users\\91991\\eclipse-workspace\\Tender\\Screenshot\\Captcha1.png");
	ImageIO.write(img, "png", outputfile);
	ITesseract image1 = new Tesseract();
	String imagetest = image1
			.doOCR(new File("C:\\Users\\91991\\eclipse-workspace\\Tender\\Screenshot\\Captcha1.png"));
	String x = imagetest.replaceAll("[^a-z0-9A-Z]", "");
	System.out.println(x);
	driver.findElement(By.id("CaptchaText")).sendKeys(x);
	
    System.out.println(img);
}
}
