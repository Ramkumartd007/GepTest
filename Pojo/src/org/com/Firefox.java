package org.com;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Firefox {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\91991\\eclipse-workspace\\Selenium\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		/* WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("ramkumar466@yahoo.com");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("ramkumar");
		WebElement login = driver.findElement(By.name("login"));
		login.click(); */
		
		WebElement CreateAccount = driver.findElement(By.xpath("//a[@data-testid= 'open-registration-form-button']"));
		CreateAccount.click();
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//a[@action='cancel']")).click();
	//	WebElement CreateAccount1 = driver.findElement(By.xpath("//a[@data-testid= 'open-registration-form-button']"));
	//	CreateAccount1.click();
	//	Thread.sleep(2000);
		WebElement Fname = driver.findElement(By.xpath("//input[@name='firstname']"));
		Fname.sendKeys("Ramkumar");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("T D");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("ramkumartd2012@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("ramkumartd2012@gmail.com");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Kumar@123");
		driver.findElement(By.xpath("//button[@name='websubmit']")).click(); 
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		WebElement day = driver.findElement(By.id("day"));
		Select d1 = new Select(day);
		d1.selectByValue("12");
		System.out.println(day.getAttribute("value"));
		List<WebElement> total = d1.getOptions();
		System.out.println(total.size());
		for(int i=0;i<total.size();i++)
		{
				String txt = total.get(i).getText();
				System.out.println(txt);
				total.get(i).click();
		}
		WebElement month = driver.findElement(By.id("month"));
		Select d2 = new Select(month);
		d2.selectByVisibleText("Aug");
		List<WebElement> total1 = d2.getOptions();
		System.out.println(total1.size());
		for(int i=0;i<total1.size();i++)
		{
				String txt1 = total1.get(i).getText();
				System.out.println(txt1);
				total1.get(i).click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
