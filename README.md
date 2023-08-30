# **UserAuthSystem**

## **Introduction**
I wanted to build a basic Vue & Java app with JWT token integration & user role-based access control.

## **Description**
The project includes a simplistic SPA frontend client build with Vue, where users (depending on their role, e.g. admin) can view and edit products and other users. The backend API was built with Java Spring and uses a MariaDB database deployed locally with Docker.
From working on this project I've learned more about building fullstack applications with Vue and Java Spring, I've also gained some insight into the challenges involved in constructing a reliable authentication system.

## **How to run locally**

### 1.	Clone the project:
```
git clone https://github.com/jfMoller/UserAuthSystem.git
```
### 2. Install and set up Maven (to enable running Java Spring from the command line):

   - [Windows tutorial](https://www.youtube.com/watch?v=YTvlb6eny_0)

   - [Mac tutorial](https://www.youtube.com/watch?v=cbhCNjjvGOw).

### 3.	Create a new Docker container with a MariaDB data source
```
See instructions below.
```
### 4.	Setup the connection to MariaDB and configure your secret key
```
See instructions below.
```

### 5.	Install local dependencies in the project directory
```
cd client
    npm i
```
### 6.	Run the project
```bash
cd client
    npm run dev
```

## **How do I get started with Docker & MariaDB?**
### 1. Download Docker desktop:
https://docs.docker.com/get-docker/

### 2.Pull the official MariaDB image:
Open a terminal and run the following command:
```bash
docker pull mariadb
```
### 3.Run the MariaDB Container: 
Once you have the MariaDB image, you can create and run a container using the docker run command. For example:
```bash
docker run -d --name my_mariadb -e MYSQL_ROOT_PASSWORD=my_password -p 3306:3306 mariadb
```
* Replace "my_mariadb" with your preferred container name.
* Replace "my_password" with your desired root password.

### 4. Verify the Running Container: 
To check if the MariaDB container is running, use the following command:
```bash
docker ps
```
### 5. Download DataGrip (or an equivalent database IDE)
https://www.jetbrains.com/datagrip/download/#section=windows

### 6. Create a new data source (DataGrip)
Open DataGrip and create a new data source, select "MariaDB". Enter your root password from step 3 to access the container.

### 7. Create a database in your container
Create a new database with a name of your choice, the database should be populated automatically when you run the project.

## **How do I setup a connection to MariaDB and configure my secret key?**
### Step 1: Set Up application.properties

Create a file named **application.properties** in your _backend/api/src/resources_ folder with the following content:

    spring.datasource.url=jdbc:mariadb://localhost:3306/DB_NAME
    spring.datasource.username=DB_USERNAME
    spring.datasource.password=DB_PASSWORD
    spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
    spring.jpa.hibernate.ddl-auto=update

Replace DB_NAME, DB_USERNAME, and DB_PASSWORD with your actual MariaDB database name, username, and password from step 3.

### Step 2: Set Up secret_key.env

Create a file named **secret_key.env** with the following content:

    JWT_SECRET_KEY=your_secret_key

Replace your_secret_key with your desired secret key for JWT token generation, for example:
```
JWT_SECRET_KEY=e9328234925F73Kc32rNfej932RKLQFEW31rwgwgw74gwnfgwkyFKEhg74h88f8k78g34fgowfwf8wgfwof8w
```
Finally, you might need to download an .env reader plugin for your IDE.