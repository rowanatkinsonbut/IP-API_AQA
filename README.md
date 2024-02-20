IP-API Test Automation
This project demonstrates automated tests for the IP-API service using TestNG, Maven, and Allure.

Getting Started
To get started with running the tests locally or in a Docker container, follow the instructions below.

Prerequisites
Java JDK 8 or higher installed
Maven installed (for running tests locally)
Docker installed (for running tests in a Docker container)
Allure command-line tool installed (for generating and serving Allure reports)
Installing Dependencies
Before running the tests, install the project dependencies by running:

bash
Copy code
mvn clean install
Running Tests
Locally
To run the tests locally, execute the following Maven command:

bash
Copy code
mvn clean test
In Docker Container
To run the tests in a Docker container, follow these steps:

Build the Docker image:
bash
Copy code
docker build -t ip-api .
Start the Docker container:
bash
Copy code
docker run -p 5050:5050 ip-api
Generating and Viewing Allure Report
After running the tests, generate the Allure report by executing:

bash
Copy code
Then, open the generated report in your web browser by navigating to [http://localhost:5050.](http://localhost:5050/allure-docker-service/latest-report)

Contributing
Contributions are welcome! Please feel free to submit issues or pull requests.

License
This project is licensed under the MIT License.
