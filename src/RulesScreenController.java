package ishto;

import javafx.fxml.FXML;

public class RulesScreenController {

    public RulesScreenController() {
        System.out.println("i created");
    }

    @FXML
    private void onMainManuButtonClicked(){

        ApplicationStarter.prStage.setScene(ApplicationStarter.mainScn);

    }

}