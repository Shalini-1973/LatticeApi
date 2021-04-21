Libraries Used :
	spring-boot-starter-data-jpa
		I have used MySQL, So, the purpose of usi JPA is to unify and easy access to the relational database system.It uses all features defined by JPA specification, especially the entity, association mappings, and JPA's query capabilities.
		
	spring-boot-starter-web
		I have used this dependency because the single spring-boot-starter-web dependency transitively pulls in all dependencies related to web development.

	mysql-connector-java
		This dependency is used for the connnection to the mysql database.
		
	spring-boot-starter-security
		I have added this dependency on the classpath, because spring boot application automatically requires the Basic Authentication for all HTTP endpoints.
	lombok
		Lombok is a java library tool that generates code for minimizing boiler plate code and this library replaces boilerplate code with easy to use annotation.
	springfox-swagger2
		The Springfox suite of java libraries are all about automating the generation of machine and human readable specifications for JSON APIs written using the spring family of projects.
	springfox-swagger-ui
		The springfox-swagger-ui web jar ships with Swagger UI.It adds a JSON endpoint /swagger-resources which lists all of the swagger resources and versions configured for a given application.
	

Listed all plus points that I have used in the project.
	
Added Swagger : 
	 Using Swagger makes documenting our RESTful services much easier. Swagger 2 is an open source project used to describe and document RESTful APIs.Swagger UI allows other API developers or consumers to interact with the API’s resources without having any of the implementation logic in place.
I have used Springfox in our project.
To bring it in, I added the following dependencies in our Maven POM
<dependency>			
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>
In addition to Springfox, we also require Swagger UI, for that I include
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.8.0</version>
    <scope>compile</scope>
</dependency>

Now Configured Swagger 2 in the Application :
For our application, we will create a Docket bean in a Spring Boot configuration to configure Swagger 2 for the application. A Springfox Docket instance provides the primary API configuration with sensible defaults and convenience methods for configuration.You can go through the SwaggerConfig class for better understanding.

Used unit tests for API by using Mockito :
	Mockito is the most popular mocking framework in Java.To test the Service layer, we don't need to know or care about how the persistence layer is implemented. Ideally, we should be able to write and test our Service layer code without wiring in our full persistence layer.To test application we hit database multiple times, hitting database all the time is not good. So, avoid such kind of issue mockito used.Instead of repository going to database it will mock to mock and mockito mark data to service so the request not goes to database for testing purpose, that is the moto of mockito framework.
To achieve this, I used the mocking support provided by Spring Boot Test.
To check the Service class, I have an instance of the PatientService class and available as a @Bean so that I Autowired it in our test class.  I achieved this configuration using the @Test annotation. And the complete configuration code you can check the Test class of the application.

Added Authentication to access APIs :
	I configured Spring Boot 2 to access Swagger 2 using HTTP Basic authorization. SecurityConfig.java.class is annotated with @EnableWebSecurity to enable Spring Security web security support. we have extended WebSecurityConfigurerAdapter to override spring features with our custom requirements.Here we want our every request to be authenticated using HTTP Basic authentication. If authentication fails, the configured AuthenticationEntryPoint will be used to retry the authentication process.
Maven Configuration
It is a spring boot project in which I have added maven dependencies inside the POM.xml file. So by doing that we should not to worry about the configuration of the library to the application. The spring boot internally do all such configurations.

 Used Logging through log4j :
	Logging generates lots of data and all the time do want that. So to avoid that we need proper logging mechanism so that we don't have to pause all the data again and again. So, for that I used Log4j. So I added the spring-boot-starter-log4j dependency in the POM.xml file. Then whereever I want logger, I initialized log. And it is initialized by log4j logManager and getLogger method.
So this logger I have used every where in file as per our requirement like methods loger.info(), logger.error(), logger.warn() etc.

Deployed On Github :
Firstly, I login my github account and create a repository by name LatticeApi also added README file and I selected public option so any one can see my project through the link.  Then I came to my project on spring tool suite.
Then search git Ripository in the search bar and paste the link there. So we create a git repository instance. Then again share the project, it will create the main file of that repository. Lastly commit and push all the files over the github. 
