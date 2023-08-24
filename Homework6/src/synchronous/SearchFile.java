package synchronous;

import java.io.File;

public class SearchFile implements Runnable{
	private String fileName;
	private File search;
	
	public SearchFile(String fileName, File search) {
		super();
		this.fileName = fileName;
		this.search = search;
	}
	
	private void searchFile() {
		File[] files = search.listFiles();
		for(File f: files) {
			if(f.isFile() && f.getName().equals(fileName)) {
				System.out.println(f.getAbsolutePath());
			}
			else if(f.isDirectory()) {
				Thread thread = new Thread(new SearchFile(fileName, f));
				thread.start();
			}
		}
	}
	@Override
	public void run() {
		searchFile();
	}
}
