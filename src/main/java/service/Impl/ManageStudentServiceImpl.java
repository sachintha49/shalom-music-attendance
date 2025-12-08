package service.Impl;

import dto.StudentDTO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.ManageStudentService;
import util.HibernateUtil;

import java.util.List;

public class ManageStudentServiceImpl implements ManageStudentService {

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = Student.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .gender(studentDTO.getGender())
                .birthday(studentDTO.getBirthday())
                .schoolGradeOrProfession(studentDTO.getSchoolGradeOrProfession())
                .contactPersonTitle(studentDTO.getContactPersonTitle())
                .contactPersonName(studentDTO.getContactPersonName())
                .contactPersonNumber(studentDTO.getContactPersonNumber())
                .contactPersonEmail(studentDTO.getContactPersonEmail())
                .address(studentDTO.getAddress())
                .hasStudentLearntMusicBefore(studentDTO.getHasStudentLearntMusicBefore())
                .deliveryMode(studentDTO.getDeliveryMode())
                .classCategories(studentDTO.getClassCategories())
                .learningGoals(studentDTO.getLearningGoals())
                .specialNotes(studentDTO.getSpecialNotes())
                .active(studentDTO.isActive())
                .build();


        session.persist(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void setStudentInactive(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setActive(false);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



    @Override
    public List<Student> getAllStudents() {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("From Student", Student.class).list();
        }

    }


}
