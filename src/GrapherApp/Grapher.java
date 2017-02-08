// Grapher.java

package GrapherApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GrapherApp.PlotGraphics;

public class Grapher extends JApplet implements ActionListener {
	
	JLabel 			xLabel, yLabel, numLabel;
	JTextField 		destX, destY, destNum;
	JButton			plotGraph;
	PlotGraphics 	showGraph;
	
	public void init()
	{
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		xLabel = new JLabel("\nSetX");
		c.add(xLabel);
		destX = new JTextField(10);
		destX.setEditable(true);
		c.add(destX);
		
		yLabel = new JLabel("\nSetY");
		c.add(yLabel);
		destY = new JTextField(10);
		destY.setEditable(true);
		c.add(destY);
		
		numLabel = new JLabel("\nNum");
		c.add(numLabel);
		destNum = new JTextField(10);
		destNum.setEditable(true);
		c.add(destNum);
		
		
		plotGraph = new JButton("Plot Graph");
		plotGraph.addActionListener(this);
		
		c.add(plotGraph);
	}

	public void actionPerformed(ActionEvent e) {		
		
		int x = Integer.parseInt(destX.getText());
		int y = Integer.parseInt(destY.getText());	
		int num = Integer.parseInt(destNum.getText());
		
		PlotGraphics showGraph = new PlotGraphics(x,y,num);
		showGraph.setVisible(true);
	}
	
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	
}
