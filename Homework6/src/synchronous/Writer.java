package synchronous;

import java.io.FileOutputStream;
import java.io.*;
import java.io.IOException;

public class Writer implements Runnable {
	private ActionSecond act;
	
	public Writer(ActionSecond act) {
		super();
		this.act = act;
	}

	@Override
	public void run() {
		File f2 = new File("12.pdf");
		
		try (FileOutputStream out = new FileOutputStream(f2)) {
			for(; !act.isStop();) {
				byte[] b = act.getByte();
				int a = act.getReadByte();
				out.write(b, 0, a);
				System.out.println("bebebebebebe");
				act.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}