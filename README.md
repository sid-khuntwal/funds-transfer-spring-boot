# Funds Transfer Backend System
This project represents a Money transfer system between two users, This is a backend system built on Spring Boot using Spring Data JPA. The high level working can be seen below - 

![high level flow diagram](https://github.com/sid-khuntwal/funds-transfer-spring-boot/assets/76204320/62c706c2-8407-44b3-8ac9-b8fd5f9411da)

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

Sender and Receiver has ManyToOne realtionship.

## End Points

`/user` - 

```
/all (GET) - Get all users.
`/add` (POST) - Add new users.
`/{userId}` (GET) - Get user by userId.
`/update/{userId}` (PUT) - Update user.
`/delete/{userId}` (DELETE) - Delete user.
```

`/transactions` - 
```
`/transfer` (POST) - Transfer money.
`/all` (GET) - Get all transactions.
`/user?userId` (Get) - Get transactions with userId.
```

