package testng.org1;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreCase extends Base1 {
	public static Pom1 d;

	@BeforeSuite
	private void setup() throws InterruptedException {

		getDriver("Chrome");
		getUrl("https://www.amazon.in/");
		System.out.println("Browser");
		d = new Pom1(driver);

	}

	@BeforeTest
	private void sign() throws InterruptedException {
		d.getSignin1().click();
		Thread.sleep(2000);
		System.out.println("Signin");
	}

	@BeforeClass
	private void login() throws InterruptedException {
		d.getEmail().sendKeys("8610210746");
		d.getContinue().click();
		Thread.sleep(2000);
		d.getPassword().sendKeys("Ramkumar@777");
		d.getlogin().click();
		Thread.sleep(2000);
		System.out.println("Login");
	}

	@BeforeMethod
	public void Login2() {
		System.out.println("Login2");
	}

	@Test
	private void AddtoCart() throws InterruptedException {
		Thread.sleep(2000);
		d.getSearch().sendKeys("iphone");
		d.getSearchSubmit().click();
		Thread.sleep(2000);
		d.getItem1().click();
		gettab1();
		Thread.sleep(2000);
		System.out.println("i-phone 11 Mobile details");
		getTitle();
	}

	@Test (enabled = false)
	private void AddtoCart2() throws InterruptedException {
		gettab0();
		Thread.sleep(2000);
		d.getSearch().clear();
		d.getSearch().sendKeys("iphone 12");
		d.getSearchSubmit().click();
		Thread.sleep(2000);
		d.getItem2().click();
		Thread.sleep(2000);
		System.out.println("i-phone 12 Mobile details");
		getTitle();
	}

	@AfterMethod
	public void VerifyHomePage() {
		//quite();
		System.out.println("VerifyHomePage");
	}

	@AfterClass
	public void Nit() {
		actionMethod(driver.findElement(By.id("nav-link-accountList-nav-line-1")));
		driver.findElement(By.xpath("(//span[@class='nav-text'])[19]")).click();
		System.out.println("Nit");
	}

	@AfterTest
	public void DeleteCooke() {
		DeleteCookies();
		System.out.println("DeleteCookies");
	}
	
	@AfterSuite
	public void BrowserClose() {
		quite();
		System.out.println("BrowserClose");
	}
}
