package MainPackage;

import java.awt.Color;

import javax.swing.JLabel;


public class Player {
	
	private String Name;
	private boolean isMyTurn;
	private Color circleColor;
	private int turnCount;
	private int winCount;
	public JLabel myLabel;

	
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
	
	public String getName()
	{
		return Name;
	}
	
	public Color getColor()
	{
		return circleColor;
	}
}
