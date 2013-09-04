package Light;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Utility.RGBColor;


/**
 * The Light superclass. Every Light subclass needs to implement a method that takes a point in space as input 
 * and returns a non-normalized vector that points from the light-source to the input point.
 * @author manzi
 *
 */
public abstract class Light {

	public abstract Vector3f getIncomingRay(Point3f p);
	
	public abstract RGBColor getColor();
}
