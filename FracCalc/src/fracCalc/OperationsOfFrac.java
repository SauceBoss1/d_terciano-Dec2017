/*
 * @author: derfel terciano
 * 
 * @version: 2 ALPHA
 * 
 * calculates the fractions with the operations
 * 
 */
package fracCalc;

public class OperationsOfFrac {
	private int[] frac1;
	private int[] frac2;
	private String operation;

	public OperationsOfFrac(int[] frac1, int[] frac2, String operation) {
		this.frac1 = frac1;
		this.frac2 = frac2;
		this.operation = operation;
	}
	
	
	/*ALGORITHM/DESCRIPTION
	 * 
	 * method name: addOrSubtractFrac
	 * 
	 * @param:String fracString1, String fracString2, String operation (arrays are always length 2)
	 * @return String
	 * 
	 * this method adds or subtracts the fraction using the well-known and famous BOWTIE METHOD
	 * 
	 * the methods converts the string fraction input in an improper fraction
	 * the main operations are stored in two corresponding variables
	 * the method checks what operation is inputed and subtracts or adds the corresponding operations
	 * 
	 * in the end the method returns a simplified string
	 * 
	 */

	public String addOrSubtractFrac(int[] inputFrac1, int[] inputFrac2, String operation) {
		int[] frac1 = toImproperFrac(inputFrac1);
		int[] frac2 = toImproperFrac(inputFrac2);
		int[] result = new int[2];
		int mainOper1 = (frac1[0] * frac2[1]);
		int mainOper2 = -(frac2[0] * frac1[1]);
		if (operation.equals("-")) {
			result[0] = mainOper1 + mainOper2;
		} else {
			result[0] = mainOper1 - mainOper2;
		}
		result[1] = (frac1[1] * frac2[1]);
		return toString(simplify(result));
	}
	
	
	/*ALGORITHM/DESCRIPTION
	 * 
	 * method name: multOrDivFrac
	 * 
	 * @param: String fracString1, String fracString2, String operation (arrays are always length 2)
	 * @return: String
	 * 
	 * the method multiplies the numerators and denominators of the first frac to the 
	 * numerators and denominators of the second frac in this order
	 * 
	 * to divide the method multiplies the numerators and denominators of the first frac to the 
	 * denominator and numerator of the second frac in this order
	 * 
	 * the method converts the input fracs into improper form and does the above algorithms^ depending on
	 * what the specified operation is
	 * 
	 * the method them returns the answer in a simplified string form
	 * 
 	 * 
	 */

	public String multOrDivFrac(int[] inputFrac1, int[] inputFrac2, String operation) {
		int[] frac1 = toImproperFrac(inputFrac1);
		int[] frac2 = toImproperFrac(inputFrac2);
		int[] result = new int[2];
		if (operation.equals("*")) {
			result[0] = frac1[0] * frac2[0];
			result[1] = frac1[1] * frac2[1];
		} else if (operation.equals("/")) {
			result[0] = frac1[0] * frac2[1];
			result[1] = frac1[1] * frac2[0];
		}
		return toString(simplify(result));
	}
	
	/*ALGORITHM/DESCRIPTION
	 * 
	 * method name: toImproperFrac
	 * 
	 * Converts a Mixed Fraction into an Improper Fraction
	 * 
	 * @param: int[] inputFrac
	 * @return: int[]
	 * 
	 * this method convert the mixed input frac of a mixed number array
	 * into an array that has a length of 2 and stores the frac into the following form:
	 * 
	 * 				[wholeNum,numerator,denominator]->[numerator,denominator]
	 * 
	 * the method creates a result array with the length of 2
	 * and stores each element of input array into the following:
	 * 		x=wholeNum  y=Numerator  z=Denominator
	 * 
	 * the program then sets the numerator by multiplying x and z and then adding the y
	 * if the whole num is a negative make it a positive and then do the operations above and conv back into a negative
	 * the denominator stays the same 
	 * return the formed improper fraction
	 */

	private int[] toImproperFrac(int[] inputFrac) {
		int[] result = new int[2];
		int x = inputFrac[0];
		int y = inputFrac[1];
		int z = inputFrac[2];
		int numerator = 0;
		if (x < 0) {
			x *= -1;
			numerator = ((x * z) + y) * -1;
		} else {
			numerator = (x * z) + y;
		}
		result[0] = numerator;
		result[1] = z;
		return result;
	}
	
	
	/*ALGORITHM/DESCRIPTION
	 * 
	 * method name: simplify
	 * 
	 * @param: int[] fracInput
	 * @return: int[]
	 * 
	 * 
	 * the method find the gcf of the improper fraction and divides the numerator and denominator
	 * by the gcf
	 * 
	 * the method also converts the answer into a mixed fraction array if needed
	 * 
	 * the method find the gcf of the fraction and divides accordingly to the numerator and denominator
	 * we then check if the abs value of the numerator is greater than the denominator if so then convert the
	 * improper to a mixed
	 * 	-if the denominator of the mixed frac is negative then make it a positive
	 * then return the mixed Frac if possible else return the improper frac
	 */

