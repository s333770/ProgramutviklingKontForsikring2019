package sample.oversikt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.InputException;
import sample.Kunde.Kunde;
import sample.PrintUt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.BytteAvScener.lastInnStage;
import static sample.Kunde.Kunde.kundeForsikring;

public class OversiktController implements Initializable {

    @FXML
    private TableView<Kunde> tableView;
    @FXML
    TableColumn<Kunde, String> tableColumnForsikring;
    @FXML
    TableColumn<Kunde, String> tableColumnPris;
    @FXML
    private TextField telefonEllerEmail;

    @FXML
    void btnOversikt(ActionEvent event) throws InputException {
        int i=0;
        for(; i<kundeForsikring.size();i++){
            System.out.println(kundeForsikring);
            if(kundeForsikring.get(i).getEmail().equals(telefonEllerEmail.getText())||kundeForsikring.get(i).getTelefonnummer().equals(telefonEllerEmail.getText())){
                setTabellVerdier("Forsikring","Pris");
                tableView.setItems(kundeForsikring);
            }
            else{
                tableView.getItems().clear();
            }
        }

    }
    public void setTabellVerdier(String forsikring,String pris) {

        tableColumnForsikring.setCellValueFactory(new PropertyValueFactory<Kunde,String>("type"));
        tableColumnPris.setCellValueFactory(new PropertyValueFactory<Kunde,String>("pris"));

    }
    public void btnTilbake(javafx.event.ActionEvent actionEvent) throws IOException {
            lastInnStage(actionEvent, "/sample/sample.fxml");
        }
    public void btnPrintut(ActionEvent event) throws Exception {
        PrintUt task = new PrintUt();
        new Thread(task).start(); //Nå fungerer trådprogrammering
        Kunde kundeSkrivUt = new Kunde(tableView.getSelectionModel().getSelectedItem().getFornavn(), tableView.getSelectionModel().getSelectedItem().getEtternavn(),tableView.getSelectionModel().getSelectedItem().getTelefonnummer(),
                tableView.getSelectionModel().getSelectedItem().getEmail(), tableView.getSelectionModel().getSelectedItem().getType(), tableView.getSelectionModel().getSelectedItem().getPris());
        System.out.println(kundeSkrivUt);


        }

        @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
