import java.util.Random;

public class Pivot {
    
    public static int pivot(int[] ary) {
	Random thing = new Random();
	int pivot = thing.nextInt(ary.length);
	partition(ary, pivot);
    }

    public static partition(int[] ary, int pivot) {
	int temp;
	int pivotVal = ary[pivot];
	for (int i = 0; i < ary.length(); i++) {
		if (ary[i] > pivotVal){
		    temp = ary[i];
		    ary[i] = ary[i+1];
		    ary[i+1] = temp;
		}
	}
    }

}
	
