package DBS;

public class Schaf extends Einheit{
	public void attackiere(Einheit e) throws SchafException
	{
		throw new SchafException();
	}
	public void werdeAngegriffen(int dmgRec)
	{
		life-=dmgRec;
		if(!lebtNoch()){System.out.println("Ein Schaf fiel den Horden zum Opfer!");return;}
		System.out.println("Ein Schaf versucht zu fliehen!");
	}
	public String toString()
	{
		return "Schaf("+this.life+")";
	}
}
