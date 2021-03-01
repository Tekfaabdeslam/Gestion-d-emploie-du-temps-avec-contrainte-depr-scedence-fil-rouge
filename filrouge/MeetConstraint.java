/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filrouge;

/**
 *
 * @author 21913180
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class MeetConstraint extends BinaryConstraint {

	 
	//constructeur qui fait appelle au constructeur de la classe mère 
	public MeetConstraint(Activity a1,Activity a2){
	super(a1,a2);

	}
	
	
	@Override	// redéfinition de issatisfied où on verifie l'egalité entre l'activité 2 et l'activité 1+ sa durée 
	public boolean isSatisfied(MonCalendrier date1,MonCalendrier date2){
     int d =this.a1.getDur();
     int h=d/60;
     int m=d%60;
     MonCalendrier DA1=new MonCalendrier(date1.getYear(),date1.getmonth(),date1.getday() 
    		 ,date1.gethour()+h,date1.getminute()+m,date1.getseconde());
     if((DA1.getYear()==date2.getYear())&&(DA1.getmonth()==date2.getmonth())&&
     	((DA1.getday()==date2.getday()))&&(DA1.gethour()==date2.gethour())&&
     	(	DA1.getminute()==date2.getminute())&&((DA1.getseconde()==date2.getseconde()))){
     	return true;
     }
    	 
	return false;
     

	}


	//redéfinition de toString
	public String toString(){
		return super.toString()+"\n *MEET* NOTE :c'est des activités qui se suivent (pas d'intervalle vide) ";
	}

	
}
