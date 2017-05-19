import java.util.ArrayList;

public class MyHeap {
    boolean isMax = true;
    ArrayList<Location> heapThing;

    public MyHeap() {
	heapThing = new ArrayList<Location>();
	heapThing.add(new Location(1,1,null,0,0,true));
    }

    public MyHeap(boolean ifMax) {
	isMax = ifMax;
	heapThing = new ArrayList<Location>();
        heapThing.add(new Location(1,1,null,0,0,true));
    }

    public int size() {
	return heapThing.size() - 1;
    }

    
    private void pushUp(int index) {
	Location temp;
	Location value = heapThing.get(index);

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
	Location value = heapThing.get(index);
	Location temp;
	int newIndex;

	if (isMax) {
	    
	    if (index * 2 == heapThing.size() - 1 && value.compareTo(heapThing.get(index * 2)) < 0) { //if heap ends with only one child
		temp = heapThing.get(index * 2);
		heapThing.set(index * 2, value);
		heapThing.set(index, temp);
	    }
	    
	    while (!(index > (heapThing.size() - 1) / 2 - 1) && (value.compareTo(heapThing.get(index * 2)) < 0 || value.compareTo(heapThing.get(index * 2 + 1)) < 0)){
		Location child1 = heapThing.get(index * 2);
		Location child2 = heapThing.get(index * 2 + 1);
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
		Location child1 = heapThing.get(index * 2);
		Location child2 = heapThing.get(index * 2 + 1);
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

    public void add(Location s) {
	heapThing.add(s);
	if (heapThing.size() > 2) {
	    pushUp(heapThing.size() - 1);
	}
    }

    public Location remove() {
    	Location toRet = heapThing.get(1);
    	if (heapThing.size() - 1 == 1) {
    	    return heapThing.remove(1);
    	}
    	Location tempTop = heapThing.get(heapThing.size() - 1);
    	heapThing.set(1, tempTop);
    	heapThing.remove(heapThing.size() - 1);
    	pushDown(1);
	return toRet;
    }
        
        
	    

    public Location peek() {
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
	MyHeap test = new MyHeap();
	test.add(new Location(1,1,null,0,0,true));
	
    }
}
    
