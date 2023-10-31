package testng.com;
import org.openqa.selenium.By;

public class BidderEnrollment extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		getDriver("firefox");
		getUrl("https://demoeproc.nic.in/nicgep/app");
		Pom p = new Pom(driver);
		p.getBidEnroll().click();Thread.sleep(2000);
		//sleep();
		p.getLoginId().sendKeys("ramkumar@yahoo.co.in");
		p.getCorrEmail().sendKeys("ramtdnic@gmail.com");

	}

}
