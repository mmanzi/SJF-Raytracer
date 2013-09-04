package Material;

import javax.vecmath.Vector3f;

import Light.Light;
import Utility.HitRecord;
import Utility.RGBColor;

/**
 * The Matte material is a simple diffuse surface
 */
public  class Matte extends Material{

	RGBColor color;
	
	public Matte(RGBColor color){
		this.color = color;
	}
	
	/**
	 * Simple diffuse shader. 
	 * The more a surfaces normal looks towards the light-source and the closer it is to the light-source, the brighter it is.
	 */
	@Override
	public RGBColor shade(HitRecord hit, Light l) {
		RGBColor shadedColor = new RGBColor(color);
		//get direction from hitpoint to lightsource
		Vector3f inc = l.getIncomingRay(hit.getHitPos());
		float attenuation = inc.lengthSquared();
		inc.normalize();
		inc.negate();
		//dot product of light-direction and surface normal
		float a = Math. max(0.f, inc.dot(hit.getNormal()));
		//attenuation with 1/dist²
		a /= attenuation;
		shadedColor.mult(a);
		shadedColor.mult(l.getColor());
		return shadedColor;
	}


}
