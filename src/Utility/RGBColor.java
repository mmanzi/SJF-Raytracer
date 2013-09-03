package Utility;

public class RGBColor {
	public float r;
	public float g;
	public float b;
	
	public RGBColor(){
		this.r=0; 
		this.g=0; 
		this.b=0;
	}
	
	public RGBColor(RGBColor c){
		this.r = c.r;
		this.g = c.g;
		this.b = c.b;
	}
	
	public RGBColor(float r, float g, float b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void attenuate(float a){
		r*=a;
		g*=a;
		b*=a;
	}
}
