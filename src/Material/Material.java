package Material;

import Light.Light;
import Utility.HitRecord;
import Utility.RGBColor;

public abstract class Material {

	public abstract RGBColor shade(HitRecord hit, Light l); 
}
