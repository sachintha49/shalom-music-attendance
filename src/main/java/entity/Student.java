package entity;

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
    private ContactTitle contactPersonTitle;

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
    private ClassCategories classCategories;

    // Learning Goals & Notes
    @Column(length = 1000)
    private String learningGoals;

    @Column(length = 1000)
    private String specialNotes;

    // -------------------- ENUMS --------------------
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum ContactTitle {
        MR, MRS, MS, DR, PROF, OTHER
    }

    public enum DeliveryMode {
        ONLINE,
        PHYSICAL
    }

    public enum CourseEnrolling {
        GUITAR_UKULELE_VOCAL, PIANO_VOCAL
    }

    public enum ClassCategories {
        // Online Classes
        INTERNATIONAL_ONLINE_INDIVIDUAL_ALL_CATEGORIES,
        SCHOOL_CLASS_ONLINE_GRADE_6_PLUS_GROUP,
        ELDERS_CLASS_ONLINE_18_PLUS_GROUP,

        // Physical Classes
        KIDS_CLASS_PHYSICAL_4_10_GROUP,
        SCHOOL_CLASS_PHYSICAL_10_18_GROUP,
        ELDERS_CLASS_PHYSICAL_18_PLUS_PROFESSIONALS_GROUP
    }

    public enum HasStudentLearntMusicBefore {
        YES,NO,A_LITTLE_BIT_BASIC_LEVEL
    }
}
