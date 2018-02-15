package ishto.controller;
import ishto.ApplicationStarter;
import ishto.logic.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
public class PlayerColourSceneController {
    private final VBox gameLook;
    public static Game game;
    public PlayerColourSceneController() throws IOException {
        System.out.println("player name and colour controller created");
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("fxml/game.fxml"));

        VBox vb=fxmlLoader.load();
        gameLook=vb;
        //gameLook = new Scene(vb);
    }
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        System.out.println("returning null");
        return null;
    }

    @FXML
    private void goToPlay(ActionEvent event){
        Node node=(Node) event.getSource();
        VBox vBox=(VBox) node.getParent().getParent();
        Color arr[]=new Color[NumberOfPlayersController.numberOfPlayers];
        int i;
        for(i=0;i<NumberOfPlayersController.numberOfPlayers;i++){
            arr[i]=new Color(0,0,0,0);
        }
        i=0;
        for(Node nd :vBox.getChildren()){
            if(nd instanceof HBox){
                for(Node nd2 : ((HBox) nd).getChildren()){
                    if(nd2 instanceof ColorPicker){
                        System.out.println("found colour picker");
                        ColorPicker colorPicker=(ColorPicker) nd2;
                        Color color=colorPicker.getValue();
                        arr[i++]=color;
                    }
                }
            }
        }
        i=0;
        for(Node temp: gameLook.getChildren()){
            if(temp instanceof HBox){
                for(Node temp2 : ((HBox) temp).getChildren()){
                    if(temp2 instanceof GridPane){

                        GridPane gp1=(GridPane) getNodeFromGridPane((GridPane) temp2,0,2);
                        for(Node circle : gp1.getChildren()){
                            circle=(Circle)circle;
                            circle.setStyle("-fx-fill: "+"#"+Integer.toHexString(arr[0].hashCode()));
                        }

                        GridPane gp2=(GridPane) getNodeFromGridPane((GridPane) temp2,2,0);
                        for(Node circle : gp2.getChildren()){
                            circle=(Circle)circle;
                            circle.setStyle("-fx-fill: "+"#"+Integer.toHexString(arr[1].hashCode()));
                        }


                        GridPane gp3=(GridPane) getNodeFromGridPane((GridPane) temp2,4,2);
                        for(Node circle : gp3.getChildren()){
                            circle=(Circle)circle;
                            circle.setStyle("-fx-fill: "+"#"+Integer.toHexString(arr[2].hashCode()));
                        }


                        GridPane gp4=(GridPane) getNodeFromGridPane((GridPane) temp2,2,4);
                        for(Node circle : gp4.getChildren()){
                            circle=(Circle)circle;
                            circle.setStyle("-fx-fill: "+"#"+Integer.toHexString(arr[3].hashCode()));
                        }
                    }
                }
            }
        }

        for( i=0;i<NumberOfPlayersController.numberOfPlayers-1;i++){
            for(int j=i+1;j<NumberOfPlayersController.numberOfPlayers;j++){
                if(arr[i].equals(arr[j])){
                    System.out.println("select different colors"); return;
                }
            }
        }

        System.out.println("going to play");
        game=new Game(NumberOfPlayersController.numberOfPlayers,arr);
        ApplicationStarter.primaryStage.getScene().setRoot(gameLook);
        ApplicationStarter.primaryStage.sizeToScene();

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
