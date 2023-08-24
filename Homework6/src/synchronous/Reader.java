package synchronous;

import java.io.File;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Reader implements Runnable {
	private ActionSecond act;

	public Reader(ActionSecond act) {
		super();
		this.act = act;
	}

	@Override
	public void run() {
		byte[] b = new byte[1024 * 1024]; // масив з байтів
		int a = 0; // кількість прочитаних байт
		File f1 = new File("11.pdf");
		try (FileInputStream in = new FileInputStream(f1)) {
			
			for(; (a = in.read(b)) > 0;) {
				act.setByte(b, a);
				System.out.println(in.available());
			}
			act.setStop(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}