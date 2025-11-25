package service;

import dto.StudentDTO;

public interface ManageStudentService {

    String getStudentCode();
    void saveStudent(StudentDTO studentDTO);
}
