
package filrouge;

import java.util.*;

public class Verifier {

	
	ArrayList<Constraint> ConstArray;

	public Verifier()
	{
		this.ConstArray = new ArrayList<Constraint>();
	}
   
	public void add(Constraint c){
		this.ConstArray.add(c);
	}
	// verifie si toutes les contrainte sont vérifiée dans un hashmap
	public boolean verify(HashMap<Activity, MonCalendrier> h) {
		boolean b = true;
		for (Constraint con : this.ConstArray){
			if (!con.isSatisfiedBySchedule(h)) b=false;
		}
		return b;
	}
}
