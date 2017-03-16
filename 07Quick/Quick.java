import java.util.Random;

public class Quick {
    
    public static int part(int[] ary, int start, int end) {
	Random thing = new Random();
	int pivot = thing.nextInt(ary.length);
	return partH(ary, pivot, start, end);
    }

    public static int partH(int[] ary, int pivot, int start, int end) {
	int temp;
	int pivotVal = ary[pivot];
	
	swap(ary, pivot, end-1);

	int toSwap = 0;
	for (int i = start; i < end; i++) {
	    if (ary[i] < pivotVal) {
		swap(ary, i, toSwap);
		toSwap++;
	    }
	}

	swap(ary, toSwap, end-1);

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
	    out += ary[i];
	}
	return out;
    }

    public static int quickselect(int[] data, int k) {
	int pivot;
	int start = 0;
	int end = data.length;
	while (start < end) {
	    pivot = part(data, start, end);
	    if (pivot == k) {
		return data[k];
	    }
	    if (k < pivot) {
	        end = pivot - 1;
	    }
	    else {
	        start = pivot + 1;
	    }
	}
	return k;
    }
		

    public static void main(String[] args) {
	int[] test = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(test, 0));
	System.out.println(quickselect(test, 1));
	System.out.println(quickselect(test, 2));
	System.out.println(quickselect(test, 3));
	System.out.println(quickselect(test, 4));
	System.out.println(quickselect(test, 5));
    }

}
	
