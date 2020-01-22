package sample.siOpp;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import sample.InputException;
import sample.Kunde.Kunde;
import sample.SkrivUt.SkrivData;
import sample.SkrivUt.SkrivUtDataCSV;
import sample.SkrivUt.SkrivUtDataJOBJ;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static sample.BytteAvScener.lastInnStage;
import static sample.Kunde.Kunde.kundeForsikring;
import static sample.SkrivUt.SkrivUtDataCSV.*;

public class SiOppController implements Initializable{


    @FXML
    private TableView<Kunde> tableView;
    @FXML
    private TableColumn<Kunde, String> tableColumnForsikring;
    @FXML
    private TableColumn<Kunde, String> tableColumnPris;
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
    Alert alarmboks = new Alert(Alert.AlertType.INFORMATION); // Lager en alarmboks


    public void setTabellVerdier(String forsikring,String pris) {
        tableColumnForsikring.setCellValueFactory(new PropertyValueFactory<Kunde,String>("type"));
        tableColumnPris.setCellValueFactory(new PropertyValueFactory<Kunde,String>("pris"));

    }
    public void btnTilbake(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/sample.fxml");
    }
    private void threadDone() {
        System.out.println("Thread has completed");
    }

    public void btnSiOpp(ActionEvent event) throws Exception {

            Kunde valgtKunde=tableView.getSelectionModel().getSelectedItem();
            tableView.getItems().remove(valgtKunde);


    }







    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }



}
