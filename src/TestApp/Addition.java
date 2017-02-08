// Fig. 2.8: Addition.java
// An addition program

package TestApp;

import javax.swing.JOptionPane;

public class Addition {
	public static void main( String args[] )
	{
		String 	firstNumber,		// First number entered by user 
			   	secondNumber;		// Second number entered by user
		int		number1,			// First number to add
				number2,			// Second number to add
				sum;				// Sum of number1 and number2
		
		// read in first number from user as a string
		firstNumber = JOptionPane.showInputDialog("Enter First Number");
		
		// read in second number from user as a string
		secondNumber = JOptionPane.showInputDialog("Enter Second Number");
		
		// convert numbers from string to int
		number1 = Integer.parseInt(firstNumber);
		number2 = Integer.parseInt(secondNumber);
		
		// add numbers
		sum = number1 + number2;
		
		// display the results
		JOptionPane.showMessageDialog(
				null, "The sum is " + sum, "Results", JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);
	}
}
