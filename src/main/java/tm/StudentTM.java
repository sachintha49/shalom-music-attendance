package tm;

import enums.*;
import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentTM {
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
    private Button delBtn;
    private boolean active;
}
