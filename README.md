# Vehicle log
TODO

More generic approach  
Tests

## Task

Create a simple REST service that is able to accept .csv file and store all its data. Allow dynamic filtering.  

### Environment & Dependencies

* Java Version 17
* Lombok
* Spring
* Springdoc
* Postgres
* JPA
* JUnit
* Mockito
* Gradle
* Docker
* Docker-compose
* Shell script

## Setup & Run

### Build

* Navigate to desired file system location and clone project with  
  `git clone https://github.com/dejan-jesic/vehiclelog.git`
* Navigate to the root with `cd vehiclelog/` and run `./gradlew clean build`.
  The Mentioned command will run complete lifecycle which includes unit tests.

### Run

* Make sure ports `8080` and `5432` are free
* Navigate to the root of the project
* Run `sh run.sh` which will run `docker-compose.yml` and start docker containers
* **After ~30 sec** you can run `sh initialize.sh`. Script will upload all 4 provided files.
* Test query by running `sh filter.sh` script. It will ask you for the input, there are 2 .json
files in /demo package.
* Test invalid query by running `sh invalid-filter.sh` script.
* At the end don't forget to stop all containers with `sh stop.sh`

### Swagger API description

* http://localhost:8080/swagger-ui.html

## Developer comments

* The application is covered with some unit and one integration test. 
I added them just to give you an insight into how I write tests. 
However, due to time limitations, they are not as detailed and in-depth as I usually prefer.
* Security was not a requirement, so I didn't implement any security measures.
* The code is written with a strong emphasis on readability and maintainability 
since it is a challenge that will be reviewed by a person.
* I didn't have clear requirements for column types, and I'm not familiar with the domain. 
Therefore, I decided to use double (DECIMAL) for all numeric values from the .csv files. 
It seems that some of these values might be integers.
* The same goes for statuses. I prefer to use enums instead of strings, both at the database level and in the Java code. However, in this case, I used booleans for columns with only two possible values (on/off).

## Major improvements

* For this use case, a NoSQL database might be a better choice.
* GraphQL can provide dynamic search capabilities, so it's worth considering for this project. 

## Other improvements

There are several other areas where improvements could be made. Here are some suggestions:
* Adding caching for vehicle searches can greatly improve performance.
* Introducing role-based security, where different roles have access to different endpoints.
* To enhance performance while parsing .csv files, we can use index-based headers. 
However, this means that the order of columns cannot be changed.
* I would use TSID as the table ID. You can find more details here: https://vladmihalcea.com/uuid-database-primary-key/#:~:text=Using%20the%20standard%20UUID%20as,a%20B%2BTree%20index%20key.
* If required, auditing functionality can be added.
* Migration tools like Flyway can be used for managing database migrations.
* Database constraints can be added to enforce data integrity.
* Custom validators can be used to enhance validation handling and 
provide clear error messages to API consumers.
* Springdoc documentation can be expanded to include request-response body types and all relevant fields.
* PostgreSQL offers advanced indexing options and features such as table partitioning, 
which can improve performance for large datasets.
* Supported search operations in VehicleLogSearchValidator.java can be defined
in a property file.
* Ignore demo data and scripts while building .jar file.