package testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.jexl2.internal.AbstractExecutor.Set;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import org.apache.logging.log4j.*;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Testexcel extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args)
			throws InterruptedException, AWTException, IOException, TesseractException, ParseException, WebDriverException {
		String date = new SimpleDateFormat("dd/MM/YYYY").format(new Date());
		String timeH = new SimpleDateFormat("HH").format(new Date());
		String timem = new SimpleDateFormat("mm").format(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String DATE1 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());
		cal.add(Calendar.DATE, 10);
		String DATE2 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());

		int timeHH = Integer.valueOf(timeH);
		int timemr = ((((Integer.valueOf(timem) / 10) + 1) * 10));
		int timemr5 = ((((Integer.valueOf(timem) / 10) + 1) * 10) + 20);

		String timeH1 = String.valueOf(timeHH + 1);
		String timer = String.valueOf(timemr);
		String timer15 = String.valueOf(timemr5);
		String timer50 = String.valueOf(timemr - 50);
		String timer60 = String.valueOf(timemr - 60);
		String timer560 = String.valueOf(timemr5 - 60);

		// String Title = "Ver.20/ATP/Works/TypeofCor/AOC";
		// String Title = " Ver.20/ITE/SF/CD/eAgre/LOA/AOC";

		// String Title = "Ver.20/Status/bidder/Dept/Home";

		String tenderType = "Open Tender";
		String formContract = "Supply";
		String noOfPackets = "2";
		String tenderCategory = "Goods";
		String bidOpenerType = "1";

		String EMD = null;
		String TFexmpt = null;
		String EMDexmpt = null;
		String TF = null;
		String e_BG = null;
		String Tenderid = null;
		//String BasicId = null;
		String BasicId = "2023_NIC_10085";

		Xls_Reader reader = new Xls_Reader("D:\\Test_Scenario_Excel\\eBG_Scenario.xls");
		
		
		String sheetName = "Test_Cases";
		String TenderFee;
		String Case;
	/*	String TenderFeewithEX;
		String ProcessingFee;
		String EMDFee;
		String EMDFeewithEX;
		String BG;
		String eBG;
		String MDP0;
		String BGmdp;
		String EBGmdp;
		String Case;*/
		
		for (int i = 2; i < 91; i++) {
			
			
			/*TenderFee = reader.getCellData(sheetName,"Tender Fee", i);
			TenderFeewithEX = reader.getCellData(sheetName,"Tender FEE Exempt", i);
			ProcessingFee = reader.getCellData(sheetName,"Processing FEE", i);
			EMDFee = reader.getCellData(sheetName,"EMD FEE", i);
			EMDFeewithEX = reader.getCellData(sheetName,"EMD FEE Exempt", i);
			BG = reader.getCellData(sheetName,"BG", i);
			eBG = reader.getCellData(sheetName,"E-BG", i);
			MDP0 = reader.getCellData(sheetName,"MDP", i);
			BGmdp = reader.getCellData(sheetName,"BG", i);
			EBGmdp = reader.getCellData(sheetName,"E-BG", i);*/
			Case = reader.getCellData(sheetName, "Case", i);
		//	System.out.println(i +" : "+ TenderFee);
			System.out.println(i +" : "+ Case);
		//	System.out.println(i);
			
			//System.out.println(" sl: "+i+"  "+TenderFee+" : "+TenderFeewithEX+" : "+EMDFee+" : "+EMDFeewithEX+" : "+EBGmdp+" : "+BGmdp+" : "+MDP0);
		}
		}
}