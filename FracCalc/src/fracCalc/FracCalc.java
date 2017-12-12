package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
    	boolean end = false;
		Scanner input = new Scanner(System.in);
		while(end==false) {
			System.out.println("Enter your fraction: ");
			String userFraction = input.nextLine();
			if(userFraction.equals("quit")) {
				System.out.println("Bye!");
				end=true;
			} else {
				System.out.println(produceAnswer(userFraction));
				
				
				
			}
		}

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        	
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    		String[] splitInput = input.split(" ");
        Fraction operand1 = new Fraction(splitInput[0]);
        Fraction operand2 = new Fraction(splitInput[2]);
        String operation = splitInput[1];
        OperationsOfFrac operateFrac = new OperationsOfFrac(operand1.getFrac(),operand2.getFrac(),operation);
        
        return operateFrac.doOperation();
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
