package DBS;
//N.A.
public class Schaf extends Einheit{
	//hier, falls ein Schaf angreift, soll eine Exception geworfen werden, anstatt wenn eines angegriffen wird
	
	public void werdeAngegriffen(int dmgRec) throws SchafException
	{
		super.werdeAngegriffen(dmgRec);
		//falls ein Schaf downed, wird dies ausgegeben
		if(!lebtNoch())throw new SchafException ("Ein Schaf fiel den Horden zum Opfer!");
		//Standard-phrase, falls ein Schaf angegriffen wird
		else
			throw new SchafException("Ein Schaf versucht zu fliehen!");
		
	}
	public String toString()
	{
		return "Schaf("+this.life+")";
	}
}
