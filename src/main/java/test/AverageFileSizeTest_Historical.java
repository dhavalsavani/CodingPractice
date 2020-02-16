package test;

import java.io.File;
import java.io.IOException;

public class AverageFileSizeTest_Historical {

	static int fileCount;
	static long totalFileSize;
	static long minSize;
	static long maxSize;

	public static void main(String[] args) {

		File folder = new File("C:\\Users\\sadh8001\\Desktop\\CiscoHistoricalDataValidationProcess\\Data");
//		File folder = new File("C:\\Users\\sadh8001\\Desktop\\AUTOMATION\\ipom\\AverageFileSize\\Change");
//		File folder = new File("C:\\Users\\sadh8001\\Desktop\\AUTOMATION\\ipom\\AverageFileSize\\Change\\01-04-2019\\20190401_010357_6224");

		try {
			getFileSize(folder, ".xml");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Total File Count: " + fileCount);
		System.out.println("Total File Size: " + totalFileSize);
		System.out.println("Average File Size: " + (totalFileSize/(fileCount * 1000)) + " KB");
		System.out.println("Min Size: " + minSize/1000 + " KB");
		System.out.println("Max Size: " + maxSize/1000 + " KB");

	}

	/**
	 * @param folder - File instance of folder in which files are stored whose size is to be calculated.
	 * @throws IOException 
	 */
	private static void getFileSize(File folder, String extension) throws IOException {
		File[] files = folder.listFiles();
		for (int i = 0; i < files.length; i++) {
			File currentFile = files[i];
			if(currentFile.isFile()) {
				if(currentFile.getName().trim().contains(extension) && currentFile.getCanonicalPath().contains("EtisalatCiscoVODXML")) {
					long fileSize = currentFile.length();
					fileCount++;
					totalFileSize += fileSize;
					if(fileCount == 1) {
						minSize = fileSize;
					}
					if(minSize > fileSize) {
						minSize = fileSize;
					}
					if(maxSize < fileSize) {
						maxSize = fileSize;
					}
				}
			} else {
				getFileSize(currentFile, extension);
			}
		}
	}
}