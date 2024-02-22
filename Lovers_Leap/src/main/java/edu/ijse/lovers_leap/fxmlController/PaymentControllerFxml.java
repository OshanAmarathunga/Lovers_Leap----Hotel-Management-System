package edu.ijse.lovers_leap.fxmlController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PaymentControllerFxml {
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnPayHere;

    @FXML
    private ComboBox<?> cmbPackageCost;

    @FXML
    private ComboBox<?> cmbPaymentMethod;

    @FXML
    private TableColumn<?, ?> colAmoutPC;

    @FXML
    private TableColumn<?, ?> colContatcNoRS;

    @FXML
    private TableColumn<?, ?> colCusNamePC;

    @FXML
    private TableColumn<?, ?> colCusNameRS;

    @FXML
    private TableColumn<?, ?> colCustomerNamePS;

    @FXML
    private TableColumn<?, ?> colPAymentMethodPC;

    @FXML
    private TableColumn<?, ?> colPackageRS;

    @FXML
    private TableColumn<?, ?> colPaymentIdPS;

    @FXML
    private TableColumn<?, ?> colPaymentMethodPS;

    @FXML
    private TableColumn<?, ?> colReservationIDPC;

    @FXML
    private TableColumn<?, ?> colReservationIDRS;

    @FXML
    private TableColumn<?, ?> colRoomCostRS;

    @FXML
    private TableColumn<?, ?> colRoomNoRs;

    @FXML
    private TableColumn<?, ?> colStayedDaysRS;

    @FXML
    private TableColumn<?, ?> colTotalAmountPS;

    @FXML
    private TableView<?> tblPaymentCart;

    @FXML
    private TableView<?> tblPaymentSummary;

    @FXML
    private TableView<?> tblReservationSummary;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtDaysStayed;

    @FXML
    private TextField txtReservationID;

    @FXML
    private TextField txtRoomCost;

    @FXML
    void btnAddToCartAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

    }

    @FXML
    void btnPayHereAction(ActionEvent event) {

    }

    @FXML
    void cmbPackageCostKeyPress(KeyEvent event) {

    }

    @FXML
    void cmbPaymentMethodKeyPressed(KeyEvent event) {

    }

    @FXML
    void tblPaymentSummaryMouseClick(MouseEvent event) {

    }

    @FXML
    void tblReservationSummaryMouseClick(MouseEvent event) {

    }

    @FXML
    void txtDaysStayedKeyPress(KeyEvent event) {

    }
}
