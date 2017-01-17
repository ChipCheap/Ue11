public class Quartett {
	private Musiker[] besetzung = new Musiker[4];
	public static int anzMusiker=0;
	
	public static void main(String[] args) {
		Quartett q = new Quartett();
		q.engagiere("Kroegi ;^)");
		q.engagiere("Heinz");
		q.engagiere("Gustav");
		q.engagiere("Balduin");
		q.engagiere("Nepumuk");
		q.engagiere("Ralf");
	}
	private void engagiere(String name) {
		try {
			Musiker m = Musiker.erstelleMusiker(name);
			System.out.println(m.name() + " spielt nun im Quartett!");
			//besetzt das Quartett tatsaechlich
			besetzung[anzMusiker]=m;
			//erhoeht die Anzahl an derzeitig existierenden Musikern
			anzMusiker++;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}