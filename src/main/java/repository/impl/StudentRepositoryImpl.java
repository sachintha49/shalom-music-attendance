package repository.impl;

import db.DBConnection;
import dto.StudentDTO;
import repository.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public String generateStudentCode() {

        // SQL: Get last code (ex: SMS-0042)
        String sql = "SELECT student_code FROM students ORDER BY student_code DESC LIMIT 1";

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            String prefix = "SMS-";

            if (rs.next()) {
                String lastCode = rs.getString(1);       // "SMS-0042"
                int number = Integer.parseInt(lastCode.substring(4));  // extract "0042" → 42
                number++;

                return prefix + String.format("%04d", number); // SMS-0043
            }

            return "SMS-0001"; // first student

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void saveStudent(StudentDTO studentDTO) {
        String SQL = "INSERT INTO students (" +
                "student_code, firstName, lastName, gender, classType, personType, dob, " +
                "email, mobileWhatsApp, parentName, address, requestedClassScheduleDateTime, " +
                "status, enrollmentDate, notes, createdAt, updatedAt" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, studentDTO.getStudentCode());
            ps.setString(2, studentDTO.getFirstName());
            ps.setString(3, studentDTO.getLastName());
            ps.setString(4, studentDTO.getGender());
            ps.setString(5, studentDTO.getClassType());
            ps.setString(6, studentDTO.getPersonType());
            ps.setObject(7, studentDTO.getDob()); // LocalDate
            ps.setString(8, studentDTO.getEmail());
            ps.setString(9, studentDTO.getMobileWhatsApp());
            ps.setString(10, studentDTO.getParentName());
            ps.setString(11, studentDTO.getAddress());
            ps.setString(12, studentDTO.getRequestedClassScheduleDateTime());
            ps.setString(13, studentDTO.getStatus());
            ps.setObject(14, studentDTO.getEnrollmentDate()); // LocalDate
            ps.setString(15, studentDTO.getNotes());

            // Automatically set timestamps
            ps.setObject(16, java.time.LocalDateTime.now()); // createdAt
            ps.setObject(17, java.time.LocalDateTime.now()); // updatedAt

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save student", e);
        }
    }



}
