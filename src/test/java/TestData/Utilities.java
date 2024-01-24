package TestData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Utilities {
	
	
	public static RequestSpecification reqSpec; // Declared static that i wont be set null for other testcase execution
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqSpec==null) {
		PrintStream printStream = new PrintStream(new FileOutputStream("output.txt")); // out put stream to output.txt
		reqSpec = new RequestSpecBuilder()
				.setBaseUri(getGlobalValue("baseUri"))// set base uri
				.addQueryParam("key","qaclick123")// set querry param
				.setContentType(ContentType.JSON)// expected content type
				.addFilter(RequestLoggingFilter.logRequestTo(printStream))// logs all request data to output.txt
				.addFilter(ResponseLoggingFilter.logResponseTo(printStream))// log all response to output.txt
				.build();// build request specification
		return reqSpec;
		}
		return reqSpec;
	}
	public static String getGlobalValue(String key) throws IOException   {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Hassan\\eclipse-workspace\\ApiFrameWork\\src\\test\\java\\TestData\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public static String getJsonKeyValue(String Responce, String key) {
		JsonPath js = new JsonPath(Responce);
		return js.getString(key);
	
	}

}
