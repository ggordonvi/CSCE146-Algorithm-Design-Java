/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 26, 2017
 * 10:31:38 AM
 */

/**
 * @author aylanickerson
 *
 */
import java.applet.*;//makes window
import java.awt.*;//draws the stuff
import java.util.*;//more stuff 

public class RandomFractal extends Applet{
	private Image display;//frame
	private Graphics drawingArea;//canvas
	
	public void init()
	{
		int height=getSize().height;
		int width=getSize().width;
		
		display=createImage(width,height);
		drawingArea=display.getGraphics();
		randomFractal(0, height/2, width, height/2, drawingArea);
		//TODO draw random fractal
	}
	public void paint(Graphics g)//draws the thing
	{
		g.drawImage(display, 0, 0, null);
	}
	public static void randomFractal(int leftX, int leftY, int rightX, int rightY, Graphics drawingArea)
	{
		int stop=4;
		int max=12;
		int midX;
		int midY;
		int delta;
		Random r=new Random();
		
		if((rightX-leftX<=stop))
		{
			drawingArea.drawLine(leftX, leftY, rightX, rightY);
		}
		else
		{
			midX=(leftX+rightX)/2;
			midY=(leftY+rightY)/2;
			delta=r.nextInt(max);
			midY+=delta;
			randomFractal(leftX, leftY, midX, midY, drawingArea);//left recursion
			randomFractal(midX, midY, rightX, rightY, drawingArea);//right recursion
		}
	}

}
