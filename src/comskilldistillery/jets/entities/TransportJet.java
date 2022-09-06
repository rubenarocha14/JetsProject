package comskilldistillery.jets.entities;

public class TransportJet extends Jet implements transportCargo {
	public TransportJet(String type, String model, double speed, int range, long purchasePrice) {
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.purchasePrice = purchasePrice;
		
		
		
	}
	
	@Override
	public String toString() {
		return "Jet [type=" + getType() + ", model=" + getModel() + ", speed=" + getSpeed() + ", range=" + getRange() + ", purchasePrice="
				+ getPurchasePrice() + "]";
		
	}

	@Override
	public void loadUp() {
		System.out.println("Engaging Bogie... pewpewpew!!!");
	}

}



