package comskilldistillery.jets.entities;

public class TransportJet extends Jet implements transportCargo {
	public TransportJet() {
		
	}
	public TransportJet(String type, String model, double speed, int range, long purchasePrice) {
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

	@Override
	public void loadUp() {
		System.out.println(getType() + " " + getModel() + " Loading Cargo...");
		System.out.println("Loading Complete... Supply Drop Inbound!!!");
	}

}



