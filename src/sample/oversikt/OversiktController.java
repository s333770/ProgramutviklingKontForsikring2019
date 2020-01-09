package sample.oversikt;

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

public class OversiktController implements Initializable{

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

    public void btnPrintut(ActionEvent event) throws Exception {
            FileChooser filvelger = new FileChooser();
            File file = filvelger.showSaveDialog(null);
            String filType = SkrivData.getFileExtension(file.toString());

            file.createNewFile();
            try {
                if (filType.equals("csv")) {
                    ExecutorService service = Executors.newSingleThreadExecutor();
                    SkrivUtDataCSV task;
                    task = new SkrivUtDataCSV(file,tableView.getSelectionModel().getSelectedItem().getFornavn(), tableView.getSelectionModel().getSelectedItem().getEtternavn(), tableView.getSelectionModel().getSelectedItem().getEmail(), tableView.getSelectionModel().getSelectedItem().getTelefonnummer(), tableView.getSelectionModel().getSelectedItem().getType(), tableView.getSelectionModel().getSelectedItem().getPris());
                    service.execute(task);

                } else if (filType.equals("jobj")) {
                    Thread.sleep(5000);// For å sjekke om trådprogrammering fungerer
                    file.createNewFile();
                    //pw.println(tableView.getSelectionModel().getSelectedItem());
                    //pw.close();
                } else {
                    alarmboks.setTitle("Ikke gyldig format");
                    alarmboks.setContentText("Du må velge enten csv eller jobj");
                    alarmboks.show();
                }
                System.out.println("Hello world");


            } catch (IllegalArgumentException e) {
                System.out.println(e);

            }



        }



        @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


}
