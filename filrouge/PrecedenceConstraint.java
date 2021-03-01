package filrouge;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class PrecedenceConstraint extends BinaryConstraint {

	 

	public PrecedenceConstraint(Activity a1,Activity a2){
		super(a1,a2);
	}
	


/*verfie si l'activité respecte la contrainte 
 * c-à-d que l'activité 1+ sa duré est soit egaleou bien 
 * avant l'activité 2
 */
	@Override
	public boolean isSatisfied(MonCalendrier date1,MonCalendrier date2){
     int d =this.a1.getDur();
     int h=d/60;
     int m=d%60;
     MonCalendrier DA1=new MonCalendrier(date1.getYear(),date1.getmonth(),date1.getday() 
    		 ,date1.gethour()+h,date1.getminute()+m,date1.getseconde());
     if(DA1.equals(date2)){
    	 return true;}
     else{
			 if(DA1.before(date2))
    		 return true;
    	}
    
     
     return false;
     
     }



}
