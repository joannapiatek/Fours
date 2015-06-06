package MainPackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class GameCircle extends JComponent
{
	private boolean filled;
	private int radius = 30;
	private Color currentColor;
	
	public GameCircle()
	{	
		setPreferredSize(new Dimension(radius, radius));
		disableFilled();		
		currentColor = Color.white;
	
	}
	
	
	@Override
    public void paintComponent(Graphics g)
    {
		Dimension size = getSize();
		int scale = 0;
        int w = size.width-scale;
        int h = size.height-scale;
        
        g.setColor(currentColor);
        g.fillOval(0, 0, w, h);
        
    }
	

	public boolean isFilled() {
		return filled;
	}

	public void setFilled() {
		filled=true;
	}
	
	public void disableFilled() {
		filled=false;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public Color getCurrentColor() {
		return currentColor;
	}
	
	public void setCurrentColor(Color color) {
		currentColor=color;
		setFilled();
	}

}
