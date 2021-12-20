## Introduction
Project 1: **VANET Data Manipulation**

Project description pdf is on Canvas. Code submission is on Zybook and Github.

*Plagiarism* will not be tolerated under any circumstances. Participating students will be penalized depending on the degree of plagiarism. It includes **“No-code”** sharing among the students. It can lead to academic misconduct reporting to the authority if identical code is found among the students.

## UML Class Diagram
![Blank diagram - Page 1 (6)](https://user-images.githubusercontent.com/89539958/134447139-3aac3fd7-6e16-4122-8379-954f88276094.png)

![Blank diagram - Page 1 (5)](https://user-images.githubusercontent.com/89539958/134447142-0b492f18-0753-420a-be20-4ed9783e2afd.png)

## DateTimeOne Class
* `dateTimeNow()`: Creates a new date object. Uses the static variable DATE_FORMAT in order to then format the date object and stores that into the variable dateString. Uses the static variable SECONDS_FORMAT in order to then format the date object and stores that into the variable secString. Then prints out the current Date/Time

* `getValueOfSecond()`: constructs a new LocalDateTime object and calls on the now() method in order to obtain the time now, then assigns this to the variable local. Then obtains the current seconds using the LocalDateTime method getSeconds(). Then prints out the time in seconds now and returns secInt in order to be used for the next method.

* `sleepForSec(int sleep)`: This method uses a try in order to bypass the InterruptedException error, in order to use the Thread.sleep(). Inside the parameters of the method sleep() we multiply the variable sleep by 1000, in order to convert from milliseconds to seconds. If the seconds passed is greater than 45 then the program will sleep for 5 seconds before resuming to run.  


## HammingDist Class
* `readFile()`: This method is used to read in the file and to then find the VEH## and assign them to the array vehicles. First we initialize an int count to 0 in order to keep count of how many times we have iterated through the loop while reading in the file and to help when assigning String to an array. This variable will also come in handy later in the method when expanding the array of vehicles. We also initialize a variable amountOfLines set to 100, in order to help increase the size of the array fileLines (where the lines of the text are being stored), when necessary. 
We then initialize the array fileLines to 10. We then use a try and catch statement in order to avoid exceptions and then read in the file. To do this we first initialize the variable file to the text file provided to us, and then use a Scanner object in order to then read through this file. While the file has a next line we assign that line into fileLines increment count. We then also check for if fileLines.length is less than the amountOfLines, if so then increment the size of the array
The vehicle array is then initialized to a size of 10. Use a nested for loop in order to search through the array of fileLines. Use an if statement to check for ‘v’, if true then use the method substring in order to obtain the veh## and then convert to uppercase. Then check if the array vehicles needs to be increased if less than count. 

* `HammingDist()`: Sets both vehicle numbers to null

* `HammingDist(String string)`: Sets vehicleA to the string passed, sets vehicleB to null

* `HammingDist(String string, String string2)`: Calls the readFile() method. Initializes 4 variables that will be used to store differences between the VEH00 and a vehicle number and two vehicle numbers. 2 of these variables will be used to call the compareWithBVEH00 method and the other two will be used to call the hammingComparison method. Assigns vehicleA and vehicleB to string and string2 respectively. Then checks if vehicleA and vehicleB are equal to each other, if true then use the StringBuilder class to reverse the second vehicle’s numbers, in order to be compared later. 
differenceOne and differenceTwo then call the method compareWithVEH00 and pass through vehicleA and vehicleB respectively in order to compare the two vehicles with VEH00 and then store the hamming distance. 
fileDifferenceOne and fileDifferenceTwo call the hammingComparison method and passed through (vehicleA, differenceOne) and (vehicleB, differenceTwo) in order to find more hammings with the same distances.
Initializes three variables hamDefault, hamVehicleA, hamVehicleB to their respective string. hamDefault displays the hamming distance between VEH00 and VEH01and VEH00 and VEH11. hamVehicleA displays the number of vehicles with the same hamming distance. hamVehicleB displays the number of vehicles with the same hamming distance. These three variables will be called upon in the toString() method and then printed out to the user if all vehicles are present and passed. 

* `compareWithVEH00(String vehicle)`: Compare the vehicle number passed (String vehicle) to the default vehicle in this case VEH00. Uses a for loop to iterate through the characters of the vehicle passed. If the character at a given point in the vehicle is not equal to the character at a given point in VEH00 then increment diff. Returns diff. 

* `hammingComparison(String vehicle, int difference)`: Similar logic used in method compareWithVEH00(). However in this case we are looking to see if there are more hammings with the same distance. We pass the diff from the prior method and a vehicle to be compared. We use a for loop to go through the vehicle characters and the array and check if they are not equal to each other. If true then increment i. Then compare i to differences. If i is equal to differences then increment sameCount. Reset i to 0 in order to repeat the process. 

* `getCountZero()`: Searches for vehicle numbers that end in 0. Uses a for loop to iterate through the Strings and checks at a given position in the String for a ‘0’, if true then increment count. Prints out the number of vehicles that end with 0. 

* `toString()`: Prints out statements. Checks if both vehicles are null, if so then return "The inputs are empty." Checks to see if the second vehicle is null, if so then return "The second vehicle is missing.” If no vehicles are missing it returns the hammings from method HammingDist.

