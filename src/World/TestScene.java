package World;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import GeometricObjects.*;
import Light.*;
import Material.*;
import Utility.*;
import Camera.*;
import Tracers.*;

public class TestScene extends World{

	public TestScene(int w, int h) {
		super(w, h);
	}
	
	protected void build(){
		camera = new PinholeCamera(new Point3f(0.f, 0.f, 0.f), 		// eye
										new Point3f(0.f,0.f,-1.f),  // lookat
										new Vector3f(1.f,0.f,0.f),	//up
										1.f); 						//scale
		background_color = new RGBColor(0.1f,0.1f,0.1f);
		rt = new MultipleObjects(this);
		
		//Add Objects
		Material redMat = new Diffuse(new RGBColor(0.8f,0.2f,0.2f));
		Sphere redSphere = new Sphere(redMat, new Point3f(0.5f,0.f,-3.f), 0.3f);
		objects.add(redSphere);
		
		Material greenMat = new Diffuse(new RGBColor(0.2f,0.8f,0.2f));
		Sphere greenSphere = new Sphere(greenMat, new Point3f(-0.2f,-0.2f,-2.f), 0.2f);
		objects.add(greenSphere);
		
		Material greyMat = new Diffuse(new RGBColor(0.5f, 0.5f, 0.5f));
		Plane greyPlane = new Plane(greyMat, new Point3f(0.f,-0.5f,0.f), new Vector3f(0.f, 1.f, 0.f));
		objects.add(greyPlane);
		
		//Add Lightsource
		Light yellowLight = new PointLight(new Point3f(0.5f,0.5f,-1.5f), new RGBColor(1.f,1.f,0.1f));
		lights.add(yellowLight);
		
		Light magentaLight = new PointLight(new Point3f(-0.5f,0.5f,-1.5f), new RGBColor(1.f,0.1f,1.f));
		lights.add(magentaLight);
	}
}
