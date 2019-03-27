# rest-basic-auth
A simple CRUD RESTful web service implementation in JAVA using JAX-RS for web methods and apache-shiro for basic authentication.

User, roles and permissions are stored in database using JPA. Sample data is provided in data_entry.sql file.

I have deployed and tested this code on apache-tomee-7.0.3 application server.

NOTE: To be worked currectly you must make sure that commons-beanutils library version be greater than 1.9. In apache-tomee-7.0.3 I was forced to remove file "commons-beanutils-core-1.8.3.jar" from lib directory. The correct version of beanutils is included in the pom dependency.

##Sample REST service call:
-------------------------
NOTE: Authorization header (basic) should be provided on all calls.


###1) **to get person:**
GET http://localhost:8080/ts-core/persons/1

--------------------------
###2) **to create a new person:**
```
POST http://localhost:8080/ts-core/persons
content-type: application/json
body:
{
	"nationalCode": "0123456789",
	"firstName": "Navid",
	"lastName": "Mojir"
}
```
----------------------
###3) **to update a person:**
```
PUT http://localhost:8080/ts-core/persons/1
content-type: application/json
body:
{
    "firstName": "Navid",
    "lastName": "Mojir",
    "nationalCode": "0016115708"
}
```
----------------------
###4) **to delete a person:**
```
DELETE http://localhost:8080/ts-core/persons/1
```

##Notes:
------
- Do not forget to configure persistence.xml correctly.
