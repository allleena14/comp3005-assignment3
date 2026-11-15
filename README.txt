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
- PostgreSQL JDBC Driver (`postgresql-<version>.jar`) added to your project build path. Please replace the postgresql-42.7.14.jar file that I already included in the folder with your respective one if you use a different version

## Setup & Running Instructions
1. Open PostgreSQL (or pgAdmin) and run the script found in `data/schema.sql` in the Query tool to initialize the database and table.
2. Open `StudentApp.java` in the src folder and update your database credentials (`URL`, `USER`, `PASSWORD`).
3. Compile and run the application from your terminal or IDE (ensure the PostgreSQL JDBC driver is included in your classpath and that you're file drectory reaches the src folder):
   ```bash
   javac StudentApp.java
   java -cp .:postgresql-42.7.14.jar StudentApp

## Link to Video Demonstration: https://drive.google.com/file/d/13z-NRMvl64kni8uOxbkHtnVHclfE8gHP/view?usp=sharing