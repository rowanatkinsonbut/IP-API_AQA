# IP-API Test Automation

This project demonstrates automated tests for the IP-API service using TestNG, Maven, and Allure.
There's only one test with dataprovider for verifying if by specified address of server - server is located in Ukraine. 
Test have a data-set of domains and is running in parallel. The output is Allure report. Also there's ability
to create docker image with completed tests and allure server on it with results - basing on it you can
run container.

## Getting Started

To get started with running the tests locally or in a Docker container, follow the instructions below.

### Prerequisites
- Java JDK 8 or higher installed
- Maven installed (for running tests locally)
- Docker installed (for running tests in a Docker container)
- Allure command-line tool installed (for generating and serving Allure reports)

### Installing Dependencies
Before running the tests, install the project dependencies with test skip by running:

```bash
mvn clean install -DskipTests
```

### Running Tests
Locally

To run the tests locally, execute the following Maven command:
```bash
mvn test
```

### Generate Allure report
Locally

To generate allure report - go to project root directory and run next allure command
```bash
allure serve allure-results
```

### Docker guide
To create an image with completed tests and installed allure server with results run next docker commands:
1. Build docker image
```bash
docker build -t ip-api .
```
2. Run container based on built image
```bash
docker run -p 5050:5050 ip-api
```
3. After successful container start you can watch allure-report by next url:

[http://localhost:5050/allure-docker-service/latest-report](http://localhost:5050/allure-docker-service/latest-report)

### Contributing
Contributions are welcome! Please feel free to submit issues or pull requests.

### License
This project is licensed under the MIT License.


