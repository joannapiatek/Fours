package MainPackage;
import java.awt.Color;

public class GameCircle
{
	private boolean filled;
	private int radius = 19;
	private Color currentColor;
	
	public GameCircle(boolean filled)
	{
		//setPreferredSize(new Dimension(radius, radius));
		this.setFilled(filled);		
		currentColor = Color.white;
	}
	
	/*
	@Override
    public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		
		Dimension size = getSize();
		int scale = 3;
        int w = size.width-scale;
        int h = size.height-scale;
        
        Ellipse2D.Double circle = new Ellipse2D.Double (0, 0, w, h);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(currentColor);
        g2.fill(circle);
        
        //g.setColor(currentColor);
        //g.fillOval(0, 0, w, h);
        
    }*/

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public Color getCurrentColor()
	{
		return currentColor;
	}
	
	public void setCurrentColor(Color color)
	{
		currentColor=color;
	}

}
