# A barebones testing framework using Selenium, Cucumber and RestAssured

## How to use:
### For Selenium:
Set website url in "src/main/java/selenium/framework/resources/config.properties".
Create page object model classes in "src/main/java/selenium/framework/pages" if you need additional ones.
Feature files are stored in "src/test/resources/features"
Step definition files are stored in "src/test/java/selenium/stepdefinitions"
You can run the cucumber tests direcly from the feature file if you have the IDE extention or you can use the runner class "src/test/java/selenium/runner/TestRunner.java"

### For RestAssured:
The RestAssured setup is simpler.
You can change the baseUrl in "src/main/java/restassured/resources/config.properties".
When writing tests extend the BaseTests class.
Settings like pathParams are stored in "src/main/java/restassured/resources/config.properties".

**For handling properties files you can use src/main/java/helpers/PropertiesHelper.java**

Framework can be used for UI automation using Selenium and Cucumber and for API testing using RestAssured.

### WIP:
Encapsulate RestAssured in a driver like wrapper like the Browser for selenium.
Optimise PropertiesHelper to be easier to usage
WebElementUtils is still a bit of a chore to use and need simplifying
