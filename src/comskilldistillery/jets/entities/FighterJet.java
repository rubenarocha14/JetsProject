package comskilldistillery.jets.entities;

public class FighterJet extends Jet implements FightMode {
public FighterJet(String type, String model, double speed, int range, long purchasePrice) {
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
	public void dogFight() {
		System.out.println("Engaging Bogie... pewpewpew!!!");
	}

}
