package ua.meta.atipikin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy implements Runnable {
	private File[] in;
	private File[] out;

	public FileCopy(File[] in, File[] out) {
		super();
		this.in = in;
		this.out = out;
	}
	
	private void fileCopy(File[] in, File[] out) throws IOException {
		byte[] buffer = new byte[3 * 1024 * 1024];
		int readByte = 0;
		for(int i = 0; i < in.length; i++) {
			try (FileInputStream fis = new FileInputStream(in[i]);
					FileOutputStream fos = new FileOutputStream(out[i])) {
				
				readByte = fis.read(buffer);
				fos.write(buffer, 0, readByte);
				
			} catch(IOException e) {
				throw e;
			}
		}
	}

	@Override
	public void run() {
		try {
			fileCopy(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
