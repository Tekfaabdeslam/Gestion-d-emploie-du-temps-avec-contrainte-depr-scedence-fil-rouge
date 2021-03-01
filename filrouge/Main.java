
package filrouge;

import java.util.*;


public class Main {

    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Activity a1=new Activity("bdd",56);
		Activity a2=new Activity("poo",30);
		Activity a3=new Activity("math",55);
		Activity a4=new Activity("anglais",90);
		
		
		PrecedenceConstraintWithGap g=new PrecedenceConstraintWithGap(a1,a2,25);
		PrecedenceConstraint g2 = new PrecedenceConstraint(a3,a4);
		MeetConstraint g3 = new MeetConstraint(a4, a2);
		
		RandomScheduler rs=new RandomScheduler();
        
         rs.activities.add(a1);
         rs.activities.add(a2);
         rs.activities.add(a3);
         rs.activities.add(a4);
        
		
		rs.constraints.add(g);
		rs.constraints.add(g2);
		rs.constraints.add(g3);
		
		
		HashMap<Activity, MonCalendrier> h =rs.createMap();
		System.out.println("le nombre de contraintes satistfaites createMap (premier Hashmap) est de " +rs.nbSatisfied(h));
		HashMap<Activity, MonCalendrier> h2 =rs.Nemploie(10);
		if(rs.nbSatisfied(h2)==0)
		{
			System.out.println("il n y a aucune contrainte satisfaite et donc aucun affichage à faire !!");
		}
		else
		{
			System.out.println("le nombre de contraintes maximale satistfaites  par un emploie du temps  est de :" +rs.nbSatisfied(h2));
			System.out.println("\n\n----------------affichage du hashmap-------------------\n\n"+h2);
		}
		
		
		System.out.println("___________________________________________");
		try{
			      //à copier si on utilise pas le makefile /*"filrouge/*/
			Reader R=new Reader("act.txt","constraint.txt");//coller dans le chemin
			System.out.println(R.getActivities());
			System.out.println("_______________________________________");
			String[] tab = {"cafe","bus"};
			System.out.println("\n______________le getprecendence constraint______________\n\n entre prendre un café et un bus \n "+R.getPrecedenceConstraint(tab)+"\n\n");
			System.out.println("\n_______________le read constraint_______________ \n\n"+R.readConstraint()+"\n\n");
		}
		catch (java.io.FileNotFoundException e)
		{
			System.err.println("une exception a ete lever le fichier est introuvable verifier votre chemin");
		}
		catch (java.io.IOException e)
		{
			System.err.println("une exception input output a ete lever ");
		}
		catch (java.lang.IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
    
}
