package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;

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
	
	/*
	 * I will pass a Map with jsonpath as key and its expected value as value. 
	 * firstname == amod
	 * bookingdates.checkin = 2025-01-01 
	 */
	public static void verifyValueFromResponseUsingJsonPath(Response response, Map<String, Object> jsonPathsWithExpectedValue) {
		
		jsonPathsWithExpectedValue.keySet().forEach(jp -> {
			Object actualValueFromResponse = response.jsonPath().get(jp); // rahul
			Object expectedValue = jsonPathsWithExpectedValue.get(jp); // amod
			Assert.assertEquals(actualValueFromResponse, expectedValue);
		});	
	}
	
	// convert response to pojo class
	// 

	public static <T> T convertResponseToPojo(Response response, Class<T> pojoClassToBeConverted)
	
	{
		return response.as(pojoClassToBeConverted);
			
	}

	
//	
//	static void add(int n1, int n2) {
//		int a = n1;
//		int b = n2;
//		int c = a+b;
//		System.out.println(c);
//	}
//		
//	
//	
//	public static void main(String[] args) {
//		add(10,20);
//		add(100,300);
//		add(45,56);
//		
//	}
	
}
