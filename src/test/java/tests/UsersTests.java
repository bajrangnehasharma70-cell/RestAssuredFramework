package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import users.UsersAPIs;

public class UsersTests {
	
	@Test
	public void verifyAllUsersAreRetunred() {
		Response allUsers = UsersAPIs.getAllUsers();
		List<String> allIds = allUsers.jsonPath().getList("id");
		System.out.println(allIds);
	}
	
	// get users using query params
	
	@Test
	public void verifyGetUserUsingIds() throws JsonMappingException, JsonProcessingException {
	 Map<String,Object> queryParms = new HashMap<>();
//	 queryParms.put("id", 3);
//	 queryParms.put("id", 5);
//	 queryParms.put("id", 13);
	 
	 //queryParms.put("id", List.of(3,5,13));
	 ArrayList<Integer> allIds = new ArrayList<>();
	 allIds.add(3);
	 allIds.add(5);
	 allIds.add(13);
	 queryParms.put("id", allIds);
	 Response response = UsersAPIs.getUsersUsingIDs(queryParms);
	 
	 String bookingId = response.asPrettyString();
	 System.out.println(bookingId);
	 
//	  int userId = response.jsonPath().getInt("[0].id");
//	 System.out.println(userId);
//	 Assert.assertEquals(userId, 1, "not equal");	
//	 String name =response.jsonPath().getString("[0].name");
//	 Assert.assertEquals(name, "Google Pixel 6 Pro" , "not equal");
//	 
//	 ObjectMapper objectMapper = new ObjectMapper();
//     JsonNode rootNode = objectMapper.readTree(bookingId);
//     for (JsonNode bookingNode : rootNode) {
//     
//    	 if (bookingNode.get("id").asInt() == 1) {
//             System.out.println("Found booking with ID 1: " + bookingNode.toPrettyString());
//    	 }
//    	 
//    	 
//     }
     
     
	 
	}
	
			 

}
