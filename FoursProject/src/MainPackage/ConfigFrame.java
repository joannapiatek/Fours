package MainPackage;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class ConfigFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField playerName1;
	private JTextField playerName2;
	private Player player1;
	private Player player2;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigFrame frame = new ConfigFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public ConfigFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//setPreferredSize(new Dimension(268, 138));
		
		setBounds(100, 100, 268, 138);
		
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Nazwa gracza 1:");
		label1.setBounds(18, 13, 97, 14);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Nazwa gracza 2:");
		label2.setBounds(18, 43, 97, 14);
		contentPane.add(label2);
		
		playerName1 = new JTextField();
		playerName1.setBounds(125, 13, 86, 20);
		contentPane.add(playerName1);
		playerName1.setColumns(10);
		
		
		playerName2 = new JTextField();
		playerName2.setColumns(10);
		playerName2.setBounds(125, 41, 86, 20);
		contentPane.add(playerName2);
		
		ConfigFrameColors chooseColor1= new ConfigFrameColors(Color.BLUE);
		chooseColor1.setSize(23, 23);
		chooseColor1.setLocation(221, 11);
		contentPane.add(chooseColor1);
		
		ConfigFrameColors chooseColor2= new ConfigFrameColors(Color.RED);
		chooseColor2.setSize(23, 23);
		chooseColor2.setLocation(221, 39);
		contentPane.add(chooseColor2);
		
		JButton btnNewButton = new JButton("Grajmy!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player1 = new Player(playerName1.getText(), chooseColor1.getColor());
				player2 = new Player(playerName2.getText(), chooseColor2.getColor());
				
				setVisible(false);
			}
		});
		btnNewButton.setBounds(85, 76, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
	}
	

}
