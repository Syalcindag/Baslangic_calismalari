 // Fig. 14.34: PaintPanel.java
 // Using class MouseMotionAdapter.
 import java.awt.Point;
 import java.awt.Graphics;
 import java.awt.event.MouseEvent;
 import java.awt.event.MouseMotionAdapter;
 import javax.swing.JPanel;

public class PanelSinifi extends JPanel
 {
 private int pointCount = 0; // count number of points

private Point[] points = new Point[1000];


 // set up GUI and register mouse event handler
 public PanelSinifi()
 {
 // handle frame mouse motion event
 addMouseMotionListener(new MouseMotionAdapter(){
     
// store drag coordinates and repaint
      public void mouseDragged( MouseEvent event ){
        if ( pointCount < points.length )
         {
           points[ pointCount ] = event.getPoint(); // find point
           ++pointCount; // increment number of points in array
           System.out.println(pointCount);
           repaint(); // repaint JFrame
         } // end if
      }
 } // end anonymous inner class
 ); // end call to addMouseMotionListener
 } // end PaintPanel constructor

 // draw ovals in a 4-by-4 bounding box at specified locations on window
 public void paintComponent( Graphics g )
 {
 super.paintComponent( g ); // clears drawing area
 // draw all points in array
 for ( int i = 0; i < pointCount; i++ )
 g.fillOval( points[ i ].x ,points[ i ].y, 5, 5 );
 } // end method paintComponent
} // end class PaintPanel