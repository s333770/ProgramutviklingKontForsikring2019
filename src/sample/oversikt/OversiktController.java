package sample.oversikt;

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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.BytteAvScener.lastInnStage;
import static sample.Kunde.Kunde.kundeForsikring;

public class OversiktController implements Initializable, Runnable {

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


    public void btnPrintut(ActionEvent event) throws Exception {
        FileChooser filvelger=new FileChooser();
        File file=filvelger.showSaveDialog(null);
        String filType= SkrivData.getFileExtension(file.toString());
        try {
            if (filType.equals("csv")) {
                Thread.sleep(5000);
                StringBuilder csvUT = new StringBuilder();
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                Kunde kunde = new Kunde(tableView.getSelectionModel().getSelectedItem().getFornavn(), tableView.getSelectionModel().getSelectedItem().getEtternavn(), tableView.getSelectionModel().getSelectedItem().getEmail(), tableView.getSelectionModel().getSelectedItem().getTelefonnummer(), tableView.getSelectionModel().getSelectedItem().getType(), tableView.getSelectionModel().getSelectedItem().getPris());
                csvUT.append(kunde.getFornavn());
                csvUT.append(',');
                csvUT.append(kunde.getEtternavn());
                csvUT.append(',');
                csvUT.append(kunde.getEmail());
                csvUT.append(',');
                csvUT.append(kunde.getTelefonnummer());
                csvUT.append(',');
                csvUT.append(kunde.getType());
                csvUT.append(',');
                csvUT.append(kunde.getPris());
                pw.println(csvUT);
                pw.close();
            } else if (filType.equals("jobj")) {
                Thread.sleep(5000);
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                pw.println(tableView.getSelectionModel().getSelectedItem());
                pw.close();
            }
            else{
                alarmboks.setTitle("Ikke gyldig format");
                alarmboks.setContentText("Du må velge enten csv eller jobj");
                alarmboks.show();
            }
        }
        catch(IllegalArgumentException e){
            System.out.println(e);

        }
        }

        @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @Override
    public void run() {

    }
}
