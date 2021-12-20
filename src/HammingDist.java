import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Reads in the file in order to parse and find and store the given vehicle numbers. 
 * Uses these values to then perform operations, and find the amount of differences (HammingDist),
 * between two given vehicles.
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class HammingDist 
{
	/** Where the file will be read in */
	private File file;
	/** An array where each line of the file will be saved */
	private String[] fileLines;
	/** An array where the vehicle numbers will be stored after being parsed from the fileLines array */
	private String[] vehicles;
	/** Given a vehicle number in order to be compared */
	private String vehicleA;
	/** Given a vehicle number in order to be compared */
	private String vehicleB;
	/** 
	 * Where the given string needed to be printed out will be stored
	 *  used for the default vehicle
	 */
	private String hamDefault;
	/**
	 * Where the given string needed to be printed out will be stored
	 *  used for the vehicleA.
	 */
	private String hamVehicleA;
	/**
	 * Where the given string needed to be printed out will be stored
	 *  used for the vehicleB.
	 */
	private String hamVehicleB;
	/** The default vehicle number */
	private final String VEH00 = "VEH00";
	 
	/**
	 * Reads in the given file, stored each line first into the fileLines array, 
	 * then searches for the vehicle numbers and parses them from the fileLines array and stored them
	 * into the vehicles array. Expands both array when needed.
	 */
	public void readFile() 
	{
		//count is used as a counter, that is incremented everytime the while loop passes. 
			//this will come in handy when trying to grow the initial capacity of vehicles as the it is needed
		int count = 0;
		
		//This int amountOfLines is used to help grow the array of fileLines
		int amountOfLines = 100;
		
		//Where the whole lines of the txt file are stored
		fileLines = new String[10]; 
		
		//From Class Lecture 
		try
		{
			//From in Class Example/Ethan Ho
			//reads in file
			file = new File("vanetp1data.txt");
			//The input or what is read from the file
			Scanner input = new Scanner(file);
			//While loops checks if there is a nextLine in the txt. If so continues
			while(input.hasNextLine())
			{
				//stores the line read in from the file into the array
				fileLines[count] = input.nextLine();
				count++;
				
				//Here fileLines is increased as needed by comparing fileLines.length to amount, if it is smaller, then fileLine.length increases by 1
				if(fileLines.length < amountOfLines)
				{
					fileLines = Arrays.copyOf(fileLines, fileLines.length + 1);
				}
			}
			//closes scanner
			input.close();
		}
		catch(FileNotFoundException e)
		{
			
		}
		
		//Where the vehicle numbers will be stored
		vehicles = new String[10];
		
		//For loop used to iterate through the file, used in order to later search for 'v's in the file
		//Help from Braden 
		//Starts at one in order to avoid the first line of text which are just labels S
		for(int i = 1; i < fileLines.length; i++)
		{
			for(int j = 0; j < fileLines[i].length(); j++)
			{
				//checks for 'v' or 'V', which could have been similarly done with ignoresCase()
				//if line contains 'v', then we can proceed and use substring
				//Idea of charAt from Discord discussion - Khoi
				if(fileLines[i].charAt(j) == 'v')
				{
					//Using the substring method we can divide the string into pieces. 
						//We start from j and go to j + 5 in order to capture the whole vehicle number (VEH##)
					//subsubtring method idea from StackOverflow and Monday lecture
					//toUperCase in order to convert all veh to VEH
					vehicles[i - 1] = fileLines[i].substring(j, j + 5).toUpperCase();
					
					//Help from Ethan Ho
					//The if statement used in order to increase the size of vehicles. If vehicles.length is less than count then increase the size of vehicles.length
					if(vehicles.length < count)
					{
						vehicles = Arrays.copyOf(vehicles, vehicles.length + 1);
					}
				}
			}
		}
	}
	
	/**
	 * Constructor sets to null
	 */
	public HammingDist() 
	{
		vehicleA = null;
		vehicleB = null;
		
	}

	//Passes one string and sets the other to null
	/**
	 * Passes one String and sets to a vehicle, sets the other to null
	 * 
	 * @param string		A given vehicle number
	 */
	public HammingDist(String string) 
	{
		vehicleA = string;
		vehicleB = null;
	}

	//Help from Braden
	/**
	 * Calls the readFile method, assigns the vehicles to their given vehicle numbers (string and string2) 
	 * and then calls other methods where they will be compared and have their HammingDists returned. Checks if both
	 * vehicles are the same, if so reverses the second one. Assigns these 
	 * HammingDist values to their respective variables to be stored. Uses these to help print out the given statements
	 * correctly.
	 * 
	 * @param string		A given vehicle number
	 * @param string2		A second given vehicle number
	 */
	public HammingDist(String string, String string2) 
	{
		//Calls the readFile method
		readFile();
		
		//Difference between the VEH00 and the string that is passed (vehicleA)
		int differenceOne;
		//Difference between VEH00 and the string2 that is passed (vehicleB)
		int differenceTwo;
		
		//difference between all the vehicles that are read into the array (method), taking the number you get from the OG vehicle, 
			//comparing the differences, if so then you increment the difference
			//Done in order to find other times that the hamming number is the same
		int fileDifferenceOne;
		int fileDifferenceTwo;
		
		vehicleA = string;
		vehicleB = string2;
		
		//If both vehicles contain the same value then it reverses the second vehicle in order to then compare them
		//Office Hours 
		if (vehicleA == vehicleB)
		{
			StringBuilder builder = new StringBuilder();
			builder.append(vehicleB);
			builder.reverse();
			vehicleB = builder.toString();
		}
		//method calls for the default method that compares with VEH00
		differenceOne = compareWithVEH00(vehicleA);
		differenceTwo = compareWithVEH00(vehicleB);
		
		//method calls for the hamming from the File which we compared using the vehicles array, between each vehicle within the file, 
		//returns the amount of vehicles that have the same amount of differences as the default
				//Checking the number of differences 
		fileDifferenceOne = hammingComparison(vehicleA, differenceOne);
		fileDifferenceTwo = hammingComparison(vehicleB, differenceTwo);
		
		//Prints out a sentence and the amount of differences between given vehicles, 
		//in this case the default vehicle, VEH00 & VEH01 (vehicleA); and VEH00 and VEH11 (vehicleB)
				//Continue process for other vehicles
		//Will be used for the two string and printed if both vehicles are present 
		hamDefault = "The Hamming distance between VEH00 and " + vehicleA + " is " + differenceOne + "; between VEH00 and " + vehicleB + " is " + differenceTwo + "." + "\n";
		hamVehicleA = "For " + vehicleA + ": " + "Number of vehicles of Hamming Distance" + differenceOne + ": " + fileDifferenceOne + ".\n";
		hamVehicleB = "For " + vehicleB + ": " + "Number of vehicles of Hamming Distance" + differenceTwo + ": " + fileDifferenceTwo + ".";
	}
	
	/**
	 * Compares the given vehicle number to the default value, returns the amount of differences.
	 * 
	 * @param vehicle		The vehicle being compared to 
	 * @return the amount of differences between the given vehicle and the default one.
	 */
	public int compareWithVEH00 (String vehicle)
	{
		int diff = 0;
		//for loop is used to iterate through the length of vehicle 
		for (int i = 0; i < vehicle.length(); i++)
		{
			//checking each character at a given point, if they are different 
			if (vehicle.charAt(i) != VEH00.charAt(i))
			{
				//if so increment diff 
				diff++;
			}
		}
		return diff;
	}
	
	/**
	 * Uses similar logic to the prior method, but in this case we are looking for other instances that have the
	 * same HammingDists. 
	 * 
	 * @param vehicle		The vehicle being compared
	 * @param differences	The amount of differences found
	 * @return returns the amount of vehicle numbers with the same amount of differences.
	 */
	public int hammingComparison(String vehicle, int differences)
	{
		int i = 0;
		int sameCount = 0;
		//Advice for for loop from Braden
		for (int j = 0; j < vehicles.length - 1; j++)
		{
			for (int k = 0; k < vehicles[j].length(); k++)
			{
				//check if they have any differences at a given point (k), if the given points are not equal (difference) then increment i in order to keep count
				//i is used to keep track of any differences
				if(vehicle.charAt(k) != vehicles[j].charAt(k))
				{
					i++;
				}
				//if i is the same as the difference from prior method (default) that is passed through then increment sameCount in order to keep count of the same chars
					//if it is the same
			}
			if (i == differences)
			{
				//same amount of differences 
				sameCount++;
			}
			//i is then reset in order to check again for another vehicle
			i = 0;
		}
		return sameCount;
	}
		
	//Help from Discord discussion
	/**
	 * Gets the amount of vehicle numbers ending with a 0. Prints out the amount of vehicles that end in 0.
	 */
	public void getCountZero() 
	{
		int counter = 0; //iterating through vehicles array at whatever instance, in this case i
		//if ends with zero increment the counter 
		//Help from Braden
		for (int i = 0; i <vehicles.length - 1; i++)
		{
			//charAt(4) checks the last char of the given vehicle from the array, looking if there is a 0
			if (vehicles[i].charAt(4) == '0')
			{
				counter++;
			}
		}
		//Help from Discord discussion
		//Prints out message and the count of vehicles that end with a 0
		System.out.println("Number of vehicles ended with zero: " + counter);
	}
	
	//Advice from Discord discussion
	//Help from office hours 
	/**
	 * Prints out the statements that were created in the HammingDist method, depending on which conditions are met.
	 * Uses the toString method in order to print out correctly and avoid mistakes such as HammingDist@12843fce
	 */
	public String toString()
	{
		//Checks if both vehicles are null, if so then return "The inputs are empty."
		if (vehicleA == null && vehicleB == null)
		{
			return "The inputs are empty.";
		}
		//Checks to see if the second vehicle is null, if so then return "The second vehicle is missing"
		else if (vehicleA != null && vehicleB == null)
		{
			return "The second vehicle is missing.";
		}
		//If no vehicles are missing it returns the hammings from method HammingDist
		else
		{
			return hamDefault + hamVehicleA + hamVehicleB; 
		}
	}
}
