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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainWindow implements FocusListener {

	private JFrame frmFours;
	private GamePanel gamePanel;
	
	
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
		frmFours = new JFrame();
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
		
		JLabel lblGracz = new JLabel("Gracz1");
		GridBagConstraints gbc_lblGracz = new GridBagConstraints();
		gbc_lblGracz.insets = new Insets(0, 0, 5, 5);
		gbc_lblGracz.gridx = 0;
		gbc_lblGracz.gridy = 1;
		frmFours.getContentPane().add(lblGracz, gbc_lblGracz);
		
		JLabel lblGracz_1 = new JLabel("Gracz2");
		GridBagConstraints gbc_lblGracz_1 = new GridBagConstraints();
		gbc_lblGracz_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGracz_1.gridx = 2;
		gbc_lblGracz_1.gridy = 1;
		frmFours.getContentPane().add(lblGracz_1, gbc_lblGracz_1);
		
		JButton btnNewButton = new JButton("Nowa gra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

	/*
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		gamePanel.OnKeyPress(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void focusGained(FocusEvent e) {
		gamePanel.requestFocusInWindow();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
