package Camera;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Tracers.Tracer;
import Utility.RGBColor;
import Utility.Ray;

/**
 * TO BE IMPLEMENTED!
 */
public class PinholeCamera extends Camera{

	public PinholeCamera(Point3f eye, Point3f lookat, Vector3f up, float scale) {
		super(eye, lookat, up, scale);
	}

	@Override
	public RGBColor[][] renderScene(RGBColor[][] img, Tracer rt) {
		int hres = img.length;
		int vres = img[0].length;
		Ray ray = new Ray();		
		for(int x=0; x<hres; x++) 
			for(int y=0; y<vres; y++){
				ray.origin.set(eye);
				ray.direction = new Vector3f(eye.x + ((x+0.5f)/hres - 0.5f)*scale, eye.y - ((y+0.5f)/vres - 0.5f)*scale, -1);
				ray.direction.sub(eye);
				img[x][y] = rt.trace(ray);
			}
		return img;
	}
}
