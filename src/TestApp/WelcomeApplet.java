package TestApp;

import javax.swing.JApplet;
import java.awt.Graphics;

public class WelcomeApplet 
{
	public void paint( Graphics g )
	{
		g.drawLine(15, 10, 210, 10);
		g.drawLine(15, 30, 210, 30);
		g.drawString("Welcome to Java Programming", 25, 25);
	}
}
