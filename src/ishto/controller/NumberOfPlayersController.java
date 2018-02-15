package ishto.controller;

import ishto.ApplicationStarter;
import ishto.logic.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static ishto.ApplicationStarter.primaryStage;

public class NumberOfPlayersController {
    //public static Scene prefScene;
    public static VBox prefScene;
    public static int numberOfPlayers=-1;
    public NumberOfPlayersController() throws IOException{
        System.out.println("NumberOfPlayersController object constructed");
        FXMLLoader loaderPlayerPref;
        loaderPlayerPref=new FXMLLoader(getClass().getResource("fxml/player_name_colour_scene.fxml"));
        if(loaderPlayerPref ==null){
            System.out.println("can not load FXMLoader ( player name ..fxml)");
        }

        VBox vBoxForPlayerPref;
        Object obj=loaderPlayerPref.load();
        vBoxForPlayerPref= (VBox) obj;
        //prefScene=new Scene(vBoxForPlayerPref);
        prefScene=vBoxForPlayerPref;
        System.out.println("NumberOfPlayersController object created");
    }
    @FXML
    private void onBackButtonAction()
    {

        ApplicationStarter.primaryStage.getScene().setRoot(ApplicationStarter.mainScnVBox);
        primaryStage.sizeToScene();
    }

    @FXML
    private void onContinueClicked(){

        if(numberOfPlayers==-1){
            return;
        }

        System.out.println("number of players "+numberOfPlayers);


        ApplicationStarter.primaryStage.getScene().setRoot(prefScene);
        primaryStage.sizeToScene();

    }

    @FXML
    private void onTwoPlayerSelected(){
        numberOfPlayers=2;
    }

    @FXML
    private void onThreePlayerSelected(){
        numberOfPlayers=3;
    }

    @FXML
    private void onFourPlayerSelected(){
        numberOfPlayers=4;
    }

    @FXML
    private void onMinimizeButtonClick(){
        ApplicationStarter.primaryStage.setIconified(true);
    }
}
