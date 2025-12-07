package controller;

import entity.Student;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Impl.ManageStudentServiceImpl;
import service.ManageStudentService;

import java.time.LocalDate;

public class ManageStudentController {

    @FXML
    private ComboBox<?> cmbClassCategories;

    @FXML
    private ComboBox<?> cmbContactTitle;

    @FXML
    private ComboBox<?> cmbDeliveryMode;

    @FXML
    private ComboBox<?> cmbGender;

    @FXML
    private ComboBox<?> cmbHasLearntMusicBefore;

    @FXML
    private TableColumn<?, ?> colActions;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colBirthday;

    @FXML
    private TableColumn<?, ?> colClassCategories;

    @FXML
    private TableColumn<?, ?> colContactPersonEmail;

    @FXML
    private TableColumn<?, ?> colContactPersonName;

    @FXML
    private TableColumn<?, ?> colContactPersonNumber;

    @FXML
    private TableColumn<?, ?> colDeliveryMode;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colHasLearntMusicBefore;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colSchoolGradeOrProfession;

    @FXML
    private DatePicker dateBirthday;

    @FXML
    private TableView<?> tblStudents;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtContactPersonEmail;

    @FXML
    private TextField txtContactPersonName;

    @FXML
    private TextField txtContactPersonNumber;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    ManageStudentService manageStudentService = new ManageStudentServiceImpl();


    @FXML
    public void initialize() {

tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("first_name"));
tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("last_name"));
    }


    @FXML
    void btnSaveStudentOnAction(ActionEvent event) {

    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
    }
}
