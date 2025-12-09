package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    public BorderPane root;

    public void mouseClickScheduleNewClassOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ScheduleNewClass.fxml"))));
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void mouseClickAddNewStudentOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ManageStudent.fxml"))));
        stage.setResizable(false);
        stage.centerOnScreen();
    }
}
