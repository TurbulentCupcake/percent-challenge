
# CheckoutService

This application exposes API's to enable the user to calculate totals for a list of products and obtain prices for a specific product.

### Requirements:
1. OpenJDK Java 11 GA (build 11+28)
2. apache-maven-3.8.2

### Setup Instructions
1. Navigate to the `checkoutservice` project
2. Run `mvn clean install -DskipTests` to install dependencies
3. Run `mvn surefire:test` to run all unit tests
4. Run `mvn failsafe:integration-test` to run all integration tests
5. Run `java -jar .\target\checkoutservice-0.0.1-SNAPSHOT.jar` to start the application

### Usage

The application exposes two endpoints: 
1. `/calculatetotal` - POST - Returns the total for a list of product codes
   1. Example request for `/calculatetotal`:
    ```
    "headers": {
      "Id" : "1234"
    },
    "body": {
      "products":
      [
        "A",
        "B",
        "C",
        "D"
      ]
    }
    ```

2. `/price/{productCode}` - GET - returns the unit and volume pricing for `{productCode}`

Both endpoints are exposed through port `8080`

An OpenAPI spec that explains usage, expected status codes and associated response bodies of both the above API's has been attached and can be viewed at `src/main/resources/spec.yaml`.
This document can be passed around to interfacing applications to recreate models useful for interfacing with the API's 
exposed by this application.  

For simplicity purposes, this application doesn't use the swagger code generation tool to generate API models and thereby creating dependencies

### Assumptions
1. A request body without any product codes will return a 400 BAD REQUEST
2. The user can calculate the price for up to 100 items per request, to prevent long running requests
3. The app will accept product codes in lower case

### Notes
1. Product prices are defined statically in the `application.yml`
2. This application uses [Zerocode](https://github.com/authorjapps/zerocode) for the purposes of integration testing.
Zerocode allows developers to define .json files that represent test requests that are sent to the application and
enables verification of the subsequent response. These .json files can be viewed under `src/test/resources/integration_tests`. 
Each of them
are triggered through a corresponding test class (under `src/test/java/com/percent/checkoutservice/integrationtests`). 
For instance, `src/test/resources/integration_tests/post/post_example1.json` represents a test definition that sends 
the application a request with the product codes ["A","B","C","D","A","B","A] and expects a response
total of 13.25 and a response status of 200. 
This definition is triggered through `com.percent.checkoutservice.integrationtests.post.VerifyExamples#testExample1`. 
To run an integration test individually, the method corresponding to the test definition must be triggered, as defined previously
. All integration tests are run through the `com.percent.checkoutservice.integrationtests.IntegrationTestSuiteIT` and
can be triggered through Step 4 under Steps.
3. `post_example1.json`, `post_example2.json` and `post_example3.json` represent the three test cases defined 
in the problem definition that are expected to work. As mentioned previously, their corresponding trigger methods
are present in `com.percent.checkoutservice.integrationtests.post.VerifyExamples`

