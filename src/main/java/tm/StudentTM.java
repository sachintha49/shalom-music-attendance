package tm;

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
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String classSchedule; // e.g., "MONDAY_SLOT1"
    private String parentName;
    private String mobileNumber;
    private String email;
    private String address;
    private String adultOrChild; // e.g., "Adult" or "Child"
}
