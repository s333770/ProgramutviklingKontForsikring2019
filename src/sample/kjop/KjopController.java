package sample.kjop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Alarmboks;
import sample.Kunde.Kunde;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import static sample.BytteAvScener.lastInnStage;
import static sample.Kunde.Kunde.kundeForsikring;

public class KjopController implements Initializable {

    @FXML
    private TextField txtFornavn;

    @FXML
    private TextField txtEtternavn;

    @FXML
    private TextField txtTelefon;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblPris;

    @FXML
    private Label lblType;

    @FXML
    private Label labelBekreftelse;

    @FXML
    private ChoiceBox<String> choiceBox=new ChoiceBox<>();

    private void visElementer(ActionEvent actionEvent) {
        if (choiceBox.getValue() == "Båt") {
            lblType.setText("Båt");
            lblPris.setText("1200");
        } else if (choiceBox.getValue() == "Innbo") {
            lblType.setText("Innbo");
            lblPris.setText("2000");
        } else if (choiceBox.getValue() == "Fritidsbolig") {
            lblType.setText("Fritid");
            lblPris.setText("3000");
        } else if (choiceBox.getValue() == "Reise") {
            lblType.setText("Reise");
            lblPris.setText("1100");
        }
    }


    Alert alarmboks = new Alert(Alert.AlertType.INFORMATION); // Lager en alarmboks


    public void tilbake(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/sample.fxml");
    }

    private void sjekkOmAlleFeltErFyltUt() throws InputMismatchException {
        if (txtFornavn.getText().equals("")  || txtEtternavn.getText().equals("") || txtEmail.getText().equals("")||txtTelefon.getText().equals("")) {
            throw new InputMismatchException("Alle feltene er ikke fylt ut ");
        }
    }

    @FXML
    void bekreftKjop(ActionEvent event) {

        try{
             sjekkOmAlleFeltErFyltUt();
                kundeForsikring.add(new Kunde(txtFornavn.getText(),txtEtternavn.getText(),txtTelefon.getText(),txtEmail.getText(),lblType.getText(),lblPris.getText()));
                labelBekreftelse.setText("Bestilling bekreftet");
                System.out.println(kundeForsikring);
        }
        catch(InputMismatchException e){
            System.err.println(e.getMessage());
            alarmboks.setTitle("Feil i en av inputfeltene");
            alarmboks.setContentText(e.getMessage());
            alarmboks.show();

        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll("Båt", "Innbo", "Reise", "Fritidsbolig");
        choiceBox.setOnAction(this::visElementer);
    }
}





