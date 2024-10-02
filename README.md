**Pre-Conditions**
1. Use suitable Before*** annotation to launch a browser and the
given URL: https://www.lambdatest.com/selenium-playground/.
2. Pass Browser Name and URL from Test Suite XML.
3. For all three given Test Scenarios, use the same URL.
4. Use suitable After*** annotation to close the browser after each
test scenario.

**Test Scenario 1:**
1. Perform an explicit wait till the time all the elements in the
DOM are available.
2. Use the SoftAssert to validate Page Title. Validate Against
“LambdaTest” (expecting a failure and proceeding to the
following statement).

**Test Scenario 2:**
1. Click “Checkbox Demo” under “Input Forms”.
2. Click the checkbox under the “Single Checkbox Demo” section.
3. Validate whether this checkbox is “selected”.
4. Now click the checkbox again and validate whether the
checkbox is “unselected”.

**Test Scenario 3:**
1. Launch the same browser and URL given in the Pre-Condition.
2. Click “Javascript Alerts” under “Alerts & Modals”.
3. Now click the “Click Me” button in the “Java Script Alert Box”
section.
4. Validate the alert message “I am an alert box!” and click ok.

 **Execution**
The test scenario should be demonstrated on the following combinations of
browsers and platforms (using Selenium 4 Grid and Selenium 4 Java):
1. Chrome + 88.0 + Windows 10
2. MicrosoftEdge + 87.0 + macOS Sierra
3. Firefox + 82.0 + Windows 7
4. Internet Explorer + 11.0 + Windows 10
