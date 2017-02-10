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
	//int[][] multi = new int[5][10];
	
	int[][][] takenBricks = new int[225][830][1];
	
	int count = 0, counter = 0;
	
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
		for (count = 0; count < 225; count++) {
			for (counter = 0; counter < 830; counter++) {
				takenBricks[count][counter][0] = 0;
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
		
		long startTime = System.currentTimeMillis();
		
		Thread currentThread = Thread.currentThread();

	    while (currentThread == animatorThread) {
	    	
	    	calculateLocation();	

	    	repaint();
	    	
	    	try {
	    		startTime += delay;
	    		Thread.sleep(10);
	    	} 
	    	catch (InterruptedException e) {
	    		break;
	    	}
	    }
	}
	
	public void calculateLocation() {
		
		if (y == 0) y = ((brickHeight + 5) * 4);
		
		int min = 1;
    	int max = 3;
    	
		
		if ((x + width + 2) > appletWidth) {
			incX = ThreadLocalRandom.current().nextInt(min, max + 1);
			
			right = false;
		}
		if ((y + height + 2) > appletHeight) {
			incY = ThreadLocalRandom.current().nextInt(min, max + 1);
			
			down = false;
		}
    	if (x <= 0) {
    		incX = ThreadLocalRandom.current().nextInt(min, max + 1);
    		
    		right = true; 
    	}
    	if (y <= ((brickHeight + 5) * 4)) {
    		incY = ThreadLocalRandom.current().nextInt(min, max + 1);
    		
    		down = true; 
    	}
    	
    	if (right) x += incX; 
    	else x -= incX;
    	if (down ) y += incY;
    	else y -= incY;
    	
	}

	public void paint(Graphics g) {
		
		Dimension appletSize = this.getSize();
	    appletHeight = appletSize.height;
	    appletWidth = appletSize.width;
	   
	    g.drawImage(imgBall, x, y, null);
	    
	    System.out.println(x + ", " + y); 
	    
	    for (count = 5; count < 200; count += 55) {	
		    for (counter = 5; counter < 800; counter += 55) {
		    	if (takenBricks[count][counter][0] == 0)
		    		g.drawImage(imgBrick, counter, count, null);
		    }
	    }
	}

}
