### Step 1: Set Up application.properties

Create a file named **application.properties** with the following content:

    spring.datasource.url=jdbc:mariadb://localhost:3306/DB_NAME
    spring.datasource.username=DB_USERNAME
    spring.datasource.password=DB_PASSWORD
    spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
    spring.jpa.show-sql=true

Replace DB_NAME, DB_USERNAME, and DB_PASSWORD with your actual MariaDB database name, username, and password.

### Step 2: Set Up secret_key.env

Create a file named **secret_key.env** with the following content:

    JWT_SECRET_KEY=your_secret_key

Replace your_secret_key with your desired secret key for JWT token generation.

### Usage Notes:

The **application.properties** file contains configuration settings for your Spring Boot application, particularly related to the database connection and JPA settings.
The **secret_key.env** file stores the secret key used for JWT token signing.

After creating and configuring these files, your application will be able to use the provided database connection settings and the secret key needed to generate JWT tokens.