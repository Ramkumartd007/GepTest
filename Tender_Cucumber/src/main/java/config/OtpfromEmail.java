package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import javax.mail.Store;

import com.testing.framework.EmailUtils;

public class OtpfromEmail {
	public static void main(String[] args) throws IOException, IOException {
		EmailUtils emailUtils = new EmailUtils();
		
		Properties prop1 = new Properties();
		prop1.load(new FileInputStream("C:\\Users\\91991\\eclipse-workspace\\Tender\\src\\main\\java\\config\\config.properties"));
	//	Store connection=emailUtils.connectToGmail(prop1);
		}

}
