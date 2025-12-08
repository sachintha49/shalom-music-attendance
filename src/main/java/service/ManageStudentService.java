package service;

import dto.StudentDTO;
import entity.Student;

import java.util.List;

public interface ManageStudentService {


    void saveStudent(StudentDTO studentDTO);

    List<Student> getAllStudents();
}
