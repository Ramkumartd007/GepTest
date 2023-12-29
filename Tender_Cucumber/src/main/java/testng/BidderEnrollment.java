package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import net.sourceforge.tess4j.TesseractException;


public class BidderEnrollment extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
		prop.load(input);
		getDriver(prop.getProperty("browser"));	
		getUrl(prop.getProperty("url"));
		Thread.sleep(2000);
		Pom p = new Pom(driver);
		p.getBidEnroll().click();Thread.sleep(1000);
		//sleep();
		p.getLoginId().sendKeys(prop.getProperty("LoginId"));
		p.getCorrEmail().sendKeys(prop.getProperty("CorrEmail"));
		selection(p.getStd(), "byVisibleText" , "IND (91)");
		p.getMobileNO().sendKeys(prop.getProperty("MobileNo"));
		p.getCompanyname().sendKeys(prop.getProperty("Companyname"));
		p.getRegNumber().sendKeys(prop.getProperty("RegNumber"));
		p.getRegisteredAddress().sendKeys(prop.getProperty("RegisteredAddress"));
		p.getIndian().click();
		p.getCity().sendKeys(prop.getProperty("City"));
		selection(p.getStatesname(), "byVisibleText", "Tamil Nadu");
		p.getPincode().sendKeys(prop.getProperty("Pincode"));
		p.getPanno().sendKeys(prop.getProperty("Panno"));
		selection(p.getEstablishYear(), "byVisibleText", "2004");
		p.getBusinessNatures().sendKeys(prop.getProperty("BusinessNatures"));
		selection(p.getLegalStatus(), "byVisibleText", "Others");
		selection(p.getBidcate(), "byVisibleText", "Others");
		selection(p.getTitle(), "byVisibleText", "Mr");
		p.getContactName().sendKeys(prop.getProperty("ContactName"));
		p.getCalender().click();Thread.sleep(1000);
		selection(p.getCalenderm(), "byVisibleText", "August");
		selection(p.getCalendery(), "byVisibleText", "1994");
		p.getCalenderd().click();
		captchaimg();
		Thread.sleep(1000);
		p.getSVC().click();
		
		
	
	}

}
