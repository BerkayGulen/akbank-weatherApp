# Akbank WeatherApp
#### This is my graduation project from Akbank-patika.dev Java Spring Bootcamp. I design a weather App where users can sign up, log in and list the weather forecast about their desired city. Also, users can be able to save their favourite cities for quick access. I used openFeign to fetch data from OpenWeatherMap API.
## Technologies
- Java Spring Boot 
- ReactJS
- Swagger 
- Spring Cloud OpenFeign
- PostgreSQL

## Features
- User can Login 
- User can Sign up
- Username and email must be unique
- User can display 5 Day / 3 Hour Weather Forecast for desired City
- User can save their favourite cities

## API Documentation
#### I used Swagger for my API documentation. 
![image](https://github.com/BerkayGulen/akbank-weatherApp/assets/76843587/d8ded4ee-6596-4755-90e4-e61f4e8ddd18)

## Logging and Error handling
#### I store my logs locally on my system. My log file can be max 100 MB and it will delete itself periodically after 7 days. For the error handling mechanism, I used controller advice. I handle my custom error messages and general errors here.

## Test
#### I created a test database on PostgreSQL for my tests. I added my connection properties under the test folder in the application.properties file. Also, I added scheme.sql and data.sql for adding dummy data for tests. I have tried to cover every controller and business layer methods while I am testing.
![image](https://github.com/BerkayGulen/akbank-weatherApp/assets/76843587/568d472a-6f48-417d-9d56-5f3f30ff12e5)

## User Interface
### Login Page
![image](https://github.com/BerkayGulen/akbank-weatherApp/assets/76843587/08e2889b-898f-4775-9e6f-725cefa443e0)
### Sign Up Page
![image](https://github.com/BerkayGulen/akbank-weatherApp/assets/76843587/a5eb4899-f62d-4b2d-9543-83b907454046)
### Home Page for Weather Forecast
![image](https://github.com/BerkayGulen/akbank-weatherApp/assets/76843587/9718641a-db5b-47a5-b0c6-8e9649a9869f)
![image](https://github.com/BerkayGulen/akbank-weatherApp/assets/76843587/24b7fdc7-5f20-49ad-8753-8a626eee2182)




