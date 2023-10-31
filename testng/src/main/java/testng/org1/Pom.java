package testng.org1;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom {
	
	public static WebDriver driver;
	public Pom(WebDriver driver2) {
    Pom.driver = driver2;
    PageFactory.initElements(driver2,this);
	}
	
	
	@FindBy(id="nav-link-accountList-nav-line-1")	
	private WebElement Signin;
	public WebElement getSignin(){return Signin;}
	
	@FindBy(xpath="//a[@data-nav-ref='nav_ya_signin']")
	private WebElement Signin1;
	public WebElement getSignin1(){return Signin1;}
		
	@FindBy(id="ap_email")	
	private WebElement Email;
	public WebElement getEmail(){return Email;}
	
	@FindBy(id="continue")	
	private WebElement Continue;
	public WebElement getContinue(){return Continue;}
	
	@FindBy(xpath="//input[@type='password']")	
	private WebElement password;
	public WebElement getPassword(){return password;}
	
	@FindBy(id="signInSubmit")	
	private WebElement login;
	public WebElement getlogin(){return login;} 

	@FindBy(id="twotabsearchtextbox")	
	private WebElement Search;
	public WebElement getSearch(){return Search;} 
	

	@FindBy(id="nav-search-submit-button")	
	private WebElement SearchSubmit;
	public WebElement getSearchSubmit(){return SearchSubmit;} 
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")	
	private WebElement item1;
	public WebElement getItem1(){return item1;}  
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")	
	private WebElement Item2;
	public WebElement getItem2(){return Item2;}		
	
	
	@FindBy(id="add-to-cart-button")	
	private WebElement AddtoCart;
	public WebElement getAddtoCart(){return AddtoCart;} 
	
	public void getBacktab() {
		String windowHandle = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.switchTo().window(windowHandle);
		}
		
}	
	
