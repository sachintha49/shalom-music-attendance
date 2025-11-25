package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AttendanceRow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MonthlyAttendanceController {

    @FXML private TableView<AttendanceRow> attendanceTable;

    @FXML private TableColumn<AttendanceRow, String> studentIdCol;
    @FXML private TableColumn<AttendanceRow, String> studentNameCol;

    @FXML private TableColumn<AttendanceRow, Boolean> day1Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day2Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day3Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day4Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day5Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day6Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day7Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day8Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day9Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day10Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day11Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day12Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day13Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day14Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day15Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day16Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day17Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day18Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day19Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day20Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day21Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day22Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day23Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day24Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day25Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day26Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day27Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day28Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day29Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day30Col;
    @FXML private TableColumn<AttendanceRow, Boolean> day31Col;

    @FXML
    public void initialize() {

        // Student columns
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("studentName"));

        // Checkbox columns
        TableColumn[] columns = {
                day1Col, day2Col, day3Col, day4Col, day5Col,
                day6Col, day7Col, day8Col, day9Col, day10Col,
                day11Col, day12Col, day13Col, day14Col, day15Col,
                day16Col, day17Col, day18Col, day19Col, day20Col,
                day21Col, day22Col, day23Col, day24Col, day25Col,
                day26Col, day27Col, day28Col, day29Col, day30Col, day31Col
        };

        day4Col.setStyle("-fx-background-color: #FFF2A8; -fx-border-color: #C9A200;");
        day14Col.setCellFactory(column -> new CheckBoxTableCell<AttendanceRow, Boolean>() {
            @Override
            public void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);

                if (!empty) {
                    setStyle("-fx-background-color: #FFF2A8; -fx-border-color: #C9A200;");
                } else {
                    setStyle(""); // reset
                }
            }
        });


        for (int i = 1; i <= 31; i++) {
            int day = i;
            TableColumn<AttendanceRow, Boolean> col = columns[i - 1];
            col.setCellValueFactory(c -> c.getValue().dayProperty(day));
            col.setCellFactory(CheckBoxTableCell.forTableColumn(col));
        }

        // Load sample data
        attendanceTable.setItems(sampleData());
    }

    private ObservableList<AttendanceRow> sampleData() {

        AttendanceRow s1 = new AttendanceRow("STD001", "John Doe");
        AttendanceRow s2 = new AttendanceRow("STD002", "Alice Brown");
        AttendanceRow s3 = new AttendanceRow("STD003", "Michael Lee");

        // Sample marked attendance
        s1.dayProperty(1).set(true);
        s1.dayProperty(2).set(true);
        s1.dayProperty(5).set(true);

        s2.dayProperty(1).set(false);
        s2.dayProperty(3).set(true);
        s2.dayProperty(10).set(true);

        s3.dayProperty(2).set(true);
        s3.dayProperty(4).set(true);
        s3.dayProperty(6).set(true);

        return FXCollections.observableArrayList(s1, s2, s3);
    }

}
