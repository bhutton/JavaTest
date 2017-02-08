// Call average program with sentinel-controlled repetition

package TestApp;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Average2 {

		public static void main( String args[] )
		{
			int 	gradeCounter,		// number of grade entered
					gradeValue,			// grade value
					total;				// sum of grades
			double 	average;			// average of all grades
			String	input;				// grade typed by user
			
			// Initialisation phase
			total = 0;			// clear total
			gradeCounter = 0;	// prepare to loop
			
			// Processing phase
			// prompt for input and reade grade from user
			input = JOptionPane.showInputDialog("Enter Integer Grade, -1 to Quit:");
			
			// convert grade from a String to an integer
			gradeValue = Integer.parseInt(input);
			
			while (gradeValue != -1) {
				
				// add gradeValue to total
				total = total + gradeValue;
				
				// add 1 to gradeCounter
				gradeCounter = gradeCounter + 1;
				
				// prompt for input and read grade from user
				input = JOptionPane.showInputDialog("Enter Integer Grade, -1 to Quit:");
				
				// convert grade to String
				gradeValue = Integer.parseInt(input);
			}
			
			// Termination phase
			DecimalFormat twoDigits = new DecimalFormat("0.00");
			
			if (gradeCounter != 0) {
				
				average = (double) total / gradeCounter;
				
				// display average of exam grades
				JOptionPane.showMessageDialog(null,
						"Class avarage is " + twoDigits.format(average),  
						"Class Average", JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, 
						"No grades were entered", "Class Average",
						JOptionPane.INFORMATION_MESSAGE);
			
			System.exit(0);		// terminate the program
		}
	
}
