# API Testing Framework with Cucumber, RestAssured, and Allure

## Overview

This framework is designed for automated API testing using Java. It combines popular tools like **Cucumber**, **RestAssured**, **JUnit**, and **Allure** to enable readable, maintainable, and powerful API tests with rich reporting.

---

## Key Components

### 1. Cucumber (BDD Testing Framework)
- Enables writing tests in **Behavior-Driven Development (BDD)** style using Gherkin syntax (`Given`, `When`, `Then`).
- Lets you describe test scenarios in plain English, making tests easy to understand.
- Integrates with JUnit to run feature files.
- Uses PicoContainer for dependency injection to manage step definitions and clients.

### 2. JUnit
- Runs the Cucumber tests and integrates with build tools like Gradle.

### 3. RestAssured
- Provides a fluent API for sending HTTP requests and validating RESTful API responses.
- Simplifies making API calls and asserting status codes, headers, and body content.

### 4. Allure Reporting
- Generates detailed and visually appealing test reports.
- Captures test execution details and attaches logs, screenshots, and other artifacts.

### 5. Groovy (Internal Dependency)
- RestAssured uses Groovy internally for its DSL.
- Be mindful of Groovy version conflicts when managing dependencies.

---

## How It Works

1. **Write Feature Files**
   - Define your test scenarios in `.feature` files using Gherkin syntax.
   - Example:
     ```gherkin
     Scenario Outline: Successful login with valid credentials
       When I login with "<username>" and "<password>"
       Then I should receive a successful response
     ```

2. **Implement Step Definitions**
   - Write Java methods to execute each Gherkin step.
   - Use RestAssured inside step definitions to call APIs and verify responses.

3. **Create API Clients and Utilities**
   - Encapsulate API requests in client classes for reusability.
   - Use helper classes like `ApiResponse<T>` to wrap and handle responses safely, including raw response access.

4. **Run Tests**
   - Use JUnit to run the Cucumber feature files.
   - Tests execute API calls, validate results, and record outcomes.

5. **Generate Reports**
   - Allure collects test data during execution.
   - Generate and view rich test reports for analysis and debugging.

---

## Benefits

- **Readable tests:** Plain English feature files accessible to all team members.
- **Modular design:** Reusable API clients and utilities reduce duplication.
- **Powerful assertions:** Fluent RestAssured syntax for concise validations.
- **Rich reports:** Allure reports give deep insights into test runs.
- **Dependency injection:** Clean management of test components using PicoContainer.

---

## Notes and Best Practices

- **Manage Dependency Versions:** Avoid Groovy version conflicts by aligning versions required by RestAssured and other libraries.
- **Handle Non-JSON Responses:** Use `ApiResponse` class logic to safely handle non-JSON responses by storing raw strings.
- **Test Data:** Maintain valid test credentials and data within feature files or external sources.
- **Run with Gradle:** Use `./gradlew test` to execute tests and generate reports.

---

## Getting Started

1. Clone the repository.
2. Ensure Java and Gradle are installed.
3. Add valid test data to your feature files.
4. Run tests:
   ```bash
   ./gradlew test
   ```
5. Generate Allure reports:
    ```bash
    ./gradlew allureReport
    ./gradlew allureServe
   ```