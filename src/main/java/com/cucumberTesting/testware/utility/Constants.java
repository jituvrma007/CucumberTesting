package com.cucumberTesting.testware.utility;

public class Constants {
	
	public static String ENV_FILE_PATH = System.getProperty("user.dir")+ "/src/test/resources/cucumberTest/environments/";
	public static String API_FILE_PATH = System.getProperty("user.dir")+ "/src/test/resources/cucumberTest/apiDetails/";
	public static String SCHEMA_FILE_PATH = "\\cucumberTest\\schema\\";
	public static String ACTIVE_ENV = "dev";
	public static String HOST = System.getenv("HOST");

	//** CucumberOptions **//
	public static final String CUCUMBER_OPTIONS_FEATURES = "src/test/resources/cucumberTest/featureFiles/";
	public static final String CUCUMBER_OPTIONS_GLUE = "com.cucumberTesting.tests.stepdef";
	public static final String CUCUMBER_PLUGIN_HTML = "html:executionReports/cucumberReports/report.html";
	public static final String CUCUMBER_PLUGIN_JSON = "json:executionReports/cucumberReports/cucumber.json";
	public static final String CUCUMBER_PLUGIN_RERUN = "rerun:executionReports/cucumberReports/rerun.txt";
	public static final String CUCUMBER_PLUGIN_EXTENT ="com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:";

}