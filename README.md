# Rock Paper Scissors
A Spring Boot Microservice for the game of Rock Paper Scissors

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Building the project
Project is bundled with the maven
```
mvn clean install
```

## Running the tests
```
mvn clean test
```

## Run the application
### Using java jar command
```
java -jar target/rockpaperscissors-<version>.jar
```
### Using Docker
##### Build the Docker image
```
docker build -t rockpaperscissors .
```
##### Run Docker container
```
docker run -p 8080:8080 -dit rockpaperscissors:latest
```

## Built With
* SpringBoot - The web framework used
* Maven - Dependency Management
* Docker - Containerization

This application uses in memory database **H2** to store the game results.

**How to test services**
Access end point http://localhost:8080/rps/{playername}/{shape} as HTTP get method.
Provide Player name and shape in the URL. Shape can be "R", "P" or "S".
