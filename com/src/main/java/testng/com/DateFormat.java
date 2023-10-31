package testng.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
public static void main(String[] args) throws ParseException {
	 String date= new SimpleDateFormat("dd/MM/YYYY").format(new Date());
	 String timeH= new SimpleDateFormat("HH").format(new Date());
	//String timem= new SimpleDateFormat("mm").format(new Date());
	 String timem = "17";
	 Calendar cal = Calendar.getInstance();
    	cal.setTime(new SimpleDateFormat("mm").parse(timem));
    	 cal.add(Calendar.MINUTE, 5);
    	 String timem5 = new SimpleDateFormat("mm").format(cal.getTime());
    	 int timesm5 = (((Integer.valueOf(timem5)/10)+1)*10);
    	 System.out.println(date);
    	 System.out.println(timeH);
    	 System.out.println(timem);
    	 System.out.println(timem5);
    	 System.out.println(timesm5);

}
}
