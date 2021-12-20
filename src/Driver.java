/**
 * @author Mohammad Mukhtaruzzaman
 * @version 2021-09
*/
import java.io.IOException;

public class Driver 
{
	public static void main(String[] args) throws IOException 
	{
		/**
		 * Read the project description pdf along with this Driver.java
		 * Also, a sample output file is provided for the format of the output.
		 * dateTimeOne.dateTimeNow() should print the data/time as the following format:
		 * Current Date/Time: 09/09/2021 06:58 PM
		 */	
		int thresholdValue = 45;
		DateTimeOne dateTimeOne = new DateTimeOne();
	    dateTimeOne.dateTimeNow();	
		/**
		 * You have to retrieve the time in the "Second" after hour and minute.
		 * If 'Second' is greater than 45, you have to sleep your program for 5 seconds. 
		 * Current value of �Second� is stored in vlaueOfSecondNow. 
		 * For example, if second is 58, the resulted string will be, 
		 * "The time in second now: 58"
		 */
		int vlaueOfSecondNow = dateTimeOne.getValueOfSecond();
		/**
		 * If vlaueOfSecondNow>45, program will sleep for 5 seconds.
		 */		
		if(vlaueOfSecondNow > thresholdValue){
			dateTimeOne.sleepForSec(5);
		}
		
		//This is the same as the above.
	    dateTimeOne.dateTimeNow();	
		System.out.print("\n");
		
		//This is an array of vehicles.
		String[] vehicles = {"VEH01", "VEH11", "VEH20", "VEH20", "VEH11", "VEH20"};

		/**
		 * If no input is given then the output will be: "The inputs are empty."
		 */	
		HammingDist hammDist0 = new HammingDist();
		System.out.println(hammDist0);
		
		/**
		 * If one input is missing the output should be: "The second vehicle is missing."
		 */	
		HammingDist hammDist1 = new HammingDist("VEH10");
		System.out.print("\n");
		System.out.println(hammDist1);
		
		/**
		 * The followings are for two vehicles passed as arguments. The description has been 
		 * provided in the pdf.
		 */	
		
		HammingDist hammDist2 = new HammingDist(vehicles[0], vehicles[1]);
		HammingDist hammDist3 = new HammingDist(vehicles[2], vehicles[3]);
		
		System.out.print("\n");
		System.out.println(hammDist2);
		System.out.print("\n");
		System.out.println(hammDist3);
		System.out.print("\n");
		
		HammingDist hammDist4 = new HammingDist(vehicles[4], vehicles[5]);
		System.out.println(hammDist4);
		System.out.print("\n");
		
		//This is the number of vehicles with vehicleID ended with a zero.
		hammDist4.getCountZero();		
	}
}