package model;
import net.webservicex.Cookings;

/**
 * This class use for set the name for Cookings(Enum), when use it in ComboBox.
 * @author Natchanon Hongladaromp 5510546034
 */
public class CookingUnitDescription {
	String name;
	Cookings unit;
	
	/**
	 * Constructor for this class.
	 * @param name a name
	 * @param unit an unit
	 */
	public CookingUnitDescription(String name, Cookings unit) {
		this.name = name;
		this.unit = unit;
	}
	
	/**
	 * returns name.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns unit.
	 * @return unit
	 */
	public Cookings getUnit() {
		return unit;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
