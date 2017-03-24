import java.util.Random;

public class Quick {
    
    public static int part(int[] ary, int start, int end) {
	Random thing = new Random();
	int pivot = thing.nextInt(end - start) + start;
	return partH(ary, pivot, start, end);
    }

    public static int partH(int[] ary, int pivot, int start, int end) {
	int pivotVal = ary[pivot];
	//System.out.println( "pivot: " + pivotVal);
	
	swap(ary, pivot, start);

	int lt = start;
	int gt  = end - 1;
	int i = start;
	while (i <= gt) {
	    if (ary[i] == pivotVal){
		i++;
	    }
	    else if (ary[i] < pivotVal) {
		swap(ary, i, lt);
		lt++;
		i++;
	    }
	    else {
		swap(ary, i, gt);
		gt--;
	    }
	}
	//swap (ary, start, gt);

	return lt;
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
	return quickselectH(data, k, 0, data.length);
    }

    public static int quickselectH(int[] data, int k, int start, int end) {
	if (start == end) {
	    return data[start];
	}
	
	int pivot = part(data, start, end);
	System.out.println();
	System.out.println("pivot: " + pivot);
	System.out.println("kth smallest: " + k);
	System.out.println();
	if (pivot == k) {
	    System.out.println("equal");
	    for (int i : data) {
	    	System.out.print(i + " ");
	    }
	    System.out.println();
	    return data[pivot];
	}
	else if (k < pivot) {
	    System.out.println("less than");
	    for (int i : data) {
	    	System.out.print(i + " ");
	    }
	    System.out.println();
	    return quickselectH(data, k, start, pivot);
	}
	else {
	    System.out.println("greater than");
	    for (int i : data) {
	    	System.out.print(i + " ");
	    }
	    System.out.println();
	    return quickselectH(data, pivot, pivot + 1, end);
	}
    }
	    
		

    public static void main(String[] args) {
	int[] test = {2, 10, 15, 23, 0,  5};
	// System.out.println(part(test, 0, test.length - 1));
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
	
