package model;

import javafx.beans.property.*;

public class AttendanceRow {

    private final StringProperty studentId = new SimpleStringProperty();
    private final StringProperty studentName = new SimpleStringProperty();

    private final BooleanProperty[] days = new BooleanProperty[32];

    public AttendanceRow(String id, String name) {
        studentId.set(id);
        studentName.set(name);

        for (int i = 1; i <= 31; i++) {
            days[i] = new SimpleBooleanProperty(false);
        }
    }

    public BooleanProperty dayProperty(int day) {
        return days[day];
    }

    public StringProperty studentIdProperty() { return studentId; }
    public StringProperty studentNameProperty() { return studentName; }
}
