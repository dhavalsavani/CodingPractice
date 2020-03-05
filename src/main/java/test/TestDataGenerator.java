package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataGenerator {

	public static void main(String[] args) {
		
		try {
			File file = new File("src/main/resources/training.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
				int n = 0;
				while(n < 100000) {
					fileOutputStream.write("10000 ".getBytes());
					n++;
				}
				fileOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}