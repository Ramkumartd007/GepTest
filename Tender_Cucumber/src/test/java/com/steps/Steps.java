	package com.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.base.Baseclass;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;
import com.runner.Runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends Baseclass {
	
	//Pomclass pc;
	
	public static WebDriver driver = Runners.driver;
	PageObjectManager pom = new PageObjectManager(driver);
	
	@Before
	public void beforehook(Scenario scenario) {
		String name = scenario.getName();
		System.out.println(name);		
	}
	
	@After
	public void afterhook(Scenario scenario) {
		Status status = scenario.getStatus();
		System.out.println(status);		
	}
	
@Given("user launch the application from chrome browser")
public void user_launch_the_application_from_chrome_browser() throws IOException {
String address = FileReaderManager.getInstance().getCrInstance().getAddress();
getUrl(address);
System.out.println(address);
//pc = new Pomclass(driver);
	/*getDriver("Chrome");
	getUrl("https://www.amazon.in/");
	System.out.println("Browser");
	pc = new Pomclass(driver);
   System.out.println("www.amazon.in");*/
}

@When("user enter the below details")
public void user_enter_the_below_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	
	List<Map<String,String>> asMaps = dataTable.asMaps(String.class,String.class);
	//p.getSignin1().click();
	pom.getLp().getSignin1().click();
	Thread.sleep(2000);
	System.out.println("Signin");
	String Username = asMaps.get(0).get("username");	
	sendkeys(pom.getLp().getEmail(), Username);
	pom.getLp().getContinue().click();
	Thread.sleep(2000);
	System.out.println("User name is: "+Username);
	
	String Password = asMaps.get(0).get("password");
	sendkeys(pom.getLp().getPassword(), Password);
	
	//sendkeys(pc.getEmail(), Username);
	//sendkeys(pc.getPassword(), Password);
	
	//pc.getEmail().sendKeys(Username);
	    
	//pc.getPassword().sendKeys(Password);
	System.out.println("Password is" +Password);
}
@Then("user clicked the login button")
public void user_clicked_the_login_button() throws InterruptedException {
	pom.getLp().getlogin().click();
	Thread.sleep(2000);
	System.out.println("Logged in");
}
}


