package TestApp;

import javax.swing.*;
import java.text.DecimalFormat;

public class LoopTable416 {
	public static void main( String args[] )
	{
		int		counter;
		int		factorTen, factorHundred, factorThousand;
		
		DecimalFormat integerOutput = new DecimalFormat("0");
		JTextArea outputTextArea = new JTextArea(11,20);
		
		outputTextArea.append("N\t10*N\t100*N\t1000*N\n\n");
		
		for (counter = 1; counter <= 5; counter++) {
			
			// Run calculations
			factorTen = counter * 10;
			factorHundred = counter * 100;
			factorThousand = counter * 1000;
			
			// Append output for later display
			outputTextArea.append(integerOutput.format(counter));
			outputTextArea.append("\t" + integerOutput.format(factorTen));
			outputTextArea.append("\t" + integerOutput.format(factorHundred));
			outputTextArea.append("\t" + integerOutput.format(factorThousand) + "\n");
			
		}
		
		// Display output in window
		JOptionPane.showMessageDialog(null, outputTextArea);
		
		System.exit(0);
	}
}
