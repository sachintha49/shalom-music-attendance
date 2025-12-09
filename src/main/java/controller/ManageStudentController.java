package controller;

import dto.StudentDTO;
import entity.Student;
import enums.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import service.Impl.ManageStudentServiceImpl;
import service.ManageStudentService;
import tm.StudentTM;

import java.time.LocalDate;
import java.util.List;

public class ManageStudentController {

    @FXML
    private ComboBox<ClassCategory> cmbClassCategories;

    @FXML
    private ComboBox<Title> cmbContactTitle;

    @FXML
    private ComboBox<DeliveryMode> cmbDeliveryMode;

    @FXML
    private ComboBox<Gender> cmbGender;

    @FXML
    private ComboBox<HasStudentLearntMusicBefore> cmbHasLearntMusicBefore;

    @FXML
    private TableColumn<StudentTM, Button> colActions;

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
    private TableView<StudentTM> tblStudents;

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
        cmbGender.getItems().setAll(Gender.values());
        cmbContactTitle.getItems().setAll(Title.values());
        cmbHasLearntMusicBefore.getItems().setAll(HasStudentLearntMusicBefore.values());
        cmbDeliveryMode.getItems().setAll(DeliveryMode.values());
        cmbClassCategories.getItems().setAll(ClassCategory.values());

        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblStudents.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("birthday"));
        tblStudents.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("schoolGradeOrProfession"));
        tblStudents.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("contactPersonName"));
        tblStudents.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("contactPersonNumber"));
        tblStudents.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("contactPersonEmail"));
        tblStudents.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudents.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("hasLearntMusicBefore"));
        tblStudents.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("deliveryMode"));
        tblStudents.getColumns().get(11).setCellValueFactory(new PropertyValueFactory<>("classCategories"));
        tblStudents.getColumns().get(12).setCellValueFactory(new PropertyValueFactory<>("delBtn"));

        colActions.setCellFactory(column -> new TableCell<StudentTM, Button>() {
            @Override
            protected void updateItem(Button btn, boolean empty) {
                super.updateItem(btn, empty);

                if (empty || btn == null) {
                    setGraphic(null);
                } else {
                    // Center alignment
                    HBox hbox = new HBox(btn);
                    hbox.setAlignment(Pos.CENTER);
                    hbox.setSpacing(0);

                    setGraphic(hbox);
                }
            }
        });



        StudentTM student = new StudentTM();

        tblStudents.getItems().add(student);

        loadAllStudents();
    }

    @FXML
    void btnSaveStudentOnAction(ActionEvent event) {
        System.out.println(txtFirstName.getText());
        StudentDTO studentDTO = StudentDTO.builder()
                .firstName(txtFirstName.getText())
                .lastName(txtLastName.getText())
                .gender(cmbGender.getValue())
                .birthday(dateBirthday.getValue())
                .schoolGradeOrProfession(colSchoolGradeOrProfession.getText())
                .contactPersonTitle(cmbContactTitle.getValue())
                .contactPersonName(txtContactPersonName.getText())
                .contactPersonNumber(txtContactPersonNumber.getText())
                .contactPersonEmail(txtContactPersonEmail.getText())
                .address(txtAddress.getText())
                .hasStudentLearntMusicBefore(cmbHasLearntMusicBefore.getValue())
                .deliveryMode(cmbDeliveryMode.getValue())
                .classCategories(cmbClassCategories.getValue())
                .active(true)
                .build();
        manageStudentService.saveStudent(studentDTO);

        loadAllStudents();

    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
    }

    private void setStudentInactive(Long id) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure you want to mark this student as inactive?",
                ButtonType.YES, ButtonType.NO);
        confirm.showAndWait();

        if (confirm.getResult() == ButtonType.YES) {
            manageStudentService.setStudentInactive(id);
            loadAllStudents();
        }
    }


    public void loadAllStudents() {
        tblStudents.getItems().clear();

        manageStudentService.getAllStudents().stream()
                .filter(Student::isActive) .forEach(dto -> {

            Button btnInactive = new Button("Inactive");
            btnInactive.setStyle("-fx-background-color: #ff9900; -fx-text-fill: white;");

            StudentTM tm = StudentTM.builder()
                    .id(dto.getId())
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .gender(dto.getGender())
                    .birthday(dto.getBirthday())
                    .schoolGradeOrProfession(dto.getSchoolGradeOrProfession())
                    .contactPersonTitle(dto.getContactPersonTitle())
                    .contactPersonName(dto.getContactPersonName())
                    .contactPersonNumber(dto.getContactPersonNumber())
                    .contactPersonEmail(dto.getContactPersonEmail())
                    .address(dto.getAddress())
                    .hasStudentLearntMusicBefore(dto.getHasStudentLearntMusicBefore())
                    .deliveryMode(dto.getDeliveryMode())
                    .classCategories(dto.getClassCategories())
                    .learningGoals(dto.getLearningGoals())
                    .specialNotes(dto.getSpecialNotes())
                    .delBtn(btnInactive)
                    .build();

            btnInactive.setOnAction(event -> {
                setStudentInactive(tm.getId());
            });

            tblStudents.getItems().add(tm);
        });
    }}



