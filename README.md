# Doctor Patient Management System

This Spring Boot application manages doctors and patients, and provides doctor suggestions based on patient symptoms.

## Features

- Add and remove doctors
- Add and remove patients
- Suggest doctors based on patient symptoms and location

## Technologies Used

- Java 17
- Spring Boot 3.3.1
- Spring Data JPA
- H2 Database
- Maven
- Swagger UI for API documentation

## Getting Started

### Prerequisites

- JDK 17
- Maven 3.9.8

### Installation

1. Clone the repository:
    git clone https://github.com/your-username/doctor-patient-system.git

2. Navigate to the project directory:
    cd doctor-patient-system

3. Build the project:
    mvn clean install

4. Run the application:
    mvn spring-boot:run

The application will start running at `http://localhost:8080`.

## API Endpoints

Access Swagger UI for full API documentation: `http://localhost:8080/swagger-ui.html`

### Doctors

- POST `/api/doctors`: Add a new doctor
- DELETE `/api/doctors/{id}`: Remove a doctor

### Patients

- POST `/api/patients`: Add a new patient
- DELETE `/api/patients/{id}`: Remove a patient

### Suggestions

- GET `/api/suggestions/{patientId}`: Get doctor suggestions for a patient

## API Usage Example

Add a Doctor

Request:
  ```http
  POST /api/doctors
  Content-Type: application/json
  
  {
  "name": "Dr. John Doe",
  "city": "DELHI",
  "email": "john.doe@example.com",
  "phoneNumber": "1234567890",
  "speciality": "ORTHOPAEDIC"
  }

Response:

  {
    "id": 1,
    "name": "Dr. John Doe",
    "city": "DELHI",
    "email": "john.doe@example.com",
    "phoneNumber": "1234567890",
    "speciality": "ORTHOPAEDIC"
  }

Add a Patient

  Request:
  
    POST /api/patients
    Content-Type: application/json
    {
      "name": "Jane Smith",
      "city": "DELHI",
      "email": "jane.smith@example.com",
      "phoneNumber": "9876543210",
      "symptom": "ARTHRITIS"
    }

Response:

  {
    "id": 1,
    "name": "Jane Smith",
    "city": "DELHI",
    "email": "jane.smith@example.com",
    "phoneNumber": "9876543210",
    "symptom": "ARTHRITIS"
  }

Get Doctor Suggestions

Request:

  GET /api/suggestions/1

Response:
  
  [
    {
      "id": 1,
      "name": "Dr. John Doe",
      "city": "DELHI",
      "email": "john.doe@example.com",
      "phoneNumber": "1234567890",
      "speciality": "ORTHOPAEDIC"
    }
  ]


To run the automated tests:
  mvn test
