package service.Impl;

import dto.StudentDTO;
import entity.Student;
import org.hibernate.Session;
import service.ManageStudentService;
import util.HibernateUtil;

public class ManageStudentServiceImpl implements ManageStudentService {


    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = new Student();

        student.setFirstName("Sachin");
        student.setLastName("Punchihewa");
        student.setEmail("snidhajit@gmail.");
student.setGender("Male");
student.setStudentCode("123");
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        //System.out.println(studentDTO.toString());
        //studentRepository.saveStudent(studentDTO);
    }
}
