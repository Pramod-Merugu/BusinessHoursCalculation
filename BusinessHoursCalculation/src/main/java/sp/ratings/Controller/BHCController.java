package sp.ratings.Controller;

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


}
