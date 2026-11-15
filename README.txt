# Assignment 3: Database Management Systems and Application Programming

## Overview
This project implements a PostgreSQL database schema for managing student records and a Java application utilizing JDBC to execute core CRUD operations (`getAllStudents`, `addStudent`, `updateStudentEmail`, `deleteStudent`).

## Repository Structure
- `database/schema.sql`: SQL script to create the database, `students` table, constraints, and initial records.
- `src/StudentApp.java`: Main Java application handling database connection and CRUD functions.
- `README.md`: Project documentation and setup guide.

## Prerequisites
- Java Development Kit (JDK 8 or higher)
- PostgreSQL installed and running locally
- PostgreSQL JDBC Driver (`postgresql-<version>.jar`) added to your project build path

## Setup & Running Instructions
1. Open PostgreSQL (or pgAdmin) and run the script found in `database/schema.sql` to initialize the database and table.
2. Open `StudentApp.java` and update your database credentials (`URL`, `USER`, `PASSWORD`).
3. Compile and run the application from your terminal or IDE (ensure the PostgreSQL JDBC driver is included in your classpath):
   ```bash
   javac StudentApp.java
   java -cp .:postgresql-42.x.x.jar StudentApp