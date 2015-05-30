package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class GamePanel extends JPanel{
	//Members//
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private ChoicePanel choicePanel;
	private GameRectangle gameRectangle;	
	
	public GamePanel() 
	{
		componentsInit();
		
		choicePanel = new ChoicePanel(width);
		height = gameRectangle.getHeight() + choicePanel.getHeight();
		setPreferredSize(new Dimension(width+6,height+6));
		
		setComponents();
	}
	
	public void componentsInit()
	{
		gameRectangle = new GameRectangle();
		width = gameRectangle.getWidth();
	}
	
	public void setComponents()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{21, 168};
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE, 1.0};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_choicePanel = new GridBagConstraints();
		gbc_choicePanel.insets = new Insets(0, 0, 0, 0);
		gbc_choicePanel.gridy = 0;
		gbc_choicePanel.gridx = 0;
		gbc_choicePanel.fill = GridBagConstraints.BOTH;
		add(choicePanel, gbc_choicePanel);

		GridBagConstraints gbc_gameRectangle = new GridBagConstraints();
		gbc_gameRectangle.insets = new Insets(0, 0, 0, 0);
		gbc_gameRectangle.fill = GridBagConstraints.BOTH;
		gbc_gameRectangle.gridy = 1;
		gbc_gameRectangle.gridx = 0;
		add(gameRectangle, gbc_gameRectangle);
		
		setBorder(BorderFactory.createEtchedBorder());
	}
}
