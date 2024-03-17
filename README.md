# Train Ticket Booking Application

This is a simple Train Ticket Booking Application built on the Spring Boot framework. It provides APIs for purchasing tickets, getting ticket receipts, retrieving lists of users in particular sections, removing tickets, and modifying seats.

## APIs

### 1. Purchasing Ticket

- **Method:** POST
- **URL:** `http://localhost:8080/trainTicket/purchase`
- **Request Body:**
    ```json
    {
        "from": "London",
        "to": "France",
        "price_paid": 20,
        "user": {
            "firstName": "Karthikeyan",
            "lastName": "Marimuthu",
            "email": "mkarthikeyanlucky0212@gmail.com"
        }
    }
    ```

### 2. Getting Ticket Receipt using Email address

- **Method:** GET
- **URL:** `http://localhost:8080/trainTicket/receipt/{email}`

### 3. Getting List of Users in Particular Section A or B

- **Method:** GET
- **URL:** `http://localhost:8080/trainTicket/users/{section}`
- **Example:** `http://localhost:8080/trainTicket/users/B`

### 4. Removing ticket using Email address

- **Method:** DELETE
- **URL:** `http://localhost:8080/trainTicket/remove/{email}`

### 5. Modify Seat 

- **Method:** PUT
- **URL:** `http://localhost:8080/trainTicket/modify/{email}?newSeat=Seat3`
- **Response:** 
    - Positive: Seat Modified Successfully.
    - Negative: Seat Not Available. (if Seat is already booked by other person)

## How to Use

1. Send a POST request to purchase a ticket with the required details in the request body.
2. Use a GET request to retrieve the ticket receipt by providing the email address.
3. Retrieve a list of users in a particular section by sending a GET request with the section (A or B) in the URL.
4. Remove a ticket using the DELETE method by providing the email address.
5. Modify a seat by sending a PUT request with the email and new seat information in the URL. The response will indicate whether the seat was successfully modified or not.

