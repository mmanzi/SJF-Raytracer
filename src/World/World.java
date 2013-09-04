package World;

import java.util.Iterator;
import java.util.LinkedList;

import Camera.*;
import GeometricObjects.*;
import Light.*;
import Tracers.*;
import Utility.*;

/**
 * Representation of the scene. The whole scene setup (eg. camera setup, geometry, lightsources is defined here)
 * @author manzi
 *
 */
public abstract class World {

	int hres;
	int vres;
	RGBColor background_color;
	Tracer rt;
	LinkedList<GeometricObject> objects;
	LinkedList<Light> lights;
	Camera camera;
	
	protected abstract void build();
	
	public World(int w, int h){
		objects = new LinkedList<GeometricObject>();
		lights = new LinkedList<Light>();
		this.vres=w;
		this.hres=h;
		build();
	}
	
	/**
	 * calls the user-defined camera to render the scene using the user-defined tracer 
	 * @return the rendered image
	 */
	public RGBColor[][] render_scene(){
		RGBColor[][] img = new RGBColor[hres][vres];
		if(camera!=null)
			return camera.renderScene(img, rt);
		return img;
	}

	/**
	 * getter functions for different world content
	 */
	public Iterator<GeometricObject> getObjectIterator(){
		return objects.iterator();
	}
	
	public Iterator<Light> getLightIterator(){
		return lights.iterator();
	}
	
	public RGBColor getBackgroundColor(){
		return background_color;
	}
}
