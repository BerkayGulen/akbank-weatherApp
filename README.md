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

