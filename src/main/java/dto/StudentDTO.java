package dto;

import enums.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthday;
    private String schoolGradeOrProfession;

    private Title contactPersonTitle;
    private String contactPersonName;
    private String contactPersonNumber;
    private String contactPersonEmail;

    private String address;

    private HasStudentLearntMusicBefore hasStudentLearntMusicBefore;
    private DeliveryMode deliveryMode;
    private ClassCategory classCategories;

    private String learningGoals;
    private String specialNotes;
    private boolean active;
}
