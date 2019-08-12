/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 26, 2017
 * 10:58:47 AM
 */

/**
 * @author aylanickerson
 *
 */
import java.applet.*;
import java.awt.*;
import java.util.*;
public class SierpinskiCarpet extends Applet{
	private Image display;//frame
	private Graphics drawingArea;//canvas
	public void init()//this is called by the libraries to initialize
	{
		int height=getSize().height;
		int width=getSize().width;
		
		display = createImage(width,height);
		drawingArea=display.getGraphics();
		//TODO call recursive method
		drawGasket(0,0,height,drawingArea);
		
	}
	public void paint(Graphics g)
	{
		g.drawImage(display, 0, 0, null);
	}
	public static void drawGasket(int x,int y, int side,Graphics g)
	{
		int sub=side/3;
		
		//draw the middle
		g.fillRect(x+sub, y+sub, sub, sub);
		if(sub>=3)
		{
			//Top 3 squares 
			drawGasket(x,y,sub,g);//Left
			drawGasket(x+sub,y,sub,g);//middle
			drawGasket(x+sub*2,y,sub,g);//right
			//middle 2 squares
			drawGasket(x,y+sub,sub,g);
			drawGasket(x+sub*2,y+sub,sub,g);
			//bottom 3 squares
			drawGasket(x,y+sub*2,sub,g);
			drawGasket(x+sub,y+sub*2,sub,g);
			drawGasket(x+sub*2,y+sub*2,sub,g);
		}
	}
}
