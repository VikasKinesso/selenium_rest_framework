# AlphaSense-functional-ui-test
Cucumber IO, Gherkin, Selenium WebDriver, Maven, TestNG, JVM Cucumber Report, GitLab and Java

# Pre Condition
1. Install Java JDK+JRE. Java home path for windows only
2. Install IDE such as Eclipse or IntelliJ
3. Ensure you have maven configured

# RUN THE TEST
1. Clone the project
1. Run all tests: mvn verify
2. Run UI tests: mvn verify -Dcucumber.filter.tags="@UI"
3. Run API tests: mvn verify -Dcucumber.filter.tags="@api"
4. Run UI tests with diffent URL : mvn verify -Durl=research.alpha-sense.com  -Dcucumber.filter.tags="@UI"

# RESULT
result location: <project folder>\test-output\index.html
for eg: C:\Users\udit\Desktop\workspace\selenium_rest_framework\test-output\index.html