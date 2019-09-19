package sample.oversikt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.internal.util.xml.impl.Input;
import sample.InputException;
import sample.Kunde.Kunde;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Kunde.Kunde.kundeForsikring;

public class OversiktController implements Initializable {

    @FXML
    private TableView<Kunde> tableView;
    @FXML
    TableColumn<Kunde, String> tableColumnForsikring;
    @FXML
    TableColumn<Kunde, String> tableColumnPris;

    @FXML
    private TextField txtTelefonnummer;

    @FXML
    void btnOversikt(ActionEvent event) throws InputException {
        int i=0;
        for(; i<kundeForsikring.size();i++){
            System.out.println(kundeForsikring);
            if(kundeForsikring.get(i).getEmail().equals(txtTelefonnummer.getText())){
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

        @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
