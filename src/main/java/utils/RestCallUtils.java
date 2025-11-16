package utils;

import java.io.File;
import java.util.Map;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
		    // .filter(new AllureRestAssured())
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
	
	public static Response performGetCall(String baseUrl, String basePath) {
		return getCall(baseUrl, basePath, null);	
	 }
	
	public static Response performGetCall(String baseUrl, String basePath, Map<String, Object> queryParams) {
		return getCall(baseUrl, basePath, queryParams);	
	}
	
	private static Response getCall(String baseUrl, String basePath, Map<String, Object> queryParams)
	{
		RequestSpecification requestSpec = RestAssured.given().log().all();
		
		requestSpec.baseUri(baseUrl);
		requestSpec.basePath(basePath);
		if(queryParams != null) 
			requestSpec.queryParams(queryParams);
		
		Response response = requestSpec
				.when()
				.get();
			return response;	
	}
	

}
