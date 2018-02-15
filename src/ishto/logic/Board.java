package ishto.logic;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static ishto.logic.Game.players;

public class Board
{

    private final int numberOfPlayers;
    private int numberOfPawnsAtHome[];
    private Cell[][] cells;
    //private Player players[];


    Board(int numberOfPlayers){
        this.numberOfPawnsAtHome =new int[numberOfPlayers];
        this.numberOfPlayers=numberOfPlayers;
      //  this.players=new Player[this.numberOfPlayers];

        cells=new Cell[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                cells[i][j]=new Cell(i,j);
            }
        }
        for(int i=0;i<this.numberOfPlayers;i++){
            for(int j=0;j<4;j++){
                cells[PlayerPaths.paths[i][0][0]][PlayerPaths.paths[i][0][1]].addPawn(new Pawn(i));
            }
        }
    }


    public int getPawnsAtHome(int index){
        return numberOfPawnsAtHome[index];
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
    private void addInGridPane(GridPane gridPane,Node node){
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                Node temp=getNodeFromGridPane(gridPane,j,i);
                if(temp==null){
                    gridPane.add(node,j,i);
                    return;
                }
            }
        }
    }
    private Circle getCircleFromPlayerIndex(GridPane gridPane,int playerIndex){
        ObservableList<Node> ls=gridPane.getChildren();
        for(Node c: ls){
            Circle circle=(Circle)c;
            Color color=(Color) circle.getFill();
            if(players[playerIndex].getColor().equals(color)){
                return circle;
            }
        }
        return null;
    }
    public int move(int playerIndex, int cellX, int cellY, int mv, GridPane gridPane){
        System.out.println("player "+playerIndex+" cellX "+cellX+" cellY "+cellY+" move "+mv);
        if(cellX==2 && cellY==2){
            return 1;
        }

        if(!cells[cellX][cellY].isPlayerHere(playerIndex)) {
            System.out.println("player not found");
            return 1;}

        GridPane prevCell=(GridPane) getNodeFromGridPane(gridPane,cellY,cellX);
        Circle pawnCircle=getCircleFromPlayerIndex(prevCell,playerIndex);

        if(pawnCircle==null) {
            System.out.println("pawn null");
            return 1;
        }

        Pawn pawnAtCell=cells[cellX][cellY].getPawnOfPlayer(playerIndex);

        if(pawnAtCell.getCurrentIndexOnPath()+ mv >= 25  ){
            System.out.println("over move");
            return 1;
        }



        int nextIndex;

        if(players[playerIndex].gotTod())
            nextIndex = pawnAtCell.getCurrentIndexOnPath() + mv;
        else
            nextIndex=(pawnAtCell.getCurrentIndexOnPath() + mv)%16;

        int x=PlayerPaths.paths[playerIndex][nextIndex][0];
        int y=PlayerPaths.paths[playerIndex][nextIndex][1];
        GridPane nextCell=(GridPane) getNodeFromGridPane(gridPane,y,x);
        if((x==0 && y==2) || (x==2 && y==0) || (x==4 && y==2) || (x==2 && y==4) || (x==2 && y==2))
        {
            cells[cellX][cellY].removePawn(pawnAtCell);
            prevCell.getChildren().remove(pawnCircle);

            cells[x][y].addPawn(pawnAtCell);
            //nextCell.getChildren().add(pawnCircle);
            addInGridPane(nextCell,pawnCircle);
            pawnAtCell.goToIndex(nextIndex);
            if( (x==2 && y==2)){
                numberOfPawnsAtHome[playerIndex]++;
            }
            return 0;
        }

        int countOfAnotherPlayer=cells[x][y].isAnotherPlayerHere(playerIndex);

        if(countOfAnotherPlayer%2==1 || countOfAnotherPlayer==0){

            if(countOfAnotherPlayer!=0){
                int playerIndexToSend=cells[x][y].getPawnList().get(0).getPlayerIndex();
                int hx,hy;
                hx=PlayerPaths.paths[playerIndexToSend][0][0];
                hy=PlayerPaths.paths[playerIndexToSend][0][1];
                GridPane homeGridPane=(GridPane) getNodeFromGridPane(gridPane,hy,hx);
                homeGridPane.getChildren().addAll(nextCell.getChildren());
                cells[hx][hy].addAllPawn(cells[x][y].getPawnList());
                cells[x][y].clearContent();
                nextCell.getChildren().clear();
                players[playerIndex].setTod();
            }

            cells[cellX][cellY].removePawn(pawnAtCell);
            prevCell.getChildren().remove(pawnCircle);
            cells[x][y].addPawn(pawnAtCell);
            nextCell.getChildren().add(pawnCircle);

            pawnAtCell.goToIndex(nextIndex);

        }

        else{
            return 1;
        }

        checkAgainIfAnyTodReseted();
        return 0;
    }

    private void checkAgainIfAnyTodReseted() {
        for(int j=0;j<numberOfPlayers;j++){
            int x,y;
            x=PlayerPaths.paths[j][0][0];
            y=PlayerPaths.paths[j][0][1];
            ArrayList<Pawn> al=cells[x][y].getPawnList();
            int count=0;
            for(int i=0;i<al.size();i++){
                if(al.get(i).getPlayerIndex()==0) count++;
            }
            if(count==4){
                players[j].removeTod();
            }
        }
    }

}