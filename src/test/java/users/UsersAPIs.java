package users;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import io.restassured.response.Response;
import utils.PropertiesFileUtils;
import utils.RestCallUtils;

public class UsersAPIs {
	
	static Properties baseUrls;
	static Properties basePaths;

	static {
		try {
			baseUrls = PropertiesFileUtils.loadProprtyFile("dev_baseUrls");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			basePaths = PropertiesFileUtils.loadProprtyFile("basePaths");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static Response getAllUsers() {
		return RestCallUtils.performGetCall(baseUrls.getProperty("restApi"), basePaths.getProperty("getObjects"));
	}
	
	
	public static Response getUsersUsingIDs(Map<String,Object> queryParms) {
		return RestCallUtils.performGetCall(baseUrls.getProperty("restApi"), basePaths.getProperty("getObjects"), queryParms);
	}
	


}
