package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.base.Baseclass;
import com.helper.FileReaderManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = "src\\test\\resources\\testfeature\\log.feature",
        glue = "com\\stepdefen" ,            
		monochrome = true,
		stepNotifications = true,
		dryRun = false,
		publish = true
				
		
		)
public class RunnerTest {
	public static WebDriver driver;
	@BeforeClass
public static void launch() throws IOException {
	String browser = FileReaderManager.getInstance().getCrInstance().getBrowser();
 driver = Baseclass.getDriver(browser);
	
}
	@AfterClass
	public static void closebrowser() {
		driver.quit();
		
	}
}
