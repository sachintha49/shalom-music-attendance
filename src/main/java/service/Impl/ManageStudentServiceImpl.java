package service.Impl;

import dto.StudentDTO;
import entity.Student;
import org.hibernate.Session;
import service.ManageStudentService;
import util.HibernateUtil;

import java.time.LocalDate;

public class ManageStudentServiceImpl implements ManageStudentService {


    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = new Student();

        student.setFirstName("Sachin");
        student.setLastName("Punchihewa");
        student.setContactPersonEmail("snidhajit@gmail.");
        student.setGender(Student.Gender.MALE);
        student.setAddress("address");
        student.setBirthday(LocalDate.now());
        student.setClassCategories(Student.ClassCategories.KIDS_CLASS_PHYSICAL_4_10_GROUP);
        student.setContactPersonName("Rebeccah");
        student.setContactPersonNumber("0778787336");
        student.setDeliveryMode(Student.DeliveryMode.ONLINE);
        student.setSchoolGradeOrProfession("A/L");
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        //System.out.println(studentDTO.toString());
        //studentRepository.saveStudent(studentDTO);
    }
}
