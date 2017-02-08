package AnimateTest;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Animate extends JApplet {
	
	int x,y,num;

	public Animate(){
		
		setSize(400,400);
		
		//this.x   = 2387;
		//this.y   = 45;
		this.num = 2343;
	}
	
	public void paint(Graphics g)
	{
		int count;		// Loop counter
		
		int x = 0;
		int y = 0;
		int prevX = 0;
		int prevY = 0;
		
		for(count = 0; count < num; count++) {
			
			super.paint(g);
			
			//g.clearRect(prevX, prevY, 100, 100);
			
			// Recalculate destination coordinates
			y += 1;
			x += 1;
			
			// Calculate random colours
			//int R = (int)(Math.random() * 256);
			//int G = (int)(Math.random() * 256);
			//int B = (int)(Math.random() * 256);
			
			// Get new color based on random numbers
			//Color randomColor = new Color(R, G, B);
			
			setSize(400,400);
			setBackground(Color.blue);
		
			
			// Set new color
			//g.setColor(randomColor);
			g.setColor(Color.blue);
			
			// Draw line
			

			g.drawRect(x, y, 100, 100);
			
			prevX = x;
			prevY = y;
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				
		}
	}
}
