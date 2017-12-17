/*
 * @author derfel terciano
 * 
 * @version: 2 ALPHA
 * 
 * parses and defines fractions for other objects to use.
 */
package fracCalc;

public class Fraction {
	private int numerator;
	private int denominator;
	private int whole;

	public Fraction(String inputFrac) {
		int[] resultFrac = parseFrac(inputFrac);
		whole = resultFrac[0];
		numerator = resultFrac[1];
		denominator = resultFrac[2];
	}
	
	/*
	 * This empty constructor is just here just in case the user
	 * creates and empty object and wants to set the fraction later.
	 * 
	 */
	public Fraction() {
		whole=0;
		numerator=0;
		denominator=0;
	}
	
	/*ALGORITHM/DESCRIPTION:
	 * 
	 * method name: parseFrac
	 * 
	 * @param: String input
	 * @return: String[]
	 * 
	 * this method parses the appropriate String (i.e. 1_3/4) into an array
	 * the purpose of converting each element into an array is so it is easier to deal with
	 * whole numbers, numerators, and denominators individually.
	 * 
	 * -the method checks if there is an "_"
	 * -if so then the split the string appropriately into the following format of the result array:
	 * 
	 * 						[wholeNumber,Numerator,Denominator]
	 * 
	 * this format is the universal setup for all the fractions calculated in this class/project
	 * -else if the "_" does not exist then the check where the "/" is and split the string accordingly
	 * 	with the whole number set to 0
	 * 			-else if it's only a whole number set the whole number as the input
	 * 				and set the numerator as "0" and the denominator as "1"
	 * 
	 * then return the result
	 */

	private int[] parseFrac(String input) {
		String[] result = new String[3];
		if (input.indexOf("_") > 0) {
			String[] wholeNum = input.split("_");
			result[0] = wholeNum[0];
			String[] frac = wholeNum[1].split("/");
			result[1] = frac[0];
			result[2] = frac[1];
		} else if (input.indexOf("_") < 0) {
			if (input.indexOf("/") > 0) {
				result[0] = "0";
				String[] fracWithoutWhole = input.split("/");
				result[1] = fracWithoutWhole[0];
				result[2] = fracWithoutWhole[1];
			} else {
				result[0] = input;
				result[1] = "0";
				result[2] = "1";
			}
		}
		return toInt(result);
	}
	

	/*ALGORITHM/DESCRIPTION
	 * 
	 * @param: Stirng[] inputFrac
	 * @return: int[]
	 * 
	 * converts a string array into a int array
	 * 
	 * the method takes each element of the String array and converts
	 * the element into an integer and stores it into a new integer array
	 * 
	 * to convert a string to an integer use Integer.parseInt(String)
	 * 
	 */

	private int[] toInt(String[] input) {
		int[] result = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			result[i] = Integer.parseInt(input[i]);
		}
		return result;
	}
	
	/*ALGORITHM/DESCRIPTION:
	 * 
	 * @param: none
	 * @return: String type
	 * 
	 * 
	 * 
	 * the toString method is a toString instance method for determining
	 * what fraction is currently being used. All parts of the fraction
	 * (i.e. whole, numerator, denominator) is being used to return the 
	 * fraction being used.
	 * 
	 * 
	 * Overrides default toString
	 * 
	 */
	
	public String toString() {
		return "whole:"+whole+" numerator:"+ numerator+" denominator:"+ denominator;
	}
	
	/*ALGORITHM/DESCRIPTION
	 * 
	 * method name: getFrac
	 * 
	 * @param: none
	 * @return: int[] type
	 * 
	 * This instance method returns the array format of getFrac. I need to make an 
	 * array format for the fractions so it can be used in the other objects that
	 * require arrays in order for them to calculate fractions.
	 * 
	 */
	
	public int[] getFrac() {
		int[] resultFrac = new int[3];
		resultFrac[0]=whole;
		resultFrac[1]=numerator;
		resultFrac[2]=denominator;
		return resultFrac;
	}
	
	
	/*ALGORITHM/DESCRIPTION
	 * 
	 * method name: setFrac
	 * 
	 * @param: String
	 * @return: none
	 * 
	 * This sets the the Fraction that is going to be used.
	 * I might use this for the extra credit but I also might
	 * be too lazy to do the extra credit so if I ever need
	 * a setter method here it is:
	 */
	
	public void setFrac(String inputFrac) {
		int[] parsedFrac = parseFrac(inputFrac);
		whole = parsedFrac[0];
		numerator=parsedFrac[1];
		denominator=parsedFrac[2];
	}

}
