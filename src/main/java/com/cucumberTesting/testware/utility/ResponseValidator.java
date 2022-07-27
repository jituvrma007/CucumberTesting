package com.cucumberTesting.testware.utility;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ResponseValidator {

	public String jsonStringValue(Response response, String regPath) {
		return JsonPath.read(response.getBody().asString(),regPath).toString();	
	} 

	public List<String> jsonListOfStringValue(Response response, String regPath ) {
		return JsonPath.read(response.getBody().asString(),regPath);
	}

	public Set<String> jsonSetOfStringValue(Response response, String regPath ) {
		return new LinkedHashSet<>(JsonPath.read(response.getBody().asString(),regPath));
	}

	public boolean schemaValidator(Response response, String format, String schemaFilePath){
		if(format.equals("json")){
			response.then().assertThat().contentType(ContentType.JSON)
					.and()
					.body(matchesJsonSchemaInClasspath(schemaFilePath));
			return true;
		}
		return false;

	}

}
