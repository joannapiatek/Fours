package MainPackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;


public class ConfigFrameColors extends JComponent{
	
	private static final long serialVersionUID = 1L;
	private int radius=23;
	private int width=2*radius;
	private int height=2*radius;
	private Color color;
	
	public ConfigFrameColors(Color newColor){
		color = newColor;
		setPreferredSize(new Dimension(width, height));
	}
	
	@Override
    public void paintComponent(Graphics g)
    {
		g.setColor(color);
		g.fillOval(0, 0, radius, radius);
		
	}
}
