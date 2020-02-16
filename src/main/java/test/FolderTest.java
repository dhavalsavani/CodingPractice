package test;

import java.io.File;
import java.io.FileFilter;

import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.http.util.HTTPFileArg;

public class FolderTest {

	public static void main(String[] args) {
		
//		folderTest();
		test();
	}
	
	public static void test() {
		//Creating File object of image file
		File imageFile = new File("C:\\Users\\sadh8001\\Desktop\\IP\\images\\image1.jpg");

		//Creating Object to set upload file parameters
		String fileName = imageFile.getName();
		HTTPFileArg fileToUpload = new HTTPFileArg(imageFile.getPath(), "files", "image/" + fileName.substring(fileName.lastIndexOf(".") + 1));
		
		HTTPFileArg[] filesToUpload = {fileToUpload};

		//Setting File Upload object
		new HTTPSamplerProxy().setHTTPFiles(filesToUpload);
	}
	
	public static void test1() {
		File folder = new File("${imageFolderPath}"); 

		File[] files = folder.listFiles(new FileFilter() { 
		  public boolean accept(File file) {
		      return file.isFile(); 
		 }
		}); 
		if (files != null && files.length > 0) {
		  HTTPFileArg[] filesToUpload = new HTTPFileArg[files.length]; 

		  for (int i = 0; i < files.length; i++) {
		  	String fileName = files[i].getName();
		     HTTPFileArg fileToUpload = new HTTPFileArg(files[i].getPath(), "", "image/" + fileName.substring(fileName.lastIndexOf(".") + 1)); 
		     filesToUpload[i] = fileToUpload; 
		  }
		  new HTTPSamplerProxy().setHTTPFiles(filesToUpload); 
		}
	}
	
	public static void folderTest() {
		
		File folder = new File("C:\\Users\\sadh8001\\Desktop\\IP");
		String fileNames = "";

		File[] files = folder.listFiles(new FileFilter() { 
			public boolean accept(File file) {
				return file.isFile(); 
			}
		});
		
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			if(fileNames.equals(""))
				fileNames += fileName;
			else
				fileNames += ", " + fileName;
		    System.out.println(fileName.substring(fileName.lastIndexOf(".") + 1));
		  }
	}
}