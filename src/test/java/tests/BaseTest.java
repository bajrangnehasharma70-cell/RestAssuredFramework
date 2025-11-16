package tests;

import org.testng.annotations.BeforeClass;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class BaseTest {
	
	@BeforeClass
	public void setup() {
		RestAssured.filters(new AllureRestAssured());
	}

}
