package testng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

public class DateFormat {
public static void main(String[] args) throws ParseException {
	
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
  	 if(timeHH < 9) {   	  
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
 	 
	 }

    	 
}

 				 