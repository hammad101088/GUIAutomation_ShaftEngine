# Test Automation Task

This is a simple automation project for testing [OrangeHRM](https://opensource-demo.orangehrmlive.com/) website.

*	Implementing a test automation framework using SHAFT_Engine.
*	Applying page object model desing pattern (POM).
*	Applying fluent desing (method chaining).
*	Applying data driven testing (DDT).

# Technologies

* JDK-17
* [Maven](https://maven.apache.org/)
* [TestNG](https://testng.org/)
* [Selenium WebDriver](https://www.selenium.dev/documentation/en/)
* [SHAFT_ENGINE](https://github.com/MohabMohie/SHAFT_ENGINE)
* [Allure Report Framework](https://docs.qameta.io/allure/)
* [Docker](https://docs.docker.com/)
* [Selenium Grid](https://www.selenium.dev/documentation/grid/)
* [GitHub Actions](https://docs.github.com/en/actions)

 


# Run the Test
## 1. Locally
Prerequisites: jdk-17 and maven should be installed

### 1.1 Run the Test LOCALLY using Eclipse IDE

* Import this project to your eclipse.
* Run the test cases/classes
* The report will be generated automatically after running the test.

### 1.2 Run the Test LOCALLY using IntelliJ IDEA

* Import this project to your intellij.
* Kindly, refere to this [link](https://github.com/MohabMohie/using_SHAFT_ENGINE) and follow the steps to add the listeners in intellij.
* Run the test cases/classes
* The report will be generated automatically after running the test.

### 1.3 Run the Test LOCALLY using the Terminal or CMD

* Clone or download the project.
* At the root directory of the project (e.g. downloads/projectName/); run the following command ```mvn test```
* The report will be generated automatically after running the test.

------------------

#### Important Note (for local execution):
- By default the report will be automatically generated, but you can check the result of the the test by running "generate_allure_report.bat" or "generate_allure_report.sh" files.

## 2. Remotly

### 2.1. Run the Test REMOTLY using Selenium-Grid and Docker 
* Clone or download the project.
* To start selenium-grid using docker-compose; at the root directory of the project, run the following command <br />
```
docker-compose -f src/main/resources/docker-compose.yml up --scale chrome=1 --remove-orphans -d
```
* Open [http://localhost:4444/grid/console](http://localhost:4444/grid/console) to monitor selenium grid.
* Run the test using the following command <br />
```
mvn test -DexecutionAddress="localhost:4444" -DtargetOperatingSystem="Linux-64" -DmaximumPerformanceMode="2"
```
* To generate the report: <br />
  - run "generate_allure_report.sh" file if you're using linux/mac. <br />
  - run "generate_allure_report.bat" file if you're using windows.

* To end selenium grid; at the root directory, run the following
```
docker-compose -f src/main/resources/docker-compose.yml down --remove-orphans
```

