import java.util.ArrayList;

public class MyHeap {
    boolean isMax = true;
    ArrayList<String> heapThing;

    MyHeap() {
	heapThing = new ArrayList<String>();
    }

    MyHeap(boolean ifMax) {
	isMax = ifMax;
    }

    private void pushUp(int index) {
	String temp = heapThing.get(index / 2);
	String toUp = heapThing.get(index);
	heapThing.set(index / 2, toUp);
	heapThing.set(index, temp);
    }

    private void pushDown(int index) {
	if (index * 2 < index * 2 + 1) {
	    index = index * 2 + 1;
	}
	else {
	    index = index * 2;
	}
        pushUp(index);
    }

    void add(String s) {
	heapThing.add(s);
	while (s.compareTo(heapThing.get(heapThing.lastIndexOf(s) / 2)) > 0) {
	    
    }
