package MainPackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;



public class GamePanel extends JPanel implements PropertyChangeListener {
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
	}
	
//Init functions////////////////////////////////////////////////////	
	public void componentsInit()
	{
		gameRectangle = new GameRectangle(margin);
		width = gameRectangle.getWidth();
		ChoiceColumnPanel = new ChoiceColumnPanel(width, margin);
		ChoiceColumnPanel.addPropertyChangeListener(this);
		
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

	@Override
	public void propertyChange(PropertyChangeEvent arg0) 
	{
		int col = ChoiceColumnPanel.getCurrentColumn();
		gameRectangle.fillCircle(ChoiceColumnPanel.columnsPointers[col], col);
		boolean success = ChoiceColumnPanel.decrColumnPointer(col);
	}
}


