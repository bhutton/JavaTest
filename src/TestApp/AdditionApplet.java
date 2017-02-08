// AdditionApplet.java

package TestApp;

import java.awt.Graphics;
import javax.swing.*;

public class AdditionApplet extends JApplet {
	
	double sum;
	
	public void init()
	{
		String	firstNumber,		// first string entered by user
				secondNumber;		// second string entered by user
		double	number1,			// first number to add
				number2;			// second number to add
		
		// read in first number from user
		firstNumber = JOptionPane.showInputDialog("Enter first floating point number");
		
		// read in second number from user
		secondNumber = JOptionPane.showInputDialog("Enter second floating point number");
		
		// convert numbers from type string to type integer
		number1 = Double.parseDouble(firstNumber);
		number2 = Double.parseDouble(secondNumber);
		
		// add the numbers
		sum = number1 + number2;
	}
	
	public void paint(Graphics g)
	{
		// draw the results with g.drawSring
		g.drawRect(15,10,270,20);
		g.drawString("The sum is " + sum, 25, 25);
	}

}
