package com.cucumberTesting.testware.utility;

public class Constants {
	
	public static String ENV_FILE_PATH = System.getProperty("user.dir")+ "/src/test/resources/cucumberTest/environments/";
	public static String API_FILE_PATH = System.getProperty("user.dir")+ "/src/test/resources/cucumberTest/apiDetails/";
	public static String SCHEMA_FILE_PATH = "\\cucumberTest\\schema\\";
	public static String FEATURE_FILES_PATH = "src/test/resources/cucumberTest/featureFiles/";
	public static String ACTIVE_ENV = "dev";
	public static String HOST = System.getenv("HOST");

}