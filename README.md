# Ticket-Booking-System
Online Cinema Ticket Booking system based on Micro Service Architecture. Ticket booking ticketing system is decomposed into below four microservices. Each microsevices is an individual rest api and can communicate with other services.
   
   1) User Micro Service:  Handles customer/admim details. 
   2) Movie Micro Service: Handles movie details.
   3) Theatre Micro Service: Handles theatre, screen and show related details.
   4) Booking Micro Service: Handles ticket booking and cancellation.
 

# Prerequisites
        Java 1.8
        Postgres Sql version- 4
        Spring boot 2 
        Spring boot cloud version -Hoxton
        Spring web/rest
        Spring Data Jpa
        Tomcat 9
        Maven version 3 or later
        Netflix eureka server for service discovery
        Netflix ribbon load balancer
        Spring cloud config server
        Netflix Zuul for api gateway
        
# Clone
To get started you can simply clone this repository using git:
        
        git clone https://github.com/Karthickben/Ticket-Booking-System.git
        
# Build an executable JAR
You can run the application from the command line using:

        mvn spring-boot:run
        Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:

        mvn clean package
        Then you can run the JAR file with:

        java -jar target/*.jar
        Instead of mvn you can also use the maven-wrapper ./mvnw to ensure you have everything necessary to run the Maven build.
  
  
