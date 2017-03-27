import java.util.*;


public class Merge {

    public static void mergesort(int[] ary) {
	if (ary.length == 1) {
	    return;
	}
	int[] left = Arrays.copyOfRange(ary, 0, ary.length / 2);
	int[] right = Arrays.copyOfRange(ary, ary.length / 2, ary.length);
	mergesort(left);
	mergesort(right);
	merge(left, right, ary);
    }

    public static void merge(int[] a, int[] b, int[] destination) {

	int ai, bi, di;
	ai = 0;
	bi = 0;
	di = 0;
	while (ai < a.length && bi < b.length) {
	    if (a[ai] < b[bi]){
		destination[di] = a[ai];
		ai++;
	    }
	    else {
		destination[di] = b[bi];
		bi++;
	    }
	    di++;
	}
	while (ai < a.length) {
	    destination[di] = a[ai];
	    ai++;
	    di++;
	}
	while (bi < b.length) {
	    destination[di] = b[bi];
	    bi++;
	    di++;
	}
    }

    public static void main(String[] args) {
	// int[] test = {1,5,3,6,3,4};
	// mergesort(test);
	// for (int i : test) {
	//     System.out.println(i);
	// }
	int[] test = new int[1000000];
	Random thing = new Random();
	for (int i = 0; i < test.length; i++) {
	    test[i] = thing.nextInt(Integer.MAX_VALUE);
	}
	mergesort(test);
	//System.out.println(toString(test));
	for (int i = 0; i < 500; i ++) {
	    System.out.println(test[i]);
	}
	for (int i = 0; i < test.length; i++) {
	    test[i] = thing.nextInt(10);
	}
	mergesort(test);
	for (int i = 521342; i < 523342; i ++) {
	    System.out.println(test[i]);
	}
	for (int i = 0; i < test.length; i++) {
	    test[i] = 0;
	}
	mergesort(test);
	mergesort(test);
        for (int i = 521342; i < 523342; i ++) {
	    System.out.println(test[i]);
	}

	
    }
}
