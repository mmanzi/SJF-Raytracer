package Tracers;

import java.util.Iterator;
import Utility.*;
import GeometricObjects.GeometricObject;
import World.World;

public class Tracer {

	protected World world_ptr;
	
	public Tracer(World w){
		world_ptr = w;
	}
	/**
	 * This simple tracer iterates over all objects and stores the s
	 * @param ray: The ray that is traced
	 * @return The shading color of the closest intersection
	 */
	public RGBColor trace(Ray ray){
		HitPoint hitp = new HitPoint();
		Iterator<GeometricObject> objItr= world_ptr.getObjectIterator();
		
		while(objItr.hasNext()){
			HitPoint new_hitp = objItr.next().hit(ray);
			if(hitp.getHitDist()>new_hitp.getHitDist()) 
				hitp = new_hitp;
		}
		
		if(hitp.anyHit())
			return hitp.shade();
		else
			return world_ptr.getBackgroundColor();
	}
}
