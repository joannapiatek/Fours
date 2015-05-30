package MainPackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GameRectangle extends JComponent {
	//Members//
	private static final long serialVersionUID = -8698788278833667708L;
	private GameCircle [][] circleTab;
	private int width;
	private int height;
	private int rows = 6;
	private int columns = 7;
	private int margin = 8;
	private int circleRadius;
	
	
	public GameRectangle()
	{
		circleTabInit();
		
		circleRadius = circleTab[0][0].getRadius();
		width = (circleRadius + margin) * 7 + margin;
		height = (circleRadius + margin) * 6 + margin;
		
		setPreferredSize(new Dimension(width, height));
	}
	
	@Override
    public void paintComponent(Graphics g)
    {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, width, height);
		
		circleTabDraw(g);
	}
		
	
	public void circleTabInit()
	{
		circleTab = new GameCircle [rows][columns];
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
			{
				circleTab[i][j] = new GameCircle(true);
			}
		}
	}
	
	public void circleTabDraw(Graphics g)
	{
		int posX, posY;
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
			{
				posX = margin*(j+1) + j*circleRadius;
				posY = margin*(i+1) + i*circleRadius;
				g.setColor(circleTab[i][j].getCurrentColor());
		        g.fillOval(posX, posY, circleRadius,circleRadius);
			}
		}
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
