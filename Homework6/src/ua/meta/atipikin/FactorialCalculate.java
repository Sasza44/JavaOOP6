package ua.meta.atipikin;

import java.math.BigInteger;

public class FactorialCalculate implements Runnable {
	private int number;

	public FactorialCalculate(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	private BigInteger factorialCalculate(int number) {
		BigInteger f = new BigInteger("1");
		for(int i = 2; i <= number; i += 1) {
			f = f.multiply(new BigInteger("" + i));
		}
		return f;
	}

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		System.out.println(th.getName() + " ! = " + factorialCalculate(this.number));
	}
}
