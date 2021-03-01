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
public class PrecedenceConstraintWithGap extends PrecedenceConstraint {
	
	protected int gap;

	
	public PrecedenceConstraintWithGap (Activity a1,Activity a2,int gap) {
		super(a1,a2);
		this.gap=gap;
	}



    /* verifie si l'activité 1 + sa durée + un temps gap est avant l'activité 2
     * ou bien qu'elle se termine au moment ou la 2 commence */
	@Override
	public boolean isSatisfied(MonCalendrier date1,MonCalendrier date2) {
	 
		 // la durée de l'activité 1 en heure et minutes
	 
		int d2=this.gap;         
		int h2=this.gap/60;
		int m2=this.gap%60;
	  
		MonCalendrier DA2=new MonCalendrier(date1.getYear(),date1.getmonth(),date1.getday() //créer une instance de calendrier où on lui ajoute 
    		 ,date1.gethour()+h2,date1.getminute()+m2,date1.getseconde());
	 	    	  
	      
		return super.isSatisfied(DA2, date2);
	}


// redéfinition de la méthode toString 

   public String toString(){
	   return super.toString()+"\n NOTE:avec un GAP (durée entre 2 activitées) de : "+this.getGap()+" minute(s)";
   }




// getters & setters 

	public int getGap() {
		return gap;
	}


	public void setGap(int gap) {
		this.gap = gap;
	}




}
