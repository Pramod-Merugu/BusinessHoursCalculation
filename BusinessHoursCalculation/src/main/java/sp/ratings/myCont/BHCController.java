package sp.ratings.myCont;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BHCController {
	
	@RequestMapping("/AddBusinessHours")
	public String greeting(String StartDateTimeGMT, String country, String hours)  {
		
		
		return "It will return busienss start time"+StartDateTimeGMT+": after adding :"+ hours;
        
	}
	
	@RequestMapping("/gethours")
	public String gethoursnew(String StartDateTimeGMT, String country, String hours)  {
		
		
		return "gethours: It will return busienss start time"+StartDateTimeGMT+": after adding :"+ hours;
        
	}
	@RequestMapping("/AddBusinessHours")
	public String AddBusinessHours(String StartDateTimeGMT, String country, String hours)  {
		
		
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'HHmmss zzz");
        try {
			date=format.parse(StartDateTimeGMT);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        
        
		return "It will return busienss start time"+StartDateTimeGMT+": after adding :"+ hours +" hours: business end time will be "+ format.format(calendar.getTime());
	}

public static void main(String[] args)
{

	String StartDateTimeGMT ="20200110T083000 GMT";
	String country ="";
	String hours ="2";
	
	Date date = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss zzz");
    try {
		date=sdf.parse(StartDateTimeGMT);
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		System.out.println("It will return business start time"+StartDateTimeGMT+"::"+ hours);
		
	}
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    TimeZone timezone = TimeZone.getTimeZone("GMT");
    calendar.setTimeZone(timezone);
    calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
    System.out.println(timezone);
    System.out.println(calendar);
    sdf.setTimeZone(timezone);
    System.out.println(sdf.getTimeZone());
	System.out.println("It will return busienss start time"+StartDateTimeGMT+": after adding :"+ hours +" hours: business end time will be "+ sdf.format(calendar.getTime()));
}


}
