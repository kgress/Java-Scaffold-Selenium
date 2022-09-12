# Java-Scaffold-Selenium
A project implementation of the Scaffold framework, running in parallel against SauceDemo

# Current version of Scaffold
To view the most current version of Scaffold, [visit the Central Repository](https://search.maven.org/search?q=g:io.github.kgress.scaffold).

# Scaffold Archetype
For a quick start on creating a new Scaffold project, [check out the Scaffold-Archetype codebase](https://github.com/kgress/scaffold-archetype).

# Scaffold Documentation
For more in depth documentation regarding Scaffold, [check out the Scaffold codebase](https://github.com/kgress/scaffold).

# Required Tools for Dev
* Java 11
* Maven 3.x

# Running the Testing
## Locally
There are two potential methods of running the testing locally. The first is maven goal execution and the second is running the testing through the IDE. There are two pre reqs:

### Local Overrides
If you don't already have one, create a file named `application.OVERRIDES` in `environment > src > main > resources > application-OVERRIDES.properties`. In this file, include the desired capabilities and any other secret values required to run your testing. 

*NOTE: Make sure `application.OVERRIDES` is in your `.gitignore`*

### Local Driver
To run these tests locally, you will need Chrome and [chromedriver](http://chromedriver.chromium.org/) installed and on your PATH. If you plan on using a different browser,
install that local driver instead.

## Maven
During your maven goal execution step on your CI, specify the following system property: `-Dspring.profiles.active=your_spring_profile.properties`.

This will pull the environment variables from the profile specified in the system property. For example, if you wanted to run the sauce chrome profile, 
you'd enter the following command: `mvn test -Dspring.profiles.active=overrides.properties`

## IDE
Create a new JUNIT run configuration for the testing you'd like to run locally. In the new run configuration, add the new environment variable `spring.profiles.active=overrides`. This setting will pull in the environment variables from the overrides profile when that test is run through the IDE. 

## CI
Just like running the testing through maven locally, add a maven step in your CI testing pipeline that includes the spring profile you'd like to use.`-Dspring.profiles.active=your_spring_profile.properties`. 
For example: `mvn test -Dspring.profiles.active=sauce_chrome.properties`

## Using a Sauce Labs configuration
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