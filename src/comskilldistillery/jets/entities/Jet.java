package comskilldistillery.jets.entities;

public abstract class Jet {

	// the jet class should be abstract and extended by different
	// jet types
	// it should have str type, str model, double speed, int range and long purchase
	// price
	// practice good encapsulation with private fields

	// fields
	protected String type;
	protected String model;
	protected double speed;
	protected int range;
	protected long purchasePrice;

	// create our no arg ctor to replace our default ctor
	public Jet() {
	}

	// create our arg ctor with the class fields.
	// currently have the type of jet as a object param, but it should be read from
	// the
	// txt file and used to construct that type of jet rather than be a field
	public Jet(String type, String model, double speed, int range, long purchasePrice) {
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.purchasePrice = purchasePrice;
	}

	// create getters and setters for private fields in class
	public String getType() {
		return type;
	}

	public String getModel() {
		return model;
	}

	public double getSpeed() {
		return speed;
	}

	public int getRange() {
		return range;
	}

	public long getPurchasePrice() {
		return purchasePrice;
	}

	// create a toString able to be overridden by subclasses
	@Override
	public String toString() {
		return "Jet Type: " + type + "\n  Model: " + model + "\n  Speed: " + speed + "\n range: " + range
				+ "\n  purchasePrice:  s" + purchasePrice + "\n";
	}

	// create a fly method that is able to be overridden by subclasses
	// this method should print out all of the toString info with the
	// addition of the time a jet can fly until running out of fuel
	public void fly() {
		// should list all info of each plane as well as give the ...
		// ...amt of time the plane can fly until it runs out of fuel

	}
}
