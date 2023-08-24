package synchronous;

public class ActionSecond {
	private byte[] b = new byte[1024 * 1024];
	private int a;
	private boolean turn = false;
	private boolean stop = false;
	public ActionSecond() {
		super();
	}
	
	public synchronized void setByte(byte[] b, int a) { // встановлення байтового масиву
		for(; turn == true;) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		for(int i = 0; i < b.length; i++) {
			this.b[i] = b[i];
		}
		this.a = a;
		turn = true;
		notifyAll();
	}
	
	public synchronized byte[] getByte() { // отримання байтового масиву
		for(; turn == false;) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		return b;
	}
	public synchronized int getReadByte() { // отримання кількості зчитаних байт
		for(; turn == false;) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		return a;
	}
	public synchronized void read() {
		for(; turn == false;) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		turn = false;
		notifyAll();
	}
	
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}