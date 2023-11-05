# Sporting Group Interview Exercise

This repository contains an Interview exercise given by Sporting Group. A Java Automation project that includes both API and UI test automation using Cucumber and Selenium. 
It demonstrates how to automate user management tasks using REST API and test web pages with challenging and dynamic elements.

#Observation:

* the API exercise had a issue where as delete user call getting too many request (429) error.
* added code to handle the endpoint limitation.

## Project Structure

- `src/test/java`: Contains the test automation code.
  -`API.steps`:Cucumber step definitions for API.
  - `config`: Configuration files and classes.
    - `Configuration.java`: Configuration settings for the project.
 - `hooks`: Cucumber hooks (e.g., setup and teardown).
    - `Hooks.java`: Hook methods for test setup and cleanup.
  - `runners`: Test runners to execute Cucumber tests.
    - `RunAPI.java`: Runner class for API tests.
    - `RunUI.java`: Runner class for UI tests.
  - `UI.pages`: Page objects for UI testing.
    - `ChallengingDOMPage.java`: Page object for the Challenging DOM page.
    - `DynamicLoadingPage.java`: Page object for the Dynamic Loading page.
    - `HomePage.java`: Page object for the home page.
  - `UI.steps`: Cucumber step definitions for UI testing.
    - `ChallengingDomSteps.java`: Step definitions for UI testing.
    - `DynamicLoadingSteps.java`: Step definitions for UI testing.
    - `UserMgmtSteps.java`: Step definitions for API testing.
  - `utils`: Utility classes for test automation.
    - `ScenarioContext.java`: A context class for sharing data between steps.
 

- `src/test/resources`: Contains project resources.
  - `drivers`: Store the `chromedriver.exe` for Selenium tests.
- `features`: Contains Cucumber feature files.
  - `API`: Feature file for API testing.
    - `UserMgmt.feature`: Scenario descriptions for API testing.
  - `UI`: Feature file for UI testing.
    - `SportingGroupInterview.feature`: Scenario descriptions for UI testing.

- `config.properties`: Configuration properties for the project.
- `extent.properties`: Configuration for Extent Reports (if used).
- `extent-config.xml`: Configuration for Extent Reports (if used).

## Getting Started

1. Clone this repository to your local machine.
2. Download the appropriate `chromedriver.exe` ( version 119.0.6045.105 ) version and place it in the `src/test/resources/drivers` folder (Attached).
3. Run the tests using the provided runners, such as `RunAPI` and `RunUI`.
4. Or Use testng.xml to run all tests
5. Test execution report will be available at `test-output/SparkReport/Spark.html`

## Dependencies

- Cucumber: https://cucumber.io/
- Selenium: (https://www.selenium.dev/
- RestAssured: https://rest-assured.io/
- Extent Reports: https://www.extentreports.com/
