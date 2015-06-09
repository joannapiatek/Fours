package MainPackage;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements GameStartListener, PropertyChangeListener {


	private static final long serialVersionUID = 1L;
	public ConfigFrame cfgFrame;
	public GamePanel gamePanel;
	public JLabel lblGracz_1;
	public JLabel lblGracz_2;
	public Player player1;
	public Player player2;
	public List<Player> playerList;
	private int active = 0;
	private int inactive = 1;
	
	@Override
	public void gameStart() {
		createGame();
	}
	
	public void createGame()
	{
		gamePanel = new GamePanel();
		gamePanel.addPropertyChangeListener(this);
		setPanel();
		initPlayers();
		start();
	}
	
	public void start()
	{
		changeTurns();
	}
	
	public void changeTurns()
	{
		//Zamiana pozycji graczy - ten z pozycj¹ 0 zawsze bêdzie aktywny
		Collections.swap(playerList, 0, 1);
		
		Player p = playerList.get(active);
		p.myLabel.setForeground(p.getColor());
		gamePanel.setPlayerColor(p.getColor());
		
		Player old = playerList.get(inactive);
		old.myLabel.setForeground(Color.BLACK);
	}
	
	public void isGameWon()
	{
		//tu sprawdzanie, czy ktoœ wygra³
		if ( CheckAlgorithm.checkAll(playerList.get(active)) )
		{
			JOptionPane.showMessageDialog(this,
				    "Zwyciezc¹ zostaje "+ playerList.get(active).getName() + "!",
				    "Koniec gry!",
				    JOptionPane.PLAIN_MESSAGE);
			//czyszczenie planszy
			clear();
		}
		else
			changeTurns();
	}
	
	public void clear()
	{
		gamePanel.clear();
		remove(gamePanel);
		setPanel();
		revalidate();
		start();
	}
	
	//Uruchamia siê, gdy ruch zosta³ wykonany prawid³owo - GamePanel, linia 90-91
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		gamePanel.resetSuccess();
		isGameWon();
	}
	
//inicjalizacja	
	public void setPanel()
	{
		
		GridBagConstraints gbc_gamePanel = new GridBagConstraints();
		gbc_gamePanel.gridheight = 3;
		gbc_gamePanel.gridwidth = 3;
		gbc_gamePanel.gridx = 0;
		gbc_gamePanel.gridy = 2;
		getContentPane().add(gamePanel, gbc_gamePanel);
	}
	
	public void initPlayers()
	{
		player1 = cfgFrame.getPlayer1();
		player2 = cfgFrame.getPlayer2();
		player1.myLabel = lblGracz_1;
		player2.myLabel = lblGracz_2;
		
		//Lista graczy dla u³atwienia prze³¹czania pomiêdzy nimi
		playerList = gamePanel.playerList;
		playerList.add(player1);
		playerList.add(player2);
		
		for (int i = 0; i< playerList.size(); i++)
		{
			playerList.get(i).myLabel.setText("" + playerList.get(i).getName()); 
		}
	}
	
	
}
