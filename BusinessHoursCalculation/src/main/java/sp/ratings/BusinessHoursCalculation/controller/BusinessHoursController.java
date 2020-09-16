package sp.ratings.BusinessHoursCalculation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessHoursController {
	
	@RequestMapping("/greeting")
	public String greeting(String StartDateTime, String country, String hours) {
		
		TimeZone timezone = TimeZone.getTimeZone("US");
		
		return "It will return business start time"+StartDateTime+"::"+ hours;
	}
	@RequestMapping("/AddBusinessHours")
	public String AddBusinessHours(String StartDateTimeGMT, String country, String hours)  {
		
		
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss zzz");
		TimeZone timezone = TimeZone.getTimeZone("GMT");
		sdf.setTimeZone(timezone);
        try {
			date=sdf.parse(StartDateTimeGMT);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "It will return business start time"+StartDateTimeGMT+"::"+ hours;
			
		}
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        
        
        
		return "It will return busienss start time"+StartDateTimeGMT+": after adding :"+ hours +" hours: business end time will be "+ sdf.format(calendar.getTime());
	}


}
