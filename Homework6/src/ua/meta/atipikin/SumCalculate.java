package ua.meta.atipikin;

public class SumCalculate implements Runnable{
	private int[] array;
	
	public SumCalculate(int[] array) {
		super();
		this.array = array;
	}

	private int sumCalculate(int[] array) {
		int s = 0;
		for(int i = 0; i < array.length; i += 1) {
			s += array[i];
		}
		return s;
	}

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		System.out.println(th.getName() + " = " + sumCalculate(array));
	}
}
