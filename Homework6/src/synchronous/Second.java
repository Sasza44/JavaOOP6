package synchronous;

import java.io.*;

public class Second {

	public static void main(String[] args) {	
		ActionSecond act = new ActionSecond();
		Reader reader = new Reader(act);
		Writer writer = new Writer(act);
		Thread th1 = new Thread(reader);
		Thread th2 = new Thread(writer);
		th1.start();
		th2.start();
	}
}