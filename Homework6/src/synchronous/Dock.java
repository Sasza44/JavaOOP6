package synchronous;

public class Dock {
	private boolean isShip = false; // наявність корабля в доці

	public Dock() {
		super();
	}
	
	public synchronized void unload() {
		isShip = true;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		isShip = false;
		System.out.println("Your ship is unloaded");
	}
}