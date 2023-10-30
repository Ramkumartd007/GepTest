package testng.com;

import org.testng.annotations.Test;

import testng.TenderBaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class SimpleAnnotations extends testng.TenderBaseClass {
	public  WebDriver driver;

	@BeforeSuite
public void chrome() {
		System.out.println("Browser");
}

@BeforeTest
public void OpenDriver() {
	System.out.println("BrowserOpened");
}

@BeforeClass
public void Login() {
	System.out.println("Login1");
}
@BeforeMethod
public void Login2() {
	System.out.println("Login2");		
}
@Test (dependsOnMethods = "CoverDetails")
public void BasicDetails() {
	System.out.println("BasicDetails");
}

@Test (priority =1)
public void CoverDetails() {
	System.out.println("CoverDetails");
}


@AfterMethod
public void VerifyHomePage(){
System.out.println("VerifyHomePage");
	}
	
	@AfterClass
	public void Nit() {
		System.out.println("Nit");
	}
	
	@AfterTest
	public void BrowserClose() {
		System.out.println("BrowserClose");
	}
	
	@AfterSuite
	public void DeleteCookies() {
		System.out.println("DeleteCookies");
	}

}


