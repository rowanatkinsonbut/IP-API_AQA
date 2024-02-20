FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Stage 1: Build the Maven project and run all test (ignoring test failures)
RUN mvn clean test -Dmaven.test.failure.ignore=true -X

# Stage 2: Use fescobar/allure-docker-service image for allure server start
FROM frankescobar/allure-docker-service

# Copy the built Allure report files into the image
COPY --from=build /app/allure-results /app/allure-results

# Expose the port used by Allure Docker Service: http://localhost:5050/allure-docker-service/latest-report
EXPOSE 5050
