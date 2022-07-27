# CucumberTesting : about the project
This is a sample backend/Api automation project for testing restful APIs of a social network. Starting from simple functionality, it consists of a couple of APIs that allows you to make posts, comments on posts and list the existing users. All the respective Api and the documentation can be found here: https://jsonplaceholder.typicode.com.

### A bit more about the project
This project is covering some basic Api automation test framework and some sample test cases. Although, we can surely enhance it more with lots of robust features.

### Project structure
```

├── CucumberTesting
│   ├── src\main\java
│   │   ├── base 
│   │   └── utility
│   │   
│   ├── src\main\resources
│   │   
│   ├── src\test\java
│   │   ├── model
│   │   ├── runner
│   │   └── stepdef
│   │   
│   ├── src\test\resources
│   │   └── cucumberTest
│   │ 		├── apiDetails
│   │   	├── environments
│   │   	└── featureFiles
│   │   	├── schema
│   │   	└── testSuites

```

### Dependencies
Here are the dependencies used in the project for development & testing perspective. 
<br/> Note - All are open source project and widely available over the web. Setup the maching dependencies to test the code further.

* [Java 17](https://www.java.com/en/) - Programming Language
* [Gradle 7.5](https://gradle.org/install/) - Dependency Management
* [RestAssured](http://rest-assured.io/) - Accessing the APIs Response
* [TestNG](https://testng.org/doc/) - Unit Testing framework for Java 
* [ExtentReports](http://extentreports.com/) - Reporting framework for our tests

## Getting Started
The below steps will get you a copy of the project up and running, on your local machine for development and testing purposes. 

1. Open your terminal and do a clone of this project.
```
git clone https://github.com/jituvrma007/CucumberTesting.git
```

2) Navigate to the respective directory and run below command.
```
gradlew cucumber
````
3) Above command will build the project along with test cases.
4) If you something like below text on terminal, means project ran successfully locally. 

## Reports
Here are a below steps to get a human readable html report.
```
1) Navigate to respective directory where the project is stored locally.
2) Navigate to /executionReports directory.
3) Find the logs inside "/generatedLogs" directory.
4) Find the html based cucumberReport inside "/cucumberReports" directory.
5) Find the html based extentReport inside "/extentReport" directory.
````

##Solution include
1. Logging -> On console screen and under "executionReports\generatedLogs\Logs.log" directory.

2. Generating html human readable report -> Yes, html reports are being generated with using utility ExtentReports and CucumberReports. It is covering the detailed steps, pass/fail/skipped results and with the respective time line. It is super easy to understand and to analyze supports detailed charts as well.

3. Layers - Layers like, BaseSetup, Utility, Request API details, and Environment layers are done. Since it is just a sample project, we can design and extend this framework to scale further

4. Run tests in parallel mode -> Yes from runner we are overriding the Dataprovider and making "parallel = true". if we remove this overridden method then we will be able to run one by one.
