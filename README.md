Civil Service Jobs Automation
This project automates the process of searching for jobs on the Civil Service Jobs website using Selenium, Cucumber BDD, and Allure for reporting.
Prerequisites
Make sure you have the following tools installed before setting up the project:
•	JDK 17+ (required for Maven)
•	Maven (for managing dependencies and build)
•	Git (for version control)
•	IDE: Any Java IDE like IntelliJ IDEA or Eclipse
•	Allure (for generating reports)
•	Browsers: Chrome, Firefox, Edge installed on your system
Project Setup
Follow the steps below to set up and run the project:
1. Clone the Repository
Clone this repository to your local machine:
git clone https://github.com/Malene-Ashokkumar/CivilServiceCode.git
cd automation
2. Install Maven Dependencies
Run the following command to download all the required dependencies:
mvn clean install
3. Set Up Allure 
3.1 Install Allure report to your local system - scoop install allure
3.2 Navigate to allure-path C:\CivilServiceAutomation\automation
3.3 Execute this command to view allure report - allure serve allure-results
4. Configuration
4.1 Configure Web Drivers
WebDriver Manager will automatically download and manage the required browser drivers for Chrome, Firefox, and Edge. No manual setup is required.

5. Running the Tests
5.1 Using Maven
Run all the tests with:
mvn test
This will execute the tests for all the browsers specified in the TestRunner.java
6. Generating Allure Reports
After running the tests, you can generate an Allure report using the following command:
allure serve allure-results
This will start a local server and open the Allure report in your browser.
7. Project Structure
Here is a breakdown of the project structure:
civil-service-jobs-automation
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── BaseTest.java           # Base test class for initializing driver
│   │   │   ├── pages
│   │   │   │   ├── HomePage.java           # Page Object Model for HomePage
│   │   │   │   ├── JobListingPage.java     # Page Object Model for Job Listings
│   │   │   │   └── SearchResultsPage.java  # Page Object Model for Search Results
│   ├── test
│   │   ├── java
│   │   │   ├── stepDefinitions
│   │   │   │   └── SearchJobSteps.java     # Step Definitions for Cucumber tests
│   │   │   └── runners
│   │   │       └── TestRunner.java         # Runner class for Cucumber tests
│   ├── resources
│   │   ├── features
│   │   │   ├── search_jobs.feature        # Feature file for job search scenario
│   │   │   └── civil_service_code.feature # Feature file for Civil Service Code link
├── pom.xml                                   # Maven configuration file
└── allure-results                             # Allure test results (generated after test execution)
8. Explanation of Key Files
8.1 BaseTest.java
This is the base class that handles the initialization and cleanup of the WebDriver instance for different browsers.
8.2 HomePage.java, JobListingPage.java, SearchResultsPage.java
These are the Page Object Model (POM) classes that represent different pages of the Civil Service Jobs website and contain methods for interacting with elements on those pages.
8.3 SearchJobSteps.java
This file contains the Cucumber step definitions that implement the scenarios defined in the feature files. Each method corresponds to a step in the BDD scenario.
8.4 TestRunner.java
This class is the Cucumber test runner that configures the execution of feature files.
8.5 search_jobs.feature, civil_service_code.feature
These are the feature files written in Gherkin syntax, which define the BDD scenarios for testing job search and Civil Service Code link functionality.
8.6 pom.xml
This file manages dependencies, plugins, and configurations for the Maven build process.
9. Troubleshooting
•	NoSuchElementException: Ensure that the locators are correct. Use browser developer tools to verify the element's XPath.
•	WebDriver Issues: Make sure that the browser drivers are correctly managed by WebDriverManager.
•	Report Issues: If the Allure report isn't generating, ensure you have the Allure command-line tool installed and the appropriate dependencies in the pom.xml
