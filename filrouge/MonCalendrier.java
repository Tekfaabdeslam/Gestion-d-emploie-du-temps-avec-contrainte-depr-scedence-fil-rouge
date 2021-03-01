package filrouge;



import java.util.Calendar;
import java.util.GregorianCalendar;

public class MonCalendrier extends GregorianCalendar {

// constructeur de monCalendrier 
	public MonCalendrier(int year, int month, int day, int hour,
            int minute,int seconde){
		super(year,month,day,hour,minute,seconde);
	}
	
	
/* on utlise les méthodes
 * de la classe calendar pour recuperer 
 * les attributs de la date 
 * mais le get() c'est celui de la classse
 * gregorian calendar
 * 
 *  */
// getters & setters
	public int getYear(){
		return super.get(Calendar.YEAR);
	}
	
	
	
	public int getmonth(){
		return super.get(Calendar.MONTH);
	}
	
	
	public int getday(){
		return super.get(Calendar.DAY_OF_MONTH);
	}
	
	
	public int gethour(){
		return super.get(Calendar.HOUR_OF_DAY);
	}
	
	
	public int getminute(){
		return super.get(Calendar.MINUTE);
	}
	
	
	public int getseconde(){
		return super.get(Calendar.SECOND);
	}
	
	
	
	
	// redéfiniton de la methode toString
	@Override
	public String toString(){
		return "\nla date : le : "+this.getYear()+"/"+this.getmonth()+"/"+this.getday()+" a : "
	            +this.gethour()+":"+this.getminute()+":"+this.getseconde();
	}

	
}
