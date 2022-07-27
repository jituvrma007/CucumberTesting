package com.cucumberTesting.tests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/cucumberTest/featureFiles/ListOfUsers.feature"},
        glue = {"com.cucumberTesting.tests.stepdef"},
        plugin = {
                "html:executionReports/cucumberReports/report.html",
                "json:executionReports/cucumberReports/cucumber.json",
                "rerun:executionReports/cucumberReports/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })

public class ListOfUsersRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}