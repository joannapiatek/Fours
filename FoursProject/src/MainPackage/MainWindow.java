package MainPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow {

	private JFrame frmFours;

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
		frmFours.setResizable(false);
		frmFours.setBounds(100, 100, 450, 300);
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
		
		JLabel lblTuBedziPanel = new JLabel("Tu bedzi\u0119 panel gry");
		lblTuBedziPanel.setForeground(Color.MAGENTA);
		lblTuBedziPanel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblTuBedziPanel = new GridBagConstraints();
		gbc_lblTuBedziPanel.gridheight = 3;
		gbc_lblTuBedziPanel.gridwidth = 3;
		gbc_lblTuBedziPanel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTuBedziPanel.gridx = 0;
		gbc_lblTuBedziPanel.gridy = 2;
		frmFours.getContentPane().add(lblTuBedziPanel, gbc_lblTuBedziPanel);
		
		JButton btnWyniki = new JButton("Wyniki");
		GridBagConstraints gbc_btnWyniki = new GridBagConstraints();
		gbc_btnWyniki.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWyniki.insets = new Insets(0, 0, 5, 0);
		gbc_btnWyniki.gridx = 3;
		gbc_btnWyniki.gridy = 2;
		frmFours.getContentPane().add(btnWyniki, gbc_btnWyniki);
		
		frmFours.pack();
	}
}
