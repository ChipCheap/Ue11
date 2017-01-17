package DBS;
import java.util.Random;
//b)
public abstract class Einheit implements Comparable<Einheit>{
	private Random r;
	protected boolean ranged;
	protected boolean armor;
	protected boolean poison;
	protected int life;
	protected int basedmg;
	protected int init;
	Einheit()
	{
		armor=(this instanceof SchwereRuestung);
		ranged=(this instanceof Fernkampf);
		poison=(this instanceof Gift);
		r=new Random();
		init=r.nextInt(100);
		life=20;
		basedmg=2;
		if(ranged)basedmg+=2;
	}
	public boolean kannAngreifen(Einheit target){return false;}
	public void werdeAngegriffen(int dmgRec)	//Received
	{
		if(this.armor)
			{life-=dmgRec/2;return;}
		life-=dmgRec;
		if(!lebtNoch())System.out.println(this+" ist gefallen!");
	}
	public boolean lebtNoch()
	{
		return life>0;
	}
	public void attackiere(Einheit target) throws SchafException
	{
		if(!this.lebtNoch())return;
//		if(target instanceof Schaf)throw new SchafException();
		if(this.kannAngreifen(target))
		{
			System.out.println(this.toString()+" greift "+target.toString()+" an.");
			if(this.poison)
				target.poisoned(2);
			target.werdeAngegriffen(basedmg);
		}
	}
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
