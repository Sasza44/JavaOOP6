package ua.meta.atipikin;

public class Third {

	public static void main(String[] args) {
		int[] arr = {6, 5, 3, 2, 1, 7, 4};
		Thread th = new Thread(new SortArray(arr));
		th.start();
	}
}