package DBS;

public class Ork extends Einheit implements Krieger, SchwereRuestung{

	Ork()
	{
		super();
	}
	public boolean kannAngreifen(Einheit target) 
	{
		if(target instanceof Mensch||target instanceof Zwerg||target instanceof Schaf)
			return true;
		return false;
	}
	public String toString()
	{
		return "Ork("+this.life+")";
	}
}
