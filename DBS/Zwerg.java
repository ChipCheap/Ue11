package DBS;
//N.A.
public class Zwerg extends Einheit implements Krieger, SchwereRuestung, Fernkampf{

	public boolean kannAngreifen(Einheit target) 
	{
		if(target instanceof Ork||target instanceof Goblin||target instanceof Schaf)
			return true;
		return false;
	}
	public String toString()
	{
		return "Zwerg("+this.life+")";
	}
}
