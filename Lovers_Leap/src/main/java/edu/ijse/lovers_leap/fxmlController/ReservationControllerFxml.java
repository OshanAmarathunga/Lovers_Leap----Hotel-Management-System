package edu.ijse.lovers_leap.fxmlController;

import edu.ijse.lovers_leap.controller.CustomerController;
import edu.ijse.lovers_leap.controller.RoomCategoryController;
import edu.ijse.lovers_leap.controller.RoomManagementController;
import edu.ijse.lovers_leap.dto.CustomerDto;
import edu.ijse.lovers_leap.dto.RoomManagementDto;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReservationControllerFxml implements Initializable {
    private RoomManagementController roomManagementController;
    private CustomerController customerController;
    private RoomCategoryController roomCategoryController;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancell;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbBookingStatus;

    @FXML
    private TableColumn<RoomManagementDto, Integer> colBedsRS;

    @FXML
    private TableColumn<?, ?> colBookingStatus;

    @FXML
    private TableColumn<RoomManagementDto, Integer> colCategoryRS;

    @FXML
    private TableColumn<CustomerDto,String> colContatcNoCS;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<CustomerDto, Integer> colCustomerIdCS;

    @FXML
    private TableColumn<?, ?> colGuests;

    @FXML
    private TableColumn<?, ?> colInDate;

    @FXML
    private TableColumn<CustomerDto, String> colNameCS;

    @FXML
    private TableColumn<?, ?> colOutDate;

    @FXML
    private TableColumn<?, ?> colResId;

    @FXML
    private TableColumn<RoomManagementDto,String> colRoomIdRS;

    @FXML
    private TableColumn<?, ?> colRoomNo;

    @FXML
    private TableColumn<RoomManagementDto,String> colStatusRS;

    @FXML
    private DatePicker dateIN;

    @FXML
    private DatePicker dateOut;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblCustomerNic;

    @FXML
    private TableView<CustomerDto> tblCustomerStatus;

    @FXML
    private TableView<?> tblReservation;

    @FXML
    private TableView<RoomManagementDto> tblRoomStatus;

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtGuests;

    @FXML
    private TextField txtRoomId;

    @FXML
    private Label lblRoomCategory;

    @FXML
    private Label lblRoomCost;

    @FXML
    void btnAddAction(ActionEvent event) {

    }

    @FXML
    void btnCancellAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

    }

    @FXML
    void cmbBookingStatusKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            txtGuests.requestFocus();
        }

    }

    @FXML
    void dateINKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            dateOut.requestFocus();
        }

    }

    @FXML
    void dateOutKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            cmbBookingStatus.requestFocus();
        }

    }

    @FXML
    void tblCustomerStatusMouseClicked(MouseEvent event) {
        if(tblCustomerStatus.getSelectionModel().getSelectedItem()!=null){
            int selectedCustomerId=tblCustomerStatus.getSelectionModel().getSelectedItem().getCustomerId();
            txtCusId.setText(Integer.toString(selectedCustomerId));
            try {
                String selectedCustomerName=customerController.getCustomrById(selectedCustomerId).getFirstName();
                String nic=customerController.getCustomrById(selectedCustomerId).getNicNo();
                lblCustomerName.setText(selectedCustomerName);
                lblCustomerNic.setText(nic);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }else {

        }

    }
    @FXML
    void txtCustomerIdKeyTyped(KeyEvent event) {

    }
    @FXML
    void txtCustomerIdAction(ActionEvent event) {


    }

    @FXML
    void tblReservationMouseClicked(MouseEvent event) {

    }

    @FXML
    void tblRoomStatusMouseClicked(MouseEvent event) {

        if(tblRoomStatus.getSelectionModel().getSelectedItem().getStatus()!=null){
            String rst=tblRoomStatus.getSelectionModel().getSelectedItem().getStatus();
            if(rst.equals("Available")){
                txtRoomId.setText(tblRoomStatus.getSelectionModel().getSelectedItem().getRoomId());
                try {
                    String selectedRoomCategory=roomCategoryController.get(tblRoomStatus.getSelectionModel().getSelectedItem().getCatId()).getRoomCatName();
                    lblRoomCategory.setText(selectedRoomCategory);

                    Double selectedRoomCategoryCost=roomCategoryController.get(tblRoomStatus.getSelectionModel().getSelectedItem().getCatId()).getCostPerNight();
                    lblRoomCost.setText(Double.toString(selectedRoomCategoryCost));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }else {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                txtRoomId.setText("");
                lblRoomCategory.setText("");
                lblRoomCost.setText("");
                alert2.setTitle("Error !");
                alert2.setContentText("You can only Book -Available Room- Only...");
                Optional<ButtonType> result2 = alert2.showAndWait();
            }
        }else {
            System.out.println("not selected");
        }

    }

    @FXML
    void txtCustomerIdKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            txtRoomId.requestFocus();
        }

    }

    @FXML
    void txtGuestsKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            btnAdd.requestFocus();
        }

    }

    @FXML
    void txtRoomNoKeyPress(KeyEvent event) {
        KeyCode k= event.getCode();
        if(k.getCode()==10){
            dateIN.requestFocus();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomManagementController=new RoomManagementController();
        customerController=new CustomerController();
        roomCategoryController=new RoomCategoryController();
        loadTables();
    }
    void loadTables(){
        ObservableList<RoomManagementDto> odtos= FXCollections.observableArrayList();
        ObservableList<CustomerDto> customerDtoObservableList=FXCollections.observableArrayList();
        try {
            ArrayList<RoomManagementDto> dtos=roomManagementController.getAll();
            odtos.addAll(dtos);
            List<CustomerDto> customerDtos=customerController.getAllCustomer();
            customerDtoObservableList.addAll(customerDtos);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        colRoomIdRS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getRoomId()));
        colCategoryRS.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getCatId()).asObject());
        colStatusRS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getStatus()));
        colBedsRS.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getNoOfBeds()).asObject());
        tblRoomStatus.setItems(odtos);

        colCustomerIdCS.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getCustomerId()).asObject());
        colNameCS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getFirstName()));
        colContatcNoCS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getContactNo()));
        tblCustomerStatus.setItems(customerDtoObservableList);


    }
    void clear(){
        txtCusId.setText("");
        txtRoomId.setText("");
        dateIN.setValue(LocalDate.now());
        dateOut.setValue(LocalDate.now());
        cmbBookingStatus.setPromptText("Select Booking Status");
        txtGuests.setText("");

    }
}
