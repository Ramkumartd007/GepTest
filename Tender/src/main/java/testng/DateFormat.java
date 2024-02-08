package testng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.time.*;
import java.time.format.DateTimeFormatter; 
import org.openqa.selenium.By;

import groovyjarjarantlr4.v4.parse.ANTLRParser.exceptionGroup_return;

public class DateFormat {
public static void main(String[] args) throws ParseException {
	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY"); 
	/*
	 String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
	 String timeH= new SimpleDateFormat("HH").format(new Date());
	 String timem= new SimpleDateFormat("mm").format(new Date());
 	 Calendar cal = Calendar.getInstance();
 	 cal.add(Calendar.DATE, 1);
	 String DATE1 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());
	 cal.add(Calendar.DATE, 1);
	 String DATE2 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());
	 System.out.println(DATE2);
	 int timemr = ((((Integer.valueOf(timem)/10)+1)*10));
  	 int timemr5 = ((((Integer.valueOf(timem)/10)+1)*10)+20);
  	 String timer = String.valueOf(timemr);
  	 String timer15 = String.valueOf(timemr5);
	 int timeHH = Integer.valueOf(timeH);
	 int timemr123 = ((((Integer.valueOf(timem)/10)+1)*10));
	 System.out.println(timemr123);
	 String da = "01/11/2023";
	 String dateram= new SimpleDateFormat("dd/MM/YYYY").format(01/11/2023);
	 System.out.println(dateram);
	 String day = "01/01/2023";
	 
	 String dateramnew = new SimpleDateFormat("dd/MM/YYYY").format(01/11/2023);
	 System.out.println(dateram);
	
	 String datekumar = "12/04/2023"; 
	 Date datekum = new SimpleDateFormat("dd/MM/YYYY").parse(datekumar);
	 
	 cal.add(Calendar.DATE,-180);
	 String DATE1546 = new SimpleDateFormat("dd/MM/YYYY").format(cal.getTime());
	/* Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("25/11/2023");          
     System.out.println("date: "+date1);         
     Calendar c = Calendar.getInstance(); 
     c.setTime(date1); 
     c.add(Calendar.MONTH, -3);
     Date d = c.getTime();
     System.out.println("d: "+d);         
     SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
     String res = format.format(d);
     System.out.println("res: "+res);    
    String ped = "25/08/2023";
    System.out.println("Date received: "+ped);
     Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(ped);
     Calendar c = Calendar.getInstance(); 
     c.setTime(date1); 
     c.add(Calendar.MONTH, -3);
     Date d = c.getTime();
     SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
     String res = format.format(d);
     System.out.println("Date changed : "+res);   
    
	*/
	/*
	// String DATE1546 = new SimpleDateFormat("dd/MM/YYYY").format(Exp);	 
	 Date d12  = new Date(Exp); 
	 int year = d12.getYear()+1900;
	 int Month = d12.getDate();
	 int Date = d12.getMonth()+1;
	
	 String ExpDate;
	 String ExpMon;
	 System.out.println(Date+":"+Month+":"+year);
	 if(Integer.valueOf(Date).bitCount(Date)<2){ ExpDate = "0"+Date;}else {ExpDate = ""+Date;}
	 if(Integer.valueOf(Month).bitCount(Month)<2){ ExpMon = "0"+Month;}else {ExpMon = ""+Month;}
	 
	 System.out.println(ExpDate+"/"+ExpMon+"/"+year);
	 
	 //System.out.println(date +":"+d12.getDate() );
	// System.out.println(da-1);
	 
  	/* if(timeHH < 9) {   	  
   	 System.out.println( "timenow "+  timeH );
   	 System.out.println(date); System.out.println("09"); System.out.println("05"); System.out.println("20");
      	 System.out.println("belowe 9 ");}
 	 else if (timeHH >19) {    	    	
   	 System.out.println( "timenow "+  timeH );
    	 System.out.println(DATE1); System.out.println("09"); System.out.println("05"); System.out.println("20");
    	 System.out.println("Above 18 ");
    	 String timeHr = String.valueOf(timeHH+1);
    	 System.out.println(timeHr);
    	 }
 	 else {
   	 System.out.println( "timenow "+timeH+":"+timer);
   	 System.out.println(date);
   
   	 if(timemr <= 50 && timemr5 <= 60 ) {
   		 System.out.println("timemr <= 50 && timemr5 <= 60");
		 System.out.println(timeHH);
		 System.out.println(timemr); 
		 System.out.println(timemr5);
		 System.out.println(1);
  		 
  	 }
   	else if(timemr >= 60 && timemr5 >= 60 ) {
   		System.out.println("timemr >= 60 && timemr5 >= 60");
 		 System.out.println(timeHH+1);
 		 System.out.println(timemr-60); 
 		 System.out.println(timemr5-60);
 		System.out.println(2);
   		 
   	 }else if(timemr >= 50 && timemr5 >=60 ) {
   		System.out.println("timemr >= 50 && timemr5 >=60");
 		 System.out.println(timeHH+1);
 		 System.out.println(timemr-50); 
 		 System.out.println(timemr5-60);
 		System.out.println(3);
   		 
   	 }
   	 
   	
         }
 	 */
	String HELLO = "Hello World";
	int hel = HELLO.length();
	System.out.println(hel);
	String EMDexmpt= null;
	String EMD= null;
	String TFexmpt = null;
	String TF= null;
	String e_BG= null;
	for (int i = 1; i < 5; i++) {
		 // if (i % 11 == 2) continue;
		  //do stuff
		
try {
	
	if (i <= 8 || i >= 15 && i <= 18) {
		TF = "TF-Yes";
	} else if (i >= 9 && i <= 14) {
		TF = "TF-No";
	}

//Tender Fee Exemption				
	
	if (i <= 4 || i == 16 || i == 17) {
		TFexmpt = "TF Exempt-Yes";
	} else if (i >= 5 && i <= 15|| i == 18 ) {
		TFexmpt = "TF Exempt-No";
	}

//EMD Fee
	
	if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 11 || i == 12
			|| i == 13 || i == 14) {
		EMD = "EMD-Yes";
	} else if (i == 16 || i == 17 || i == 15 || i == 18 || i == 9 || i == 10) {
		EMD = "EMD-No";
	}

//EMD Fee Exemption	
	
	if (i == 1 || i == 2 || i == 5 || i == 6 || i == 11 || i == 12) {
		EMDexmpt = "EMD Exempt-Yes";
	} else if (i == 3 || i == 4 || i == 7 || i == 8 || i == 13 || i == 14 || i == 16 || i == 17 || i == 15
			|| i == 18 || i == 9 || i == 10) {
		EMDexmpt = "EMD Exempt-No";
	}

//e-BG 	
	
	if (i == 1 || i == 3 || i == 5 || i == 7 || i == 10 || i == 11 || i == 13 || i == 16 || i == 18) {
		e_BG = "BG-Yes";
	} else if (i == 2 || i == 4 || i == 6 || i == 8 || i == 9 || i == 12 || i == 14 || i == 15 || i == 17) {
		e_BG = "BG-No";
	}
System.out.println(i+ " : "+TF+ " -> "+TFexmpt+ " -> "+EMD+ " -> "+EMDexmpt+ " -> "+e_BG);

}catch (Exception e)
{
	System.out.println(e);}
	}
		  }
	}

    	 


 				 