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

	private int[] toInt(String[] input) {
		int[] result = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			result[i] = Integer.parseInt(input[i]);
		}
		return result;
	}
	
	public String toString() {
		return "whole:"+whole+" numerator:"+ numerator+" denominator:"+ denominator;
	}

}
