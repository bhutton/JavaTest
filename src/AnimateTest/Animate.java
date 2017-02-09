package AnimateTest;

import java.applet.Applet;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Animate extends Applet implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int x,y,num,width=50,height=50, appletHeight, appletWidth, incX=1, incY=1;
	
	int delay = 100;
	
	Thread animatorThread;
	
	boolean frozen = false, forward = true, right = true, down = true;
	
	public void init(){
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
    	if (y <= 0) {
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
	    
	    g.drawOval(x, y, width, height);
	}

}
