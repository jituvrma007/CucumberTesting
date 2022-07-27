package com.cucumberTesting.testware.base;

import com.cucumberTesting.testware.utility.ApiDetailReader;
import com.cucumberTesting.testware.utility.CommonHelperMethods;
import com.cucumberTesting.testware.utility.RequestExecutor;
import com.cucumberTesting.testware.utility.ResponseValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiBaseSetup {

        public Response response;
        public RequestSpecification request;
        public CommonHelperMethods common = new CommonHelperMethods();
        public RequestExecutor requestExecutor = new RequestExecutor();
        public ResponseValidator responseValidator = new ResponseValidator();
        public ApiDetailReader apiDetailReader = new ApiDetailReader();
        public Logger log = LoggerFactory.getLogger(this.getClass());


}
