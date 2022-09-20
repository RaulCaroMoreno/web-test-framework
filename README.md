# web-test-framework
Test layer which use web-behavior-framework to execute parallel tests and create reports.

# Prerequisites
You must download web-behavior-framework and build it with "mvn clean install -Dexec.skip=true". Selenium hub and node running for distributed execution.

# Tools
It uses Junit5 (annotations, suites, concurrent executions...), Maven, Java and ExtentReport to generate custom reports. 

# Configuration
Under resources/regression.properties you can choose:

1. The URL of the Selenium HUB in order to execute parallel tests. By default port 4444  example: http:/localhost:4444/wd/hub
2. Which browser You want to use: edge, firefox or chrome
3. Url of the site you want to test. For example: https://www.saucedemo.com/

# How to run it
You can execute junit5 suites (for example: java/suites/TestSuite.java) with the following maven command "mvn test -DtestSuite=TestSuite". All test are executed in parallel.

# Reports
After parallel execution of tests, report is generated in reports folder:
![image](https://user-images.githubusercontent.com/39560502/191049301-763c3768-844c-4e1f-99cd-718c00d44995.png)

# Test Data
Data for each test is retrieved from resources/data