	private int[] simplify(int[] fracInput) {
		int[] result = new int[2];
		int divisibleNum = gcf(fracInput[0], fracInput[1]);
		result[0] = fracInput[0] / divisibleNum;
		result[1] = fracInput[1] / divisibleNum;

		int absOfNum = 0;
		if (result[0] < 0) {
			absOfNum = result[0] * -1;
		}
		if (result[0] > result[1] || absOfNum > result[1]) {
			int[] resultInMixed = toMixedNum(result);
			if (resultInMixed[2] < 0) {
				resultInMixed[2] *= -1;
			}
			return resultInMixed;
		} else {
			return result;
		}
	}
	
	
	/*ALGORTHM/DESCRIPTION
	 * 
	 * method name: toMixedNum
	 * 
	 * @param: int[] inputFrac
	 * @return: int[]
	 * 
	 * converts an improper fraction into a mixed fraction
	 * 
	 * this uses the modulo of the fraction to create the numerator
	 * the whole number would be the  numerator/denominator
	 * the denominator stays the same and is returned in an array with the length of 3
	 */

	private int[] toMixedNum(int[] inputFrac) {
		int[] mixedFracResult = new int[3];
		int modOfFrac = inputFrac[0] % inputFrac[1];
		int wholeNum = inputFrac[0] / inputFrac[1];
		if (modOfFrac < 0) {
			modOfFrac *= -1;
		}
		mixedFracResult[0] = wholeNum;
		mixedFracResult[1] = modOfFrac;
		mixedFracResult[2] = inputFrac[1];
		return mixedFracResult;
	}
	
	
	
	/*ALGORITHN/DESCRIPTION
	 * 
	 * method name: gcf
	 * 
	 * @param: int num1, int num2
	 * @returnL int
	 * 
	 * the method find the gcf using the Euclid's method
	 * 
	 * 
	 * the method uses a form of recursion until the second number reached 0;
	 */
	private int gcf(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		}
		return gcf(num2, num1 % num2);
	}
	
	
	/*ALGORITHM/DESCRIPTION
	 * 
	 * method name: toString
	 * 
	 * @param: int[] inputFrac
	 * @return: String
	 * 
	 * this method converts an integer array to the appropriate answer in the form of a string
	 * 
	 * this method NEEDS to check the LENGTH of the array b/c when simplifying there are certain exception
	 * to fractions for example, I could have returned [0,3,4] for any fractions without a whole number
	 * however, it would be smoother if I sometimes have an array that just return the numerator or denominator
	 * i.e [3,4] so that the program does not return the 0 with the string too.(Yes I have tried having the
	 * arrays be the length of 3 and it didn't work too well)
	 * 
	 * We check if the length of the input is 3 and if it is then form the input result variable into the 
	 * the appropriate String
	 * if the length is 2 and the denominator is 1 then just return the numerator
	 * if the length is 2 in general then return the numerator over the denominator
	 * 
	 * exceptional conditionals:
	 * if the array length is 2 and the formed string is 0/1 or the numerator is 0 then return 0
	 * if the length is 3 and the numerator is 0 just return the whole number
	 * if the length is 3 and numerator equals the denominator then just return 1 
	 * 
	 */

	public String toString(int[] inputFrac) {
		String result = "";
		if (inputFrac.length == 3) {
			result = inputFrac[0] + "_" + inputFrac[1] + "/" + inputFrac[2];
		} else if (inputFrac.length == 2 && inputFrac[1] == 1) {
			result = inputFrac[0] + "";
		} else if (inputFrac.length == 2) {
			result = inputFrac[0] + "/" + inputFrac[1];
		}

		if (result.equals("0/1") || (inputFrac.length == 2 && inputFrac[0] == 0)) {
			result = "0";
		} else if (inputFrac.length == 3 && inputFrac[1] == 0) {
			result = inputFrac[0] + "";
		} else if (inputFrac.length == 2 && inputFrac[0] == inputFrac[1]) {
			result = 1 + "";
		}
		return result;
	}
	
	
	/*ALGORITHM/DESCRIPTION
	 * 
	 * @param: none
	 * @return: String type
	 * 
	 * This instance method just calculates the intended operation and its fractions 
	 * as defined in the instance methods at the top of the class.
	 * 
	 */
	
	public String doOperation() {
		String result = "";
		if (operation.equals("+")) {
			result = addOrSubtractFrac(frac1,frac2,operation);
		}else if (operation.equals("-")) {
			result = addOrSubtractFrac(frac1,frac2,operation);
		}else if(operation.equals("*")) {
			result=multOrDivFrac(frac1,frac2,operation);
		}else {
			result=multOrDivFrac(frac1,frac2,operation);
		}
		return result;
	}

}
