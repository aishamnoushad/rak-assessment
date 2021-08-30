# rak-assessment
# Assessment

The assessment is done as two part 
front end:- angular http://localhost:4200
As I don't have enough experience in angular I tried my best for validation but last minute it shows errors so I commented those.
 Rest of all works smooth.


backend : rest api using springboot
Need to create a database named employee in local db. 
Once the project runs, it will create the tables and 
Department code and name should be entered into the department table.
spring boot application port is 8180 and angular application port is 4200

Get All Employees:
HTTP Method: GET
http://localhost:8180/api/v1/employees
------------------------------------------------------
Get Employee By Id:
HTTP Method GET
http://localhost:8180/api/v1/employees/{id}
----------------------------------------------------------
Create Employee:
HTTP Method - POST
http://localhost:8180/api/v1/employees

RequestBody
{
   "id":1234567,
    "employeeName":"Manal",
	"dateOfJoining":"2017-09-14T23:28:56.782Z",
	"salary":130000,
	"department":"AD"
}
-------------------------------------------------------------------
Update Employee
HTTP Method - POST
http://localhost:8180/api/v1/employees/{id}

RequestBody
{
   "id":1234567,
    "employeeName":"Manal",
	"dateOfJoining":"2017-09-14T23:28:56.782Z",
	"salary":130000,
	"department":"AD"
}
-----------------------------------------------
Delete Employee By Id:
HTTP Method - DELETE
http://localhost:8180/api/v1/employees/{id}
--------------------------------------------------------------
Search with employeeNumber and employee name
HTTP Method - GET
http://localhost:8180/api/v1/employees/{id}/{employeeName}











