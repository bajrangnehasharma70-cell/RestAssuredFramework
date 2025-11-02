package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseValidationUtils {
	
	public static int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	
	public static long getResponseTime(Response response) {
		return response.getTime();
	}
	
	public static void isResponseTimeLessThan(Response response, long expectedResponseTime) {
		response.then().time(Matchers.lessThanOrEqualTo(expectedResponseTime));
	}
	
	
	public static Object getValueFromResponseUsingJsonPath(Response response, String jsonPath) {
		return response.jsonPath().get(jsonPath);
	}
	
	
	public static Map<String, Object> getValueFromResponseUsingJsonPath(Response response, List<String> jsonPaths) {
		Map<String, Object> valueMap = new HashMap();
		jsonPaths.forEach(jsonpath -> {
			Object val = response.jsonPath().get(jsonpath);
			valueMap.put(jsonpath, val);
		});
		return valueMap;
	}
	
	public static void verifyValueFromResponseUsingJsonPath(Response response, Map<String, Object> jsonPathsWithExpectedValue) {
		
	}

}
