package ua.meta.atipikin;

import java.io.File;

public class CheckFolder implements Runnable {
	private File directory;
	private int a = 4; // початкова кількість файлів в папці

	public CheckFolder(File directory) {
		super();
		this.directory = directory;
	}
	
	private void checkFolder(File directory) {
		File[] f = directory.listFiles();
		if(f.length > a) {
			System.out.println("A file is added to the directory");
		}
		else if(f.length < a) {
			System.out.println("A file is deleted from the directory");
		}
		a = f.length;
	}

	@Override
	public void run() {
		checkFolder(directory);
	}
}
