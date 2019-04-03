package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class LoadResourceFromJar {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		try {
//			properties.load(new FileInputStream(new File("src/main/resources/config/config.properties")));
//			InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config/config.properties");
//			InputStream inputStream = ClassLoader.getSystemResourceAsStream("config/config.properties");
			
//			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//			properties.load(classLoader.getResourceAsStream("/config/config.properties"));
			properties.load(new FileInputStream(new File(new LoadResourceFromJar().getClass().getClassLoader().getResource("/config/config.properties").toURI())));
			System.out.println(properties.getProperty("name"));
			Thread.sleep(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
