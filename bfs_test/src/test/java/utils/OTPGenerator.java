package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;


public class OTPGenerator {

	public static String getOTPForNewUser(String mobNum) {
		String otp = "";
		
		RestAssured.baseURI = "https://stage-api.whjr.one";
		
		String postResponse = given().log().all().header("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlblZlcnNpb24iOjMsImlkIjoiZjE2ZTM0MzctODdkZS00ZTQzLWJlNjctOGQ0MTRlZWYzYTJkIiwidG9rZW5UeXBlIjoicHJpbWFyeV90b2tlbiIsImV4cCI6MTcwMjk4MjEyMSwiaWF0IjoxNjk1MjA2MTIxfQ.URn1eQ78ee6PUjiME4a24r0LZvzOfXKmsx5OeYkv7wg")
				.header("Content-Type", "application/json")
				.body(
						"{\r\n"
						+ "    \"cacheName\": \"OTP\",\r\n"
						+ "    \"key\": \"+91_"+mobNum+"_otp_token\"\r\n"
						+ "}")
				.when().post("api/V1/caching/getRedisCacheByKey")
				.then().extract().response().asString();
		
		JsonPath js = new JsonPath(postResponse);
		otp = js.getString("data");
		
		
		return otp;
	}

	//This method should not be used as it has not yet been tested
	public static String getOTPForRegisteredUSer(String email, String mobNum) {
		String otp = "";
		
		RestAssured.baseURI = "https://stage-api.whjr.one";
		
		String postResponse = given().log().all().header("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlblZlcnNpb24iOjYyLCJpZCI6IjIyMGUyNzRhLTE4NDUtNGNhMC04ODc5LThkZmY5Y2M0MjAwNCIsInRva2VuVHlwZSI6InByaW1hcnlfdG9rZW4iLCJleHAiOjE3MTAwNDcxMDMsImlhdCI6MTcwMjI3MTEwM30.5p6CNE5H10z_md6nCSajqe-niyYWRNs4gJfHP9lDBkk")
				.header("Content-Type", "application/json")
				.body(
						"{\"email\":"+email+"\",\"mobile\":"+mobNum+"}")
				.when().post("api/V1/users/generateVerificationCode?timezone=Asia%2FCalcutta&langCode=en_US")
				.then().extract().response().asString();
		
		JsonPath js = new JsonPath(postResponse);
		otp = js.getString("data.token");
		
		
		return otp;
	}
}
