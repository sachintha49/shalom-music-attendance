package repository;

import dto.StudentDTO;

public interface StudentRepository {
    String generateStudentCode();

    void saveStudent(StudentDTO studentDTO);
}
