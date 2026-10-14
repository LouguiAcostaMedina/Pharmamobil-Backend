# PharmaSoft - Backend

PharmaSoft is the backend service for the PharmaMobile application. It provides RESTful APIs for managing pharmaceutical products, categories, clients, and sales. It is built using Java and Spring Boot.

## Prerequisites

- Java 24 (or at least 17)
- Maven
- (Optional) Oracle Database if using the default profile

## Running Locally for Development (H2 Profile)

For local development and testing, you can use the `h2` profile. This profile configures an in-memory/file-based H2 database, which avoids the need to set up Oracle Database or Docker.

### 1. Start the Server with H2 Profile

Navigate to the project root and run:

```bash
mvnw spring-boot:run "-Dspring-boot.run.profiles=h2"
```

This will:
- Start the server on port `8080`.
- Automatically create the database schema (using Hibernate `ddl-auto=update`).
- Seed initial data (Categories and Products) via the `H2DataSeeder` component.
- The H2 database file will be stored in `./data/pharmadb.mv.db`.

### 2. Verify Endpoints

You can verify the API is running correctly using `curl` or Postman. For example, to retrieve the paginated list of products:

```bash
curl -i "http://localhost:8080/api/v1/productos?pagina=0&tamanio=20&ordenarPor=id&direccion=asc"
```

## Testing

To run the unit and integration tests using the `h2` profile, execute:

```bash
mvnw clean test
```

Note: The tests are configured to use `@ActiveProfiles("h2")` by default.

## API Documentation (Swagger/OpenAPI)

Once the server is running, you can explore the interactive API documentation at:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
