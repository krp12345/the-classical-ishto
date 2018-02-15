package ishto.logic;

import java.util.ArrayList;

public class Cell
{
	private ArrayList<Pawn> CellContent;
	private int positionX,positionY;

	public Cell(int x, int y)
	{
		this.positionX=x;
		this.positionY=y;
		CellContent=new ArrayList<>();
	}

	public void addPawn(Pawn pawn){
	    CellContent.add(pawn);
    }
    public ArrayList<Pawn> getPawnList(){
	    return this.CellContent;
    }
    public void removePawn(Pawn pawn){
	    if(CellContent.size() ==0 ) return;
        CellContent.remove(pawn);
    }

    public boolean isPlayerHere(int playerIndexToCheck){

	    for(int i=0;i<CellContent.size();i++){
            System.out.println("cell content "+CellContent.get(i).getPlayerIndex());
	        if(CellContent.get(i).getPlayerIndex() == playerIndexToCheck) return true;
        }

	    return false;
    }
    public void clearContent(){

	    CellContent.clear();
    }
    public int isAnotherPlayerHere(int playerIndexToCheck){
	    int countOfAnotherPlayer=0;
        for(int i=0;i<CellContent.size();i++){
            if(CellContent.get(i).getPlayerIndex() != playerIndexToCheck) countOfAnotherPlayer++;
        }
        return countOfAnotherPlayer;
    }

    public Pawn getPawnOfPlayer(int playerIndex){

	    for(int i=0;i<CellContent.size();i++){
	        if(CellContent.get(i).getPlayerIndex() == playerIndex) return CellContent.get(i);
        }

        return null;
    }

    public void addAllPawn(ArrayList<Pawn> listOfPawn){
	    for(int i=0;i<listOfPawn.size();i++){
	        listOfPawn.get(i).goToIndex(0);
        }

	    CellContent.addAll(listOfPawn);

    }


}