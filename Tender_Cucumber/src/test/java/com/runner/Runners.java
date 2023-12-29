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
		features = "src\\test\\java\\com\\featurefile\\Logins.feature",
        glue = "com\\steps" ,            
		monochrome = true,
		stepNotifications = true,
		dryRun = false,
		publish = true,
		plugin =//"pretty"
				//"usage"
				//"html:target\\cucumberreports\\file.html"
				//"json:target\\cucumberreports\\file.json"
				//"junit:target\\cucumberreports\\file.xml"
		          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		tags = "@sr1"
		)
public class Runners {
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
