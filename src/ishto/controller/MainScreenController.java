package ishto.controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.io.IOException;
import static ishto.ApplicationStarter.primaryStage;

public class MainScreenController {
    public final VBox rulesScene;
    public static VBox numberOfPlayersVBox;
    public MainScreenController() throws  IOException {
        System.out.println("MainScreenController object created");
        FXMLLoader nofp=new FXMLLoader(getClass().getResource("fxml/number_of_players.fxml"));
        VBox vb2;
        vb2 = nofp.load();
        numberOfPlayersVBox =vb2;

        FXMLLoader fxm;
        fxm=new FXMLLoader(getClass().getResource("fxml/rules_description.fxml"));
        VBox vb=fxm.load();
        int sz=vb.getChildren().size();
        int i;
        for(i=0;i<sz;i++){
            Node temp=vb.getChildren().get(i);
            if(temp instanceof WebView){
                System.out.println("found object");
                WebEngine webeng=((WebView) temp).getEngine();
                webeng.load(getClass().getResource("other/rules.html").toExternalForm());
            }
        }
        rulesScene=vb;
        //rulesScene =new Scene(vb);
    }

    @FXML
    private void onRulesButtonClickedAction()
    {
        primaryStage.getScene().setRoot(rulesScene);
        primaryStage.sizeToScene();
    }
    @FXML
    private void onplayNowButtonClickAction()
    {
        System.out.println("original");
        System.out.println(primaryStage.getHeight());
        System.out.println(primaryStage.getWidth());
        System.out.println("vbox size");
        primaryStage.getScene().setRoot(numberOfPlayersVBox);
        primaryStage.sizeToScene();
    }
    @FXML
    private void onQuitButtonClicked(){
        Platform.exit();
    }
    @FXML
    private void onMinimizeButtonClick(){
        primaryStage.setIconified(true);
    }
}