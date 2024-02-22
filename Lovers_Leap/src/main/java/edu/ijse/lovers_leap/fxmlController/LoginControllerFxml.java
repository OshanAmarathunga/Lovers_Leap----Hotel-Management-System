package edu.ijse.lovers_leap.fxmlController;
import edu.ijse.lovers_leap.controller.ReceptionistController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

public class LoginControllerFxml {
    private ReceptionistController receptionistController = new ReceptionistController();

    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserId;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtMobileNo;

    @FXML
    void btnSearchAction(ActionEvent event) {
        try {
            int id=receptionistController.getId(txtMobileNo.getText()).getReceptionistId();
            txtMobileNo.setText("");
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Please login with this user ID");
            alert2.setContentText("Your User Id ->" + id);
            Optional<ButtonType> result2 = alert2.showAndWait();


        } catch (Exception e) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error!");
            alert2.setContentText("Sorry,Incorrect mobile no! or Register as new Receptionist!");
            Optional<ButtonType> result2 = alert2.showAndWait();
        }

    }

    @FXML
    void btnLogin(ActionEvent event) {
        if ((txtPassword.getText().isEmpty()) | (txtUserId.getText().isEmpty())) {
            errorAlert.setTitle("Login Error");
            errorAlert.setContentText("Please Enter Valid User name & Password");
            Optional<ButtonType> result = errorAlert.showAndWait();
        } else {
            try {
                if (receptionistController.getReceptionist(Integer.parseInt(txtUserId.getText())).getPassword().equals(txtPassword.getText())) {
                    try {

                        Parent root;
                        root = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/home.fxml"));
                        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene1 = new Scene(root);
                        stage1.setScene(scene1);
                        stage1.show();
                        stage1.centerOnScreen();
                        stage1.setResizable(false);
                        stage1.initStyle(StageStyle.UTILITY);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    errorAlert.setTitle("Login Error");
                    errorAlert.setContentText("Your Password or User Id is incorrect");
                    Optional<ButtonType> result = errorAlert.showAndWait();
                }
            } catch (Exception e) {
                errorAlert.setTitle("Login Error");
                errorAlert.setContentText("Your Password or User Id is incorrect");
                Optional<ButtonType> result = errorAlert.showAndWait();
            }
        }

    }

    @FXML
    void btnRegister(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/Receptionist_Register.fxml"));
            Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene2 = new Scene(root2);
            stage2.setScene(scene2);
            stage2.show();
            stage2.centerOnScreen();
            stage2.initStyle(StageStyle.UTILITY);
            stage2.setResizable(false);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void txtPasswordKeyPressAction(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            btnLogin.requestFocus();
        }

    }
    @FXML
    void txtMobileNoKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            btnSearch.requestFocus();
        }

    }

    @FXML
    void txtUserIDKeyPresses(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            txtPassword.requestFocus();
        }

    }
}
