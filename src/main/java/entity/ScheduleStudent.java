package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "schedule_student")
@Data
public class ScheduleStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private ScheduleClass scheduleClass;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // optional extra fields
    private LocalDate addedDate = LocalDate.now();

    // getters and setters
}
