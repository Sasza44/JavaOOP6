package ua.meta.atipikin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fourth {

	public static void main(String[] args) {
		File source = new File("Source");
		File[] files = source.listFiles();
		int x1 = files.length / 2; // ділимо елементи масиву на 2 масиви (парні і непарні)
		int x2 = files.length % 2;
		File[] files1 = new File[x1 + x2]; // масив з непарних елементів
		File[] files2 = new File[x1]; // масив з парних елементів
		int j1 = 0;	int j2 = 0;
		for(int i = 0; i < files.length; i++) {
			if((i + 1) % 2 == 1) {
				files1[j1] = files[i]; // набираємо масив з непарних елементів
				j1 += 1;
			}
			else {
				files2[j2] = files[i]; // набираємо масив з парних елементів
				j2 += 1;
			}
		}	
		File receiver = new File("Receiver");
		receiver.mkdir();
		File[] files3 = new File[files1.length]; // копія масиву files1
		for(int i = 0; i < files1.length; i++) {
			files3[i] = new File("Receiver/" + files1[i].getName());
		}
		File[] files4 = new File[files2.length]; // копія масиву files2
		for(int i = 0; i < files2.length; i++) {
			files4[i] = new File("Receiver/" + files2[i].getName());
		}
		Thread th1 = new Thread(new FileCopy(files1, files3), "th1");
		Thread th2 = new Thread(new FileCopy(files2, files4), "th2");
		th1.start();
		th2.start();
	}
}