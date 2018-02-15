package ishto.logic;

import javafx.scene.paint.Color;

public class Player
{
    private int currIndex=0;
    private boolean tod=false;
    private final Color color;

    private final int playerIndex;
    public Player(int playerIndex,Color color)
	{
        this.playerIndex=playerIndex;
        this.color=color;
	}

	public  void setTod(){
        this.tod=true;
    }

    public  void removeTod(){
        this.tod=false;
    }

    public boolean gotTod(){
        return this.tod;
    }

    public Color getColor(){
        return this.color;
    }
}
