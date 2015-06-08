package MainPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow implements GameStartListener{
	
	private MainFrame frmFours;
	private GamePanel gamePanel;
	//private ConfigFrame configFrame;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmFours.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFours = new MainFrame();
		frmFours.setTitle("Fours");
		frmFours.setResizable(true);
		frmFours.setBounds(100, 100, 430, 323);
		frmFours.setLocationRelativeTo(null);
		frmFours.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {87, 117, 105, 0};
		gridBagLayout.rowHeights = new int[] {10, 23, 42, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		frmFours.getContentPane().setLayout(gridBagLayout);
		
		frmFours.lblGracz_1 = new JLabel("Gracz1");
		GridBagConstraints gbc_lblGracz_1 = new GridBagConstraints();
		gbc_lblGracz_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGracz_1.gridx = 0;
		gbc_lblGracz_1.gridy = 1;
		frmFours.getContentPane().add(frmFours.lblGracz_1, gbc_lblGracz_1);
		
		frmFours.lblGracz_2 = new JLabel("Gracz2");
		GridBagConstraints gbc_lblGracz_2 = new GridBagConstraints();
		gbc_lblGracz_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblGracz_2.gridx = 2;
		gbc_lblGracz_2.gridy = 1;
		frmFours.getContentPane().add(frmFours.lblGracz_2, gbc_lblGracz_2);
		
		JButton btnNewButton = new JButton("Nowa gra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				createFrame();
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		frmFours.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
//////////////////////////////////////////////////////////////
		gamePanel = new GamePanel();
		GridBagConstraints gbc_gamePanel = new GridBagConstraints();
		gbc_gamePanel.gridheight = 3;
		gbc_gamePanel.gridwidth = 3;
		gbc_gamePanel.gridx = 0;
		gbc_gamePanel.gridy = 2;
		frmFours.getContentPane().add(gamePanel, gbc_gamePanel);
//////////////////////////////////////////////////////////////////		
		
		JButton btnWyniki = new JButton("Wyniki");
		GridBagConstraints gbc_btnWyniki = new GridBagConstraints();
		gbc_btnWyniki.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWyniki.insets = new Insets(0, 0, 5, 0);
		gbc_btnWyniki.gridx = 3;
		gbc_btnWyniki.gridy = 2;
		frmFours.getContentPane().add(btnWyniki, gbc_btnWyniki);
		
		frmFours.pack();
	}
	
	public void createFrame()
	{
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {*/
					frmFours.cfgFrame = new ConfigFrame();
					frmFours.cfgFrame.setVisible(true);
					frmFours.cfgFrame.addListener(frmFours);
				/*} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	@Override
	public void gameStart() {
		// TODO Auto-generated method stub
		
	}
}
