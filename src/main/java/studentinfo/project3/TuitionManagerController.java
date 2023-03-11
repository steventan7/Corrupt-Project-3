package studentinfo.project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Alert.AlertType;

public class TuitionManagerController {
    @FXML
    private Button addStudent, removeStudent, changeMajor, loadSchedule;

    @FXML
    private RadioButton bait, cs, ece, iti, math, resident, nonresident, international, tristate, ny, ct;

    @FXML
    private CheckBox studyabroad;

    @FXML
    private TextField firstname, lastname, creditscompleted;

    @FXML
    private TextArea output;

    @FXML
    private DatePicker dob;

    @FXML
    private ToggleGroup major, isResident;

    public static final String [] STUDENTTYPE = new String [] {"Resident", "Tri-state",
            "International student", "Non-Resident"};

    Roster studentRoster = new Roster();
    Enrollment studentEnrollment = new Enrollment();

    @FXML
    void add(ActionEvent event) {
        try {
            RadioButton selectedRadioButton = (RadioButton) major.getSelectedToggle();
            Student student = new Resident(new Profile(firstname.getText(), lastname.getText(), birthDate()),
                    Major.valueOf((selectedRadioButton).getText()), Integer.parseInt(creditscompleted.getText()), 0);
            studentRoster.add(student);
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Data");
            alert.setHeaderText("Non-numeric data has been entered.");
            alert.setContentText("Please enter an integer.");
            alert.showAndWait();
        }
        catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("You suck");
            alert.setHeaderText("Non-numeric rizz has been entered.");
            alert.setContentText("Please");
            alert.showAndWait();
        }
    }

    private String birthDate() {
        String[] date = dob.getValue().toString().split("-");
        String birthDate = date[1] + "/" + date[2] + "/" + date[0];
        return birthDate;
    }

    @FXML
    void remove(ActionEvent event) {

    }

    @FXML
    void checkIfResident(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) isResident.getSelectedToggle();
        if((selectedRadioButton).getText().equals("Non-Resident")) {
            ct.setDisable(false);
            ny.setDisable(false);
            tristate.setDisable((false));
            studyabroad.setDisable(false);
            international.setDisable(false);
        } else {
            ct.setDisable(true);
            ny.setDisable(true);
            tristate.setDisable((true));
            studyabroad.setDisable(true);
            international.setDisable(true);
        }
    }

//    @FXML
//    void checkIfTriStateOrInternational(ActionEvent event) {
//        RadioButton selectedRadioButton = (RadioButton) location.getSelectedToggle();
//        if((selectedRadioButton).getText().equals("Tri-State")) {
//            studyabroad.setDisable(false);
//            international.setDisable(false);
//        } else {
//            studyabroad.setDisable(true);
//            international.setDisable(true);
//        }
//    }
}