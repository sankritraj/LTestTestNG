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

**SeleniumAdvancedScen**
1. Navigate to https://www.lambdatest.com.
2. Perform an explicit wait till the time all the elements in the DOM
are available.
3. Scroll to the WebElement ‘Explore all Integrations’ using the
scrollIntoView() method. You are free to use any of the available
web locators (e.g., XPath, CssSelector, etc.)
4. Click on the link and ensure that it opens in the new tab.
5. Save the window handles in a List (or array). Print the window handles
of the opened windows (now there are two windows open).
6. Verify whether the URL is the same as the expected URL (if not, throw
an Assert).
7. On that page, scroll to the page where the WebElement
(Codeless Automation) is present.
8. Click the ‘INTEGRATE TESTING WHIZ WITH LAMBDATEST’ link for
Testing Whiz. The page should open in the same window.
9. Check if the title of the page is ‘TestingWhiz Integration With
LambdaTest’. If not, raise an Assert.
10. Close the current window using the window handle [which we
obtained in step (5)]
11. Print the current window count.
12. On the current window, set the URL to
https://www.lambdatest.com/blog.
13. Click on the ‘Community’ link and verify whether the URL is
https://community.lambdatest.com/.
14. Close the current browser window.


 **Execution**
The test scenario should be demonstrated on the following combinations of
browsers and platforms (using Selenium 4 Grid and Selenium 4 Java):
1. Chrome + 88.0 + Windows 10
2. MicrosoftEdge + 87.0 + macOS Sierra
3. Firefox + 82.0 + Windows 7
4. Internet Explorer + 11.0 + Windows 10
5. Chrome + 128.0 + Windows 10 (Test Scenario 1)
6. Microsoft Edge + 127.0 + macOS Ventura (Test Scenario 2)

 ***to execute on gitpod use below file***
 tasks:
  - init: mvn install -DskipTests=false
