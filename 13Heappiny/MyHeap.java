import java.util.ArrayList;

public class MyHeap {
    boolean isMax = true;
    ArrayList<String> heapThing;

    public MyHeap() {
	heapThing = new ArrayList<String>();
	heapThing.add("");
    }

    public MyHeap(boolean ifMax) {
	isMax = ifMax;
	heapThing = new ArrayList<String>();
        heapThing.add("");
    }

    private void pushUp(int index) {
	String temp;
	String value = heapThing.get(index);

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


     private boolean hasTwoChildren(int index) {
	if (index * 2 + 1 <= heapThing.size() - 1) {
	    return true;
	}
	return false;
    }
    
     private void pushDown(int inputIndex) {
        if (inputIndex > (heapThing.size() - 1) / 2) {
	    return;
	}
	int index = inputIndex;
	String value = heapThing.get(index);
	String child1, child2;
	
	while (index <= (heapThing.size() - 1) / 2){
	    child1 = heapThing.get(index * 2);
	    if(!hasTwoChildren(index)) {
		child2 = child1;
	    }
	    else{
		child2 = heapThing.get(index * 2 + 1);
	    }
	    // System.out.println("child1: " + child1);
	    //  System.out.println("value: " + value);
	    //   System.out.println("mode: " + isMax);
	    //   System.out.println("compare: " + (value.compareTo(child1) < 0));
	    //   System.out.println("compare2: " + (value.compareTo(child2) < 0));
	      
	    if ((isMax && value.compareTo(child1) > 0 && value.compareTo(child2) > 0) ||
		(!isMax && value.compareTo(child1) < 0 && value.compareTo(child2) < 0)){
		break;
	    }
		
	    if ((isMax && child1.compareTo(child2) < 0) ||
		(!isMax && child1.compareTo(child2) > 0)){
		heapThing.set(index, child2);
		heapThing.set(index * 2 + 1, value);
		index = index * 2 + 1;
	    }
	    else {
	        //System.out.println("optionB");
		heapThing.set(index,child1);
		heapThing.set(index * 2, value);
		index = index * 2;
	    }
	}
	
    }

    public void add(String s) {
	heapThing.add(s);
	if (heapThing.size() > 2) {
	    pushUp(heapThing.size() - 1);
	}
    }

    public String remove() {
    	String toRet = heapThing.get(1);
    	if (heapThing.size() - 1 == 1) {
    	    return heapThing.remove(1);
    	}
    	String tempTop = heapThing.get(heapThing.size() - 1);
    	heapThing.set(1, tempTop);
    	heapThing.remove(heapThing.size() - 1);
    	pushDown(1);
	return toRet;
    }
        
        
	    

    public String peek() {
	if (heapThing.size() == 1) {
	    return null;
	}
	return heapThing.get(1);
    }

    public String toString() {
	String out = "[";
	if (heapThing.size() == 1) {
	    return out + "]";
	}
	for (int i = 1; i < heapThing.size(); i++) {
	    out += heapThing.get(i) + ", ";
	}
	return out.substring(0, out.length() - 2) + "]";
    }

    public static void main(String[] args) {
	MyHeap test = new MyHeap(false);
	System.out.println(test);
	System.out.println(test.peek());
	test.add("a");
	test.add("b");
	test.add("c");
	test.add("d");
	test.add("a");
	test.remove();
	test.remove();
	System.out.println(test.peek());
    }
}
    
