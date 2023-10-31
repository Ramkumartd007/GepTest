package org.com;

public class Demo2 extends BaseClass {

	public static void main(String[] args)  {

    getDriver("Chrome");
    getUrl("https://www.facebook.com/");
    Demo d = new Demo(driver);
	d.getUsername().sendKeys("ramkumar");
	d.getPassword().sendKeys("12345");
	d.getlogin().click();	  	
	    
	    
	}
}
