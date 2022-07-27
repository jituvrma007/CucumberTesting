# CucumberTesting :about the project
This is a sample backend/Api automation project for the service: https://jsonplaceholder.typicode.com using Java, RestAssured, Cucumber, and Gradle.

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

* [Java 17](https://www.java.com/en/) - Coding Language
* [Gradle 7.5](https://gradle.org/install/) - Dependency Management
* [RestAssured](http://rest-assured.io/) - Used to get API Response
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