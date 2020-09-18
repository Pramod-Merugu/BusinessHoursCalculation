package sp.ratings.calender;

import java.util.ArrayList;
import java.util.List;

public class BusinessCalenders {

	List<BusinessCalender> businessCalenders;
	int year;
	
	BusinessCalenders(int year){
		businessCalenders = new ArrayList<BusinessCalender>();
		this.year = year;
	}
	
	public void addBusinessCalender(BusinessCalender businessCalender) {
		this.businessCalenders.add(businessCalender);
	}
}
