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

	public static void main(String[] args) { // main methodj calls launch()

		// create our JetsApplication instance
		JetsApplication jets = new JetsApplication();
		jets.launch();
	}

	private void launch() {// method will call our display menu and menuOperations

		displayMenu();
		menuOperations(mainAirfield);
	}

	public void displayMenu() {//solely displays menu
		System.out.println("Please select from the following menu");
		System.out.println("|=======================================|");
		System.out.println("\t 1) List the fleet");
		System.out.println("\t 2) Fly all jets");
		System.out.println("\t 3) View fastest jet");
		System.out.println("\t 4) View jet with longest range");
		System.out.println("\t 5) Load all Transport Jets");
		System.out.println("\t 6) TopGun!");
		System.out.println("\t 7) Add a jet to the fleet");
		System.out.println("\t 8) Remove a jet from the fleet");
		System.out.println("\t 9) Quit");
		System.out.println("|=======================================|");
	}

	private void menuOperations(ArrayList<Jet> officialAirfield) {//takes a users selection and performs the associated operation
		// take the menu selection from the user
		int selection = scan.nextInt();
		// use switch statements to convert the users input into a method call
		switch (selection) {
		case 1://list jets
			System.out.println("Jets in the airfield: ");
			listJets(officialAirfield);
			break;

		case 2://displays all jet info in the airfield as well as their remaining flight time
			System.out.println("Flying all jets: ");
			fly(mainAirfield);
			break;

		case 3://idx thorugh for loop and use .getSpeed() to determine the fastest jet in the airfield
			System.out.println("Fastest jet in the airfield is: ");
			getFastestJet(mainAirfield);
			break;
		case 4://idx through for loop and use .getRange() to determine the distance jet in the airfield
			System.out.println("Jet with the longest range in the airfield is: ");
			getLongestRange(mainAirfield);
			break;
		case 5:
			// simulate loadCargo for all jets that are instanceOf TransportJet
			loadUp(mainAirfield);
			break;
		case 6:
			// simulate dogFight() for all jets that are instanceOf FighterJet
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
			flightTime = Math.round((jetRange / jetSpeed) * 100.00) / 100.00;
			// should print out each Jets toString and amount of fly time
			System.out.println(jetsToBeFlown.get(i) + "  Flight Time Remaining : " + flightTime + " hours");
		}

	}

	private void getLongestRange(ArrayList<Jet> mainAirfield) {
		// Jet distanceJet = mainAirfield.get(0);
		Jet distanceJet = mainAirfield.get(0);
		Jet nextDistanceJet = null;
		for (int i = 0; i < mainAirfield.size(); i++) {
			nextDistanceJet = mainAirfield.get(i);

			if (distanceJet.getRange() < nextDistanceJet.getRange()) {
				distanceJet = nextDistanceJet;
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
		double mach = 0;
		for (int i = 0; i < mainAirfield.size(); i++) {
			nextFastestJet = mainAirfield.get(i);

			if (fastestJet.getSpeed() < nextFastestJet.getSpeed()) {
				fastestJet = nextFastestJet;
			} else {
				continue;

			}
		}
		System.out.println("Jet with the fastest top speed in MPH: " + fastestJet);
		mach = fastestJet.getSpeed() / 767.3;
		System.out.println("Top Speed in Mach : " + mach);
		System.out.println();

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

	private void loadUp(ArrayList<Jet> mainAirfield) {
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
	}

	private void addCreatedJet(ArrayList<Jet> mainAirfield) {
		mainAirfield.add(createNewJet());//adds return value of createNewJet() to the fleet
	}

	private Jet createNewJet() {
		createJetMenu();//displays submenu to user
		Jet createdJet = createJetOperations(); // returns the createdJet from createJetOperations
		return createdJet;
		
	}

	private void createJetMenu() {//displays menu
		System.out.println("What type of jet would you like to create?");
		System.out.println("1) Common");
		System.out.println("2) Fighter");
		System.out.println("3) Transport");
		System.out.println("4) Quit");
	}

	private Jet createJetOperations() {//takes jet info from users and creats new Jet 
		int selection = scan.nextInt();
		if(selection == 4) {
			quitApp();
		}
		Jet userCreated = null;

		String jetType;
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
		switch (selection) {

		case 1:
			jetType = "Common";
			userCreated = new CommonJet(jetType, jetModel, jetSpd, jetRng, jetCost);
			break;
		case 2:
			jetType = "Fighter";
			userCreated = new FighterJet(jetType, jetModel, jetSpd, jetRng, jetCost);
			break;
		case 3:
			jetType = "Transport";
			userCreated = new TransportJet(jetType, jetModel, jetSpd, jetRng, jetCost);
			break;
		default:
			System.out.println("Please choose a valid number ( 1-3");


	}
		return userCreated;

	}

	private void removeJet(ArrayList<Jet> mainAirfield) {//removes a jet from the ArrayList
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
