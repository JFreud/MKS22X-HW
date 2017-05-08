import java.util.ArrayList;

public class IntHeap {
    boolean isMax = true;
    ArrayList<Integer> heapThing;

    public IntHeap() {
	heapThing = new ArrayList<Integer>();
	heapThing.add(0);
    }

    public IntHeap(boolean ifMax) {
	isMax = ifMax;
	heapThing = new ArrayList<Integer>();
        heapThing.add(0);
    }

    public int size() {
	return heapThing.size() - 1;
    }

    
    private void pushUp(int index) {
	Integer temp;
	Integer value = heapThing.get(index);

	if(isMax) {
	    
	    while (index != 1 && value.compareTo(heapThing.get(index / 2)) > 0) {
		temp = heapThing.get(index / 2);
		heapThing.set(index / 2, heapThing.get(index));
		heapThing.set(index, temp);
		index = index / 2;
	    }
	}

	else {

	    while (index != 1 && value.compareTo(heapThing.get(index / 2)) < 0) {
		temp = heapThing.get(index / 2);
		heapThing.set(index / 2, heapThing.get(index));
		heapThing.set(index, temp);
		index = index / 2;
	    }
	}
    }

    private void pushDown(int index) {
	Integer value = heapThing.get(index);
	Integer temp;
	int newIndex;

	if (isMax) {
	    
	    if (index * 2 == heapThing.size() - 1 && value.compareTo(heapThing.get(index * 2)) < 0) { //if heap ends with only one child
		temp = heapThing.get(index * 2);
		heapThing.set(index * 2, value);
		heapThing.set(index, temp);
	    }
	    
	    while (!(index > (heapThing.size() - 1) / 2 - 1) && (value.compareTo(heapThing.get(index * 2)) < 0 || value.compareTo(heapThing.get(index * 2 + 1)) < 0)){
		Integer child1 = heapThing.get(index * 2);
		Integer child2 = heapThing.get(index * 2 + 1);
		if (child1.compareTo(child2) <= 0){ 
		    temp = child2;
		    heapThing.set(index * 2 + 1, value);
		    newIndex = index * 2 + 1;
		}
		else {
		    temp = child1;
		    heapThing.set(index * 2, value);
		    newIndex = index * 2;
		}
		heapThing.set(index, temp);
		index = newIndex;
	    }
	}

	else {

	    if (index * 2 == heapThing.size() - 1 && value.compareTo(heapThing.get(index * 2)) > 0) { //if heap ends with only one child
		temp = heapThing.get(index * 2);
		heapThing.set(index * 2, value);
		heapThing.set(index, temp);
	    }

	    while (!(index > (heapThing.size() - 1) / 2 - 1) && (value.compareTo(heapThing.get(index * 2)) > 0 || value.compareTo(heapThing.get(index * 2 + 1)) > 0)){
		Integer child1 = heapThing.get(index * 2);
		Integer child2 = heapThing.get(index * 2 + 1);
		if (child1.compareTo(child2) >= 0){ 
		    temp = child2;
		    heapThing.set(index * 2 + 1, value);
		    newIndex = index * 2 + 1;
		}
		else {
		    temp = child1;
		    heapThing.set(index * 2, value);
		    newIndex = index * 2;
		}
		heapThing.set(index, temp);
		index = newIndex;
	    }
	}
	    
    }

    public void add(Integer s) {
	heapThing.add(s);
	if (heapThing.size() > 2) {
	    pushUp(heapThing.size() - 1);
	}
    }

    public Integer remove() {
    	Integer toRet = heapThing.get(1);
    	if (heapThing.size() - 1 == 1) {
    	    return heapThing.remove(1);
    	}
    	Integer tempTop = heapThing.get(heapThing.size() - 1);
    	heapThing.set(1, tempTop);
    	heapThing.remove(heapThing.size() - 1);
    	pushDown(1);
	return toRet;
    }
        
        
	    

    public Integer peek() {
	return heapThing.get(1);
    }

    public String toString() {
	String out = "[";
	for (int i = 1; i < heapThing.size(); i++) {
	    out += heapThing.get(i) + ", ";
	}
	return out.substring(0, out.length() - 2) + "]"; //make sure no indexoutofbounds
    }

    public static void main(String[] args) {
	IntHeap test = new IntHeap();
	test.add(10);
	test.remove();
	test.add(15);
	test.add(20);
	System.out.println(test);
	test.add(11);
	test.add(7);
	test.add(5);
	test.add(13);
	test.add(10);
	test.add(22);
	test.add(25);
	System.out.println(test);
	System.out.println(test.remove());
	System.out.println(test);
	System.out.println(test.peek());
	
    }
}
    
