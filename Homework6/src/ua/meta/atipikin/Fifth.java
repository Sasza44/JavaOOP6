package ua.meta.atipikin;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Fifth {

	public static void main(String[] args) {
		File directory = new File("Receiver");
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleAtFixedRate(new CheckFolder(directory), 0, 1, TimeUnit.SECONDS);
	}
}