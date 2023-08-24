package ua.meta.atipikin;

import java.util.Arrays;

public class SortArray implements Runnable {
	private int[] array;

	public SortArray(int[] array) {
		super();
		this.array = array;
	}
	
	private int[] sortArray(int[] array) { // сортування елементів масиву методом Шелла
		int d = array.length / 2;
		while(d > 0) {
			for(int i = 0; (i + d) < array.length; i++) {
				if(array[i] > array[i + d]) {
					int x = array[i];
					array[i] = array[i + d];
					array[i + d] = x;
				}
			}
			d = d / 2;
		}
		return array;
	}

	@Override
	public void run() {
		System.out.println(Arrays.toString(sortArray(array)));
		
	}
}
