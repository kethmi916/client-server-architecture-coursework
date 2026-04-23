# Smart Campus REST API

A RESTful web service built using Java, JAX-RS (Jersey), Maven, and the Grizzly HTTP server to manage rooms, sensors, and sensor readings in a smart campus environment.

---

## API Design Overview

This API follows RESTful principles to manage a smart campus system consisting of Rooms, Sensors, and Sensor Readings.

- Rooms represent physical locations within the campus.
- Sensors are devices assigned to specific rooms.
- Sensor Readings maintain historical data for each sensor.

The API uses a hierarchical resource structure:

- `/rooms` → manage rooms  
- `/sensors` → manage sensors  
- `/sensors/{id}/readings` → manage readings for a specific sensor  

A sub-resource locator pattern is used to handle nested resources, improving modularity and scalability.

All data is stored in-memory using a shared DataStore. Business rules and validation logic are applied to maintain data integrity.

---

## Features

- Manage Rooms (create, view, update, delete)
- Manage Sensors assigned to rooms
- Record and retrieve Sensor Readings
- Filter sensors by type using query parameters
- Prevent deletion of rooms with active sensors
- Maintain consistency between sensor readings and current values
- RESTful API design with appropriate HTTP status codes
- Centralized exception handling and logging

---

## Technologies Used

- Java  
- JAX-RS (Jersey)  
- Maven  
- Grizzly HTTP Server  

---

## How to Run the Project

### 1. Clone the repository
git clone https://github.com/kethmi916/client-server-architecture-coursework.git

cd client-server-architecture-coursework


### 2. Build the project


mvn clean install


### 3. Run the server

Run the `Main` class from your IDE  
or use Maven:


mvn exec:java


### 4. Access the API

Base URL:


http://localhost:8080/api/v1


---

## API Endpoints

### Rooms

| Method | Endpoint        | Description            |
|--------|---------------|------------------------|
| GET    | /rooms        | Get all rooms          |
| GET    | /rooms/{id}   | Get room by ID         |
| POST   | /rooms        | Create a new room      |
| PUT    | /rooms/{id}   | Update a room          |
| DELETE | /rooms/{id}   | Delete a room          |

---

### Sensors

| Method | Endpoint                  | Description           |
|--------|--------------------------|-----------------------|
| GET    | /sensors                 | Get all sensors       |
| GET    | /sensors?type=Temperature| Filter sensors        |
| GET    | /sensors/{id}            | Get sensor by ID      |
| POST   | /sensors                 | Create a sensor       |
| PUT    | /sensors/{id}            | Update a sensor       |
| DELETE | /sensors/{id}            | Delete a sensor       |

---

### Sensor Readings

| Method | Endpoint                      | Description           |
|--------|------------------------------|-----------------------|
| GET    | /sensors/{id}/readings       | Get all readings      |
| POST   | /sensors/{id}/readings       | Add a new reading     |

---

## Sample cURL Commands

### Get all rooms

curl http://localhost:8080/api/v1/rooms


### Create a room

curl -X POST http://localhost:8080/api/v1/rooms

-H "Content-Type: application/json"
-d "{"id":3,"name":"Lab","capacity":40}"


### Get all sensors

curl http://localhost:8080/api/v1/sensors


### Filter sensors by type

curl "http://localhost:8080/api/v1/sensors?type=Temperature
"


### Add sensor reading

curl -X POST http://localhost:8080/api/v1/sensors/1/readings

-H "Content-Type: application/json"
-d "{"id":1,"timestamp":1710000000,"value":25.5}"


### Delete a room

curl -X DELETE http://localhost:8080/api/v1/rooms/3


---

## Error Handling

The API uses custom exception handling to provide consistent and meaningful responses:

- **400 Bad Request** → Invalid input data  
- **403 Forbidden** → Sensor is in maintenance state  
- **404 Not Found** → Resource does not exist  
- **409 Conflict** → Attempt to delete a room with active sensors  
- **422 Unprocessable Entity** → Invalid linked resource (e.g., non-existent room ID)  
- **500 Internal Server Error** → Unexpected server error  

Custom exception mappers ensure that internal server details are not exposed to clients.

---

## Notes

- Data is stored in-memory using a DataStore class  
- The application is designed for demonstration purposes  
- Tested using Postman  

---

## Author

Kethmi Edirisinghe
