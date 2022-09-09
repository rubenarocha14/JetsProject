package comskilldistillery.jets.app;

import java.util.ArrayList;
import java.util.Scanner;

import comskilldistillery.jets.entities.Airfield;
import comskilldistillery.jets.entities.CommonJet;
import comskilldistillery.jets.entities.FighterJet;
import comskilldistillery.jets.entities.Jet;
import comskilldistillery.jets.entities.TransportJet;

public class JetsApplication {

	// will have an airfield
	// readFromFile(mainAirfield);
	Scanner scan = new Scanner(System.in); // instantiate a scanne to take a user input
	Airfield airfield1 = new Airfield(); // instantiate our object of our airfield
	ArrayList<Jet> mainAirfield = airfield1.readFromFile(); // create an array list of Jet types named mainAirfield
	// that holds the values of our jets from the Airfield method readFromFile();
	// public static List<Jet> airfield = new ArrayList<Jet>();

	public static void main(String[] args) { // main method

		// create our JetsApplication instance
		JetsApplication jets = new JetsApplication();
		jets.launch();
	}

	private void launch() {

		displayMenu();
		menuOperations(mainAirfield);
	}

	public void displayMenu() {
		System.out.println("Please select from the following menu");
		System.out.println("|=======================================|");
		System.out.println("\t 1) List the fleet");
		System.out.println("\t 2) Fly all jets");
		System.out.println("\t 3) View fastest jet");
		System.out.println("\t 4)View jet with longest range");
		System.out.println("\t 5) Load all Cargo Jets");
		System.out.println("\t 6)Dogfight!");
		System.out.println("\t 7)Add a jet to the fleet");
		System.out.println("\t 8)Remove a jet from the fleet");
		System.out.println("\t 9)Quit");
		System.out.println("|=======================================|");
	}

	private void menuOperations(ArrayList<Jet> officialAirfield) {
		// take the menu selection from the user
		int selection = scan.nextInt();
		// use switch statements to convert the users input into a method call
		switch (selection) {
		case 1:
			// listFleet(ArrayList<Jet> getJets);
			// initial list of jets should be read from a .txt file
			System.out.println("Jets in the airfield: ");
			// listFleet(mainAirfield);
			listJets(officialAirfield);
			break;

		case 2:
			// should utilize an overridden toString for each jet to display jet data and
			// the distance util
			// empty
			System.out.println("Flying all jets: ");
			fly(mainAirfield);
			break;

		case 3:
			// determine the fastest jet in fleet
			// let the first jet(i) in the list be assigned to a variable = fastestJet
			// index through the list and if i<i+1 reassign fastestJet to i+1
			// return fastestJet once the index has finished
			System.out.println("Fastest jet in the airfield is: ");
			getFastestJet(mainAirfield);
			break;
		case 4:
			// determine the jet with the longest range in the fleet
			// let the first jet(i) in the list be assigned to a variable = distanceJet
			// index through the list and if i<i+1 reassign distanceJet to i+1
			// return distanceJet once the index has finished
			System.out.println("Jet with the longest range in the airfield is: ");
			getLongestRange(mainAirfield);
			break;
		case 5:
			// simulate loadCargo for all jets that are instanceOf
			// System.out.println("Loading all Cargo: ");
			loadCargo(mainAirfield);
			break;
		case 6:
			// simulate dogfight for all jets that are instanceOf
			dogFight();
			break;
		case 7:
			// add jet to fleet
			addCreatedJet(mainAirfield);
			System.out.println("Jet added to the airfield");
			break;
		case 8:
			// remove jet from fleet
			System.out.println("Removing jet from the airfield: ");
			removeJet(mainAirfield);
			break;
		case 9:
			// quit the program and display a message
			quitApp();
		default:
			// promt user to enter a valid entry
			System.out.println("Please enter a valid entry!");

		}
		// if 4 is not selected run again
		displayMenu();
		menuOperations(officialAirfield);
	}

	private void listJets(ArrayList<Jet> jetsInAirfield) {
		for (int i = 0; i < jetsInAirfield.size(); i++) {
			System.out.println(jetsInAirfield.get(i).toString());
		}
	}

	private void fly(ArrayList<Jet> jetsToBeFlown) {
		double flightTime = 0;
		for (int i = 0; i < jetsToBeFlown.size(); i++) {
			int jetRange = jetsToBeFlown.get(i).getRange();
			double jetSpeed = jetsToBeFlown.get(i).getSpeed();
			flightTime = Math.round((jetRange / jetSpeed)*100.00)/100.00;
			// should print out each Jets toString and amount of fly time
			System.out.println(jetsToBeFlown.get(i) + "  Flight Time Remaining : " + flightTime + " hours");
		}

	}

