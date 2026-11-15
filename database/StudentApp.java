import java.sql.*;

/**
 * Assignment 3 - Database Management Systems
 * Student Application demonstrating PostgreSQL connectivity and CRUD operations using JDBC.
 */
public class StudentApp {

    // Database connection parameters (Update URL, user, and password as needed)
    private static final String URL = "jdbc:postgresql://localhost:5432/assignment3_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Pnature14"; // Please replace with your PostgreSQL password

    public static void main(String[] args) {
        System.out.println("=== Starting Student Management Application ===\n");

        // 1. Read / Display initial records
        getAllStudents();

        // 2. Create / Add a new student
        addStudent("Alice", "Wonder", "alice.wonder@example.com", "2023-09-03");

        // 3. Update an existing student's email
        updateStudentEmail(1, "john.newemail@example.com");

        // 4. Delete a student record
        deleteStudent(3);

        // Display final state of the table
        getAllStudents();
    }

    /**
     * 1. getAllStudents(): Retrieves and displays all records from the students table.
     */
    public static void getAllStudents() {
        String query = "SELECT student_id, first_name, last_name, email, enrollment_date FROM students";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
            System.out.println("--- Current Students List in Database ---");
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String email = rs.getString("email");
                Date date = rs.getDate("enrollment_date");
                
                System.out.printf("ID: %d | Name: %s %s | Email: %s | Enrolled: %s%n",
                        id, fName, lName, email, date);
            }
            System.out.println("-----------------------------------------\n");
        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
        }
    }

    /**
     * 2. addStudent(...): Inserts a new student record into the students table.
     * Uses PreparedStatement to prevent SQL injection.
     */
    public static void addStudent(String firstName, String lastName, String email, String enrollmentDate) {
        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
             
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setDate(4, Date.valueOf(enrollmentDate));
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("[INSERT SUCCESS] Added student: " + firstName + " " + lastName);
            }
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    /**
     * 3. updateStudentEmail(student_id, new_email): Updates email for a specific student ID.
     */
    public static void updateStudentEmail(int studentId, String newEmail) {
        String updateSQL = "UPDATE students SET email = ? WHERE student_id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
             
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, studentId);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("[UPDATE SUCCESS] Updated email for Student ID: " + studentId);
            } else {
                System.out.println("[UPDATE FAILED] Student ID " + studentId + " not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating student email: " + e.getMessage());
        }
    }

    /**
     * 4. deleteStudent(student_id): Deletes a student record with the specified ID.
     */
    public static void deleteStudent(int studentId) {
        String deleteSQL = "DELETE FROM students WHERE student_id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
             
            pstmt.setInt(1, studentId);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("[DELETE SUCCESS] Removed student ID: " + studentId);
            } else {
                System.out.println("[DELETE FAILED] Student ID " + studentId + " not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}