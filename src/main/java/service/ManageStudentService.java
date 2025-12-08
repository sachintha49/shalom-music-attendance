package service;

import dto.StudentDTO;
import entity.Student;

import java.util.List;

public interface ManageStudentService {


    void saveStudent(StudentDTO studentDTO);
    void setStudentInactive(Long id);
    List<Student> getAllStudents();
}
