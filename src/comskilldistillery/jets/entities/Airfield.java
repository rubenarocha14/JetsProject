package comskilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Airfield {

	
	public ArrayList<Jet> readFromFile() {//create a readFromFile method class inside of Airfield Class to read txt file
		ArrayList<Jet> airfield = new ArrayList<>();//create new ArrayList named airfield
		try (BufferedReader br = new BufferedReader(new FileReader("jets.txt"))) {//create buffer that creates a FileReader that reads txt file
			String line; //declare String variable named line
			while ((line = br.readLine()) != null) { //loop that assins each line read by the buffer and if it finds a line assigns it to the line var
				String jetList[] = line.split(",");//Create an String array that contains the line splits of the line read by the buffer
				String type = jetList[0];
				String model = jetList[1];  //creates model var that stores the idx 1
				double speed = Double.parseDouble(jetList[2]);
				int range = Integer.parseInt(jetList[3]);
				long price = Long.parseLong(jetList[4]);

				Jet jetHolder = null; //instantiate a placeholder jet reassigned each time we get a jet
				// if replaces the value of jetHolder with the associated jet found
				if (type.equalsIgnoreCase("Transport")) {
					jetHolder = new TransportJet(type, model, speed, range, price);

				} else if (type.equalsIgnoreCase("fighter")) {
					jetHolder = new FighterJet(type, model, speed, range, price);
				} else if (type.equalsIgnoreCase("common")) {
					jetHolder = new CommonJet(type, model, speed, range, price);
				}


				airfield.add(jetHolder); //jet added to our airfield ArrayList each time it finds one
				//System.out.println(airfield.get(0));
				
			}
			br.close();
		}

		catch (IOException e) {
			System.err.println("Problem while reading names.txt" + ": " + e.getMessage());
		}
		return airfield;

	}
}

