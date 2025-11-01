package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileUtils {
	
	public static Properties loadProprtyFile(String propertyFileName) throws IOException {
		
		Properties properties = new Properties();
		try {
			InputStream inputStream = 
					Thread.currentThread().getContextClassLoader().getSystemResourceAsStream(propertyFileName + ".properties");
			
			if(inputStream == null) {
				throw new IOException(propertyFileName + " File not found.");
			}
			
			properties.load(inputStream);
			return properties;
			
			
		} catch(Exception e) {
			throw new IOException("Problem occured while reaidng property file. " + e.getMessage());
		}
		
	}

}
