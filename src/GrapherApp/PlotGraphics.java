package GrapherApp;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class PlotGraphics extends Frame {
	
	int x,y,num;

	public PlotGraphics(int x, int y, int num){
		
		setSize(400,400);
		
		this.x   = x;
		this.y   = y;
		this.num = num;
	}
	
	public void paint(Graphics g)
	{
		int count;		// Loop counter
		
		for(count = 0; count < num; count++) {
			
			// Recalculate destination coordinates
			y += count;
			x += 1;
			
			// Calculate random colours
			int R = (int)(Math.random() * 256);
			int G = (int)(Math.random() * 256);
			int B = (int)(Math.random() * 256);
			
			// Get new color based on random numbers
			Color randomColor = new Color(R, G, B);
			
			// Set new color
			g.setColor(randomColor);
			
			// Draw line
			g.drawLine(0, 0, x, y);
				
		}
	}
}
