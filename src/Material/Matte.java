package Material;

/**
 * The Matte material is a simple diffuse surface
 * At the moment it is assumed there is a single directional light source at the rays origin.
 * This should be extended to support multiple user-defined light sources!
 */

import javax.vecmath.Vector3f;

import Utility.HitPoint;
import Utility.RGBColor;

public  class Matte extends Material{

	RGBColor color;
	
	public Matte(RGBColor color){
		this.color = color;
	}
	
	
	@Override
	public RGBColor shade(HitPoint hit) {
		RGBColor shadedColor = new RGBColor(color);
		Vector3f inc = new Vector3f(hit.getRay().origin);
		inc.sub(hit.getHitPos());
		inc.normalize();
		float a = Math. max(0.f, inc.dot(hit.getNormal()));
		shadedColor.attenuate(a);
		return shadedColor;
	}


}
