
package filrouge;

import java.util.*;

public class MaxSpanConstraint implements Constraint  {

	protected ArrayList<Activity> al;
	protected int span;

	public MaxSpanConstraint(ArrayList<Activity> al, int span) {
		this.al = al;
		this.span = span;
	}
	
	
	/* recuperer la premières activité de notre arrayList
	 *recupererr la dernières
	 * ajouter à la dernière sa propre durée apres avoir recuperer sa date
	 * ajouter le span à la date de la premiere activité
	 * comparer avec after si l'activité 1 + span ne depasse pas la dernière + sa durée
	 */
	@Override
	public boolean isSatisfiedBySchedule(HashMap<Activity, MonCalendrier> h) {
		
		Activity debut,fin;
		debut = this.al.get(0);
		fin = debut; 
		for (Activity act : this.al){
			if (h.containsKey(act) && h.get(act).before(h.get(debut))) {  
				debut = act;											
			}
		}
		
		MonCalendrier actDate = new MonCalendrier(h.get(debut).getYear(), h.get(debut).getmonth(),
		h.get(debut).getday(),h.get(debut).gethour(),h.get(debut).getminute(),h.get(debut).getseconde());
		
		for (Activity act : this.al){
		if (h.containsKey(act) && h.get(act).after(h.get(fin))) {
				fin = act;
			}
		}
			
		int hFin = fin.getDur()/60;
		int mFin = fin.getDur()%60;
		
		MonCalendrier finalDate = new MonCalendrier(h.get(fin).getYear(), h.get(fin).getmonth(),
		h.get(fin).getday(),h.get(fin).gethour()+hFin,h.get(fin).getminute()+mFin,h.get(fin).getseconde());
			
			
			
			
			
			
		int hSpan = this.span/60;
		int mSpan = this.span%60;
		 //span date c'est la première activité + le span 
		MonCalendrier spanDate = new MonCalendrier(h.get(debut).getYear(), h.get(debut).getmonth(), 
		h.get(debut).getday(),h.get(debut).gethour()+hSpan,h.get(debut).getminute()+mSpan,h.get(debut).getseconde());
		
		return spanDate.after(finalDate);	
		
	}
	
	//redifinition de la méthode toString 
    
    public String toString (){
		return "\n-la contrainte:\n"+this.al+"\nNOTE : avec un span de : "+this.span+" minutes \n";
	}



}
