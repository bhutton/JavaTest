package AnimateTest;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppletAnimation extends Applet implements Runnable {
  int frameNumber = -1;
  int x = 0;
  int y = 0;

  int delay = 100;

  Thread animatorThread;

  boolean frozen = false;

  public void init() {
    String str;
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (frozen) {
          frozen = false;
          start();
        } else {
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
      frameNumber++;
      x++;
      y++;

      repaint();

      try {
        startTime += delay;
        Thread.sleep(100);
      } catch (InterruptedException e) {
        break;
      }
    }
  }

  public void paint(Graphics g) {
    g.drawString("Frame " + frameNumber, 0, 30);
    g.drawRect(x, y, 100, 100);
  }
}