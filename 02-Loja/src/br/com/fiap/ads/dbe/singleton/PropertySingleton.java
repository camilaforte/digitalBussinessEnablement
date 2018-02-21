package br.com.fiap.ads.dbe.singleton;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	private static Properties prop;
	
	public static Properties getInstance() {
		if(prop == null) {
			prop= new Properties();
			try {
				prop.load(PropertySingleton.class.getResourceAsStream("/propriedade.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return prop;
	}
	
	private PropertySingleton() {
		
	}
}
