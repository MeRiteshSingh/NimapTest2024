# NimapTest2024
1. *Spring Boot Setup:*
   - Spring Boot provides a convenient way to create stand-alone, production-grade Spring-based applications. You can start by creating a new Spring Boot project using Spring Initializr or your preferred IDE.
   - Make sure to include the necessary dependencies for Spring Web, Spring Data JPA, and any database driver (e.g., H2, MySQL, PostgreSQL).

2. *REST Controllers:*
   - Create REST controllers to handle the CRUD operations for both categories and products.
   - Annotate your controller methods with @GetMapping, @PostMapping, @PutMapping, and @DeleteMapping to define the API endpoints.

3. *Database Configuration (RDB):*
   - Configure your database connection in the application.properties or application.yml file.
   - Use an RDBMS (Relational Database Management System) like MySQL, PostgreSQL, or H2 (for development/testing).

4. *Annotation-Based Configuration:*
   - Spring Boot encourages annotation-based configuration over XML.
   - Use annotations like @Entity, @Table, @Column, and @OneToMany to define your data model and relationships.

5. *Category CRUD Operations:*
   - Implement the following APIs for categories:
     - GET /api/categories?page=3: Retrieve all categories (with pagination).
     - POST /api/categories: Create a new category.
     - GET /api/categories/{id}: Retrieve a category by ID.
     - PUT /api/categories/{id}: Update a category by ID.
     - DELETE /api/categories/{id}: Delete a category by ID.

6. *Product CRUD Operations:*
   - Implement similar APIs for products:
     - GET /api/products?page=2: Retrieve all products (with pagination).
     - POST /api/products: Create a new product.
     - GET /api/products/{id}: Retrieve a product by ID.
     - PUT /api/products/{id}: Update a product by ID.
     - DELETE /api/products/{id}: Delete a product by ID.

7. *One-to-Many Relationship:*
   - Define a one-to-many relationship between categories and products.
   - Annotate the appropriate fields in your entities (e.g., @OneToMany in the Category entity).
