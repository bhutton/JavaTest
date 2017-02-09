package LoadImageDemo;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
 
/** Test loading an external image into a BufferedImage using ImageIO.read() */
@SuppressWarnings("serial")
public class LoadImageDemo extends JPanel {
   // Named-constants
   public static final int CANVAS_WIDTH = 640;
   public static final int CANVAS_HEIGHT = 480;
   public static final String TITLE = "Load Image Demo";
 
   private String imgFileName = "/src/LoadImageDemo/ball.jpg"; // relative to project root (or bin)
   private Image img;  // a BufferedImage object
 
   /** Constructor to set up the GUI components */
   public LoadImageDemo() {
      // Load an external image via URL
	   String workingDir = System.getProperty("user.dir");
	    System.out.println("Current working directory : " + workingDir);
      URL imgUrl = getClass().getClassLoader().getResource(imgFileName);
      if (imgUrl == null) {
         System.err.println("Couldn't find file: " + imgFileName);
      } else {
         try {
            img = ImageIO.read(imgUrl);
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
 
      setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
   }
 
   /** Custom painting codes on this JPanel */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);    // paint background
      setBackground(Color.WHITE);
      g.drawImage(img, 50, 50, null);
   }
 
   /** The Entry main method */
   public static void main(String[] args) {
      // Run the GUI codes on the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            JFrame frame = new JFrame("Load Image Demo");
            frame.setContentPane(new LoadImageDemo());
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         }
      });
   }
}