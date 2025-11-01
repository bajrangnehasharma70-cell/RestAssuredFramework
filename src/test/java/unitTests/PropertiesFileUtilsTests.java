package unitTests;

import java.io.IOException;
import java.util.Properties;

import utils.PropertiesFileUtils;


public class PropertiesFileUtilsTests {
		
	public static void main(String[] args) throws IOException {
		Properties properties = PropertiesFileUtils.loadProprtyFile("dev_baseUrls");
		String value = properties.getProperty("restFullBooker");
		System.out.println(value);
	}

}
