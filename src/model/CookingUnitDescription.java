package model;
import net.webservicex.Cookings;


public class CookingUnitDescription {
	String name;
	Cookings unit;
	
	public CookingUnitDescription(String name, Cookings unit) {
		this.name = name;
		this.unit = unit;
	}
	
	public String getName() {
		return name;
	}

	public Cookings getUnit() {
		return unit;
	}
	
	public String toString() {
		return name;
	}
}
