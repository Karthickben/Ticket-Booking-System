# Ticket-Booking-System
The Application has been implemented using the Microservice Architecture. This system is decomposed into below four microservices. Each microsevices is an individual rest service and can communicate with other services.
   
   1) User Micro Service:  Handles customer/admim details. 
   2) Movie Micro Service: Handles movie details.
   3) Theatre Micro Service: Handles theatre, screen and show related details.
   4) Booking Micro Service: Handles ticket booking and cancellation.
   
   * API Gateway: Zuul server will be used as the API gateway and it routes all the client’s requests to the individual services.
   * Service Registry: Eureka server has been used as the registry server. 
   * Cloud config server: All the common properties of microservices will be stored centrally in Git. Cloud config sever helps microservices to fetch the properties from GIT https://github.com/Karthickben/TicketBookingConfigs

 

## Prerequisites
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
        Hibernate
        Hibernate validator
        Model Mapper
        Swagger libraries
        Netflix Hystrix for fallback
        
## Clone
To get started you can simply clone this repository using git:
        
        git clone https://github.com/Karthickben/Ticket-Booking-System.git
        
## Build an executable JAR

        You can run the application from the command line using:
        mvn spring-boot:run
        
        Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
        mvn clean package
        
        Then you can run the JAR file with:
        java -jar target/*.jar
        
        Instead of mvn you can also use the maven-wrapper ./mvnw to ensure you have everything necessary to run the Maven build.
  
  
### Contact
   karthickben@gmail.com
