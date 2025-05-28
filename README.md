# Customer Rewards Program

## Problem Statement:

2 points for every dollar spent over $100 in a single transaction.
1 point for every dollar spent between $50 and $100 in a single transaction.
For example:

A $120 purchase earns:
2 × (120 - 100) = 40 points
1 × (100 - 50) = 50 points
Total = 90 points

## Features
- RESTful API to fetch reward points per customer per month and total.
- Dynamic month calculation (no hardcoded months).
- In-memory dataset for demonstration.
- Unit and integration tests with multiple customers and transactions.
- Exception handling and negative test scenarios.
- JavaDocs for all classes and methods.
- Follows Java coding standards and clean architecture.

## API Endpoint
`GET /api/rewards` - Returns reward summary for all customers.

## Project Structure
```
rewards-program/
├── src/
│   ├── main/
│   │   ├── java/org/example/
│   │   ├── Controller/
│   │   ├── data/
│   │   ├── Exception/
│   │   ├── Model/
│   │   ├── Service/
│   │   └── RewardApiApplication.java
│   └── test/
│       └── java/
│           └── TestCases/
├── .gitignore
├── pom.xml
└── README.md
```

## Technologies Used

Java 17
Spring Boot 3.x
Maven
JUnit 5
Lombok

## API Endpoints
GET /api/rewards
Returns reward points per customer per month and total.

## Sample Response
```
[
{
"customerId": "C002",
"customerName": "Bob",
"monthlyRewards": [
{
"month": "APRIL 2025",
"points": 70
},
{
"month": "MAY 2025",
"points": 110
},
{
"month": "MARCH 2025",
"points": 0
}
],
"totalPoints": 180
},
{
"customerId": "C001",
"customerName": "Alice",
"monthlyRewards": [
{
"month": "APRIL 2025",
"points": 250
},
{
"month": "MARCH 2025",
"points": 115
}
],
"totalPoints": 365
},
{
"customerId": "C003",
"customerName": "Charlie",
"monthlyRewards": [
{
"month": "MAY 2025",
"points": 0
}
],
"totalPoints": 0
}
]
```

## Testing
Unit tests for service classes.
Negative test cases for invalid inputs and edge cases.
Run tests using:


## Exception Handling
Handles invalid  transaction Amount.
Returns meaningful error messages with appropriate Message. 


## Clone the repository:

git clone https://github.com/Maha60/RewardService.git
cd RewardService

## Build the project:

mvn clean install


## Run the application:

mvn spring-boot:run


## Access the API at:

http://localhost:8080/api/rewards

## Notes
Do not check in target/ or .bin/ folders.
Do not upload zipped versions of the project.
Ensure code is formatted and follows naming conventions.
JavaDocs are included for all classes and methods.


