
public class Musiker {
	private String name;
	/**
	 * erstellt neuen Musiker mit eingegebenem Namen
	 * @param newName Name, den der Musiker erhalten soll
	 * @throws Exception falls mehr als 4 Musiker existieren
	 */
	Musiker(String newName) throws Exception
	{
		if(Quartett.anzMusiker==4)
		{
			throw new Exception("Zu viele Musiker");
		}
		name=newName;
	}
	/**
	 * name-getter
	 * @return Name des M
	 */
	public String name()
	{
		return name;
	}
	/**
	 * ruft den Konstruktor auf und gibt den erstellten Musiker aus
	 * @param Name erstellt neuen Musiker mit dem Namen
	 * @return neuer Musiker aus
	 * @throws Exception falls 4 Musiker existieren
	 */
	public static Musiker erstelleMusiker(String Name) throws Exception
	{
		//in den Konstruktor exportiert worden
//		if(Quartett.anzMusiker==4)
//		{
//			Exception e =new Exception("Zu viele Musiker");
//			throw e;
//		}
		return new Musiker(Name);	 
	}
}
