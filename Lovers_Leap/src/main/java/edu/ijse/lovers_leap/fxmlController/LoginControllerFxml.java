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

import java.util.Optional;

public class LoginControllerFxml {
    private ReceptionistController receptionistController = new ReceptionistController();
    //HomeControllerFxml controllerFxml;
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserId;

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
                        root = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/home.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        stage.centerOnScreen();
                        stage.setResizable(false);

//                        try {
//                            String name=receptionistController.getReceptionist(Integer.parseInt(txtUserId.getText())).getFirstName();
//                            System.out.println(name);
//                            controllerFxml=new HomeControllerFxml(name);
//                            controllerFxml.setLblShowReceiptionistName(name);
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        }
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
            root = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/Receptionist_Register.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();

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
    void txtUserIDKeyPresses(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            txtPassword.requestFocus();
        }

    }
}
