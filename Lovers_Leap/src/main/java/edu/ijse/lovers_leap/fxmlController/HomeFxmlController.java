package edu.ijse.lovers_leap.fxmlController;

import edu.ijse.lovers_leap.controller.CustomerController;
import edu.ijse.lovers_leap.controller.HotelDetailController;
import edu.ijse.lovers_leap.controller.ReceptionistController;
import edu.ijse.lovers_leap.dto.CustomerDto;
import edu.ijse.lovers_leap.dto.HotelDto;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class HomeFxmlController implements Initializable {
    private CustomerController customerController;
    private ReceptionistController receptionistController;
    private LoginControllerFxml loginControllerFxml;
    private HotelDetailController hotelDetailController;



    @FXML
    private TableColumn<CustomerDto, String> ColAddress;

    @FXML
    private TableColumn<CustomerDto, String> ColContatcNo;

    @FXML
    private TableColumn<CustomerDto, Integer> ColCustomerId;

    @FXML
    private TableColumn<CustomerDto, String> ColEmail;

    @FXML
    private TableColumn<CustomerDto, String> ColFirstName;

    @FXML
    private TableColumn<CustomerDto, String> ColGender;

    @FXML
    private TableColumn<CustomerDto, String> ColNicNo;

    @FXML
    private Button btnAddCustomer;

    @FXML
    private Button btnAvailabeRooms;

    @FXML
    private Button btnDeleteCustomer;

    @FXML
    private Button btnHotelDetails;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnReceiptionist;

    @FXML
    private Button btnReservation;

    @FXML
    private Button btnRoomCategories;

    @FXML
    private Button btnSearcCustomer;

    @FXML
    private Button btnUpdateCustomer;

    @FXML
    private ComboBox<String> cmbCountry;

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private Label lblShowContactNo;

    @FXML
    private Label lblShowCustomerID;

    @FXML
    private Label lblShowEmail;

    @FXML
    private Label lblShowFirstName;

    @FXML
    private Label lblShowReceiptionistName;

    @FXML
    private Label lblShowSeacrheCustomerId;

    @FXML
    private TableView<CustomerDto> tblShowCustomers;

    @FXML
    private TextField txtContatcNo;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerFirstName;

    @FXML
    private TextField txtCustomerLastName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEnterNICnumber;

    @FXML
    private TextField txtNICnumber;

    public HomeFxmlController() {
        customerController = new CustomerController();
        receptionistController = new ReceptionistController();
        loginControllerFxml = new LoginControllerFxml();
        hotelDetailController = new HotelDetailController();
    }

    @FXML
    void addCustomerAction(ActionEvent event) {
        if (txtCustomerFirstName.getText().equals("") | txtContatcNo.getText().equals("") | txtNICnumber.getText().equals("") | cmbGender.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Please Enter Valid Data");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            CustomerDto customerDto = new CustomerDto(txtCustomerFirstName.getText(),
                    txtCustomerLastName.getText(),
                    txtCustomerAddress.getText(),
                    cmbCountry.getValue(),
                    cmbGender.getValue(),
                    txtEmail.getText(),
                    txtContatcNo.getText(),
                    txtNICnumber.getText());
            try {
                String rsp = customerController.addCustomer(customerDto);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Saved Successfully");
                alert.setContentText("Customer has been saved Successfully..");
                loadCustomerTable();
                clearText();
                Optional<ButtonType> result = alert.showAndWait();

                txtCustomerFirstName.setText("");
                txtCustomerLastName.setText("");
                txtCustomerAddress.setText("");
                txtEmail.setText("");
                txtContatcNo.setText("");
                txtNICnumber.setText("");
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("Customer Submission Error!" + e.getMessage());
                Optional<ButtonType> result = alert.showAndWait();
            }
        }
    }

    @FXML
    void btnHotelDetailAction(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/HotelDetails.fxml"));
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root1);
            stage1.setScene(scene1);
            stage1.show();
            stage1.centerOnScreen();
            stage1.setResizable(false);
            stage1.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnReceiptionistAction(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/mainReceptionistRegister.fxml"));
            Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene2 = new Scene(root2);
            stage2.setScene(scene2);
            stage2.centerOnScreen();
            stage2.initStyle(StageStyle.UTILITY);
            stage2.setResizable(false);
            stage2.show();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    void btnReservationAction(ActionEvent event) {


        try {
            Parent root3 = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/reservation.fxml"));
            Stage stage3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene3 = new Scene(root3);
            stage3.setScene(scene3);
            stage3.centerOnScreen();
            stage3.initStyle(StageStyle.UTILITY);
            stage3.setResizable(false);
            stage3.show();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void btnRoomCategoryAction(ActionEvent event) {
        Parent root4;
        try {
            root4 = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/RoomCategory.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene4 = new Scene(root4);
        stage4.setScene(scene4);
        stage4.centerOnScreen();
        stage4.initStyle(StageStyle.UTILITY);
        stage4.setResizable(false);
        stage4.show();

    }
    @FXML
    void btnRoomManagementAction(ActionEvent event) {
        Parent root5;
        try {
            root5 = FXMLLoader.load(getClass().getResource("/edu/ijse/lovers_leap/RoomManagement.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene5 = new Scene(root5);
        stage5.setScene(scene5);
        stage5.centerOnScreen();
        stage5.initStyle(StageStyle.UTILITY);
        stage5.setResizable(false);
        stage5.show();
    }

    @FXML
    void cmbCustomerCountryKeyPressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbGender.requestFocus();
        }
    }

    @FXML
    void cmbGenderKeyPressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtEmail.requestFocus();
        }
    }

    @FXML
    void deleteAction(ActionEvent event) {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Are You Sure ?");
        alert1.setContentText("Your Data will be permanently delete ! ");
        Optional<ButtonType> result = alert1.showAndWait();

        if (result.isEmpty()) {

        } else if (result.get() == ButtonType.OK) {
            try {
                String resuly = customerController.deleteCustomer(Integer.parseInt(lblShowCustomerID.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Deleted ");
                alert.setContentText(resuly);
                loadCustomerTable();
                clearText();
                Optional<ButtonType> result2 = alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail");
                alert.setContentText("Fail to delete the customer" + e.getMessage());
                Optional<ButtonType> result2 = alert.showAndWait();
            }
        } else if (result.get() == ButtonType.CANCEL) {

        }


    }

    @FXML
    void searchCustomerAction(ActionEvent event) {
        try {
            CustomerDto dto = customerController.getCustomer(txtEnterNICnumber.getText());
            if (dto != null) {
                lblShowFirstName.setText(dto.getFirstName());
                lblShowSeacrheCustomerId.setText(Integer.toString(dto.getCustomerId()));
                lblShowContactNo.setText(dto.getContactNo());
                lblShowEmail.setText(dto.getEmail());


            } else {
                lblShowSeacrheCustomerId.setText("");
                lblShowFirstName.setText("");
                lblShowContactNo.setText("");
                lblShowEmail.setText("");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("Not found any customer");
                Optional<ButtonType> result = alert.showAndWait();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void tblShowCustomerMouseClicked(MouseEvent event) {
        CustomerDto customerDto = tblShowCustomers.getSelectionModel().getSelectedItem();
        if (customerDto != null) {
            lblShowCustomerID.setText(Integer.toString(customerDto.getCustomerId()));
            txtCustomerFirstName.setText(customerDto.getFirstName());
            txtCustomerLastName.setText(customerDto.getLastName());
            txtCustomerAddress.setText(customerDto.getAddress());
            cmbCountry.setPromptText(customerDto.getCountry());
            cmbGender.setPromptText(customerDto.getGender());
            txtEmail.setText(customerDto.getEmail());
            txtContatcNo.setText(customerDto.getContactNo());
            txtNICnumber.setText(customerDto.getNicNo());
        }

    }

    @FXML
    void txtContactNoKeypressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtNICnumber.requestFocus();
        }

    }

    @FXML
    void txtCustomerAddressKeypressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbCountry.requestFocus();
        }
    }

    @FXML
    void txtCustomerFirstnameKeypressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtCustomerLastName.requestFocus();
        }
    }

    @FXML
    void txtCustomerLastNameKeypressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtCustomerAddress.requestFocus();
        }
    }

    @FXML
    void txtEmailKeypressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtContatcNo.requestFocus();
        }
    }

    @FXML
    void txtEnterNicNumberKeypressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            btnSearcCustomer.requestFocus();
        }
    }

    @FXML
    void txtNicKeypressAction(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            btnAddCustomer.requestFocus();
        }
    }

    @FXML
    void updateAction(ActionEvent event) {
        if (txtNICnumber.getText().equals("") | txtContatcNo.getText().equals("") | lblShowCustomerID.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("Please Enter Valid Data");
            Optional<ButtonType> result = alert.showAndWait();

            txtCustomerFirstName.setText("");
            txtCustomerLastName.setText("");
            txtCustomerAddress.setText("");
            txtEmail.setText("");
            txtContatcNo.setText("");
            txtNICnumber.setText("");

        } else {

            CustomerDto customerDto = new CustomerDto(Integer.parseInt(lblShowCustomerID.getText()), txtCustomerFirstName.getText(), txtCustomerLastName.getText(), txtCustomerAddress.getText(), cmbCountry.getValue(), cmbGender.getValue(), txtEmail.getText(), txtContatcNo.getText(), txtNICnumber.getText());
            try {
                String rsp = customerController.updateCustomer(customerDto);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successfully updated ! ");
                alert.setContentText(rsp);
                clearText();
                loadCustomerTable();
                Optional<ButtonType> result = alert.showAndWait();

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("Update Error" + e.getMessage());
                Optional<ButtonType> result = alert.showAndWait();
            }
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbGender.setItems(FXCollections.observableArrayList("Male", "Female"));
        loadCustomerTable();
        loadCmbCountry();
    }

    void loadCmbCountry() {
        ArrayList<String> contryList = new ArrayList<>();
        try {
            ArrayList<HotelDto> hotelDtos = hotelDetailController.getAll();
            for (HotelDto names : hotelDtos) {
                contryList.add(names.getName());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ObservableList<String> nameObservableList = FXCollections.observableArrayList(contryList);
        cmbCountry.setItems(nameObservableList);

    }

    void loadCustomerTable() {
        ObservableList<CustomerDto> oList = FXCollections.observableArrayList();
        try {
            oList.addAll(customerController.getAllCustomer());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ColCustomerId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCustomerId()).asObject());
        ColFirstName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFirstName()));
        ColContatcNo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getContactNo()));
        ColAddress.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAddress()));
        ColGender.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGender()));
        ColEmail.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));
        ColNicNo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNicNo()));
        tblShowCustomers.setItems(oList);
    }

    void clearText() {
        txtCustomerFirstName.setText("");
        txtCustomerLastName.setText("");
        txtCustomerAddress.setText("");
        txtEmail.setText("");
        txtContatcNo.setText("");
        txtNICnumber.setText("");
    }
}