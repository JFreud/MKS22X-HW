import java.util.Stack;

public class StackCalc {



    private static boolean isNum(String s) {
	double test;
	try {
	    test = Double.parseDouble(s);
	}
	catch (NumberFormatException e) {
	    return false;
	}
	return true;
    }

    
    public static double eval(String s) {
	String [] tokens = s.split(" ");
	Stack<String> nums = new Stack<String>();

	for (String p : tokens) {
	    if (isNum(p)) {
		nums.push(p);
	    }
	    else {
	        if (p.equals("+")) {
		    nums.push(Double.toString(Double.parseDouble(nums.pop()) + Double.parseDouble(nums.pop())));
		}
		if (p.equals("-")) {
		    nums.push(Double.toString(-1 * Double.parseDouble(nums.pop()) + Double.parseDouble(nums.pop())));
		}
		if (p.equals("*")) {
		    nums.push(Double.toString(Double.parseDouble(nums.pop()) * Double.parseDouble(nums.pop())));
		}
		if (p.equals("/")) {
		    nums.push(Double.toString(1/Double.parseDouble(nums.pop()) * Double.parseDouble(nums.pop())));
		}
		if (p.equals("%")) {
		    double temp = Double.parseDouble(nums.pop());
		    nums.push(Double.toString(Double.parseDouble(nums.pop()) % temp));
		}
	    }
	}
	return Double.parseDouble(nums.pop());
    }


    public static void main(String[] args) {
	String test = "15 443 * 336 * 939 / 600 -";
	System.out.println(StackCalc.eval(test));
    }
}
