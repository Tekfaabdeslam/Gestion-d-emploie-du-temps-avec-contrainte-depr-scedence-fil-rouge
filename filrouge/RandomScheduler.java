package filrouge;

import java.util.*;

public class RandomScheduler {

	
	protected Set<Activity> activities;
	protected List<Constraint> constraints;
	protected Random randomGenerator;

	

//constructeur qui initialise la classe 
	public RandomScheduler() {
		this.activities = new HashSet<Activity>();
		this.constraints = new ArrayList<Constraint>();
		this.randomGenerator = new Random();
	}



	//ajouter une activité au Set
	
	public void add(Activity a) {
		this.activities.add(a);
	}
	
	
	//ajouter une contrainte à la list

	public void add(Constraint c) {
		this.constraints.add(c);
	}
	
	

    /* comme nous la conseiller notre prof nous avons déjà intialiser l'année le mois et le jour
     * on parcour le set d'activité et pour chaque activité on génère une heure,minute,seconde aleatoire
     * et on l'affecte dans une instance de Moncalendrier et l'inserer dans le map avec l'acitvité
     */
     
	public HashMap createMap(){
	HashMap<Activity, MonCalendrier> map = new HashMap<Activity, MonCalendrier>();
	int h,m,s;
	for(Activity act : activities)
	{
		h=this.randomGenerator.nextInt(24);
		m=this.randomGenerator.nextInt(60);
		s=this.randomGenerator.nextInt(60);
		MonCalendrier dateAct=new MonCalendrier(2019,4,2,h,m,s);
		
		map.put(act,dateAct); //insertion dans le Hashmap
	
	}
	return map;
	
	
	}
	
	

	// retourne le nombre de contraintes satisfaite 

	public int nbSatisfied(HashMap<Activity, MonCalendrier> map) {
		int i = 0;
		for (Constraint co : constraints) {
			
			if (co.isSatisfiedBySchedule(map)) {
				i++;
			}
		}
		return i;
	}
	
	
   /*on crées une  ArrayList de Hashmap
    * on creer plusieur emploie du temps avec creatmap
    * on retourne l'emploie du temps qui satisfait le max de contrainte 
    * grace à nbSatisfied 
   */
   public HashMap Nemploie(int n)
   {
     int i=0;
     ArrayList<HashMap<Activity,MonCalendrier>> listAl=new ArrayList<HashMap<Activity,MonCalendrier>>();
     while(i<n)
      {
		  listAl.add(createMap());
		  i++;
		 
	  }
     i=0;
     int max; 
     HashMap<Activity,MonCalendrier> edt;
     max=this.nbSatisfied(listAl.get(0));
		 edt=listAl.get(0);i++;
     while(i<n)
     {
		
		 if(max<this.nbSatisfied(listAl.get(i))) {
		    edt=listAl.get(i);
		    max=this.nbSatisfied(listAl.get(i));
		} else  {
		   i++;
		}
		 
		 i++;
		 
		 
	}
	if(i==0){
	  return null;}
						//pas d'emploie du temps dans le set
	return edt;
	}
	


}
