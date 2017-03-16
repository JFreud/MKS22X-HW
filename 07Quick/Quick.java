import java.util.Random;

public class Quick {
    
    public static int part(int[] ary, int start, int end) {
	Random thing = new Random();
	int pivot = thing.nextInt(ary.length);
	return partH(ary, pivot, start, end);
    }

    public static int partH(int[] ary, int pivot, int start, int end) {
	int pivotVal = ary[pivot];
	
	swap(ary, pivot, end);

	int toSwap = start;
	for (int i = start; i < end; i++) {
	    if (ary[i] < pivotVal) {
		swap(ary, i, toSwap);
		toSwap++;
	    }
	}

	swap(ary, toSwap, end);

	return toSwap;
    }

    public static void swap(int[] ary, int indexA, int indexB) {
	int temp;
	temp = ary[indexA];
	ary[indexA] = ary[indexB];
	ary[indexB] = temp;
    }

    public static String toString(int[] ary) {
	String out = "";
	for (int i = 0; i < ary.length; i++) {
	    out += ary[i] + " ";
	}
	return out;
    }

    public static int quickselect(int[] data, int k) {
	return quickselectH(data, k, 0, data.length - 1);
    }

    public static int quickselectH(int[] data, int k, int start, int end) {
	if (start == end) {
	    return data[start];
	}
	int pivot = part(data, start, end);
	if (pivot == k) {
	    return data[k];
	}
	if (k < pivot) {
	    return quickselectH(data, k, start, pivot - 1);
	}
	else {
	    return quickselectH(data, k, pivot + 1, end);
	}
    }
	    
		

    public static void main(String[] args) {
	int[] test = { 2, 10};
	// System.out.println(part(test, 0, test.length));
	// System.out.println(toString(test));


	
	System.out.println(quickselect(test, 0));
	int[] test2 = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(test2, 1));
	int[] test3 = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(test3, 2));
        int[] test4 = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(test4, 3));
	int[] test5 = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(test5, 4));
	int[] test6 = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(test6, 5));
    }

}
	
