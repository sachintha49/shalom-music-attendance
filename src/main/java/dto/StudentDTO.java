package dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {

    private Long studentId;

    private String studentCode;

    private String firstName;
    private String lastName;
    private String gender;
    private String classType;
    private String personType;

    private LocalDate dob;
    private LocalDate enrollmentDate;

    private String email;
    private String mobileWhatsApp;
    private String parentName;
    private String address;

    private String requestedClassScheduleDateTime;
    private String notes;

    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
