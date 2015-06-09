package MainPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Triangle extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private int h;
	private int w;
	private Color myColor;
	public Color bgdColor;
	private Color playerColor;
	private int position;
	
	public Triangle(int width, int height, int column)
	{
		w = width;
		h = height;
		bgdColor = Color.LIGHT_GRAY;
		myColor = bgdColor;
		playerColor = bgdColor;
		position = column;
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
	}
	public void paint(Graphics g)
	{
		int xpoints[] = {0, w, w/2};
	    int ypoints[] = {0, 0, h};
	    int npoints = 3;
	    
	    g.setColor(myColor);
	    g.fillPolygon(xpoints, ypoints, npoints);
	}
	
	public Color getBgdColor()
	{
		return bgdColor;
	}
	public void setColor(Color color)
	{
		myColor = color;
		repaint();
	}
	
	public void setPlayerColor(Color color)
	{
		playerColor = color;
	}
	
	public int getPosition()
	{
		return position;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setColor(playerColor);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		setColor(bgdColor);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
