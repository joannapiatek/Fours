package MainPackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 150);
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
		
		JButton btnNewButton = new JButton("Grajmy!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(85, 76, 89, 23);
		contentPane.add(btnNewButton);
		
		ConfigFrameColors chooseColor1= new ConfigFrameColors(Color.BLUE);
		chooseColor1.setSize(23, 23);
		chooseColor1.setLocation(221, 11);
		contentPane.add(chooseColor1);
		
		ConfigFrameColors chooseColor2= new ConfigFrameColors(Color.RED);
		chooseColor2.setSize(23, 23);
		chooseColor2.setLocation(221, 39);
		contentPane.add(chooseColor2);
		
	}
}
