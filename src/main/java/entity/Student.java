package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")  // Table name in DB
@Data
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_code", unique = true, nullable = false)
    private String studentCode;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String gender;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "mobile_whatsapp")
    private String mobileWhatsApp;

    @Column
    private String email;

    @Column(name = "parent_name")
    private String parentName;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "class_type")
    private String classType;

    @Column(name = "person_type")
    private String personType;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @Column
    private String status;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "requested_class_schedule_datetime")
    private LocalDateTime requestedClassScheduleDateTime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
