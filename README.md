# JetsProject: Week 3 Assignment


##Description
This program simulates a Jet Application that allows the user to interact with a menu to perform operations on an airfield. The airfield consists of 5 starter Jets that are read from a .txtFile. These starter jets are all extensions of the abstract class Jet, and two of them (FighterJet and TransportJet) implement interfaces specific to their subclasses. The program is structured between multiple classes. We first created our abstract class Jet and provided it with the appropriate fields, getters, and a toString. Once we were finished with the Jet class we were able to create the children classes which consisted of Common(no changes from the parent Jet class, just able to be instantiated), FighterJet which implements the FightMode interface, and  TransportJet which implements the TransportCargo interface. Each of the interfaces have one method that is specific to the jet type which implements it. Next we moved onto the Airfield class which read a list of Jets and their attributes from a .txtFile and used a Buffered reader and File Reader to set each line in the file to an index of a created ListArray.
This ListArray would be the list of starter jets, and be utilized throughout the main method JetsApplication.
Finally we were able to get started on the meat of the project, Jets Application. Jets Application called utilized a total of 16 local methods, as well as pulled from each class mentioned prior to this point. The main method only contains an instaniation of the JetsApplication class, and a call to launch() which is the method doing most of the work. Within launch() is two methods: displayMenu() and menuOperations(), between these two methods, the user will be shown a menu of the application, and each operation will be performed when selected. displayMenu solely shows the user the menu. The menuOperations(mainAirfield), however, takes an Airfield object as a parameter, receives the users selection using a scanner, and calls the associated method for each selection option.

1 - calls the method listJets(mainAirfield) which displays the toString of each jet in the Airfield object

2- fly(mainAirfield) displays the toString of all jets along with their remaining flight time by dividing their range by speed.

3 - getFastestJet(mainAirfield) indexes through the ArrayList using a for loop and returns the jet with the fastest speed using the .getSpeed(). It also performs a calculation to give the speed in Mach as well.

4- getLongestRange(mainAirfield) identical to the getFastestJet(mainAirfield), however it indexes through and returns the largest Range

5- loadUp() displays the jets that are an instance of TransportJet and displays the their overridden loadUp() method

6- TopGun calls the method dogFight() which displays the instances of FighterJet and displays its overridden dogFight().

7 - addCreatedJet(mainAirfield) adds the return value of createJetOperations() to the mainAirfield. createJetOperations() takes a selections of which jet to create from a user and uses a switch statement, much like the displayOperations() to create the specified jet and recieve it's fields for the constructor.It then returns the created jets

8- removeJet() indexes through the mainAirfield and utilizes the .remove method on the mainAirfield's selected index

9- displays a good bye message and quits the program


##What I learned

I learned not to make things complicated, and keep methods small. Initially I tried having each of my methods utilize the return of one another, however it made things way too complex when I needed to create new objects from those return values. I was able to utilize this way of thinking for my addJet() option and it's called methods, but when I tried to make it large scale for the entire menu Operation, it didn't bode well for me. As far as keeping code simple, my downfall for this project was trying implement something complex initially rather than working in chunks and then increasing complexity once functionality has been accomplished. I initially tried to have a single method read from the file, as well as read a users input. I felt like I was so close multiple times, but I ultimately never achieved that goal of mine. 

##Technologies Used
Java, Eclipse, Git, GitHub, Terminal, Zoom
