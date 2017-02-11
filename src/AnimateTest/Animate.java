package AnimateTest;

import java.applet.Applet;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animate extends Applet implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int x,y,num,width=50,height=50, appletHeight, appletWidth, incX=1, incY=1, delay = 100, brickHeight = 50;
	
	int[][][] takenBricks = new int[225][830][3];
	int numRows = 0, numCols = 0;
	
	Thread animatorThread;
	
	boolean frozen = false, forward = true, right = true, down = true;
	
	BufferedImage imgBall = null, imgBrick = null;
	
	String 	ball = "../src/AnimateTest/ball.png",
			brick = "../src/AnimateTest/brick-green.png"; 
	
	public void init(){
		
		// Initialize Window Size
		setSize(800,600);
		
		// Load Ball Image
		try { imgBall = ImageIO.read(new File(ball)); } 
		catch (IOException e) { e.printStackTrace(); }
		
		// Load Brick Image
		try { imgBrick = ImageIO.read(new File(brick)); } 
		catch (IOException e) { e.printStackTrace(); }
		
		// Initialize array and setting taken bricks to 0 indicating none
		for (int count = 0; count < 225; count++) {
			for (int counter = 0; counter < 830; counter++) {
				takenBricks[count][counter][2] = 0;
			}
		}
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
	        
				if (frozen) {
					frozen = false;
					start();
				} 
				else {
					frozen = true;
					stop();
				}
			}
		});
	}
	
	public void start() {
		if (!frozen) {
			if (animatorThread == null) {
				animatorThread = new Thread(this);
			}
			
			animatorThread.start();
		}
	}

	public void stop() {
	    animatorThread = null;
	}

	public void run() {
		
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		//long startTime = System.currentTimeMillis();
		
		Thread currentThread = Thread.currentThread();

	    while (currentThread == animatorThread) {
	    	
	    	calculateLocation();	

	    	repaint();
	    	
	    	try {
	    		//startTime += delay;
	    		Thread.sleep(10);
	    	} 
	    	catch (InterruptedException e) {
	    		break;
	    	}
	    }
	}
	
	public void calculateLocation() {
		
		// Start ball below bricks
		if (y == 0) y = ((brickHeight + 5) * 4);
		
		// Randomize range for ball angle
		int min = 1, max = 3;
		
		// Ball hits right side of screen
		if ((x + width + 2) > appletWidth) {
			incX = ThreadLocalRandom.current().nextInt(min, max);
			
			right = false;
		}
		
		// Ball hits bottom of screen
		if ((y + height + 2) > appletHeight) {
			incY = ThreadLocalRandom.current().nextInt(min, max);
			
			down = false;
		}
		
		// Ball hits left side of screen
    	if (x <= 0) {
    		incX = ThreadLocalRandom.current().nextInt(min, max);
    		
    		right = true; 
    	}
    	
    	// Ball hits top of screen or bricks
    	if (y <= ((brickHeight + 5) * 4)) {
    		incY = ThreadLocalRandom.current().nextInt(min, max);
    		this.checkBricks();
    	}
    	
    	if (right) x += incX; 
    	else x -= incX;
    	if (down ) y += incY;
    	else y -= incY;
    	
	}
	
	private void checkBricks() {
				
		if (down == false) {
		    
			// Initialize array and setting taken bricks to 0 indicating none
    		for (int count = 0; count < numCols; count++) {
    			for (int counter = 0; counter < numRows; counter++) {
    				
    				if (takenBricks[count][counter][0] >= x-60 &&
    					takenBricks[count][counter][0] <= x+120) {
    					
    					takenBricks[count][counter][2] = 1;
    					
    				}
    			}
    		}
		}
		
		down = true; 
	}
	
	public void paint(Graphics g) {
		
		int brickX = 0, brickY = 0;
		
		// Get Windows Dimensions
		Dimension appletSize = this.getSize();
	    appletHeight = appletSize.height;
	    appletWidth = appletSize.width;
	   
	    // Draw ball
	    g.drawImage(imgBall, x, y, null);
	    
	    // Draw bricks at top of screen
	    for (int count = 5; count < 800; count += 55) {
	    	
	    	takenBricks[brickX][brickY][0] = count;
	    	
		    for (int counter = 5; counter < 200; counter += 55) {
		    	
		    	takenBricks[brickX][brickY][1] = counter;
		    	
		    	if (takenBricks[brickX][brickY][2] == 0)
		    		g.drawImage(imgBrick, count, counter, null);
		    	
		    	
		    	brickY++;
		    }
		    
		    brickX++;
	    }
	    
	    numRows = brickY;
	    numCols = brickX;
	}

}
