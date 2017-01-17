package DBS;
//N.A.
public class Goblin extends Einheit implements Krieger, Gift, Fernkampf{

	public Goblin()
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
		return "Goblin("+this.life+")";
	}
}
