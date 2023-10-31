package testng.org1;

import org.openqa.selenium.By;

public class Amazon extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
	

    getDriver("chrome");
    getUrl("https://www.amazon.in/");
    Pom d = new Pom(driver);
	d.getSignin().click(); Thread.sleep(2000);
	d.getEmail().sendKeys("8610210746");
	d.getContinue().click();Thread.sleep(1000);
	d.getPassword().sendKeys("Ramkumar@777");
	d.getlogin().click(); Thread.sleep(1000);
	d.getSearch().sendKeys("i PHONE");
	d.getSearchSubmit().click();Thread.sleep(2000);
	d.getItem2().click();
	gettab1();Thread.sleep(1000);
	selection( driver.findElement(By.name("dropdown_selected_size_name")), "byVisibleText", "XL");Thread.sleep(2000);
	d.getAddtoCart().click();Thread.sleep(2000);
	gettab0();Thread.sleep(1000);
	d.getSearch().sendKeys("");
	d.getSearchSubmit().click();Thread.sleep(2000);
	d.getItem2().click();Thread.sleep(1000);
	//gettab3();Thread.sleep(1000);
	selection( driver.findElement(By.name("dropdown_selected_size_name")), "byVisibleText", "XL");Thread.sleep(2000);
	d.getAddtoCart().click();
	    
	    
	}
}
 