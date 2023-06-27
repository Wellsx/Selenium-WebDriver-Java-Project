# Selenium with Java and TestNG for The Internet App

[![on_push](https://github.com/Wellsx/Selenium-WebDriver-Java-Project/actions/workflows/actions.yaml/badge.svg)](https://github.com/Wellsx/Selenium-WebDriver-Java-Project/actions/workflows/actions.yaml)

This repository contains a Selenium automation framework using Java and TestNG for testing the https://the-internet.herokuapp.com/ application. The framework follows the Page-Object Model (POM) design pattern, enabling easy maintenance and scalability of tests.

---

## Features

- Uses Selenium WebDriver with Java to interact with web elements and perform actions on the application.
- Implements the TestNG testing framework for test management and reporting.
- Utilizes the Page-Object Model (POM) design pattern to separate test scripts from the web elements and actions, ensuring maintainable and readable tests.
- Includes test suites and test data management for efficient test execution.


## Prerequisites

Ensure you have the following software installed on your system:

- Java Development Kit (JDK): [Download and Install JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Maven: [Download and Install Maven](https://maven.apache.org/install.html)

## Getting Started

1. Clone this repository:

   ```bash
   git clone https://github.com/Wellsx/Selenium-WebDriver-Java-Project.git
   ```

2. Navigate to the project root:

   ```bash
   cd your-repo
   ```

3. Run the tests:

   ```bash
   mvn clean test
   ```
---

## Test Organization

- Test scripts are written in Java and can be found in the `src/test/java` directory.
- The Page Object classes representing the web pages of the application are located in the `src/main/java/pages` directory.
- Test data, if required, can be managed in the `src/test/resources` directory.
- Configuration settings, such as browser type and URL, can be modified in the `src/test/java/base/BaseTests.java` file.


