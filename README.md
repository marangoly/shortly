# SHORTLY - URL Shortener Application

Shortly is an API for shortening urls.

The following are the requirements:
   * Design and implement an API for short URL creation
   * Implement forwarding of short URLs to the original ones

### Tech Stack
   * Spring Boot for RESTful Web Services
   * Angular for frontend
   * Spring Boot in-memory H2 database
   * Mockito for Service Layer Test
   * Docker for distribution

### How shortcode is generated?

Each url is stored in the database with a unique id. The id is convered to base 62, as the total number of possible characters in the short code is 62 (a-zA-Z0-9). Each digit in base 62 code is mapped to one of the possible characters as
0 - a 
1 - b
.
.
.


### Steps to run the application locally

* From the root directory run the below mentioned command
```
mvn clean install && java -jar shortly-app/target/shortly-app-0.0.1.SNAPSHOT.jar
```
* Now access the UI from *http://localhost:9001*

### Steps to run using Dockerfile

* Run the below command to make use of the Dockerfile

```
docker build -t app/shortly . && docker run -p "9001:9001" app/shortly
```

### Steps to run using docker-compose

* Run the below mentioed command to make use of docker-compose

```
docker-compose up
```

### Prebuilt docker image

A prebuilt docker image of the application is already available in docker hub. To run it locally

```
docker run -p "9001:9001" marangoly/shortly:0.0.1
```

### Usage

* localhost:9001/api/urls to get all available urls
* localhost:9001 to homepage
* localhost:9001/api/{shortcode} to use shortened url 
