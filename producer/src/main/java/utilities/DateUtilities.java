package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities {
	
	public static final String DATE_FORMAT = "dd.MM.yyyy hh:mm:ss";
	
	public static Date currentTime(){
		return new Date();
	}
	
	public static String currentTimeString(){
		Date date = currentTime();
        SimpleDateFormat dt1 = new SimpleDateFormat(DATE_FORMAT);
        return dt1.format(date);
	}
}
