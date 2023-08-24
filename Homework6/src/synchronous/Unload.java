package synchronous;

public class Unload implements Runnable{
	private Dock dock;

	public Unload(Dock dock) {
		super();
		this.dock = dock;
	}
	public void unload() {
		Thread th = new Thread(this);
		th.start();
	}
	@Override
	public void run() {
		dock.unload();
	}
}