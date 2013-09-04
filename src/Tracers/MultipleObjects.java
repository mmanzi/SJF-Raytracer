package Tracers;

import java.util.Iterator;

import GeometricObjects.GeometricObject;
import Light.Light;
import Utility.HitRecord;
import Utility.RGBColor;
import Utility.Ray;
import World.World;

public class MultipleObjects extends Tracer{

	public MultipleObjects(World w) {
		super(w);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This simple tracer iterates over all objects and light sources
	 * @param ray: The ray that is traced
	 * @return The shading color of the closest intersection
	 */
	public RGBColor trace(Ray ray){
		//find closest hit
		HitRecord hitp = new HitRecord();
		Iterator<GeometricObject> objItr= world_ptr.getObjectIterator();	
		while(objItr.hasNext()){
			HitRecord new_hitp = objItr.next().hit(ray);
			if(hitp.getHitDist()>new_hitp.getHitDist()) 
				hitp = new_hitp;
		}		
		//shading
		if(hitp.anyHit()){
			RGBColor color = new RGBColor();
			Iterator<Light> lightItr= world_ptr.getLightIterator();
			while(lightItr.hasNext())
				color.add(hitp.shade(lightItr.next()));
			return color;
		}
		else
			return world_ptr.getBackgroundColor();
	}
}
