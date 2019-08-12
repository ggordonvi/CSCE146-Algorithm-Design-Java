/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 28, 2017
 * 9:33:04 PM
 */

/**
 * @author aylanickerson
 *
 */
import java.applet.*;//Window
	import java.awt.*;//Drawing Stuff
	import java.util.*;//Fun Stuff
public class TriForce extends Applet{
	

		private Image display;//Frame
		private Graphics drawingArea;//Canvas
		
		public void init() {//Called by the libraries to initialize stuff
			int height = getSize().height;
			int width = getSize().width;
			display = createImage(width,height);
			drawingArea = display.getGraphics();
			
			//TODO recrusive method
			drawTriangle(0, 0, height, drawingArea);
			drawSmallTriangle(0, 0, height, drawingArea);	
			
			
		}
		public void paint(Graphics g) {
			g.drawImage(display, 0, 0, null);
		}
		public void paint1(Graphics h) {
			h.drawImage(display, 0, 0, null);
		}
		public static void drawTriangle(int x, int y, int side, Graphics g) {
			int[] x2 = {0, side, side/2};
			int[] y2 = {side, side, 0};
			g.setColor(Color.black);
			g.fillPolygon(x2, y2, 3);
			
		}
		public static void drawSmallTriangle(int x, int y, int side, Graphics h) {
			int sub = side/2;
			int[] x2 = {x+side/2, x+side/4, x+3*side/4};
			int[] y2 = {y+side, y+side/2, y+side/2};
			h.setColor(Color.white);
			h.fillPolygon(x2, y2, 3);
			if(sub >= 12) {
				drawSmallTriangle(x+sub, y+sub, sub, h);
				drawSmallTriangle(x+sub/2, y, sub, h);
				drawSmallTriangle(x, y+sub, sub, h);
			}
		}	
	}


