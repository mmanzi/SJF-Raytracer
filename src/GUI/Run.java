package GUI;
import Utility.*;
import World.*;


public class Run{

	/**
	 * The main class of the raytracer.
	 * @param args 
	 * TODO args should encode the dimension of the image
	 */
	public static void main(String[] args) {
		int width =1200;
		int height = 1200;
		String title = "Simple Ray Tracer";
		
		//call the raytracer
		World myWorld = new World(width, height);
		RGBColor[][] rendered_image = myWorld.render_scene();
		
		//setup the gui
		GUI gui = new GUI(width, height, title, rendered_image);
		gui.setVisible(true);
		
		//TODO: the image should be stored somewhere 
	}
}
