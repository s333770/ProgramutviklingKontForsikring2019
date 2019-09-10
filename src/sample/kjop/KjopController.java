package sample.kjop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.Kunde.Kunde;

import java.util.InputMismatchException;

import static sample.Kunde.Kunde.kundeForsikring;

public class KjopController {

    @FXML
    private TextField txtFornavn;

    @FXML
    private TextField txtEtternavn;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPris;


    @FXML
        void bekreftKjop(ActionEvent event) {
            kundeForsikring.add(new Kunde(txtFornavn.getText(),txtEtternavn.getText(),txtEmail.getText(),"1000"));
        }

        @FXML
        void fritidKjop(ActionEvent event) {

        }

        @FXML
        void kjopBat(ActionEvent event) {

        }

        @FXML
        void kjopInnbo(ActionEvent event) {

        }

        @FXML
        void reiseKjop(ActionEvent event) {

        }
    Alert informasjonboks = new Alert(Alert.AlertType.INFORMATION); // Lager en alarmboks

        public void sjekkOmAlleFeltErFyltUt() throws InputMismatchException {
            try {
                if (txtFornavn.getText() == null || txtEtternavn.getText() == null || txtEmail.getText() == null) {
                    throw new InputMismatchException("Alle feltene er ikke fylt ut ");
                }
            }
            catch(InputMismatchException e){
                System.err.println(e.getMessage());
                informasjonboks.setTitle("Feil i en av inputfeltene");
                informasjonboks.setContentText(e.getMessage());
                informasjonboks.show();
            }
        }

}





