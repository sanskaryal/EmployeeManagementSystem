# Employee Management System

This is a Spring Boot application for managing employee information, built with Java 17 and MySQL database.

## Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- Docker and Docker Compose (if you want to run with containers)
- MySQL (if running locally without Docker)

## Running the Application

### Option 1: Using Docker (Recommended)

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd EmployeeManagementSystem
   ```

2. Build and run the application using Docker Compose:
   ```bash
   docker-compose up --build
   ```

This will:
- Start a MySQL container
- Build and start the Spring Boot application
- The application will be available at http://localhost:8080

To stop the application:
```bash
docker-compose down
```

### Option 2: Running Locally

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd EmployeeManagementSystem
   ```

2. Configure MySQL:
   - Create a MySQL database named `mydatabase`
   - Update `src/main/resources/application.properties` with your MySQL credentials if different from the defaults

3. Build and run the application:
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

The application will be available at http://localhost:8080

## Database Configuration

The default database configuration is:
- Database: mydatabase
- Username: root
- Password: rootpassword
- Port: 3306

You can modify these settings in the `docker-compose.yml` file for Docker deployment or in `application.properties` for local deployment.

## Technologies Used

- Spring Boot 3.4.2
- Spring Data JPA
- MySQL
- Docker
- Maven
- Lombok
- Jakarta Validation

## Project Structure

The application follows a standard Spring Boot project structure:
- `src/main/java/` - Contains the Java source code
- `src/main/resources/` - Contains application properties and configurations
- `src/test/` - Contains test cases

## API Documentation

The API endpoints will be documented here once they are finalized.

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the terms specified in the LICENSE file. 