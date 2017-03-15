import java.util.Random;

public class Pivot {
    
    public static int partition(int[] ary) {
	Random thing = new Random();
	int pivot = thing.nextInt(ary.length);
	return partitionH(ary, pivot);
    }

    public static int partitionH(int[] ary, int pivot) {
	int temp;
	int pivotVal = ary[pivot];
	
	swap(ary, pivot, ary.length-1);

	int toSwap = 0;
	for (int i = 0; i < ary.length; i++) {
	    if (ary[i] < pivotVal) {
		swap(ary, i, toSwap);
		toSwap++;
	    }
	}

	swap(ary, toSwap, ary.length-1);

	return toSwap;
    }

    public static void swap(int[] ary, int indexA, int indexB) {
	int temp;
	temp = ary[indexA];
	ary[indexA] = ary[indexB];
	ary[indexB] = temp;
    }

    public static void main(String[] args) {
	int[] test = {5,6,7,1,4,6};
	System.out.println(partition(test));
    }

}
	
