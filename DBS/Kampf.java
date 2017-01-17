package DBS;

import java.util.Arrays;
import java.util.Random;

public class Kampf {
	
	private int laenge = 10;
	private Einheit[] einheiten;
	public static int counter=0;	//sieht

	public static void main(String[] args){
		Kampf kampf = new Kampf(10);
		System.out.println("Kampfaufstellung: ");
		System.out.println(kampf);
		System.out.println("\nDer Kampf beginnt!");
		if(kampf.allesSchafe())
			System.out.println("Ausnahmsweise gewinnen die Schafe mangels anderer Interessenten!\n\n");
		else {
			Einheit gewinner = kampf.kaempfen();
			System.out.println(gewinner + " beendet das Gefecht mit einem letzten beherzten Schlag!\n\n");
			System.out.println("Verbleibende Kaempfer: ");
			System.out.println(kampf);
		}
	}
	
	public Kampf(int laenge){
		this.laenge = laenge;
		einheiten = new Einheit[laenge];
		
		Random random = new Random();
		for(int i = 0; i < laenge; i++){			//Array mit Einheiten initialisieren			
			switch(random.nextInt(5)){
				case 1: einheiten[i] = new Mensch(); break;
				case 2: einheiten[i] = new Zwerg(); break;
				case 3: einheiten[i] = new Ork(); break;
				case 4: einheiten[i] = new Goblin(); break;
				default: einheiten[i] = new Schaf(); break;
			}
		}
		Arrays.sort(einheiten);
	}
	
	public boolean allesSchafe() {
		for(int i = 0; i < laenge; i++){
			if(!(einheiten[i] instanceof Schaf))
				return false;
		}
		return true;
	}
	
	public String toString() {
		String str = "";
		str += "-----------------\n";
		for(int i = 0; i < laenge; i++){
			if(einheiten[i].lebtNoch())
				str += einheiten[i] +
//				" "+Integer.toString(einheiten[i].getInit())+	fuer bessere Erkennung einer Einheit init bei toString hinzufuegen oder hier
				"\n";
		}
		str += "-----------------";
		return str;
	}
//a)	N.A.
	/**
	 * gibt die naechste  anzugreifende Einheit aus
	 * @param angreiferPosition	die Einheit, die nun angreifen soll
	 * @return anzugreifende Einheit
	 */
	private Einheit findeNaechstesZiel(int angreiferPosition) {
		if(einheiten[angreiferPosition] instanceof Schaf)return null;
		for(int i=angreiferPosition+1;i!=angreiferPosition;++i)
		{
			if(i>=laenge)i=0;
			//beugt vor allem vor Fehlern bei besonders kleinen Anzahlen an Kaempfern vor
			counter++;		//emergency brake; falls zu lange nichts passiert, ist der Kampf vorbei, bei sehr vielen Angreifern fuehrt dies zu bugs, wenn 1000 nicht erhoeht wird
			if(counter>1000)
			{
				break;
			}
			if(einheiten[angreiferPosition].kannAngreifen(einheiten[i])&&einheiten[i].lebtNoch())
			{
				return einheiten[i];
			}
		}
		return einheiten[angreiferPosition];
	}
	
	// simuliert den gesamten Kampf und endet erst, wenn eine Fraktion gewonnen hat. 
	// Die Rückgabe ist die siegreiche Einheit, die den letzten Schlag vollführt hat.
	public Einheit kaempfen() {

		int angreiferPosition = 0;
		
		while(true) {
			Einheit angreifer = einheiten[angreiferPosition];
			if(angreifer instanceof Krieger && angreifer.lebtNoch()){
				Einheit ziel = findeNaechstesZiel(angreiferPosition);

				if(ziel == angreifer) // in diesem Fall wurde kein gueltiges Ziel gefunden => Kampfende
					return angreifer;
				if(ziel != null)
						angreifer.attackiere(ziel);
			}
			angreiferPosition++;
			if(angreiferPosition >= laenge)
				angreiferPosition = 0;
			
		}
	}
}