package sample;

import java.io.IOException;

import static sample.BytteAvScener.lastInnStage;

public class Controller {
    public void kjop(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/kjop/kjop.fxml");
    }
    public void oversikt(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/oversikt/oversikt.fxml");
    }
    public void skade(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/skade/skade.fxml");
    }
    public void siOpp(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/siOpp/siOpp.fxml");
    }
}
