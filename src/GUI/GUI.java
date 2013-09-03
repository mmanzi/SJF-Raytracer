package GUI;
/**
 * Very simple GUI class. It simply takes an image data array and displays it.
 * @author manzi
 *
 **/
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Utility.RGBColor;

public class GUI extends JFrame{

	private static final long serialVersionUID = 1L;

	public GUI(int w, int h, String title, RGBColor[][] img){

		//setup frame
		setTitle(title);
		setSize(w,h);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);      
	    
	    //write image data into bufferedImage
	    BufferedImage bufferedImg = new BufferedImage(w,h,BufferedImage.TYPE_3BYTE_BGR);
	    for(int i=0; i<w; i++)
	    	for(int j=0; j<h; j++)
	    		bufferedImg.setRGB(i,j,new Color((int)(255*img[i][j].r),(int)(255*img[i][j].g),(int)(255*img[i][j].b)).getRGB());
	    
	    //add bufferedImage to JFrame
	    ImageIcon ic = new ImageIcon(bufferedImg);
	    JLabel jp = new JLabel(ic);
	    add(jp);
	}

}
