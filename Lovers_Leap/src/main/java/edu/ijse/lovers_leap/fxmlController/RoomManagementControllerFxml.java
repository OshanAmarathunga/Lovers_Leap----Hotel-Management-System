package edu.ijse.lovers_leap.fxmlController;
import edu.ijse.lovers_leap.controller.HotelDetailController;
import edu.ijse.lovers_leap.controller.RoomCategoryController;
import edu.ijse.lovers_leap.controller.RoomManagementController;
import edu.ijse.lovers_leap.dto.HotelDto;
import edu.ijse.lovers_leap.dto.RoomCategoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomManagementControllerFxml implements Initializable {
    RoomManagementController roomManagementController;
    RoomCategoryController roomCategoryController;
    HotelDetailController hotelDetailController;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private ComboBox<String> cmbHotel;

    @FXML
    private ComboBox<String> cmbStatus;

    @FXML
    private TableColumn<?, ?> colCategoryName;

    @FXML
    private TableColumn<?, ?> colHotelName;

    @FXML
    private TableColumn<?, ?> colNoOfBeds;

    @FXML
    private TableColumn<?, ?> colRoomNo;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableView<?> tblRooms;

    @FXML
    private TextField txtNoOfBeds;

    @FXML
    private TextField txtRoomNo;

    @FXML
    void btnAddReceiptionistAction(ActionEvent event) {
        if ((!txtRoomNo.getText().isEmpty()) & (!txtNoOfBeds.getText().isEmpty()) & (cmbStatus.getValue()!=null) & (cmbHotel.getValue()!=null)){

        }

    }
    void loadComboBox(){
        ObservableList<String> cmbCat= FXCollections.observableArrayList();
        try {
            ArrayList<RoomCategoryDto> roomCategoryDtos =roomCategoryController.getAll();
            for(RoomCategoryDto dto:roomCategoryDtos){
                cmbCat.addAll(dto.getRoomCatName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        cmbCategory.setItems(cmbCat);

        ObservableList<String> cmbHot=FXCollections.observableArrayList();
        try {
            ArrayList<HotelDto> hotelDtos=hotelDetailController.getAll();
            for(HotelDto hotelDto:hotelDtos){
                cmbHot.add(hotelDto.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        cmbHotel.setItems(cmbHot);
        ObservableList<String> list= FXCollections.observableArrayList();
        list.add("Available");
        list.add("Booked");
        list.add("Under Maintenance");
        list.add("Under Preparation");

        cmbStatus.setItems(list);
    }

    @FXML
    void btnClearAction(ActionEvent event) {
        txtRoomNo.setText("");
        cmbCategory.setPromptText("Select Room Category");
        cmbHotel.setPromptText("Select Hotel");
        txtNoOfBeds.setText("");
        cmbStatus.setPromptText("Select Room Status");
        txtRoomNo.requestFocus();

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

    }

    @FXML
    void cmbCategoryKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbHotel.requestFocus();
        }

    }

    @FXML
    void cmbHotelKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            txtNoOfBeds.requestFocus();
        }

    }

    @FXML
    void cmbStatusKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            btnAdd.requestFocus();
        }

    }

    @FXML
    void txtNoOfBedsKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbStatus.requestFocus();
        }

    }

    @FXML
    void txtRoomNoKeyPress(KeyEvent event) {
        KeyCode k = event.getCode();
        if (k.getCode() == 10) {
            cmbCategory.requestFocus();
        }


    }
    void clear(){
        txtRoomNo.setText("");
        txtNoOfBeds.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomManagementController=new RoomManagementController();
        roomCategoryController=new RoomCategoryController();
        hotelDetailController=new HotelDetailController();
        loadComboBox();

    }
}
