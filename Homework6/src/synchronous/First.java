package synchronous;

public class First {

	public static void main(String[] args) {
		Dock d1 = new Dock();
		Dock d2 = new Dock();
		Unload ship1 = new Unload(d1);
		Unload ship2 = new Unload(d2);
		Unload ship3 = new Unload(d1);
		ship1.unload();
		ship2.unload();
		ship3.unload();
	}
}