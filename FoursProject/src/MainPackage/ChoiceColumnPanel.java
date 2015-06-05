package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;



public class ChoiceColumnPanel extends JComponent{
	//Members//
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private int[] columnsPointers;
	private int currentColumn;
	private int columns = 7;
	private int rows = 6;
	private Color mainColor = Color.DARK_GRAY;
	private Color playerColor;
	
	private Triangle[] triangleTab;
	private int triangleMargin;
	private int triangleWidth;
	private int triangleHeight;
	
	
	public ChoiceColumnPanel(int w, int margin)
	{
		triangleMargin = margin;
		width = w;
		height = 20;
		currentColumn = 0;
		playerColor = Color.RED;
		setPreferredSize(new Dimension(width, height));
		
		columnsPointersTableInit();
		trianglesInit();
		layoutInit();
	}
	
	@Override
    public void paintComponent(Graphics g)
    {
		g.setColor(mainColor);
		g.fillRect(0, 0, width, height);
    }
	
//Triangles///////////////////////////////////////////////////////
	public void trianglesInit()
	{
		initTriangleCoordinates();
		
		triangleTab = new Triangle[columns];
		for (int i=0; i<columns; i++)
		{
			triangleTab[i] = new Triangle(triangleWidth,triangleHeight, mainColor);
		}
		triangleTab[currentColumn].setColor(playerColor);
	}
	
	public void initTriangleCoordinates()
	{
		triangleMargin = height/4;
		triangleWidth = (width - (columns +1)*triangleMargin)/7;
		triangleHeight = height - triangleMargin*2;
	}
///////////////////////////////////////////////////////////
	
	public void layoutInit()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, triangleMargin, 0);

		
		for (int i=0; i<columns; i++)
		{
			add(triangleTab[i], gbc);
			if (i==0)
				gbc.insets = new Insets(0, triangleMargin, triangleMargin, 0);
		}
		
	}
	
//Columns services////////////////////////////////////////
	public void columnsPointersTableInit()
	{
		columnsPointers = new int [columns];
		for (int i = 0; i < columns; i++)
		{
			columnsPointers[i] = rows;
		}
	}
	
	public boolean decrColumnPointer(int column)
	{
		if( isColumnFilled(column) )
			return false;
		columnsPointers[column]--;
		return true;
	}
	
	public boolean isColumnFilled(int column)
	{
		if( columnsPointers[column] <= 0 )
			return true;
		
		return false;
	}
	
	public void nextColumn()
	{
		if ( currentColumn < columns-1 )
		{
			triangleTab[currentColumn].setColor(mainColor);
			currentColumn++;
			triangleTab[currentColumn].setColor(playerColor);
			repaint();
		}
	}
	
	public void previousColumn()
	{
		if ( currentColumn > 0 )
		{
			triangleTab[currentColumn].setColor(mainColor);
			currentColumn--;
			triangleTab[currentColumn].setColor(playerColor);
			repaint();
		}
	}
////////////////////////////////////////////////////////
	
	public int getHeight()
	{
		return height;
	}

}
