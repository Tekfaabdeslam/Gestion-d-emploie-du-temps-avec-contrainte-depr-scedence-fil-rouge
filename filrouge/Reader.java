package filrouge;
import java.util.*;
import scheduleio.ActivityReader;
import scheduleio.ActivityDescription;
import scheduleio.ConstraintDescription;
import scheduleio.ConstraintReader;

public class Reader{
		
		protected Map <String,Activity> hashAct;
		protected String fich1,fich2;
		
		/*on associe les noms de fichier au reader
		 * ensuite on utilise read all de activity reader
		 * et on transforme activity description en activity
		 * pour pouvoir retourner un hash map <string,activity>
		 * et non pas <string,acitvitydescription>
		 * 
		 * */
	public Reader(String fich1,String fich2)throws java.io.FileNotFoundException, java.io.IOException {
		this.fich1=fich1;
		this.fich2=fich2;
		ActivityReader aR=new ActivityReader(fich1);
		Map <String,ActivityDescription> hashFile;
		hashFile=aR.readAll();
		this.hashAct = new HashMap<String, Activity>();
		for (String key : hashFile.keySet()){
			Activity act = new Activity(hashFile.get(key).getName(), hashFile.get(key).getDuration());
			this.hashAct.put(key, act);
		}
		
		
		
	}
		//getter des activity on affiche les valeur du hashmap 
		public Collection<Activity> getActivities(){
			return this.hashAct.values();
		}
		
		
		/* les get precedences permettent de creer un objet contrainte avec min 2 arguments en entrée
		 */
		public PrecedenceConstraint getPrecedenceConstraint(String [] arguments) throws java.lang.IllegalArgumentException {
			if (arguments.length > 2 || arguments.length < 2) {
				throw new java.lang.IllegalArgumentException("EXCEPTION !! taille pour les arguments de getPrecendenceConstraint non respecté ");
			}
			if (!hashAct.containsKey(arguments[0]) || !hashAct.containsKey(arguments[1])) {
				throw new java.lang.IllegalArgumentException("EXCEPTION !! id des arguments non contenue dans le hashmap");
			}
			 Activity activity1 = hashAct.get(arguments[0]);
			 Activity activity2 = hashAct.get(arguments[1]);
			 PrecedenceConstraint PConstr = new PrecedenceConstraint(activity1, activity2);
			 return PConstr;
		}
		


		public PrecedenceConstraintWithGap getPrecedenceConstraintWithGap(String [] arguments) throws java.lang.IllegalArgumentException {
			if (arguments.length > 3 || arguments.length < 3) {
				throw new java.lang.IllegalArgumentException("EXCEPTION !! taille pour les arguments de getPrecendenceConstraint non respecté");
			}
			if (!hashAct.containsKey(arguments[1]) || !hashAct.containsKey(arguments[2])) {
				throw new java.lang.IllegalArgumentException("EXCEPTION !! id des arguments non contenue dans le hashmap");
			}
			 Activity activity1 = hashAct.get(arguments[1]);
			 Activity activity2 = hashAct.get(arguments[2]);
			 int gap = Integer.parseInt(arguments[0]);
			 PrecedenceConstraintWithGap PConstrWG = new PrecedenceConstraintWithGap(activity1, activity2, gap);
			 return PConstrWG;
		}



		


		public MeetConstraint getMeetConstraint(String [] arguments) throws java.lang.IllegalArgumentException {
			if (arguments.length > 2 || arguments.length < 2) {
				throw new java.lang.IllegalArgumentException("EXCEPTION !! taille pour les arguments de getPrecendenceConstraint non respecté");
			}
			if (!hashAct.containsKey(arguments[0]) || !hashAct.containsKey(arguments[1])) {
				throw new java.lang.IllegalArgumentException("EXCEPTION !! id des arguments non contenue dans le hashmap");
			}
			 Activity activity1 = hashAct.get(arguments[0]);
			 Activity activity2 = hashAct.get(arguments[1]);
			 MeetConstraint MConstr = new MeetConstraint(activity1, activity2);
			 return MConstr;
		}
		
		



		public MaxSpanConstraint getMaxSpanConstraint(String [] arguments) throws java.lang.IllegalArgumentException {
			if (arguments.length < 3) {
				throw new java.lang.IllegalArgumentException("EXCEPTION !! taille pour les arguments de getPrecendenceConstraint non respecté");
			}
			if (!hashAct.containsKey(arguments[1]) || !hashAct.containsKey(arguments[2])) {
				throw new java.lang.IllegalArgumentException("EXCEPTION !! id des arguments non contenue dans le hashmap");
			}
			int span = Integer.parseInt(arguments[0]);
			ArrayList<Activity> al = new ArrayList<Activity>();
			for (int i = 1; i < hashAct.size(); i++) {
				Activity act = hashAct.get(arguments[i]);
				al.add(act);
			}
			 MaxSpanConstraint MSConstr = new MaxSpanConstraint(al, span);
			 return MSConstr;
		}
		
		

/*on crée une Array liste de contrainte suivant le type de la contrainte et pour chaque type on appelle sa propre méthode getPrecendence ...*/


		public ArrayList<Constraint> readConstraint() throws java.io.FileNotFoundException, java.io.IOException{
			ConstraintReader dR=new ConstraintReader(this.fich2);
			List<ConstraintDescription> File2 = dR.readAll();
			ArrayList<Constraint> constr = new ArrayList<Constraint>();
			for (ConstraintDescription cd : File2) {
				if (cd.getKeyword().equals("PRECEDENCE")) {
					PrecedenceConstraint p = this.getPrecedenceConstraint(cd.getArguments());
					constr.add(p);
				}
				if (cd.getKeyword().equals("PRECEDENCE_GAP")) {
					PrecedenceConstraintWithGap p = this.getPrecedenceConstraintWithGap(cd.getArguments());
					constr.add(p);
				}
				if (cd.getKeyword().equals("MEET")) {
					MeetConstraint p = this.getMeetConstraint(cd.getArguments());
					constr.add(p);
				}
				if (cd.getKeyword().equals("MAX_SPAN")) {
					MaxSpanConstraint p = this.getMaxSpanConstraint(cd.getArguments());
					constr.add(p);
				}
			}
			return constr;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
