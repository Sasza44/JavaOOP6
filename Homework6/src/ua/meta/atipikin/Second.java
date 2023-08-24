package ua.meta.atipikin;

public class Second {

	public static void main(String[] args) {
		int[] arr1 = {47, 395, 6, 87, 794, 433, 9, 39, 184}; // масив, сума якого буде обчислюватись в першому потоці
		int[] arr2 = {96, 4, 324, 497, 275, 57}; // масив, сума якого буде обчислюватись у другому потоці
		int[] arr = new int[arr1.length + arr2.length]; // масив, який містить усі елементи двох попередніх та сума якого буде обчислюватись в головному потоці
		for(int i = 0; i < arr.length; i++) {
			if(i < arr1.length) {
				arr[i] = arr1[i];
			}
			else {
				arr[i] = arr2[i - arr1.length];
			}
		}
		Thread th1 = new Thread(new SumCalculate(arr1), "Sum1");
		Thread th2 = new Thread(new SumCalculate(arr2), "Sum2");
		th1.start();
		th2.start();
		System.out.println(Thread.currentThread().getName() + " = " + sumCalc(arr)); // швидше обчислюється сума в головному потоці
	}
	
	public static int sumCalc(int[] arr) {
		int s = 0;
		for(int i = 0; i < arr.length; i++) {
			s += arr[i];
		}
		return s;
	}
}