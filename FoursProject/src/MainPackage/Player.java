package MainPackage;

import java.awt.Color;


public class Player {
	
	private String Name;
	private boolean isMyTurn;
	private Color circleColor;
	private int turnCount;
	private int winCount;

	
	public Player(String playerName, Color playerColor){
		Name = playerName;
		circleColor = playerColor;
	}
	
	public int getTurnCount(){
		return turnCount;
	}
	
	public boolean isActiveTurn(){
		return isMyTurn;
	}
	
	public void setActiveTurn(){
		isMyTurn=true;
	}
	
	public void disableActiveTurn(){
		isMyTurn=false;
	}
	
	public void increaseWinCount(){
		winCount += 1;
	}
	
	public void resetWinCount(){
		winCount=0;
	}
}
