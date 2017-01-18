package DBS;
import java.util.Random;
//b)	N.A.
public abstract class Einheit implements Comparable<Einheit>{
	private Random r;	//fuer random inits
	protected boolean ranged;
	protected boolean armor;
	protected boolean poison;	//booleans, die angeben, ob ein Objekt ein bestimmtes Interface implementiert
	protected int life;
	protected int basedmg;
	protected int init;
	/**
	 * erstellt neue Einheit mit zufaelligem init, festem Leben und booleans fuer Sonder-Eigenschaften werden gesetzt
	 */
	public Einheit()
	{
		armor=(this instanceof SchwereRuestung);
		ranged=(this instanceof Fernkampf);
		poison=(this instanceof Gift);	//hier werden die Interfaces gecheckt
		r=new Random();
		init=r.nextInt(100);
		life=20;
		basedmg=2;
		if(ranged)basedmg+=2;
	}
	/**
	 * deafault Methode genutzt fuer Schaf
	 * @param target Einheit
	 * @return false
	 */
	public boolean kannAngreifen(Einheit target){return false;}
	/**
	 * Schadensberechnung fuer eine angegriffene Einheit
	 * @param dmgRec eingehender Schaden
	 * @throws SchafException falls Schaf attackiert wird, wird dies ausgegeben (ziemlich unnoetig ~.~)
	 */
	public void werdeAngegriffen(int dmgRec) throws SchafException	//damage received
	{
		//falls Ruestung getragen wird, wird dmg halbiert
		if(this.armor)
			{life-=dmgRec/2;return;}
		life-=dmgRec;
		//falls ein Krieger downgeht, dann wird dies ausgegeben, ¬N.A.
		if(!lebtNoch()&&this instanceof Krieger)System.out.println(this+" ist gefallen!");
	}
	/**
	 * gibt aus, ob eine Einheit noch Leben hat
	 * @return boolean, ob Einheit noch lebt
	 */
	public boolean lebtNoch()
	{
		return life>0;
	}
	/**
	 * ueberprueft, ob Ziel angegriffen werden kann und fuegt diesem dann Schaden zu
	 * @param target andere Einheit
	 */
	public void attackiere(Einheit target) 
	{
		if(!this.lebtNoch())return;
		if(this.kannAngreifen(target))
		{
			System.out.println(this.toString()+" greift "+target.toString()+" an.");
			if(this.poison)
				//ruft extra poison Methode auf, die flat dmg dealen soll
				target.poisoned(2);
			try
			{
				target.werdeAngegriffen(basedmg);
			}
			catch(SchafException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	/**
	 * dealt flat damage durch armor
	 * @param poisondmg variabler poison damage, der armor pen't
	 */
	//Aufgabenstellung wurde so verstanden, dass nur die 2 Giftschaden die armor penetrieren
	public void poisoned(int poisondmg)
	{
		this.life-=poisondmg;
	}
	public int compareTo(Einheit e)
	{
		if(this.init>e.init)return -1;
		if(this.init<e.init)return 1;
		return 0;
	}
	public abstract String toString();
	public int getInit()
	{
		return init;
	}
}
