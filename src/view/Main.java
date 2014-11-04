package view;
import net.webservicex.CookingUnit;
import net.webservicex.CookingUnitSoap;



public class Main {
	public static void main(String[] args) {
		CookingUnit cu = new CookingUnit();
		CookingUnitSoap soap = cu.getCookingUnitSoap();
		Runnable gui = new GUI(soap);
		gui.run();
	}
}
