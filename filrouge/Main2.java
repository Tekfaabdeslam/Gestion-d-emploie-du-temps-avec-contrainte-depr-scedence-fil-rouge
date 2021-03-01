/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filrouge;

import java.util.*;

/**
 *
 * @author 21913180
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Activity a1=new Activity("POO",30);
		Activity a2=new Activity("BDD",30);
		Activity a3=new Activity("ASD",30);
		Activity a4=new Activity("SYSTEM",20);
		Activity a5=new Activity("MATH",30); 
		
		MonCalendrier date1=new MonCalendrier(2019,1,13,10,00,00);
		MonCalendrier date2=new MonCalendrier(2019,1,13,10,40,00);
		MonCalendrier date3=new MonCalendrier(2019,1,13,11,00,00);
		MonCalendrier date4=new MonCalendrier(2019,1,13,11,30,00);
		MonCalendrier date5=new MonCalendrier(2019,1,13,11,50,00);
		
		HashMap<Activity, MonCalendrier> h = new HashMap<> ();
		
		h.put(a1, date1);
		h.put(a2, date2);
		h.put(a3, date3);
		h.put(a4, date4);
		h.put(a5, date5);
		
		System.out.println("---------------le hashmap d'activité----------------- \n"+h+"\n\n");
		PrecedenceConstraintWithGap g=new PrecedenceConstraintWithGap(a1,a2,10);
		PrecedenceConstraint g2 = new PrecedenceConstraint(a1,a4);
		MeetConstraint g3 = new MeetConstraint(a4, a5);
		
		

		if(g.isSatisfied(date1, date2))
			System.out.println("\n*resultat de teste correcte la contrainte g est satistfaite et l'activité 1 "
					+ " et commence avant la 2 avec un creux entre elles de "+g.gap);
		else
			System.out.println("\n*resultat de teste incorrecte la contrainte g avec un gap de : "+g.gap+" n'est pas satisfaite ");



		if(g2.isSatisfiedBySchedule(h)) {
			System.out.println("\n*resultat de teste correcte les 2 activité de la contrainte g2 est respecté ");
		}
		else{
			System.out.println("\n*resultat de teste incorrecte les 2 activité de la contrainte g2 n'est pas respecté ");
		}


		if(g3.isSatisfied(date4, date5)) {
			System.out.println("\n*resultat correcte l'acticité 4 se termine au moment où la 5 commence c'est à dire : "+date5.toString()+"\n");
		}
		else{
			System.out.println("\n*resultat de teste incorrecte normalment l'activité  4 se termine au moment où 5 commence \n");
		}
		
		
		

	
		ArrayList<Activity> alTest = new ArrayList<Activity>();
		alTest.add(a1); //ajout des activités dans l'arraylist
		alTest.add(a2);
		alTest.add(a3);
		alTest.add(a4);
		alTest.add(a5);
		MaxSpanConstraint ms=new MaxSpanConstraint(alTest,141);
		if (ms.isSatisfiedBySchedule(h)) {
			System.out.println("\n*resultat correcte le test du max span c'est correctement derouler les activité de l'ArrayList ne depassent pas : "+ms.span +"minutes");
		}
		else{
			System.out.println("\n*resultat de teste incorrecte le max span n'est pas respecter par les activités de l'ArrayList !!!"+ms.span +"minutes");
		}
		
		Verifier v = new Verifier();
		v.add(ms);
		v.add(g2);
		v.add(g3);
		if (v.verify(h)) {
			System.out.println("\n*resultat correcte  toutes contraintes  contenue dans l'ArayList sont respécté dans notre hashmap :\n"+v.ConstArray);
		}
		else{
			System.out.println("\n*resultat de teste incorrecte un problème au survenue avec votre verifier ");
		}
		
		System.out.println("\n\n\t------main end-------" );
	
		}
		
		
		
    
}
