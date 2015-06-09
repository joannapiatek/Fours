package MainPackage;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.FutureTask;


public class MainWindow {
	
	private MainFrame frmFours;
	
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
		frmFours.setTitle("Connect fours!");
		frmFours.setResizable(false);
		frmFours.setBounds(100, 100, 430, 323);
		frmFours.setMinimumSize(new Dimension(430, 323));
		frmFours.setLocationRelativeTo(null);
		frmFours.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {87, 117, 105, 0};
		gridBagLayout.rowHeights = new int[] {10, 23, 42, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		frmFours.getContentPane().setLayout(gridBagLayout);
		
		Font TitleFont = new Font("Arial", Font.BOLD, 24);
		frmFours.lblGameTitle = new JLabel("Connect fours!");
		frmFours.lblGameTitle.setFont(TitleFont);
		frmFours.lblGameTitle.setForeground(Color.RED);
		GridBagConstraints gbc_lblGameTitle = new GridBagConstraints();
		gbc_lblGameTitle.insets = new Insets(0, 0, 0, 0);
		gbc_lblGameTitle.gridx = 1;
		gbc_lblGameTitle.gridy = 2;
		frmFours.getContentPane().add(frmFours.lblGameTitle, gbc_lblGameTitle);
		
		Font playersFont = new Font("Arial", Font.BOLD, 20);
		frmFours.lblGracz_1 = new JLabel("Gracz1");
		frmFours.lblGracz_1.setFont(playersFont);
		frmFours.lblGracz_1.setVisible(false);
		//frmFours.lblGracz_1.setBorder(BorderFactory.createBevelBorder(1));
		GridBagConstraints gbc_lblGracz_1 = new GridBagConstraints();
		gbc_lblGracz_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGracz_1.gridx = 0;
		gbc_lblGracz_1.gridy = 1;
		frmFours.getContentPane().add(frmFours.lblGracz_1, gbc_lblGracz_1);
		
		frmFours.lblGracz_2 = new JLabel("Gracz2");
		frmFours.lblGracz_2.setFont(playersFont);
		frmFours.lblGracz_2.setVisible(false);
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
				frmFours.lblGracz_1.setVisible(true);
				frmFours.lblGracz_2.setVisible(true);
				frmFours.lblGameTitle.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		frmFours.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
/*		JButton btnWyniki = new JButton("Wyniki");
		GridBagConstraints gbc_btnWyniki = new GridBagConstraints();
		gbc_btnWyniki.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWyniki.insets = new Insets(0, 0, 5, 0);
		gbc_btnWyniki.gridx = 3;
		gbc_btnWyniki.gridy = 2;
		frmFours.getContentPane().add(btnWyniki, gbc_btnWyniki);*/
		
		JButton btnOgrze = new JButton("O grze");
		btnOgrze.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					showInfoPane();
				}
			});
		GridBagConstraints gbc_btnOgrze = new GridBagConstraints();
		gbc_btnOgrze.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOgrze.insets = new Insets(0, 0, 5, 0);
		gbc_btnOgrze.gridx = 3;
		gbc_btnOgrze.gridy = 3;
		frmFours.getContentPane().add(btnOgrze, gbc_btnOgrze);
		
		frmFours.pack();
	}
	
	public void createFrame()
	{
		frmFours.cfgFrame = new ConfigFrame();
		frmFours.cfgFrame.setVisible(true);
		frmFours.cfgFrame.addListener(frmFours);
	}
	
	public void showInfoPane()
	{
		JOptionPane.showMessageDialog(frmFours,
			    "- Gracze wrzucaj¹ naprzemian ¿etony do wybranych kolumn."
			    + "\n- ¯eton po wrzuceniu zajmuje najni¿sz¹ mo¿liw¹ pozycjê w kolumnie."
			    + "\n- Celem gracza jest u³o¿enie 4 ¿etonów swojego koloru pionowo, poziomo, lub po ukosie."
			    + "\n- Wygrywa gracz, który zrobi to pierwszy."
			    + "\n- W przypadku ca³kowitego zape³nienia planszy i braku czwórki - ¿aden z graczy nie wygrywa i jest remis. ",
			    "Instrukcja do gry",
			    JOptionPane.INFORMATION_MESSAGE);
	}
}
