package ishto.controller;
import ishto.ApplicationStarter;
import ishto.logic.Game;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
public class PlayerColourSceneController {
    private final Scene gameLook;
    public static Game game;
    public PlayerColourSceneController() throws IOException {
        System.out.println("player name and colour controller created");
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("fxml/game.fxml"));
        VBox vb=fxmlLoader.load();
        gameLook = new Scene(vb);
    }
    @FXML
    private void goToPlay(ActionEvent event){
        Node node=(Node) event.getSource();
        VBox vBox=(VBox) node.getParent().getParent();
        Color arr[]=new Color[NumberOfPlayersController.numberOfPlayers];
        int i=0;
        for(Node nd :vBox.getChildren()){
            if(nd instanceof ColorPicker){
                ColorPicker colorPicker=(ColorPicker) nd;
                Color color=colorPicker.getValue();
                arr[i++]=color;
            }
        }
        System.out.println("going to play");
        game=new Game(4,arr);
        ApplicationStarter.primaryStage.setScene(gameLook);
    }

    @FXML
    private void goToBack(){
        ApplicationStarter.primaryStage.getScene().setRoot(MainScreenController.numberOfPlayersVBox);
    }

    @FXML
    private void onMinimizeButtonClick(){
        ApplicationStarter.primaryStage.setIconified(true);
    }
}