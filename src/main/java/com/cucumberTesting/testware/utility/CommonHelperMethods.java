package com.cucumberTesting.testware.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonHelperMethods {
    Logger log = LoggerFactory.getLogger(this.getClass());
    public String returnValueFromCurrentEnvPropertyFile(String propertyName) {
        log.info("propertyName :: "+ propertyName);

        String value = "";
        String host = Constants.HOST;

        if (StringUtils.isBlank(Constants.HOST)) {
            host = Constants.ACTIVE_ENV;
        }

        String filePath = Constants.ENV_FILE_PATH + host + ".properties";
        log.info("reading Filepath :: "+ filePath);

        FileReader reader = null;
        Properties prop = null;

        try {
            reader = new FileReader(filePath);
            prop = new Properties();
            prop.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
        value = prop.getProperty(propertyName);
        if (value == null) {
            log.info("returning value :: "+ "");
            return "";
        }
        log.info("returning value :: "+ value);
        return value;

    }

    public String replaceParamInsideURL(String url, String[] params) {
       log.info("URL :: "+ url +" params :: "+ Arrays.toString(params));

       for (int i = 0; i < params.length; i++) {
            url = url.replace("${" + i + "}", params[i]);
        }

        log.info("Replaced URL :: "+ url);
        return url;
    }

    public String returnConcatenatedBaseURI(String protocol, String baseUrl, String serviceUrl) {
        return new String(returnValueFromCurrentEnvPropertyFile(protocol) +
                returnValueFromCurrentEnvPropertyFile(baseUrl) + "/" +
                returnValueFromCurrentEnvPropertyFile(serviceUrl));
    }
}
