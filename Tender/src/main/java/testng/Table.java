package testng;

import org.apache.logging.log4j.*;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

public class Table {
	public static void main(String[] args) {
		org.apache.logging.log4j.Logger log = LogManager.getLogger("TenderItemRate");
		System.out.println("This is logger demo version");
		log.info("for info only"); 
		log.debug("for debug");
		log.error("error message");
		log.warn("warning message");
	}
	 
	
}