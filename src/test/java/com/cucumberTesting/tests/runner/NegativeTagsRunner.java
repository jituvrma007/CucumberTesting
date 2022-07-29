package com.cucumberTesting.tests.runner;

import com.cucumberTesting.testware.utility.Constants;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {Constants.CUCUMBER_OPTIONS_FEATURES},
        glue = {Constants.CUCUMBER_OPTIONS_GLUE},
        tags = "@negative",
        plugin = {
                Constants.CUCUMBER_PLUGIN_HTML,
                Constants.CUCUMBER_PLUGIN_JSON,
                Constants.CUCUMBER_PLUGIN_RERUN,
                Constants.CUCUMBER_PLUGIN_EXTENT
        })
public class NegativeTagsRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

}