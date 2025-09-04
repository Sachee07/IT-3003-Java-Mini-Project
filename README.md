# Student Database Mini Project

### Requirements
- Java 8+
- MySQL
- JDBC Driver

### Setup Instructions
1. Create the database:
   ```sql
   CREATE DATABASE studentdb;
   USE studentdb;
   CREATE TABLE students (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       age INT NOT NULL,
       email VARCHAR(100) UNIQUE NOT NULL
   );
