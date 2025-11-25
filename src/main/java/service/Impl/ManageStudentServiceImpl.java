package service.Impl;

import dto.StudentDTO;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.ManageStudentService;

public class ManageStudentServiceImpl implements ManageStudentService {

    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public String getStudentCode() {
        return studentRepository.generateStudentCode();
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        System.out.println(studentDTO.toString());
        studentRepository.saveStudent(studentDTO);
    }
}
