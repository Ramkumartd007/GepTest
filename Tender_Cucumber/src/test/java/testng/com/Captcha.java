package testng.com;

import java.io.File;
import java.io.IOException;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Captcha {
	
public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

 
  ITesseract image = new Tesseract();
  String imagetest = image.doOCR(new File ("C:\\Users\\91991\\Pictures\\Screenshots\\Screenshot (16).png"));
  //String x= imagetest.replaceAll("[^a-z0-9A-Z :\r^]","");
  System.out.println(imagetest);
  
  	
}

}

