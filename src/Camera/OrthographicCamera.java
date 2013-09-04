package Camera;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Tracers.Tracer;
import Utility.RGBColor;
import Utility.Ray;
/**
 * An orthographic camera.
 * @author manzi
 *
 */
public class OrthographicCamera extends Camera{

	public OrthographicCamera(Point3f eye, Point3f lookat, Vector3f up, float scale) {
		super(eye, lookat, up, scale);
	}

	@Override
	public RGBColor[][] renderScene(RGBColor[][] img, Tracer rt) {
		int hres = img.length;
		int vres = img[0].length;
		Ray ray = new Ray();		
		for(int x=0; x<hres; x++) 
			for(int y=0; y<vres; y++){
				ray.direction.set(z);
				ray.direction.negate();
				ray.origin = new Point3f(eye.x + ((x+0.5f)/hres - 0.5f)*scale, eye.y - ((y+0.5f)/vres - 0.5f)*scale, 0);
				img[x][y] = rt.trace(ray);
			}
		return img;
	}

}
