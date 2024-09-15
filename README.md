
# Spring Security Web Application

## Overview

This is a simple web application built using the **Spring Framework** that integrates **Spring Security** for authentication and authorization. It uses **Spring Data JPA** for database interaction, **MySQL** as the database, and **Maven** as the build tool. The application secures various pages based on user roles, and each user sees a different homepage depending on their role.

## Features

- **User Authentication**: Users log in using a username and password stored in the MySQL database (passwords are encrypted using **BCrypt**).
- **Role-based Authorization**: Users have different roles (e.g., Admin, User) and can access specific pages based on their roles.
- **Custom Homepages**: Each user is directed to a different homepage after login, depending on their role.
- **Login & Logout Forms**: Custom login and logout forms are provided by **Spring Security**.
- **RESTful API**: The application exposes some APIs via **Spring Data REST**.
  
## Technologies Used

- **Spring Framework** (Core, Web, Data JPA)
- **Spring Security** for securing web pages and APIs
- **Spring Data JPA** for database interactions
- **MySQL** as the database for user data storage
- **BCrypt** for password encryption
- **Maven** for build and dependency management

## Setup Instructions

### Prerequisites

Ensure you have the following installed on your system:

- Java 11+
- MySQL
- Maven
- Git

### Steps to Run the Application

1. **Clone the Repository**:
   ```bash
   git clone [https://github.com/yourusername/your-repo-name.git](https://github.com/MReza-90/Spring-Boot-Role-Based-Authentication-and-Authorization.git)
   cd your-repo-name
   ```

2. **Configure MySQL Database**:
   - Create a MySQL database named `your-database-name`.
   - Update the `application.properties` (or `application.yml`) file located in `src/main/resources/` with your database configurations:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run the Application**:
   Use Maven to build and run the application:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application**:
   Once the application starts, it will be available at `http://localhost:8080`. Users can log in via the login page located at `/showMyLoginPage`.

### User Authentication

- **Passwords**: User passwords are stored securely in the database using **BCrypt** encryption.
- **Login/Logout**:
  - Login form is available at `/showMyLoginPage`.
  - After a successful login, users will be redirected to their respective home pages based on their roles.
  - Logout is available at `/logout`.

### Role-Based Access

- Users are assigned roles such as `ADMIN`, `MANAGER` and 'EMPLOYEE, and can access different parts of the application based on their roles:
  - `/system/*` - Pages accessible only by users with the `ADMIN` role.
  - `/managers/*` - Pages accessible only by users with the `MANAGER` role.
  - `/` - Pages accessible by `EMPLOYEE` role.
  
  Each role will have different permissions to access the resources, ensuring secure role-based access control.
## Contributing

Feel free to contribute by submitting a pull request or opening an issue if you find any bugs or want to add new features!

