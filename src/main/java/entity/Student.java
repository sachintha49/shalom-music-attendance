package entity;

import enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Student Information
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(name = "school_grade_or_profession", nullable = false)
    private String schoolGradeOrProfession;

    // Contact Person Information
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_person_title")
    private Title contactPersonTitle;

    @Column(name = "contact_person_name", nullable = false)
    private String contactPersonName;

    @Column(name = "contact_person_number", nullable = false)
    private String contactPersonNumber;

    @Column(name = "contact_person_email", nullable = false)
    private String contactPersonEmail;

    @Column(nullable = false)
    private String address;

    // Course & Enrollment Information
    @Column(name = "has_student_learnt_music_before")
    private HasStudentLearntMusicBefore hasStudentLearntMusicBefore;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_mode", nullable = false)
    private DeliveryMode deliveryMode;

    @Enumerated(EnumType.STRING)
    @Column(name = "class_categories", nullable = false)
    private ClassCategory classCategories;

    // Learning Goals & Notes
    @Column(length = 1000)
    private String learningGoals;

    @Column(length = 1000)
    private String specialNotes;

    private boolean active = true;
}
