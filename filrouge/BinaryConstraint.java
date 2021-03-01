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

public abstract class BinaryConstraint implements Constraint {

	protected Activity a1,a2;
	 
	//constructeur avec parametre 
	public BinaryConstraint(Activity a1,Activity a2){
	this.a1=a1;
	this.a2=a2;

	}
	// constructeur par defaut
	public BinaryConstraint(){
	}
	
	//retourne initialement false 
	public boolean isSatisfied(MonCalendrier date1,MonCalendrier date2){
		return false;
	}
	
	//getters & setters 
	public Activity getA1(){
		return a1;
	}

	
	public void setA1(Activity a1) {
		this.a1 = a1;
	}

	public Activity getA2(){
		return a2;
	}

	public void setA2(Activity a2){
		this.a2 = a2;
	}

	@Override //redifinition de toString
	public String toString(){
		return "\n\n-la contrainte :"+this.a1.toString()+"\net "+this.a2.toString();
	}
	
	// verifie si 2 activité données sont contenue dans edt et si elles satisfaitent la contrainte
	public boolean isSatisfiedBySchedule(HashMap<Activity, MonCalendrier> h) {
		if (h.containsKey(a1) && h.containsKey(a2)) {
			return this.isSatisfied(h.get(a1), h.get(a2));
		}
		else {
			return false;
		}
	}

	
}
