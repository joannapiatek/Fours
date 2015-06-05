package MainPackage;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;


public class Triangle extends JPanel{

	private static final long serialVersionUID = 1L;
	private int h;
	private int w;
	private Color myColor;
	
	public Triangle(int width, int height, Color color)
	{
		w = width;
		h = height;
		myColor = color;
		setPreferredSize(new Dimension(w, h));
	}
	public void paint(Graphics g)
	{
		int xpoints[] = {0, w, w/2};
	    int ypoints[] = {0, 0, h};
	    int npoints = 3;
	    
	    g.setColor(myColor);
	    g.fillPolygon(xpoints, ypoints, npoints);
	}
	
	public void setColor(Color color)
	{
		myColor = color;
	}
	

}
