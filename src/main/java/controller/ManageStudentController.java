package controller;

import dto.StudentDTO;
import entity.Student;
import enums.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Impl.ManageStudentServiceImpl;
import service.ManageStudentService;
import tm.StudentTM;

import java.time.LocalDate;
import java.util.List;

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

        StudentTM student = new StudentTM();

        tblStudents.getItems().add(student);

        loadAllStudents();
    }


    @FXML
    void btnSaveStudentOnAction(ActionEvent event) {
        System.out.println(txtFirstName.getText());
        // txtFirstnameue
        // cmbGender.getValue.toStirng
        StudentDTO studentDTO = StudentDTO.builder()
                .firstName(txtFirstName.getText())
                .lastName(txtLastName.getText())
//                .gender(Gender.valueOf(cmbGender.getValue()))
                .gender(Gender.MALE)
                .birthday(dateBirthday.getValue())
                .schoolGradeOrProfession(txtContactPersonName.getText())
//                .contactPersonTitle(Title.valueOf(cmbContactTitle.getValue()))
                .contactPersonTitle(Title.MR)
                .contactPersonName(txtContactPersonName.getText())
                .contactPersonNumber(txtContactPersonNumber.getText())
                .contactPersonEmail(txtContactPersonEmail.getText())
                .address(txtAddress.getText())
//                .hasStudentLearntMusicBefore(cmbHasLearntMusicBefore.getValue())
                .hasStudentLearntMusicBefore(HasStudentLearntMusicBefore.A_LITTLE_BIT_BASIC_LEVEL)
//                .deliveryMode(DeliveryMode.valueOf(cmbDeliveryMode.getValue()))
                .deliveryMode(DeliveryMode.ONLINE)
//                .classCategories(ClassCategory.valueOf(cmbClassCategories.getValue()))
                .classCategories(ClassCategory.KIDS_CLASS_PHYSICAL_4_10_GROUP)
//                .learningGoals(txtLearningGoals.getText())
//                .specialNotes(txtSpecialNotes.getText())
                .build();


        manageStudentService.saveStudent(studentDTO);

        loadAllStudents();

    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void loadAllStudents(){
        tblStudents.getItems().clear();

        manageStudentService.getAllStudents().forEach(dto -> tblStudents.getItems().add(
                StudentTM.builder()
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
                        .delBtn(new Button("Delete"))
                        .build()
        ));

    }
}
