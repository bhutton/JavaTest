package TestApp;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

public class TestGraphics extends JApplet {
	
	String xInput,yInput;
	
	public void init()
	{
		// read in first number from user
		xInput = JOptionPane.showInputDialog("Enter first floating point number");
		yInput = JOptionPane.showInputDialog("Enter first floating point number");		
	}

	public void paint(Graphics g)
	{
		// Set initial target coordinates
		int x = 2100;	// destination x coordinate
		int y = 0;		// destination y coordinate
		int count;		// Loop counter
		
		x = Integer.parseInt(xInput);
		y = Integer.parseInt(yInput);
		
		for(count = 0; count < 300; count++) {
			
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
