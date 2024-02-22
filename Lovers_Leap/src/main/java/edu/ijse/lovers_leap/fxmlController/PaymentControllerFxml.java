package edu.ijse.lovers_leap.fxmlController;

import edu.ijse.lovers_leap.controller.CustomerController;
import edu.ijse.lovers_leap.controller.ReservationController;
import edu.ijse.lovers_leap.dto.PaymentCartDto;
import edu.ijse.lovers_leap.dto.ReservationSummaryDto;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class PaymentControllerFxml implements Initializable {
    private ReservationController reservationController;
    private CustomerController customerController;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnPayHere;



    @FXML
    private ComboBox<String> cmbPaymentMethod;

    @FXML
    private TableColumn<PaymentCartDto, Double> colAmoutPC;

    @FXML
    private TableColumn<ReservationSummaryDto, String> colContatcNoRS;

    @FXML
    private TableColumn<PaymentCartDto, String> colCusNamePC;

    @FXML
    private TableColumn<ReservationSummaryDto, String> colCusNameRS;

    @FXML
    private TableColumn<?, ?> colCustomerNamePS;

    @FXML
    private TableColumn<PaymentCartDto, String> colPAymentMethodPC;

    @FXML
    private TableColumn<ReservationSummaryDto, String> colPackageRS;

    @FXML
    private TableColumn<?, ?> colPaymentIdPS;

    @FXML
    private TableColumn<?, ?> colPaymentMethodPS;

    @FXML
    private TableColumn<PaymentCartDto, Integer> colReservationIDPC;

    @FXML
    private TableColumn<ReservationSummaryDto, Integer> colReservationIDRS;

    @FXML
    private TableColumn<ReservationSummaryDto, Double> colRoomCostRS;

    @FXML
    private TableColumn<ReservationSummaryDto, String> colRoomNoRs;

    @FXML
    private TableColumn<ReservationSummaryDto, Integer> colStayedDaysRS;

    @FXML
    private TableColumn<?, ?> colTotalAmountPS;

    @FXML
    private TableView<PaymentCartDto> tblPaymentCart;

    @FXML
    private TableView<?> tblPaymentSummary;

    @FXML
    private TableView<ReservationSummaryDto> tblReservationSummary;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtDaysStayed;

    @FXML
    private TextField txtReservationID;

    @FXML
    private TextField txtRoomCost;
    @FXML
    private TextField txtPackageCost;

    ObservableList<PaymentCartDto> pcDtos=FXCollections.observableArrayList();
    @FXML
    void btnAddToCartAction(ActionEvent event) {
        try {
            if(!txtReservationID.getText().isEmpty() | !txtCustomerName.getText().isEmpty() | !txtRoomCost.getText().isEmpty() | !txtPackageCost.getText().isEmpty() | !txtDaysStayed.getText().isEmpty() | !cmbPaymentMethod.getValue().isEmpty()){
                try{
                    pcDtos.add(new PaymentCartDto(Integer.parseInt(txtReservationID.getText()),((Double.parseDouble(txtRoomCost.getText()))*(Double.parseDouble(txtPackageCost.getText()))),cmbPaymentMethod.getValue(),txtCustomerName.getText()));
                    tblPaymentCart.setItems(pcDtos);
                    colReservationIDPC.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getReservationId()).asObject());
                    colAmoutPC.setCellValueFactory(c->new SimpleDoubleProperty(c.getValue().getAmount()).asObject());
                    colPAymentMethodPC.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getPaymentMethod()));
                    colCusNamePC.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getCustomerName()));
                    clear();
                }catch (Exception e){
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert2.setTitle("Error!");
                    alert2.setContentText("Please fill all the fields....");
                    Optional<ButtonType> result2 = alert2.showAndWait();
                }
            }else {
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Error!");
                alert2.setContentText("Please fill all the fields....");
                Optional<ButtonType> result2 = alert2.showAndWait();
            }
        }catch (Exception e){
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Error!");
            alert2.setContentText("Please fill all the fields....");
            Optional<ButtonType> result2 = alert2.showAndWait();
        }
    }
    void clear(){
        txtReservationID.setText("");
        txtCustomerName.setText("");
        txtRoomCost.setText("");
        txtPackageCost.setText("");
        txtDaysStayed.setText("");
        cmbPaymentMethod.setPromptText("Select method");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        PaymentCartDto dto=tblPaymentCart.getSelectionModel().getSelectedItem();
        pcDtos.remove(dto);

    }

    @FXML
    void btnPayHereAction(ActionEvent event) {
        

    }



    @FXML
    void cmbPaymentMethodKeyPressed(KeyEvent event) {

    }

    @FXML
    void tblPaymentSummaryMouseClick(MouseEvent event) {

    }

    @FXML
    void tblReservationSummaryMouseClick(MouseEvent event) {
        ReservationSummaryDto dto=tblReservationSummary.getSelectionModel().getSelectedItem();
        if(dto!=null){
            txtReservationID.setText(String.valueOf(dto.getReservationId()));
            txtCustomerName.setText(dto.getCustomerName());
            txtRoomCost.setText(String.valueOf(dto.getRoomCost()));
            txtDaysStayed.setText(String.valueOf(dto.getStayedDated()));

        }

    }

    @FXML
    void txtDaysStayedKeyPress(KeyEvent event) {

    }
    @FXML
    void txtRoomCostKeyPress(KeyEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reservationController=new ReservationController();
        customerController=new CustomerController();
        loadTables();

        ObservableList<String> list=FXCollections.observableArrayList();
        list.add("Card Payment");
        list.add("Cash Payment");
        list.add("Online Transfer");
        list.add("Cheque");
        cmbPaymentMethod.setItems(list);
    }

    void  loadTables(){
        ObservableList<ReservationSummaryDto> oList= FXCollections.observableArrayList();

        try {
            ArrayList<ReservationSummaryDto> rDtos=reservationController.getAllSummary();
            for(ReservationSummaryDto rsdto:rDtos){
               if(!rsdto.getPackageName().equals("Cancelled") & !rsdto.getPackageName().equals("Paid")){
                   oList.add(rsdto);
               }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        colReservationIDRS.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getReservationId()).asObject());
        colCusNameRS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getCustomerName()));
        colContatcNoRS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getContactNo()));
        colRoomNoRs.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getRoomNo()));
        colPackageRS.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getPackageName()));
        colRoomCostRS.setCellValueFactory(c->new SimpleDoubleProperty(c.getValue().getRoomCost()).asObject());
        colStayedDaysRS.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getStayedDated()).asObject());
        tblReservationSummary.setItems(oList);
    }

}