	private void getLongestRange(ArrayList<Jet> mainAirfield) {
		// Jet distanceJet = mainAirfield.get(0);
		Jet distanceJet = mainAirfield.get(0);
		Jet nextDistanceJet = null;
		int range = 0;
		for (int i = 0; i < mainAirfield.size(); i++) {
			nextDistanceJet = mainAirfield.get(i);

			if (distanceJet.getRange() < nextDistanceJet.getRange()) {
				distanceJet = nextDistanceJet;
				range = distanceJet.getRange();
			} else {
				continue;
			}
		}

		System.out.println("Jet with longest range is: " + distanceJet);
	}

	private void getFastestJet(ArrayList<Jet> mainAirfield) {
		// TODO Auto-generated method stub
		Jet fastestJet = mainAirfield.get(0);
		Jet nextFastestJet = null;
		double speed = 0;
		for (int i = 0; i < mainAirfield.size(); i++) {
			nextFastestJet = mainAirfield.get(i);

			if (fastestJet.getSpeed() < nextFastestJet.getSpeed()) {
				fastestJet = nextFastestJet;
				speed = fastestJet.getSpeed();
			} else {
				continue;

			}
		}
		System.out.println("Jet with the fastest top speed is: " + fastestJet );

	}

	private void dogFight() {
		// should have all fighter type jets call their overridden method fightMode();
		// should iterate through the list and check for if the jet is an instance of
		// FighterJet
		// call fightMode()
		// else continue
		int sizeOfAirfield = mainAirfield.size();
		Jet jetInstance;

		for (int i = 0; i < sizeOfAirfield; i++) {
			if (mainAirfield.get(i) instanceof FighterJet) {
				jetInstance = mainAirfield.get(i);
				((FighterJet) jetInstance).dogFight();
			} else {
				continue;
			}
		}
		// if no fighter types found return "no fighter jets in the fleet to fight!"
	}

	private void loadCargo(ArrayList<Jet> mainAirfield) {
		// should have all cargo type jets call their overridden method fightMode();
		// should iterate through the list and check if jet is an instacne of Transport
		// Jet
		int sizeOfAirfield = mainAirfield.size();
		Jet jetInstance;

		for (int i = 0; i < sizeOfAirfield; i++) {
			if (mainAirfield.get(i) instanceof TransportJet) {
				jetInstance = mainAirfield.get(i);
				((TransportJet) jetInstance).loadUp();
			} else {
				continue;
			}
		}
		// call loadUp()
		// else continue

		// if no cargo jets found, return "no cargo jets available for resupply
		// mission!"
	}

	private void addCreatedJet(ArrayList<Jet> mainAirfield) {
		mainAirfield.add(createNewJet());
	}

	private Jet createNewJet() {
		Jet userCreated = null;
		System.out.println("What type of jet would you like to add to the fleet?\n"
				+ "Enter: Transport, Common, or Fighter. \nEnter \"quit\" to exit the App");
		String jetType = scan.next(); 
		if (jetType.equalsIgnoreCase("Transport") || jetType.equalsIgnoreCase("Common")
				|| jetType.equalsIgnoreCase("Fighter")) {
			if(jetType.equalsIgnoreCase("quit")) {
				quitApp();
			}

			System.out.println("What model is the jet?");
			String jetModel = scan.next();
			System.out.println("What top speed of the jet?");
			String jetSpeed = scan.next();
			double jetSpd = Double.parseDouble(jetSpeed);
			System.out.println("What is the range of the jet?");
			String jetRange = scan.next();
			int jetRng = Integer.parseInt(jetRange);
			System.out.println("What purchase price of the jet?");
			String jetPrice = scan.next();
			long jetCost = Long.parseLong(jetPrice);
			if (jetType.equalsIgnoreCase("Transport")) {
				userCreated = new TransportJet(jetType, jetModel, jetSpd, jetRng, jetCost);
			} else if (jetType.equalsIgnoreCase("Fighter")) {
				userCreated = new FighterJet(jetType, jetModel, jetSpd, jetRng, jetCost);
			} else {
				userCreated = new CommonJet(jetType, jetModel, jetSpd, jetRng, jetCost);
			}
		} else {
			System.out.println("Invalid jet type -- Exiting App");
			System.exit(0);

		}

		return userCreated;

	}

	private void removeJet(ArrayList<Jet> mainAirfield) {
		System.out.println("Please select the jet you'd like to remove. Select \n"
				+ "by entering the position the jet resides in the list. The first jet \n"
				+ "in the list would be 0, and the last jet would be the size of the list -1.");
		int idx = scan.nextInt();
		mainAirfield.remove(idx);

	}

	private void quitApp() {
		System.out.println("Thank you for using the Jets App. Goodbye!");
		System.exit(0);
	}
}
