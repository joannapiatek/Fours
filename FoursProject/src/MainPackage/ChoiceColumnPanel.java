package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;




public class ChoiceColumnPanel extends JComponent implements MouseListener{
	//Members//
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	public int[] columnsPointers;
	private int currentColumn;
	private int columns = 7;
	private int rows = 6;
	private Color mainColor = Color.DARK_GRAY;
	private Color playerColor;
	
	private Triangle[] triangleTab;
	private int triangleMargin;
	private int triangleWidth;
	private int triangleHeight;
	
	private PropertyChangeSupport propChangeSupport = new PropertyChangeSupport(this);
	
	
	public ChoiceColumnPanel(int w, int margin)
	{
		triangleMargin = margin;
		width = w;
		height = 20;
		currentColumn = 0;
		setPreferredSize(new Dimension(width, height));
		
		columnsPointersTableInit();
		trianglesInit();
		layoutInit();
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
	    propChangeSupport.addPropertyChangeListener(listener);
	  }

	public void removePropertyChangeListener(PropertyChangeListener listener) {
	    propChangeSupport.removePropertyChangeListener(listener);
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
			triangleTab[i] = new Triangle(triangleWidth,triangleHeight, i);
			triangleTab[i].addMouseListener(this);
		}

		addMouseListener(this);
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
			columnsPointers[i] = rows-1;
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
		if( columnsPointers[column] < 0 )
			return true;
		
		return false;
	}
	
	public boolean emptyColumnsLeft()
	{
		for (int i=0; i<columns; i++)
		{
			if (! isColumnFilled(i) )
				return true;
		}
			return false;
	}

	public void changeColumn(int newColumn)
	{
		int oldColumn = 0;
		if (newColumn != currentColumn)
		{	oldColumn = currentColumn;	}
		else if(newColumn == 0)
		{	oldColumn = 1;	}
		else {	oldColumn = 0;	}
			
		triangleTab[oldColumn].setColor(triangleTab[0].bgdColor);
		currentColumn = newColumn;
		
		repaint();
		propChangeSupport.firePropertyChange("currentColumn", oldColumn, newColumn);
	}
	
	public void refreshColor()
	{
		triangleTab[currentColumn].setColor(playerColor);
		repaint();
	}
	
	public void setInitialValues()
	{
		currentColumn = 0;
		for (int i=0; i<columns; i++)
		{
			triangleTab[i].setColor(triangleTab[0].bgdColor);
		}
		
		for (int i = 0; i < columns; i++)
		{
			columnsPointers[i] = rows-1;
		}
		repaint();
	}
//Get, set//////////////////////////////////////////////////////	
	public int getHeight()
	{
		return height;
	}
	public int getCurrentColumn()
	{
		return currentColumn;
	}

	public void setPlayerColor(Color color)
	{
		playerColor = color;
		for (int i=0; i<columns; i++)
		{
			triangleTab[i].setPlayerColor(color);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if (source instanceof Triangle){
			Triangle sourceTriangle = (Triangle) source;
			changeColumn( sourceTriangle.getPosition() );
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		repaint();
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		repaint();
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
