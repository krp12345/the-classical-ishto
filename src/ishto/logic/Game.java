package ishto.logic;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.Random;

public class Game
{

    private final Board gameBoard;
	private final int numberOfPlayers;
	private int currentPlayerIndex=0;
	static Player players[];
	private Random random;
	public Game(int numberOfPlayers, Color[] colorOfPlayers){
	    this.gameBoard=new Board(numberOfPlayers);
	    this.numberOfPlayers=numberOfPlayers;
        players = new Player[this.numberOfPlayers];
        for(int i=0;i<numberOfPlayers;i++){
			players[i]=new Player(i,colorOfPlayers[i]);
		}
		random=new Random();
	}

	public void move(int rawIndex, int coloumIndex, int mvs, GridPane gridPane){

	    if(gameBoard.getPawnsAtHome(currentPlayerIndex) == 4) {
			currentPlayerIndex++;
			currentPlayerIndex%=numberOfPlayers;
		}
		System.out.println("generating random number for move ");
	    mvs=random.nextInt(5);
        System.out.println("move = "+mvs);
	    if(mvs==0){
            mvs=8;
		}
		int success=gameBoard.move(currentPlayerIndex,rawIndex,coloumIndex,mvs,gridPane);

		if(success==0){
			currentPlayerIndex++;
			currentPlayerIndex%=numberOfPlayers;
            if(isGameEnded()){
                endGame();
            }
		}

	}

    private void endGame() {

    }

    private boolean isGameEnded(){

	    int count=0;
	    for(int i=0;i<numberOfPlayers;i++){
	        if(gameBoard.getPawnsAtHome(i)!=4) count++;
        }

        if(count>1) return false;
	    else return true;

    }

}