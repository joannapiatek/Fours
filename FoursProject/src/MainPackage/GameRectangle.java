package MainPackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class GameRectangle extends JComponent {
	//Members//
	private static final long serialVersionUID = -8698788278833667708L;
	private GameCircle [][] circleTab;
	private int width;
	private int height;
	private int rows = 6;
	private int columns = 7;
	private int margin;
	private int circleRadius;
	private GridBagConstraints gbc;
	private GridBagLayout gridBagLayout;
	
	
	public GameRectangle(int newMargin)
	{
		margin = newMargin;
		layoutInit();
		
		circleTabInit();
		setWidthAndHeight();
		
	}
	
	@Override
    public void paintComponent(Graphics g)
    {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, width, height);
	}
		
	
	public void circleTabInit()
	{
		circleTab = new GameCircle [rows][columns];
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
			{
				circleTab[i][j] = new GameCircle();	
				add(circleTab[i][j], gbc);
			}
			gbc.gridy++;
		}		
	}
	
	public void layoutInit()
	{
		gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(4,4,4,4);
		gbc.gridy = 0;
	}
	
	public void setWidthAndHeight()
	{
		circleRadius = circleTab[0][0].getRadius();
		width = (circleRadius + margin) * 7 + margin;
		height = (circleRadius + margin) * 6 + margin;
		setPreferredSize(new Dimension(width, height));
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}

}
