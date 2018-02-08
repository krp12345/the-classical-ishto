package ishto.controller;

import ishto.ApplicationStarter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NumberOfPlayersController {
    public Scene prefScene;
    public NumberOfPlayersController() throws IOException{
        System.out.println("here i am");
        FXMLLoader loaderPlayerPref;
        loaderPlayerPref=new FXMLLoader();
        File player_pref;
        player_pref=new File("/home/rushikesh/IdeaProjects/the classical ishto/src/ishto/res/fxml/player_name_colour_scene.fxml");

        FileInputStream streamPlayerPref;
        streamPlayerPref=new FileInputStream(player_pref);
        VBox vBoxForPlayerPref;
        vBoxForPlayerPref= loaderPlayerPref.load(streamPlayerPref);
        prefScene=new Scene(vBoxForPlayerPref);

    }

    @FXML
    private void onBackButtonAction()
    {
        ApplicationStarter.prStage.setScene(ApplicationStarter.mainScn);
    }

    @FXML
    private void onContinueClicked(){
        ApplicationStarter.prStage.setScene(prefScene);
    }
}