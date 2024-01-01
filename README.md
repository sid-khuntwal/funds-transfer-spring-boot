# Funds Transfer Backend System
This project represents a Money transfer system between two users, This is a backend system built on Spring Boot using Spring Data JPA. The high level working can be seen below - 

![High level flow]()

There are two entities `User` & `Transaction`. 

`User`  -
```JSON
{
"name": "Siddahrth",
"email": "sid@sid.com",
"accBalance": "100"
}
``` 
`Transaction` - 
```JSON
{
"transaction": 5,
"sender": {
	"userId": 1,
	"name": "Siddharth",
	"email": "Siddharth@example.com",
	"accBalance": 100000
},
"receiver": {
	"userId": 3,
	"name": "jui",
	"email": "jui@jui.com",
	"accBalance": 2400
},
"ammount": 1000
}
```
