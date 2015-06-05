package MainPackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener{
	//Members//
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private int margin = 8;
	private ChoiceColumnPanel ChoiceColumnPanel;
	private GameRectangle gameRectangle;	
	
	public GamePanel() 
	{
		componentsInit();
		setComponents();
		addKeyListener(this);
	}
	
	/*
	public void OnKeyPress(KeyEvent ke) {
		int code = ke.getKeyCode();
		if (code == KeyEvent.VK_RIGHT)
		{
			ChoiceColumnPanel.nextColumn();
		}
		else if (code == KeyEvent.VK_LEFT)
		{
			ChoiceColumnPanel.previousColumn();
		}
	}*/
	
	public void addNotify() 
	{
        super.addNotify();
        requestFocusInWindow();
    }
	
	

//KeyListener	
	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		int code = ke.getKeyCode();
		if (code == KeyEvent.VK_RIGHT)
		{
			ChoiceColumnPanel.nextColumn();
		}
		else if (code == KeyEvent.VK_LEFT)
		{
			ChoiceColumnPanel.previousColumn();
		}
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}
	
//Init functions////////////////////////////////////////////////////	
	public void componentsInit()
	{
		gameRectangle = new GameRectangle(margin);
		width = gameRectangle.getWidth();
		ChoiceColumnPanel = new ChoiceColumnPanel(width, margin);
		height = gameRectangle.getHeight() + ChoiceColumnPanel.getHeight();
		setPreferredSize(new Dimension(width+6,height+6));
	}
	
	public void setComponents()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{21, 168};
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE, 1.0};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_ChoiceColumnPanel = new GridBagConstraints();
		gbc_ChoiceColumnPanel.insets = new Insets(0, 0, 0, 0);
		gbc_ChoiceColumnPanel.gridy = 0;
		gbc_ChoiceColumnPanel.gridx = 0;
		gbc_ChoiceColumnPanel.fill = GridBagConstraints.BOTH;
		add(ChoiceColumnPanel, gbc_ChoiceColumnPanel);

		GridBagConstraints gbc_gameRectangle = new GridBagConstraints();
		gbc_gameRectangle.insets = new Insets(0, 0, 0, 0);
		gbc_gameRectangle.fill = GridBagConstraints.BOTH;
		gbc_gameRectangle.gridy = 1;
		gbc_gameRectangle.gridx = 0;
		add(gameRectangle, gbc_gameRectangle);
		
		setBorder(BorderFactory.createEtchedBorder());
	}
}
