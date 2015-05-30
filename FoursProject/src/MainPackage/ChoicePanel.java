package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;


public class ChoicePanel extends JComponent{
	//Members//
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	
	
	public ChoicePanel(int w)
	{
		width = w;
		height = 20;
		setPreferredSize(new Dimension(width, height));
	}
	
	@Override
    public void paintComponent(Graphics g)
    {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, width, height);
    }
	
	public int getHeight()
	{
		return height;
	}
}
