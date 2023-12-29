package config;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import net.sourceforge.tess4j.TesseractException;

public class BidderPrivilegeschecking extends BaseClass{
	public static void main(String[] args) throws InterruptedException, IOException, TesseractException, AWTException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
		prop.load(input);
		getDriver(prop.getProperty("browser"));	
		getUrl(prop.getProperty("url"));
		Thread.sleep(2000);
		Pom p = new Pom(driver);
		p.getLogin().click();Thread.sleep(1000);
		//sleep();
		captchaimg1();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Robot1();
		p.getMyAccount().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p.getPrivileges().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
	}
	public static void Robot1() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(489, 500);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(3000);
		robot.mouseMove(276, 156);
		robot.delay(1500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(2000);
		robot.mouseMove(460, 492);
		robot.delay(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(2000);

	}

}
