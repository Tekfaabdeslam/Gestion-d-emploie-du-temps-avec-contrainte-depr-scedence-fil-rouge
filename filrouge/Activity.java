
package filrouge;

public class Activity{

	
	private String nomAct;
	private int Dur;

	
	public Activity(String nomAct,int Dur){
	this.nomAct=nomAct;
	this.Dur=Dur;
	}
   
    public Activity(){     //constructeur par defaut 
	}						
	
	@Override 
	public 	String toString(){				//redifinition de la méthode toString pour la classe acitvity
		return "\ndescription de l'activite :\n*"+this.nomAct+" elle dure : "+this.Dur+" minute(s) ";		
	}

	// definition des accesseurs get&set
	public String getNomAct(){
		return nomAct;
	}


	public void setNomAct(String nomAct) {
		this.nomAct = nomAct;
	}


	public int getDur(){
		return Dur;
	}


	public void setDur(int dur) {
		Dur = dur;
	}

    
}
