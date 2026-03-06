# OrangeHRM Test Automation Framework

## Framework Structure
```
ORANGEHRM-AUTOMATION
├── src/main/java
│   ├── base
│   │   └── BaseTest.java
│   ├── pages
│   │   ├── LoginPage.java
│   │   └── DashboardPage.java
│   ├── utils
│   │   ├── ConfigReader.java
│   │   ├── WaitUtils.java
│   │   ├── DriverFactory.java
│   │   └── CommonUtils.java
│   └── constants
│       └── FrameworkConstants.java
├── src/test/java
│   ├── tests
│   │   ├── LoginTest.java
│   │   └── DashboardTest.java
│   └── listeners
│       └── TestListener.java
├── src/test/resources
│   ├── config.properties
│   ├── testdata/
│   └── log4j2.xml
├── reports/
├── screenshots/
├── testng.xml
└── pom.xml
```

## Prerequisites
- Java 11+
- Maven 3.6+
- Chrome/Firefox/Edge browser

## Setup
1. Clone the repository
2. Update `config.properties` with your test data
3. Run `mvn clean install`

## Run Tests
```bash
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=LoginTest

# Run with TestNG XML
mvn test -DsuiteXmlFile=testng.xml
```

## Features
- Page Object Model (POM)
- Data-driven testing support
- Screenshot on failure
- TestNG listeners
- Configurable waits
- Multiple browser support
