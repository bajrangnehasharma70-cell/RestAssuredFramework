package utils;

import java.io.File;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestCallUtils {
	
	public static Response perfromPOSTCall(String baseUrl, String basePath, String requestBody) {
		return postCall(baseUrl, basePath, requestBody);		
	 }
	
	public static Response perfromPOSTCall(String baseUrl, String basePath, Map<String, Object> requestBody) {
		return postCall(baseUrl, basePath, requestBody);		
	 }
	
	public static Response perfromPOSTCall(String baseUrl, String basePath, Object requestBody) {
		return postCall(baseUrl, basePath, requestBody);		
	 }
	
	public static Response perfromPOSTCall(String baseUrl, String basePath, File requestBodyFile) {
		return postCall(baseUrl, basePath, requestBodyFile);	
	 }
	
	
	private static Response postCall(String baseUrl, String basePath, Object requestBody) {	
		//Response response =  RestAssured
		return RestAssured
		.given()
			.log()
			.all()
			.baseUri(baseUrl)
			.basePath(basePath)
			.contentType(ContentType.JSON)
			.body(requestBody)
		.when()
			.post()
		.then()
			.log()
			.all()
			.extract()
			.response();	
		//return response;
	}

}
