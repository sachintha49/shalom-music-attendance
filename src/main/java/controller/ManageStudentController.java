package controller;

import dto.StudentDTO;
import enums.ClassScheduleDateTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import service.Impl.ManageStudentServiceImpl;
import service.ManageStudentService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ManageStudentController {

    @FXML
    private ComboBox<String> cmbAdultChild;

    @FXML
    private ComboBox<String> cmbClassSchedule;

    @FXML
    private ComboBox<String> cmbClassType;

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCassSchedule;

    @FXML
    private TableColumn<?, ?> colClassType;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TextArea txtAddressId;

    @FXML
    private TextField txtEmailId;

    @FXML
    private TextField txtFirstNameId;

    @FXML
    private TextField txtLastNameId;

    @FXML
    private TextField txtMobileNoId;

    @FXML
    private TextField txtParentNameId;

    @FXML
    private DatePicker dateDob;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colParentName;


    @FXML
    private TableView<?> tblStudentList;


    ManageStudentService manageStudentService = new ManageStudentServiceImpl();


    public void initialize(){

    // Loading values to the combo boxes
    // Gender Combo
    cmbGender.getItems().addAll("Male", "Female", "Other");

    // Adult or Child
    cmbAdultChild.getItems().addAll("Adult", "Child");

    // Class Type
    cmbClassType.getItems().addAll("Online", "Physical");

    // Class Schedule
    for (ClassScheduleDateTime value : ClassScheduleDateTime.values()) {
        cmbClassSchedule.getItems().add(value.toString());
    }

}
    @FXML
    void btnSaveStudentOnAction(ActionEvent event) {
        // TEXTFIELDS
        String firstName   = txtFirstNameId.getText();
        String lastName    = txtLastNameId.getText();
        String email       = txtEmailId.getText();
        String mobileNo    = txtMobileNoId.getText();
        String parentName  = txtParentNameId.getText();
        String address     = txtAddressId.getText();

        // COMBOBOXES
        Object gender       = cmbGender.getValue();
        Object classType    = cmbClassType.getValue();
        Object requestedClassScheduleDateTIme= cmbClassSchedule.getValue();
        Object personType   = cmbAdultChild.getValue();

        // DATEPICKER
        LocalDate dob       = dateDob.getValue();

//        StudentDTO student = StudentDTO.builder()
//                .studentCode(manageStudentService.getStudentCode())
//                .firstName(firstName)
//                .lastName(lastName)
//                .gender(gender.toString())
//                .requestedClassScheduleDateTime(requestedClassScheduleDateTIme.toString())
//                .classType(classType.toString())
//                .dob(dob)
//                .email(email)
//                .personType(personType.toString())
//                .mobileWhatsApp(mobileNo)
//                .parentName(parentName)
//                .address(address)
//                .status("ACTIVE")
//                .enrollmentDate(LocalDate.now())
//                .notes("A sample note can be added here!") //a note filed has to be added in client and let the value to be enter by user
//                .createdAt(LocalDateTime.now())
//                .build();

                manageStudentService.saveStudent(new StudentDTO());


    }

}
