/**
 * Class: Configuration.java
 * 
 * @since 5/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/


package edu.cecar.componentes;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
	
	private static String path = "configuration/configuration.properties";
	private static Properties properties = new Properties();
	
	static {
		
		try {
			
			properties.load(new FileInputStream(path));
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static String getKeyWithName(String name) {
		
		return properties.getProperty(name);
		
	}

}
