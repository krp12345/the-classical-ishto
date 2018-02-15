package ishto.controller;
import ishto.ApplicationStarter;
import javafx.fxml.FXML;

import static ishto.ApplicationStarter.primaryStage;

public class RulesScreenController {
    public RulesScreenController() {
        System.out.println("i created");
    }
    @FXML
    private void onMainManuButtonClicked(){
        ApplicationStarter.primaryStage.getScene().setRoot(ApplicationStarter.mainScnVBox);
        primaryStage.sizeToScene();
    }
}
