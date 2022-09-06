package comskilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Airfield {

	// declare a list of Jets named airfield

	public List<Integer> airfield = new ArrayList<>();

	// my airfield should keep a list of jets in the airfield at any given time
	// the original list of jets should be read from a .txt file
	// the airfield list should be modified each time the user selects to add or
	// remove a
	// jet. The user should be able to select which jet they want to remove (can be
	// in the middle
	// of the list)

//did this empty list for testing, don't think i need it
//	public void createEmptyList() {
//		ArrayList<Jet> airfield = new ArrayList<>();
//		// needs much more in here
//
//		System.out.println("Empty list:" + airfield);
//
////		CargoJet hercules = new CargoJet("Transport", "C-130 Hercules", 100, 1000, 100000);
////		FighterJet f22 = new FighterJet("Fighter", "F22 Raptor", 200, 2000, 200000);
////		CommonJet osprey = new CommonJet("Multi-Mission", "V-22 Osprey", 300, 3000, 300000);
//
//		for (Jet jet : airfield) {
//			System.out.println(airfield);
//		}
//
//	}
	//is reading from file, but skips the first line for some reason
	//had to enter an empty line in the txt file to get it to read the first entry
	public ArrayList<String> readFromFile(ArrayList<String> listOfLines) {
		try {

			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
			listOfLines.add(line);
			}
			//System.out.println(listOfLines);
			br.close();
			//return listOfLines;
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading names.txt" + ": " + e.getMessage());
		}
		return listOfLines;

	}
}