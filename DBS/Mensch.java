package DBS;

public class Mensch extends Einheit implements Krieger, SchwereRuestung, Fernkampf{

	public boolean kannAngreifen(Einheit target) 
	{
		if(target instanceof Goblin||target instanceof Ork||target instanceof Schaf)
			return true;
		return false;
	}
	public String toString()
	{
		return "Mensch("+this.life+")";
	}
}
