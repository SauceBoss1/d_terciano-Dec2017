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

	private int gcf(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		}
		return gcf(num2, num1 % num2);
	}

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
