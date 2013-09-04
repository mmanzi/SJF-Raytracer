package Camera;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Tracers.Tracer;
import Utility.RGBColor;

/**
 * The abstract camera class, each derived class needs a render scene method
 * @author manzi
 *
 */
public abstract class Camera {

	Point3f eye;
	Point3f lookat;
	Vector3f up;
	float scale;
	
	Vector3f x, y, z;
	
	public Camera(Point3f eye, Point3f lookat, Vector3f up, float scale){
		this.eye = eye;
		this.lookat = lookat;
		this.up = up;
		this.scale = scale;
		x = new Vector3f();
		y = new Vector3f();
		z = new Vector3f();
		setupCoordSystem();
	}

	private void setupCoordSystem(){
		//setup z axis
		z.set(eye);
		z.sub(lookat);
		z.normalize();
		//setup x axis
		x.cross(up, z);
		x.normalize();
		//setup y axis
		y.cross(z, x);
	}
	
	public abstract RGBColor[][] renderScene(RGBColor[][] img, Tracer rt);
	
}
