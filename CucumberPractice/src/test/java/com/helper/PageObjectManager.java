package com.helper;

import org.openqa.selenium.WebDriver;
import com.pom.Pomclass;

public class PageObjectManager {
	public static WebDriver driver3;
	private Pomclass pc;

	public PageObjectManager(WebDriver basedriver) {
		this.driver3 = basedriver;
	}
	public Pomclass getLp() {
		pc =  new Pomclass(driver3);
		return pc;
	}
//	public HomePage getHp() {
//	Hp = new HomePage (driver);
//	return Hp;
		
	}
	
