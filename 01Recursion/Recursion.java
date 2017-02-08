public class Recursion {

    public static String name() {
	return "Freudenberg,Jerome";
    }

    public static double sqrt(double n) {
	return findSqrt(n, 1.0);
    }

    private static double findSqrt(double n, double guess) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if(isEqual(n, guess * guess)) {
	    return guess;
	}
	 if(guess == 0.0) {
	    return guess;
	 }
	double betterGuess = ((n / guess) + guess) / 2;
	System.out.println(betterGuess);
	return findSqrt(n, betterGuess);
    }


    private static boolean isEqual(double a, double b) {
	if (Math.abs(a-b) < a/100000000000.0) {
	    return true;
	}
	return false;
    }

    



}
