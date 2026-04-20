Smart Campus REST API

A RESTful web service built using Java, JAX-RS (Jersey), and Maven to manage rooms, sensors, and sensor readings in a smart campus environment.

Features

->Manage Rooms (create, view, update, delete)

->Manage Sensors assigned to rooms

->Record and retrieve Sensor Readings

->Filter sensors by type

->Prevent deletion of rooms with active sensors

->RESTful API design with proper HTTP status codes

Technologies Used

->Java

->JAX-RS (Jersey)

->Maven

->Grizzly HTTP Server

How to Run the Project
1. Clone the repository
   
    git clone https://github.com/kethmi916/client-server-architecture-coursework.git

    cd client-server-architecture-coursework

2. Build the project

    mvn clean install

3. Run the server

    Run the Main class in your IDE
    OR via Maven
    mvn exec:java

4. Access API

     Base URL:

       http://localhost:8080/api/v1

API Endpoints

Rooms
| Method | Endpoint    | Description       |
| ------ | ----------- | ----------------- |
| GET    | /rooms      | Get all rooms     |
| GET    | /rooms/{id} | Get room by ID    |
| POST   | /rooms      | Create a new room |
| PUT    | /rooms/{id} | Update room       |
| DELETE | /rooms/{id} | Delete room       |

Sensors
| Method | Endpoint                  | Description     |
| ------ | ------------------------- | --------------- |
| GET    | /sensors                  | Get all sensors |
| GET    | /sensors?type=Temperature | Filter sensors  |
| GET    | /sensors/{id}             | Get sensor      |
| POST   | /sensors                  | Create sensor   |
| PUT    | /sensors/{id}             | Update sensor   |
| DELETE | /sensors/{id}             | Delete sensor   |

Sensor Readings
| Method | Endpoint               | Description  |
| ------ | ---------------------- | ------------ |
| GET    | /sensors/{id}/readings | Get readings |
| POST   | /sensors/{id}/readings | Add reading  |

Sample cURL Commands

Get all rooms

	curl http://localhost:8080/api/v1/rooms
	
Create a room

	curl -X POST http://localhost:8080/api/v1/rooms \
	
	-H "Content-Type: application/json" \
	
	-d "{\"id\":3,\"name\":\"Lab\",\"capacity\":40}"
	
Get Sensors

	curl http://localhost:8080/api/v1/sensors
	
Filter sensors

	curl "http://localhost:8080/api/v1/sensors?type=Temperature"
	
Add sensor reading

	curl -X POST http://localhost:8080/api/v1/sensors/1/readings \

	-H "Content-Type: application/json" \

	-d "{\"value\":25.5}"
	
Get sensor readings

	curl http://localhost:8080/api/v1/sensors/1/readings

Error Handling

404 Not Found → Resource does not exist

400 Bad Request → Invalid input

403 Forbidden → Sensor in maintenance

409 Conflict → Cannot delete room with sensors

Note

Data is stored in-memory (DataStore)

Designed for demonstration purposes

Tested using Postman

Author

Kethmi Edirisinghe
	
