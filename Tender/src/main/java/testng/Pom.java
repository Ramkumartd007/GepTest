package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom {

	public static WebDriver driver;
	public Pom(WebDriver driver2) {
    Pom.driver = driver2;
	PageFactory.initElements(driver2, this);
	}
	
	@FindBy(id="DirectLink_11") private WebElement bidEnroll;
	@FindBy(id="EmailId") private WebElement loginId;
	@FindBy(id="Email") private WebElement corrEmail;
	@FindBy(id="mobileIsdCode") private WebElement std;
	@FindBy(id="Mobile") private WebElement mobileNO;
	@FindBy(id="CompanyName") private WebElement companyname;
	@FindBy(id="RegNumber") private WebElement regNumber;
	@FindBy(id="RegisteredAddress") private WebElement registeredAddress;
	@FindBy(id="bidderTypeIndian") private WebElement indian;
	@FindBy(id="city") private WebElement city;
	@FindBy(id="StatesName") private WebElement statesname;
	@FindBy(id="PostalCode") private WebElement pincode;
	@FindBy(id="PanNumber") private WebElement panno;
	@FindBy(id="EstablishYear") private WebElement establishYear;
	@FindBy(id="BusinessNatures") private WebElement businessNatures;
	@FindBy(id="LegalStatus") private WebElement legalStatus;
	@FindBy(id="BidderCategory") private WebElement bidcate;
	@FindBy(id="title") private WebElement title;
	@FindBy(id="ContactName") private WebElement contactName;
	@FindBy(id="dateOfBirth") private WebElement dob;
	@FindBy(id="Designation") private WebElement tester;
	@FindBy(id="captchaText") private WebElement captchaenter;
	@FindBy(id="captchaImage") private WebElement captchaimage;
	@FindBy(xpath="//img[@class='datePickerImg']") private WebElement calender;
	@FindBy(xpath="(//td[@class='labelContainer'])[1]/select") private WebElement calenderm;
	@FindBy(xpath="(//td[@class='labelContainer'])[2]/select") private WebElement calendery;
	@FindBy(xpath="//table[@class='grid']/tbody/tr/td[text()='12']") private WebElement calenderd;
	@FindBy(id="submit") private WebElement SVC; 
	@FindBy(id="PageLink_0_0") private WebElement MyAccount;
	@FindBy(id="PrivilegesEnabled") private WebElement Privileges;
	@FindBy(id="Login") private WebElement Login;
	
	public WebElement getLogin() {
		return Login;
	}
	public WebElement getPrivileges() {
		return Privileges;
	}
	
	public WebElement getMyAccount() {
		return MyAccount;
	}
	
	public WebElement getSVC() {
		return SVC;
	}
	public WebElement getCalenderd() {
		return calenderd;
	}
	public WebElement getCalenderm() {
		return calenderm;
	}
	public WebElement getCalendery() {
		return calendery;
	}
	public WebElement getCalender() {
		return calender;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public WebElement getBidEnroll() {
		return bidEnroll;
	}
	public WebElement getLoginId() {
		return loginId;
	}
	public WebElement getCorrEmail() {
		return corrEmail;
	}
	public WebElement getStd() {
		return std;
	}
	public WebElement getMobileNO() {
		return mobileNO;
	}
	public WebElement getCompanyname() {
		return companyname;
	}
	public WebElement getRegNumber() {
		return regNumber;
	}
	public WebElement getRegisteredAddress() {
		return registeredAddress;
	}
	public WebElement getIndian() {
		return indian;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getStatesname() {
		return statesname;
	}
	public WebElement getPincode() {
		return pincode;
	}
	public WebElement getPanno() {
		return panno;
	}
	public WebElement getEstablishYear() {
		return establishYear;
	}
	public WebElement getBusinessNatures() {
		return businessNatures;
	}
	public WebElement getLegalStatus() {
		return legalStatus;
	}
	public WebElement getBidcate() {
		return bidcate;
	}
	public WebElement getTitle() {
		return title;
	}
	public WebElement getContactName() {
		return contactName;
	}
	public WebElement getDob() {
		return dob;
	}
	public WebElement getTester() {
		return tester;
	}
	public WebElement getCaptchaenter() {
		return captchaenter;
	}
	public WebElement getCaptchaimage() {
		return captchaimage;
	}



	
}

