# Forum_Spring-Boot-API-Rest
It consists of an API for a school forum, in which the students can register any doubts about the courses they are taking. It was used H2 database and you can monitor this API using Spring Boot Admin. 

# Running the Forum project
If you want to run the Forum application, you have to download the forum project, import a maven project in your IDE (it was used eclipse) and execute:

It was set to run locally in port 8080.

Set profile "test" in the classes AuthenticationController and SecurityConfigurations

@Profile(value = { "test" })

- For the test profile, no authentication is needed.

Method:

- GET: localhost:8080/topics/${id}
- POST: localhost:8080/topics
  
  Headers: 
  Content-Type: application/json
  
  body (raw):
        {"title": "type the title", "message": "type the message", "courseName": "type the name of the course"}
        

- PUT: localhost:8080/topics/${id}
  
  Headers: 
  Content-Type: application/json
  
  body (raw):
        {"title": "type the title, if you want to update this information", "message": "type the message, if you want to update this information"}
        
- DELETE: localhost:8080/topics/${id}

OBS: I have registered only 3 registers in the database, if you want to change, access data.sql in the project.

# Environment variables (Deploy):

This project use environment variables in the production environment.

In order to export them type this command in the cmd:

OBS: No change is needed, if you set to the test profile, as explained above. Please, undo the changes.

(Example with user, password and secret):

java -jar -DFORUM_DATABASE_URL=DATABASE:h2:
mem:forum
-DFORUM_DATABASE_USERNAME=sa
-DFORUM_DATABASE_PASSWORD=
-DFORUM_JWT_SECRET=123456 forum.jar

OBS: This project also contains classes to set authentication via token.

# Running the Spring Boot Admin

You can also download the Spring Boot Admin, import the project and run with the forum API in order to monitor the API.
It was set to run in the port 8081 "http://localhost:8081/applications"

