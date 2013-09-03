package Utility;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import GeometricObjects.GeometricObject;



public class HitPoint {

	private float dist;
	private Ray ray;
	private Point3f position;
	private Vector3f normal;
	private GeometricObject obj;
	//private RGBColor color;
	private boolean anyHit;
	
	public HitPoint(){
		dist = Float.MAX_VALUE;
		normal = new Vector3f(0,0,0);
		anyHit = false;
	}
	
	public void recordHit(GeometricObject obj, Ray charles, Vector3f n, Point3f p, float t){
		this.obj = obj;
		this.ray = charles;
		this.normal = n;
		this.dist = t;
		this.position = p;
		//this.color = c;
		anyHit = true;
	}
	
	
	public RGBColor shade(){
		return obj.getMaterial().shade(this);
	}
	public boolean anyHit() {
		return anyHit;
	}
	
	public float getHitDist(){
		return dist;
	}
	
	public Point3f getHitPos(){
		return position;
	}
	
	public Vector3f getNormal(){
		return normal;
	}
	
	public Ray getRay(){
		return ray;
	}

}
