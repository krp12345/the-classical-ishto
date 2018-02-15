package ishto.controller;
import ishto.ApplicationStarter;
import javafx.fxml.FXML;
public class RulesScreenController {
    public RulesScreenController() {
        System.out.println("i created");
    }
    @FXML
    private void onMainManuButtonClicked(){
        ApplicationStarter.primaryStage.getScene().setRoot(ApplicationStarter.mainScnVBox);
    }
}
