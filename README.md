# Automation Exercise – Selenium Test Automation Framework

A Java test automation framework for an online shopping portal ([Automation Exercise](https://automationexercise.com)), with **20+ automated test cases** covering Login, Products, Search, Cart and Payment. UI tests run with Selenium WebDriver and TestNG using the Page Object Model, and the payment flow is written as Cucumber BDD scenarios.

## Application Under Test

- **Site:** https://automationexercise.com (public e-commerce practice website)
- **Areas covered:** Login · Products · Search · Cart · Payment (Cucumber BDD)

## Tech Stack

| Area | Tools |
|------|-------|
| Language | Java 17 |
| UI Automation | Selenium WebDriver 4 |
| Test Framework | TestNG 7 |
| BDD | Cucumber 7 (cucumber-java, cucumber-testng) |
| Design Pattern | Page Object Model |
| Test Data | JSON (Jackson) and Excel (Apache POI) |
| Reporting | Extent Reports |
| Build Tool | Maven (with profiles) |
| Version Control | Git, GitHub |

## Key Features

- Page Object Model for reusable, maintainable page classes
- Two separate Maven profiles: TestNG UI suite and Cucumber BDD suite
- Cucumber feature scenarios for the payment flow, run through a TestNG runner
- TestNG listener with Extent Reports and a screenshot utility
- Retry mechanism (`RetryTransformer`) to re-run flaky failed tests
- Data-driven testing with JSON and Excel readers
- Positive and negative test scenarios

## Test Coverage

| Module | Test Class / Runner | Test Cases |
|--------|--------------------|-----------|
| Login | `LoginTest` | 05 |
| Products | `ProductTest` | 05 |
| Search | `SearchTest` | 06 |
| Cart | `CartTest` | 05 |
| Payment (BDD) | `PaymentTestRunner` | 02 |
| **Total** | | **20+** |

## Project Packages

- `automation_exercise_tests` – TestNG test classes (Login, Product, Search, Cart)
- `automation_exercise_runners` – Cucumber TestNG runner (`PaymentTestRunner`)
- `automation_exercise_listeners` – TestNG listener and retry transformer
- `automation_exercise_base` – base setup (browser/driver initialization)
- `automation_exercise_pages` – Page Object classes: `LoginPage`, `SignUpPage`, `ProductsPage`, `CartPage`, `PaymentPage`, `OrderConfirmationPage`
- `automation_exercise_utilities` – helpers: `JsonReader`, `ExcelReader`, `Extent_Report`, `getScreenShotUtils`, data models (`ProductData`, `CartData`, `CartItemData`) and `GlobalData.properties`
- `automation_exercise_stepdefinitions` – Cucumber step definitions (`PaymentStepDefinitions`)

## Prerequisites

- Java JDK 17
- Maven 3.x
- Google Chrome (or your configured browser)
- Git


## ▶️ How to Run
**Prerequisites:** JDK [version], Maven, Chrome/[browser]

```bash
git clone https://github.com/Pradeep-07-jpg/Automation-Exercise-Selenium-Automation-Framework.git
cd Automation-Exercise-Selenium-Automation-Framework
mvn clean test
```
To run a specific suite: `mvn test -DsuiteXmlFile=testng.xml`

## 📊 Reports
Reports are generated in `Reports/index.html`. <img width="1915" height="790" alt="image" src="https://github.com/user-attachments/assets/95216139-1bf1-4646-80bc-b948817535d5" />


## Author

**Pradeep A** – QA Engineer (Manual + Automation)

**LinkedIn:** https://www.linkedin.com/in/pradeep-qa

**Email:** pradhip2207@gmail.com
