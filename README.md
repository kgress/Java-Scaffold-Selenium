# Java-Scaffold-Selenium
A project implementation of the Scaffold framework, running in parallel against SauceDemo

# ***************
# This project is IN BETA, and not ready for general use quite yet
# ***************

This project is currently awaiting the arrival of scaffold artifacts from the sonatype/Nexus Maven repo, and won't work on its own until they are published.

In order to use this project in its current state, you will need to download [the scaffold project](https://github.com/RetailMeNot/scaffold), then run the following commands:

```
from scaffold/ - $ mvn clean install
from scaffold/model - $ mvn clean install
from scaffold/environment - $ mvn clean install
from scaffold/framework - $ mvn clean install
```

Performing these commands will install the needed jar files into your local Maven repo. Once these artifacts have been 
installed properly, you should be able to work with this sample project.

# Running Tests

After completeing the configuration steps, you should be able to run the SauceDemo tests either locally or against Sauce Labs servers, 
depending on the options you specify.

## Local Configuration

To run these tests locally, you will need Chrome and [chromedriver](http://chromedriver.chromium.org/) installed and on your PATH.

## Sauce Labs configuration

To run these tests on Sauce Labs, you will need to set two environment variables to match your Sauce Labs credentials.
 
You will need both your User Name and your Access Key: 

Your user name is listed in blue at the top of the "My Account" page on the Sauce Labs site. Note that you need this 
username, not your full email address, in order to set the credentials properly.

To get your Access Key, go to the "My Account" page on the Sauce Labs site, and look below the graphs on the bottom half 
of the page. Your Access Key will be shown there, and you can click the clipboard icon to copy it.

# Page Objects
Scaffold very strongly encourages use of a Page Object Model. Though it is not required, the Model greatly simplifies the 
abstractions you must write and maintain in order to keep your tests simple and user-focused. See Martin Fowler's seminal
article about [Page Objects](https://martinfowler.com/bliki/PageObject.html) for more detail.

# Strongly-typed WebElements
Scaffold makes available particular types of WebElements for you to use, which narrow the scope of methods available 
for any given WebElement, and keep the user focused on the actions they should be performing on these elements. For example, 
You can't, as a user "sendKeys" to a Button or a Link. The ButtonWebElement and LinkWebElement objects take that account and
don't expose those methods.

Another advantage of these elements is that they manage all interaction with the WebDriver internally. Most frameworks 
require the test write/page object maintainer to use the WebDriver to perform all their actions, which requires a lot of
Selenium knowledge, and can also lead to race conditions, thread-safety issues, and the exposure of unnecessary complexity
to the testers.

In the millions of test cases run by Scaffold over the years, there has never been a reported occurrence of a StaleElementReferenceException. 
This is possible because the framework manages the WebDriver and the WebElements internally, in a thread-safe and careful manner. 

# The WebDriver
As a test-writer, you should never have to know about or interact with any instance of a WebDriver 