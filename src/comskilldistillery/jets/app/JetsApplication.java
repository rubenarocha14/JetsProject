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
	protected ArrayList<String> mainAirfield = new ArrayList<>();
	//readFromFile(mainAirfield);
	Airfield airfield1 = new Airfield();
	Scanner scan = new Scanner(System.in);
	//public static List<Jet> airfield = new ArrayList<Jet>();

	public static void main(String[] args) {

		// create our JetsApplication instance
		JetsApplication jets = new JetsApplication();
		//jets.mainAirfield = stringToJets();
		jets.launch();
	}

	private void launch() {
		//gets the initial jets from the text file and assigns them to a main airfield
		mainAirfield = copyAirfield(mainAirfield);
		//System.out.println(mainAirfield);
		
		//adds each line to its own index of an array
		mainAirfield = jetsArr(mainAirfield);
		//System.out.println(mainAirfield);
		System.out.println(mainAirfield.get(0));
		
		System.out.println();
		
		//mainAirfield = 
		
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
	private ArrayList<String> copyAirfield(ArrayList<String> mainAirfield) {
		//instantiating an array to hold a copy of the array list
		//generated from the txt file
		ArrayList<String> copyOfMainAirfield = new ArrayList<>();
		//copy of array list from txt file. Initially called the readFromFile 
		// in a listFleet method, but it added the entire txt file to the array
		//each time "list fleet" from the menu was selected
		copyOfMainAirfield = airfield1.readFromFile(mainAirfield);
		//calling jets() method to turn each line of the txt file into an index of an
		//array list
		
		return copyOfMainAirfield;
		
//test		
		//copyOfMainAirfield = jetsArr(copyOfMainAirfield);
		//System.out.println(copyOfMainAirfield);
	}
	private ArrayList<String> jetsArr(ArrayList<String> jetItems){
		//new array list to hold each line of the passed array list
		//as an index of jetItemList
		ArrayList<String> jetItemList = new ArrayList<>();
		//indexes through the passed ArrayList
		//each line is assigned to a String and stored
		//in the variable jetInfo
		for(int i = 0; i < jetItems.size(); i++) {
			String jetInfo = jetItems.get(i);
			//test
			//takes each string and and stores it inside of a String[] jetHolder
			//and separates indexes by commas
			splitJetItemsInfo(jetInfo);
			
			//System.out.println(jetInfo);
			jetItemList.add(jetItems.get(i));
			//getJetInfo(jetItemList.get(i));
			//System.out.println(jetItems);
			//getJetInfo(jetItemList);
		}
		return jetItemList;
	}
	private String[] splitJetItemsInfo (String jetInfo) {
		String[] jetHolder = jetInfo.split(",");
		createJetFromJetItemsInfo(jetHolder);
		//System.out.println(jetHolder[0]);
		//System.out.println(jetHolder);
		return jetHolder;
	}
	private Jet createJetFromJetItemsInfo(String[] jetHolder) {
		String jetType = jetHolder[0];
		String jetModel = jetHolder[1];
		String jetSpeed = jetHolder[2];
		double jetSpd = Double.parseDouble(jetSpeed);
		String jetRange = jetHolder[3];
		int jetRng = Integer.parseInt(jetRange);
		String jetPrice = jetHolder[4];
		long jetCost = Long.parseLong(jetPrice);
		
		
		if(jetHolder[0].equalsIgnoreCase("Transport")) {
			Jet transport = new TransportJet (jetType, jetModel, jetSpd, jetRng, jetCost);
			System.out.println(transport.toString());
			return transport;
		}
		else if(jetHolder[0].equalsIgnoreCase("fighter")) {
			Jet fighter = new FighterJet (jetType, jetModel, jetSpd, jetRng, jetCost);
			System.out.println(fighter.toString());
			return fighter;
		}
		else if(jetHolder[0].equalsIgnoreCase("common")) {
			Jet common = new CommonJet(jetType, jetModel, jetSpd, jetRng, jetCost);
			System.out.println(common.toString());
			return common;
		}
		else {
			return null;
		}
		
		
//		else {
//			System.out.println("Not a valid option - choose from Common, Transport or Fighter"
//					+ "- Returning to menu");
//		}
	}
	
	private void addJet() {
		System.out.println("What type of jet would you like to add to the fleet?");
		String jetType = scan.nextLine(); //Ternary Statement if there's user input or not;
		System.out.println("What model is the jet?");
		String jetModel = scan.nextLine();
		System.out.println("What top speed of the jet?");
		String jetSpeed = scan.nextLine();
		System.out.println("What is the range of the jet?");
		String jetRange = scan.nextLine();
		System.out.println("What purchase price of the jet?");
		String jetPrice = scan.nextLine();
		
		String newJet = jetType + jetModel + jetSpeed + jetRange + jetPrice;
	    
	}

	private void menuOperations(ArrayList<String> officialAirfield) {
		// take the menu selection from the user
		int selection = scan.nextInt();
		// use switch statements to convert the users input into a method call
		switch (selection) {
		case 1:
			//initial list of jets should be read from a .txt file
			System.out.println("Jets in the fleet: ");
			//listFleet(mainAirfield);
			System.out.println(officialAirfield);
			break;

		case 2:
			// should utilize an overridden toString for each jet to display jet data and the distance util
			//empty
			System.out.println("Flying all jets: ");
			fly(mainAirfield);
			break;

		case 3:
			// determine the fastest jet in fleet
			//let the first jet(i) in the list be assigned to a variable = fastestJet
			//index through the list and if i<i+1 reassign fastestJet to i+1
			//return fastestJet once the index has finished
			System.out.println("Fastest jet in the fleet is: ");
			//getFastestJet();
			break;
		case 4:
			// determine the jet with the longest range in the fleet
			//let the first jet(i) in the list be assigned to a variable = distanceJet
			//index through the list and if i<i+1 reassign distanceJet to i+1
			//return distanceJet once the index has finished
			System.out.println("Jet with the longest range in the fleet is: ");
			//getLongestRange();
			break;
		case 5:
			// simulate loadCargo for all jets that are instanceOf
			System.out.println("Loading all Cargo: ");
			//transportCargo();
			break;
		case 6:
			// simulate dogfight for all jets that are instanceOf
			System.out.println("DogFight!!!: ");
			//Dogfight();
			break;
		case 7:
			// add jet to fleet
			System.out.println("Adding jet to the fleet: ");
			//getFastestJet();
			break;
		case 8:
			// remove jet from fleet
			System.out.println("Removing jet from the fleet: ");
			//getFastestJet();
			break;
		case 9:
			// quit the program and display a message
			System.out.println("Thanks for using the Food Truck App!");
			System.exit(0);
		default:
			// promt user to enter a valid entry
			System.out.println("Please enter a valid entry!");

		}
		// if 4 is not selected run again
		displayMenu();
		menuOperations(officialAirfield);
	}
	private void getLongestRange(ArrayList<String >mainAirfield) {
		// TODO Auto-generated method stub
		int distanceJet;
		for(int i=0; i<mainAirfield.size(); i++) {
			distanceJet = i;
			if(i<i+1) {
				distanceJet = i+1;
			}
			else {
				continue;
			}
		}
		
		

	}

	private void getFastestJet(ArrayList<String >mainAirfield) {
		// TODO Auto-generated method stub
		int fastestJet;
		for(int i=0; i<mainAirfield.size(); i++) {
			fastestJet = i;
			if(i<i+1) {
				fastestJet = i+1;
			}
			else {
				continue;
			}
		}

	}
	private void fly(ArrayList<String >mainAirfield) {
		
	}

	
	private void dogFight() {
		//should have all fighter type jets call their overridden method fightMode();
		//should iterate through the list and check for "fighter" if fighter = true
		//call fightMode() 
		//else continue
		
		//if no fighter types found return "no fighter jets in the fleet to fight!"
	}
	private void loadCargo() {
		//should have all cargo type jets call their overridden method fightMode();
		//should iterate through the list and check for "cargo" if cargo = true
		//call loadUp() 
		//else continue
		
		//if no cargo jets found, return "no cargo jets available for resupply mission!"
	}
	
	private void getJetInfo(String indexOfListOfJets) {
		
		//stringToJets(mainAirfield);
		
		
		//this method should promt user for the Jet type first (Cargo, Fighter, Common)
		System.out.println("What type of jet would you like to add to the fleet?");
		String jetType = scan.nextLine(); //Ternary Statement if there's user input or not;
		System.out.println("What model is the jet?");
		String jetModel = scan.nextLine();
		System.out.println("What top speed of the jet?");
		double jetSpeed = scan.nextDouble();
		System.out.println("What is the range of the jet?");
		int jetRange = scan.nextInt();
		System.out.println("What purchase price of the jet?");
		long jetPrice = scan.nextLong();
		}
	}
//		
//		addJet(jetType, jetModel, jetSpeed, jetRange, jetPrice);
//
//		private void addJet(ArrayList<String> jetListItem) {
//		// the type is received the user is promted for the field data of the jet
//		if(jetListItem.("Transport")) {
//			TransportJet transport = new TransportJet (jetType, jetModel, jetSpeed, jetRange, jetPrice);
//		}
//		else if(jetType.equals("fighter")) {
//			FighterJet fighter = new FighterJet (jetType, jetModel, jetSpeed, jetRange, jetPrice);
//		}
//		else if(jetType.equals("common")) {
//			CommonJet common = new CommonJet(jetType, jetModel, jetSpeed, jetRange, jetPrice);
//		}
//		else {
//			System.out.println("Not a valid option - choose from Common, Transport or Fighter"
//					+ "- Returning to menu");
//		}
//		// next a new Jet type is instantiated with the received data
//	}
//	}

//	public void getFleetData(ArrayList<String >mainAirfield) {
//		for (int i = 0; i < mainAirfield.size(); i++) {
//			mainAirfield(i.toString();
//		}
//
//
//}
