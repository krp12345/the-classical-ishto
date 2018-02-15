package ishto.controller;

import ishto.ApplicationStarter;
import ishto.logic.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import static ishto.ApplicationStarter.primaryStage;

public class GameController {

    public GameController(){


    }

    @FXML
    private void onMinimizeButtonClicked(){
        ApplicationStarter.primaryStage.setIconified(true);

    }
    @FXML
    private void onStopGame(){
        Platform.exit();
    }
    @FXML
    private void onNewGame(){

        ApplicationStarter.primaryStage.getScene().setRoot(MainScreenController.numberOfPlayersVBox);
        primaryStage.sizeToScene();
    }
    @FXML
    public void mouseEntered(MouseEvent event){

        Node source = (Node)event.getSource() ;
        System.out.println(source.getParent().toString());

        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.println(colIndex+" "+rowIndex);

        PlayerColourSceneController.game.move(rowIndex,colIndex,4,(GridPane) source.getParent());

    }

}