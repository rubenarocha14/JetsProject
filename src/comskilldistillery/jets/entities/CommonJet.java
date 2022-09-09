package comskilldistillery.jets.entities;

public class CommonJet extends Jet {
	public CommonJet() {
		
	}
	public CommonJet(String type, String model, double speed, int range, long purchasePrice) {
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.purchasePrice = purchasePrice;
	}
	
	@Override
	public String toString() {
		return "Jet Type: " + type + "\n  Model: " + model + "\n  Speed: " + speed + "\n  Range: " + range + "\n  Purchase Price: "
				+ purchasePrice + "\n";
		
	}
}
