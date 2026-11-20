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
| Login | `LoginTest` | [5] |
| Products | `ProductTest` | [5] |
| Search | `SearchTest` | [6] |
| Cart | `CartTest` | [5] |
| Payment (BDD) | `PaymentTestRunner` | [1] |
| **Total** | | **22** |

## Project Packages

- `automation_excercise_tests` – TestNG test classes (Login, Product, Search, Cart)
- `automation_excercise_runners` – Cucumber TestNG runner (`PaymentTestRunner`)
- `automation_excercise_listeners` – TestNG listener and retry transformer
- `automation_excercise_base` – base setup (browser/driver initialization)
- `automation_excercise_pages` – Page Object classes: `LoginPage`, `SignUpPage`, `ProductsPage`, `CartPage`, `PaymentPage`, `OrderConfirmationPage`
- `automation_excercise_utilities` – helpers: `JsonReader`, `ExcelReader`, `Extent_Report`, `getScreenShotUtils`, data models (`ProductData`, `CartData`, `CartItemData`) and `GlobalData.properties`
- `automation_excercise_stepdefinitions` – Cucumber step definitions (`PaymentStepDefinitions`)

## Prerequisites

- Java JDK 17
- Maven 3.x
- Google Chrome (or your configured browser)
- Git


## Reports

After a run, reports are generated at: `Reports/` folder [confirm the exact file name, e.g. Reports/ExtentReport.html]

## Author

**Pradeep A** – QA Engineer (Manual + Automation)

**LinkedIn:** https://www.linkedin.com/in/pradeep-qa

**Email:** pradhip2207@gmail.com
