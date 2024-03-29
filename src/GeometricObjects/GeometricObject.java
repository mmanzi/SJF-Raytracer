package GeometricObjects;


import Material.Material;
import Utility.HitRecord;
import Utility.Ray;

/**
 * Abstract class for Objects. Each derived class needs at least an intersection method and an associated material
 * @author manzi
 *
 */
public abstract class GeometricObject {

	Material mat;
	final protected float tmin = 0.00001f;
	
	
	public GeometricObject(Material mat){
		this.mat = mat;
	}
	
	/**
	 * Intersection Method. Checks if and where a ray intersects with the object
	 * @param ray
	 * @return A HitRecord Object that records relevant information
	 */
	public abstract HitRecord hit(Ray ray);

	
	public Material getMaterial() {
		return mat;
	}

}
