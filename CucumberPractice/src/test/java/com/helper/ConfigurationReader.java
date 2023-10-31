package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	Properties p;
	public ConfigurationReader() throws IOException {
		File f = new File("src\\test\\java\\com\\helper\\browser.property");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
	}
	
	public String getBrowser() {
		String browser = p.getProperty("Browser");
		return browser;
		}
    public String getAddress(){
    	String address = p.getProperty("Url");
		return address;
    	
    }

}
