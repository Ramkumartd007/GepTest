package itemwise;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	public static Properties prop;
	public static void main(String[] args) throws IOException {
		
		prop = new Properties();
		InputStream input = new FileInputStream("src\\main\\java\\itemwise\\config.properties");
		prop.load(input);

String Browser = prop.getProperty("browser");
String Url = prop.getProperty("url");
String loginid = prop.getProperty("Loginid");
String password = prop.getProperty("password");

	}

}
