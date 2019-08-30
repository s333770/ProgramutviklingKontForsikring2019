package sample;

import java.io.IOException;

import static sample.BytteAvScener.lastInnStage;

public class Controller {
    public void kjop(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/kjop/kjop.fxml");
    }
}
