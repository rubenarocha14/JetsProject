package comskilldistillery.jets.entities;

public class FighterJet extends Jet implements FightMode {
	
	public FighterJet() {
		
	}
	
public FighterJet(String type, String model, double speed, int range, long purchasePrice) {
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
	public void dogFight() {
		System.out.println(getType() + " " +  getModel() + " Engaging Bogie... pewpewpew!!!");
	}

}
