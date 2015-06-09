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
	public boolean [][] playerTab;
	private int rows = 6;
	private int columns = 7;

	
	public Player(String playerName, Color playerColor){
		Name = playerName;
		circleColor = playerColor;
		playerTabInit();
	}
	
	public void playerTabInit(){
	
		playerTab = new boolean [rows][columns];
		clear();
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
	
	public void fillField(int x, int y)
	{
		playerTab[x][y] = true;
	}
	
	public void clear()
	{
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
			{
				playerTab[i][j]=false;
			}
		}
	}
}
