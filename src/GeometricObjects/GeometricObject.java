package GeometricObjects;
/**
 * Abstract class for Objects. Each derived class needs at least an intersection method and an associated material
 * @author manzi
 *
 */
import javax.vecmath.Point3d;

import Material.Material;
import Utility.HitPoint;
import Utility.Ray;

public abstract class GeometricObject {

	Material mat;
	
	public GeometricObject(Material mat){
		this.mat = mat;
	}
	
	public abstract HitPoint hit(Ray ray);

	
	public Material getMaterial() {
		return mat;
	}

}
