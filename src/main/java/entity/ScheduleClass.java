package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schedule_class")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scheduleName;
    private String classType;
    private String instructorName;
    private String zoomLink;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;

    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thu;
    private boolean fri;
    private boolean sat;
    private boolean sun;

    @OneToMany(mappedBy = "scheduleClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScheduleStudent> students = new ArrayList<>();

    // getters and setters
}
