package ua.meta.atipikin;

public class First {

	public static void main(String[] args) throws InterruptedException {
		Thread[] th = new Thread[100];
		for(int i = 0; i < th.length; i += 1) {
			th[i] = new Thread(new FactorialCalculate(i), "th " + i);
		}
		for(int i = 0; i < th.length; i += 1) {
			th[i].start();
		}
		
		System.out.println("Everything is already executed");
	}
}