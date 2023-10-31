package testng.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demo {
	
	public static WebDriver driver;
	public Demo(WebDriver driver2) 
	{
    Demo.driver = driver2;
    PageFactory.initElements(driver2,this);
	}
	
	
	@FindBy(id="email")	
	private WebElement username;
	
	public WebElement getUsername()
	{
		return username;
	}

	@FindBy(name="pass")	
	private WebElement password;
	
	public WebElement getPassword() 
	{
		return password;
	}
	@FindBy(name="login")	
	private WebElement login;

	public WebElement getlogin() 
	{
		return login;
	}

}	
	