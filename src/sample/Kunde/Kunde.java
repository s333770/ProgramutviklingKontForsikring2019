package sample.Kunde;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kunde {
    public static ObservableList<Kunde> kundeForsikring= FXCollections.observableArrayList();

    private SimpleStringProperty fornavn;
    private SimpleStringProperty etternavn;
    private SimpleStringProperty email;
    private SimpleStringProperty type;
    private SimpleStringProperty telefonnummer;
    private SimpleStringProperty pris;

    public String getTelefonnummer() {
        return telefonnummer.get();
    }

    public SimpleStringProperty telefonnummerProperty() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer.set(telefonnummer);
    }
    public static ObservableList<Kunde> getKundeForsikring() {
        return kundeForsikring;
    }

    public static void setKundeForsikring(ObservableList<Kunde> kundeForsikring) {
        Kunde.kundeForsikring = kundeForsikring;
    }

    public String getFornavn() {
        return fornavn.get();
    }

    public SimpleStringProperty fornavnProperty() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
    }

    public String getEtternavn() {
        return etternavn.get();
    }

    public SimpleStringProperty etternavnProperty() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn.set(etternavn);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getPris() {
        return pris.get();
    }

    public SimpleStringProperty prisProperty() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris.set(pris);
    }

    public Kunde(String fornavn, String etternavn, String email, String telefonnummer, String type, String pris) {
        this.fornavn = new SimpleStringProperty(fornavn);
        this.etternavn = new SimpleStringProperty(etternavn);
        this.email = new SimpleStringProperty(email);
        this.telefonnummer=new SimpleStringProperty(telefonnummer);
        this.type = new SimpleStringProperty(type);
        this.pris = new SimpleStringProperty(pris);


    }
    @Override
    public String toString(){
        return "Navn: "+fornavn+" "+etternavn+"Telefonnummer: "+ telefonnummer+"Email: "+email+"Type"+type+"Pris: "+pris;
    }
}
