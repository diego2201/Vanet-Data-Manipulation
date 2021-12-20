import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Gets the date, time, and seconds, will be used to determine if the program needs to be put to sleep. 
 * 
 * @author Diego Cifuentes
 * @version 1
 *
 */
public class DateTimeOne 
{
	/** Where date is stored */
	private Date date;
	/** Where the local time value is stored */
	private LocalDateTime local;
	/** Where the dateString will be formated and then stored */
	private String dateString;
	/** Where the secString will be formatted and then stored */
	private String secString;
	/** Where secInt will be stored */
	private int secInt;
	
	//Help from Discord discussion 
	/** 
	 * Uses the SimpleDateFormat object to help format the date and the time, in order to print out correctly
	 */
	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy hh:mm aa"); 
	
	/**
	 * Uses the SimpleDateFormat object to help format the seconds correctly, in order to print out correctly.
	 * This is done in a separate variable in order to help print out the seconds on their own.
	 */
	private static SimpleDateFormat SECONDS_FORMAT = new SimpleDateFormat("s");
	
	//Help from Braden White
	/**
	 * Creates a new date object and uses the format static variables to assign them to the dateString and seconString variables,
	 * then prints out the current date and time using the dateString variable.
	 */
	public void dateTimeNow() 
	{
		//Creates new date object
		date = new Date();
		
		//obtains the date part
		//Uses the format (simpledateformat is the class that can format the date object) 
			//so this next line is to format the date, the time, and the time of day (AM or PM)
		dateString = DATE_FORMAT.format(date);
		
		//secString uses the same idea as dateString however it is done separately in order to return seconds 
		secString = SECONDS_FORMAT.format(date);
		
		//Prints out "Current Date/Time: " and dateString to the user
		System.out.println("Current Date/Time: " + dateString);
	}

	
	//Help from Ethan Ho
	/**
	 * Gets the value of the seconds, uses the formatted secString in order to pint out the time. 
	 * Creates a new LocalDateTime, in order to obtain the current time and to then get the current seconds.
	 * 
	 * @return secInt Will be used to determine if the method will need to be put to sleep
	 */
	public int getValueOfSecond() 
	{
		//Constructs local, calling the time now
		local = LocalDateTime.now();
		//Gets the seconds 
		secInt = local.getSecond();
		
		//Prints out "The time in seconds now: " and secString to the user which was created in the method prior
		System.out.println("The time in second now: " + secString);
		return secInt;
	}

	//From in class lecture/Discord
	/**
	 * Converts time in milliseconds to seconds and uses the sleep() method to put the method to sleep if the current
	 * seconds is greater than 45 seconds.
	 * 
	 * @param sleep		Given seconds, will be used to determine if the method needs to be put to sleep (paused)
	 */
	public void sleepForSec(int sleep) 
	{
		//Used try in order to bypass the InterruptedException error, in order to use Thread.sleep
		try 
		{
			//converts time from milliseconds to seconds by multiplying by 1000
			//Help from Discord discussion
			Thread.sleep(1000 * sleep);
		}
		catch (InterruptedException e)
		{
			//Advice from Ron
			e.printStackTrace();
		}
	}
}