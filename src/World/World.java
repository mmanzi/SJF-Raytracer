package World;
/**
 * Representation of the scene. The whole scene setup (eg. camera setup, geometry, lightsources is defined here)
 * @author manzi
 *
 */
import java.util.Iterator;
import java.util.LinkedList;

import GeometricObjects.*;
import Material.Material;
import Material.Matte;
import Tracers.Tracer;
import Utility.*;

import javax.vecmath.*;

import Utility.Ray;

public class World {

	int hres;
	int vres;
	RGBColor background_color;
	Tracer rt;
	LinkedList<GeometricObject> objects;
	ViewPlane vp;
	
	public World(int w, int h){
		objects = new LinkedList<GeometricObject>();
		this.vres=w;
		this.hres=h;
		build();
	}
	
	
	private void build(){
		background_color = new RGBColor(0.f,0.f,0.5f);
		rt = new Tracer(this);
		
		Material redMat = new Matte(new RGBColor(1.f,0.f,0.f));
		Sphere redSphere = new Sphere(redMat, new Point3f(0.f,80.f,-50f), 150f);
		objects.add(redSphere);
		
		Material greenMat = new Matte(new RGBColor(0.f,1.f,0.f));
		Sphere greenSphere = new Sphere(greenMat, new Point3f(0.f,-80.f,-6f), 150f);
		objects.add(greenSphere);
	}
	
	
	public RGBColor[][] render_scene(){
		RGBColor[][] img = new RGBColor[hres][vres];
		Ray ray = new Ray();
		
		ray.direction = new Vector3f(0.f,0.f,-1.f);
		for(int x=0; x<hres; x++) //left-right 
			for(int y=0; y<vres; y++){ //top-bottom (or bottom-up?)
				ray.origin = new Point3f(y-vres/2.f + 0.5f, x-hres/2.f+0.5f, 100); //orthographic projection!!!
				img[x][y] = rt.trace(ray);			
			}
		return img;
	}

	
	public Iterator<GeometricObject> getObjectIterator(){
		return objects.iterator();
	}
	
	
	public RGBColor getBackgroundColor(){
		return background_color;
	}
}
