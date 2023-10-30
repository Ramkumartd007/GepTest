package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom2 {

	public static WebDriver driver;
	public Pom2(WebDriver driver2) {
    Pom2.driver = driver2;
	PageFactory.initElements(driver2, this);
	}
	
	@FindBy(id="login") private WebElement Login;
	@FindBy(id="UserName") private WebElement UserName;
	@FindBy(id="Password") private WebElement Password;
	@FindBy(xpath="//img[@id='captchaImage']") private WebElement captimg;
	@FindBy(id="CaptchaText") private WebElement CaptchaText;
	@FindBy(id="submitSHA") private WebElement Loginsubmit;
	@FindBy(xpath="//a[contains(text(),'Create Tender')]") private WebElement CreateTender;
	@FindBy(id="bd") private WebElement CallTender;
	@FindBy(id="tenderRefNo") private WebElement TenderRefNo;
	@FindBy(name ="tenderType") private WebElement Tendertype;
	@FindBy(id="formContract") private WebElement formContract;
	@FindBy(id="noOfPackets") private WebElement noOfPackets;
	@FindBy(id="tenderCategory") private WebElement tenderCategory;
	@FindBy(id="bidOpenerType") private WebElement bidOpenerType;
	@FindBy(id="Next") private WebElement Next;
	@FindBy(id="one") private WebElement one;
	@FindBy(id="docDesc") private WebElement docDesc;
	@FindBy(id="docType") private WebElement docType;
	@FindBy(id="Save") private WebElement Save;
	@FindBy(id="DirectLink_1") private WebElement DirectLink_1;
	@FindBy(id="one_0") private WebElement one_0;
	@FindBy(id="DirectLink_0") private WebElement DirectLink_0;
	@FindBy(id="Verifysave") private WebElement Verifysave;
	@FindBy(id="DirectLink_2") private WebElement DirectLink_2;
	@FindBy(id="txtTenderTitle") private WebElement txtTenderTitle;
	@FindBy(id="txtWorkDesc") private WebElement txtWorkDesc;
	@FindBy(id="txtPreQual") private WebElement txtPreQual;
	@FindBy(id="productCategory") private WebElement productCategory;
	@FindBy(id="txtProductSubcategory") private WebElement txtProductSubcategory;	
	@FindBy(id="contractType") private WebElement contractType;
	@FindBy(id="tenderValue") private WebElement tenderValue;
	@FindBy(id="showTenderValueYes") private WebElement showTenderValueYes;
	@FindBy(id="secValidDays") private WebElement secValidDays;
	@FindBy(id="txtLocation") private WebElement txtLocation;
	@FindBy(id="pinCodeLocation") private WebElement pinCodeLocation;
	@FindBy(id="bidOpeningPlace") private WebElement bidOpeningPlace;
	@FindBy(id="TendererClass") private WebElement TendererClass;
	@FindBy(id="invitingOfficer") private WebElement invitingOfficer;
	@FindBy(id="invitingOfficerAddress") private WebElement invitingOfficerAddress;
	@FindBy(id="expireDays") private WebElement expireDays;
	@FindBy(xpath ="//input[@name='mclServiceAllowed']") private WebElement mclService;
	@FindBy(id="NotApplicable") private WebElement NotApplicable;
	@FindBy(id="publishDate") private WebElement publishDate;
	@FindBy(id="publishingDateHour") private WebElement publishingDateHour;
	@FindBy(id="publishingDateMin") private WebElement publishingDateMin;
	@FindBy(id="documentSaleStartDate") private WebElement documentSaleStartDate;
	@FindBy(id="documentSaleStartDateHour") private WebElement documentSaleStartDateHour;
	@FindBy(id="documentSaleStartDateMin") private WebElement documentSaleStartDateMin;
	@FindBy(id="bidSubStartDate") private WebElement bidSubStartDate;
	@FindBy(id="bidSubmissionStartDateHour") private WebElement bidSubmissionStartDateHour;
	@FindBy(id="bidSubmissionStartDateMin") private WebElement bidSubmissionStartDateMin;
	@FindBy(id="bidSubCloseDate") private WebElement bidSubCloseDate;
	@FindBy(id="bidSubmissionClosingDateHour") private WebElement bidSubmissionClosingDateHour;
	@FindBy(id="bidSubmissionClosingDateMin") private WebElement bidSubmissionClosingDateMin;
	@FindBy(id="bidOpenDate") private WebElement bidOpenDate;
	@FindBy(id="bidOpeningDateHour") private WebElement bidOpeningDateHour;
	@FindBy(id="bidOpeningDateMin") private WebElement bidOpeningDateMin;
	@FindBy(name="selectbox_0") private WebElement selectbox_0;
	@FindBy(id="selectbox_1") private WebElement selectbox_1;
	@FindBy(id="selectbox_4") private WebElement selectbox_4;
	@FindBy(id="Submit") private WebElement Submit;
	@FindBy(id="documentType") private WebElement documentType;
	@FindBy(id="description") private WebElement description;
	@FindBy(id="ViewBOQCheck") private WebElement ViewBOQCheck;
	@FindBy(id="checkbox4") private WebElement checkbox4;
	@FindBy(id="DirectLink_3") private WebElement DirectLink_3;
	@FindBy(xpath="//table[@class='message_box']/tbody/tr[9]/td/b/span/span/b") private WebElement Tenderid;
	@FindBy(id="PageLink_0_9") private WebElement PageLink_0_9;
	@FindBy(id="TenderId") private WebElement TenderId;
	@FindBy(id="search") private WebElement search;
	@FindBy(id="view") private WebElement view;
	
	public static WebDriver getDriver() {
		return driver;
	}
	public WebElement getLogin() {
		return Login;
	}
	public WebElement getUserName() {
		return UserName;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getCaptimg() {
		return captimg;
	}
	public WebElement getCaptchaText() {
		return CaptchaText;
	}
	public WebElement getLoginsubmit() {
		return Loginsubmit;
	}
	public WebElement getCreateTender() {
		return CreateTender;
	}
	public WebElement getCallTender() {
		return CallTender;
	}
	public WebElement getTenderRefNo() {
		return TenderRefNo;
	}
	public WebElement getTendertype() {
		return Tendertype;
	}
	public WebElement getFormContract() {
		return formContract;
	}
	public WebElement getNoOfPackets() {
		return noOfPackets;
	}
	public WebElement getTenderCategory() {
		return tenderCategory;
	}
	public WebElement getBidOpenerType() {
		return bidOpenerType;
	}
	public WebElement getNext() {
		return Next;
	}
	public WebElement getOne() {
		return one;
	}
	public WebElement getDocDesc() {
		return docDesc;
	}
	public WebElement getDocType() {
		return docType;
	}
	public WebElement getSave() {
		return Save;
	}
	public WebElement getDirectLink_1() {
		return DirectLink_1;
	}
	public WebElement getOne_0() {
		return one_0;
	}
	public WebElement getDirectLink_0() {
		return DirectLink_0;
	}
	public WebElement getVerifysave() {
		return Verifysave;
	}
	public WebElement getDirectLink_2() {
		return DirectLink_2;
	}
	public WebElement getTxtTenderTitle() {
		return txtTenderTitle;
	}
	public WebElement getTxtWorkDesc() {
		return txtWorkDesc;
	}
	public WebElement getTxtPreQual() {
		return txtPreQual;
	}
	public WebElement getProductCategory() {
		return productCategory;
	}
	public WebElement getTxtProductSubcategory() {
		return txtProductSubcategory;
	}
	public WebElement getContractType() {
		return contractType;
	}
	public WebElement getTenderValue() {
		return tenderValue;
	}
	public WebElement getShowTenderValueYes() {
		return showTenderValueYes;
	}
	public WebElement getSecValidDays() {
		return secValidDays;
	}
	public WebElement getTxtLocation() {
		return txtLocation;
	}
	public WebElement getPinCodeLocation() {
		return pinCodeLocation;
	}
	public WebElement getBidOpeningPlace() {
		return bidOpeningPlace;
	}
	public WebElement getTendererClass() {
		return TendererClass;
	}
	public WebElement getInvitingOfficer() {
		return invitingOfficer;
	}
	public WebElement getInvitingOfficerAddress() {
		return invitingOfficerAddress;
	}
	public WebElement getExpireDays() {
		return expireDays;
	}
	public WebElement getMclService() {
		return mclService;
	}
	public WebElement getNotApplicable() {
		return NotApplicable;
	}
	public WebElement getPublishDate() {
		return publishDate;
	}
	public WebElement getPublishingDateHour() {
		return publishingDateHour;
	}
	public WebElement getPublishingDateMin() {
		return publishingDateMin;
	}
	public WebElement getDocumentSaleStartDate() {
		return documentSaleStartDate;
	}
	public WebElement getDocumentSaleStartDateHour() {
		return documentSaleStartDateHour;
	}
	public WebElement getDocumentSaleStartDateMin() {
		return documentSaleStartDateMin;
	}
	public WebElement getBidSubStartDate() {
		return bidSubStartDate;
	}
	public WebElement getBidSubmissionStartDateHour() {
		return bidSubmissionStartDateHour;
	}
	public WebElement getBidSubmissionStartDateMin() {
		return bidSubmissionStartDateMin;
	}
	public WebElement getBidSubCloseDate() {
		return bidSubCloseDate;
	}
	public WebElement getBidSubmissionClosingDateHour() {
		return bidSubmissionClosingDateHour;
	}
	public WebElement getBidSubmissionClosingDateMin() {
		return bidSubmissionClosingDateMin;
	}
	public WebElement getBidOpenDate() {
		return bidOpenDate;
	}
	public WebElement getBidOpeningDateHour() {
		return bidOpeningDateHour;
	}
	public WebElement getBidOpeningDateMin() {
		return bidOpeningDateMin;
	}
	public WebElement getSelectbox_0() {
		return selectbox_0;
	}
	public WebElement getSelectbox_1() {
		return selectbox_1;
	}
	public WebElement getSelectbox_4() {
		return selectbox_4;
	}
	public WebElement getSubmit() {
		return Submit;
	}
	public WebElement getDocumentType() {
		return documentType;
	}
	public WebElement getDescription() {
		return description;
	}
	public WebElement getViewBOQCheck() {
		return ViewBOQCheck;
	}
	public WebElement getCheckbox4() {
		return checkbox4;
	}
	public WebElement getDirectLink_3() {
		return DirectLink_3;
	}
	public WebElement getTenderid() {
		return Tenderid;
	}
	public WebElement getPageLink_0_9() {
		return PageLink_0_9;
	}
	public WebElement getTenderId() {
		return TenderId;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getView() {
		return view;
	}

		
}

