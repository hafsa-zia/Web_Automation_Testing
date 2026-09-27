# Spotify Web Automated Testing

An automated testing framework for validating key functionality of the **Spotify web application**. The project uses **Behavior-Driven Development (BDD)** with Gherkin to define clear, human-readable test scenarios and supports data-driven testing using **Excel files and databases**.

## Testing Scope

The framework includes automated test cases for:

* **Login**

  * Valid login scenarios
  * Invalid login scenarios
  * Validation of login behavior and responses

* **Logout**

  * Verification of successful logout
  * Validation of session termination and navigation behavior

* **Song Search**

  * Searching for songs using different test inputs
  * Validating search results and expected application behavior

## Key Features

* **BDD-based testing** using Gherkin syntax for readable and structured test scenarios
* **Automated web testing** for Spotify's core user workflows
* **Data-driven testing** using test data stored in Excel
* **Database integration** for retrieving and managing test data
* Reusable test steps and structured test scenarios
* Automated validation of expected application behavior

## Test Data Management

The framework supports multiple sources for test data:

* **Excel** files for parameterized test scenarios
* **Database** integration for retrieving test data dynamically

This approach separates test data from test logic and makes the test cases easier to maintain and extend.

## Test Scenarios

| Feature     | Functionality Tested                       |
| ----------- | ------------------------------------------ |
| Login       | Valid and invalid login workflows          |
| Logout      | Successful logout and session behavior     |
| Song Search | Search functionality and result validation |

## Technologies & Tools

* Gherkin
* BDD
* Automated Web Testing
* Excel Test Data
* Database Integration

## Project Purpose

The project demonstrates the use of a structured, maintainable approach to **automated web application testing**, combining BDD test scenarios with external test-data sources to improve test coverage, reusability, and maintainability.
