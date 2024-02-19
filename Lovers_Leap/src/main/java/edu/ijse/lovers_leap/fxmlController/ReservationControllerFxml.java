package edu.ijse.lovers_leap.fxmlController;

import edu.ijse.lovers_leap.controller.RoomManagementController;
import edu.ijse.lovers_leap.dto.RoomManagementDto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationControllerFxml implements Initializable {
    RoomManagementController roomManagementController;

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
    private TableColumn<?, ?> colContatcNoCS;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colCustomerIdCS;

    @FXML
    private TableColumn<?, ?> colGuests;

    @FXML
    private TableColumn<?, ?> colInDate;

    @FXML
    private TableColumn<?, ?> colNameCS;

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
    private TableView<?> tblCustomerStatus;

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

    }

    @FXML
    void tblReservationMouseClicked(MouseEvent event) {

    }

    @FXML
    void tblRoomStatusMouseClicked(MouseEvent event) {

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
        loadTables();
    }
    void loadTables(){
        ObservableList<RoomManagementDto> odtos= FXCollections.observableArrayList();
        try {
            ArrayList<RoomManagementDto> dtos=roomManagementController.getAll();
            odtos.addAll(dtos);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        colRoomIdRS.
        tblRoomStatus.setItems(odtos);


    }
    void clear(){

    }
}
