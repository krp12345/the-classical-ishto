package ishto.logic;


public class Pawn
{

	private int playerIndex;
    private int currentIndexOnPath;
	public Pawn(int player)
	{
	    currentIndexOnPath=0;
        this.playerIndex=player;
	}

    public void goToIndex(int index){
        currentIndexOnPath=index;
    }
    public int getCurrentIndexOnPath(){
	    return currentIndexOnPath;
    }
    public int getPlayerIndex(){
	    return playerIndex;
    }

}