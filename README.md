# Nuwe-Repte4

This is my project submitted for [Nuwe](https://nuwe.io/)'s challenge "Repte #4 - Operacions CRUD" on the programming league made for IT Academy.

## Installation & Usage

You can directly download the repository in zip format and, as it is a Maven project, import it into your preferred IDE (Eclipse, IntelliJ, etc.). 

Once you can open it in your IDE, make sure to open the `application.properties` file so that you can configure the database connection before trying to run the application.  
To persist I have used MySQL, so you will need to change the following lines:
```properties
spring.datasource.url = jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username = test
spring.datasource.password = 1234
```
In the url field, you can change the connection url, which in this case is `localhost:3306`, and the database in which the tables will be created by Hibernate, which in this case is `test`. 
Also, you must change both `username` and `password` to values that can be used with your connection and have sufficient permissions to perform CRUD operations in the database. 

Once this is done, you should already be able to run the application and test it using [Postman](https://www.postman.com/) (see 'Postman tests' section at this README).
## Structure

In this CRUD I have chosen to persist two simple entities, **Fruita** & **Verdura**, both of which have the same two fields (not including Id).
The endpoints to which requests can be made can be seen documented [here](http://localhost:3000/swagger-ui.html) once the application is running.

The project package structure is the following:

* **Configuration**
It contains configuration classes, in this case only Swagger needed to be configured.
* **Controllers**   
It contains controllers for both entities, giving responses to the requests by using the endpoints.
* **Exceptions**  
It contains custom exceptions as well as a ControllerAdvisor class to handle exceptions and return Response Entities as needed.
* **Model**
	* **Domain**  
	There are both entities persisted.
	* **Repositories** 
	In this package you can find interfaces for both entites, extending the appropiate JpaRepository so that queries can be made.
	* **Services**
	For each entity there is a service class which is used to be the middle point between the other layers (repository to controller or viceversa, and also throwing exceptions when needed).


As you can see, I did not follow the structure recommended in the challenge description, because I am more comfortable with this one.
Also, to handle the entity validation I did not need a middleware package with classes to validate the entities, as I have used annotations for the same purposes.  
Those annotations can be seen in the domain layer (`@NotBlank`, `@NotNull`, `@Min` to make rules for each field in the entity) and in the controller layer (`@Valid` to show that the entity must follow the rules made).

##  Postman tests

I have uploaded a json file that contains a Postman collection with requests written for the purpose of testing if they work properly and if their responses are exactly what we should expect. To run these tests, you can import the file into Postman as a collection.  
Please take in mind that all tests that need it use the path variable `id=1`, so if there is no entity with this id these tests might not always pass, as the response code will be `404` instead of the expected one.
