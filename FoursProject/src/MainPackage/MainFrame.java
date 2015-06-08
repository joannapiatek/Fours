package MainPackage;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements GameStartListener{

	public ConfigFrame cfgFrame;
	public JLabel lblGracz_1;
	public JLabel lblGracz_2;
	public Player player1;
	public Player player2;
	
	@Override
	public void gameStart() {
		createGame();
	}
	
	public void createGame()
	{
		player1 = cfgFrame.getPlayer1();
		player2 = cfgFrame.getPlayer2();
		System.out.println("" + player1.getName() + " i " + player2.getName());
		
		lblGracz_1.setText("" + player1.getName());
		lblGracz_2.setText("" + player2.getName());
		
	}
}
