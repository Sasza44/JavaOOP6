package synchronous;

import java.io.File;

public class Third {

	public static void main(String[] args) {
//		String fileName = "Project1.HEX";
		String fileName1 = "current.svg";
		File search = new File("d:/Games/");
		Thread th = new Thread(new SearchFile(fileName1, search));
		th.start();
	}
}