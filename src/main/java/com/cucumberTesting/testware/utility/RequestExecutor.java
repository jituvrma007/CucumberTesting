package com.cucumberTesting.testware.utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestExecutor {
	public Response response;
	public CommonHelperMethods common = new CommonHelperMethods();
	public Logger log = LoggerFactory.getLogger(this.getClass());

	public RequestSpecification returnRequestSpecification(String url) {
		RequestSpecification requestSpecification = RestAssured.given().when().log().all();
		requestSpecification.baseUri(url);
		return requestSpecification;
	}

	public Response executeGetRequest(RequestSpecification requestSpecification, String apiEndPoint) {
		response = requestSpecification.get(apiEndPoint).then().extract().response();
		log.info(response.getBody().asPrettyString());
		return response;
		}

	public Response executeGetRequestWithParams(RequestSpecification requestSpecification, String apiEndPoint, String[] params) {

		apiEndPoint = common.replaceParamInsideURL(apiEndPoint, params);
		response = requestSpecification.get(apiEndPoint).then().extract().response();
		log.info(response.getBody().asPrettyString());
		return response;
		}
	
	public Response executePostRequest(RequestSpecification requestSpecification, String apiEndPoint,  Object payload) {
		response =  requestSpecification.contentType(ContentType.JSON).body(payload).post(apiEndPoint).then().extract().response();
		log.info(response.getBody().asPrettyString());
		return response;
	}

	public Response executeDeleteRequestWithParams(RequestSpecification requestSpecification, String apiEndPoint, String[] params) {
		apiEndPoint = common.replaceParamInsideURL(apiEndPoint, params);
		response =  requestSpecification.contentType(ContentType.JSON).delete(apiEndPoint).then().extract().response();
		log.info(response.getBody().asPrettyString());
		return response;
	}
	
}
