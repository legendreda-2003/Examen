package pullup;

public class Car extends Vehicle {
	private String matricula;
	private String maletero;
	private boolean isMaleteroAbierto;
	
	public void start() {
	}

	public boolean isTrunkOpen() {
		return isMaleteroAbierto;
	}
}
