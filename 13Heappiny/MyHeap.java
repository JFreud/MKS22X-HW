import java.util.ArrayList;

public class MyHeap {
    boolean isMax = true;
    ArrayList<String> heapThing;

    public MyHeap() {
	heapThing = new ArrayList<String>();
	heapThing.add(""); //temp
    }

    public MyHeap(boolean ifMax) {
	isMax = ifMax;
	heapThing = new ArrayList<String>();
	if (isMax){
	    heapThing.add("");
	}
	else {
	    heapThing.add("~~~~~~~~~"); //temp
	}
    }

    private void pushUp(int index) {
	String temp = heapThing.get(index / 2);
	String toUp = heapThing.get(index);
	heapThing.set(index / 2, toUp);
	heapThing.set(index, temp);
    }

    private void pushDown(int index) {
	if (heapThing.get(index * 2).compareTo(heapThing.get(index * 2 + 1)) < 0) {
	    index = index * 2 + 1;
	}
	else {
	    index = index * 2;
	}
        pushUp(index);
    }

    public void add(String s) {
	heapThing.add(s);
	if (heapThing.size() == 2) {
	    return;
	}
	if (isMax) {
	    while (s.compareTo(heapThing.get(heapThing.lastIndexOf(s) / 2)) <= 0) {
		pushUp(heapThing.lastIndexOf(s));
	    }
	} else {
	    while (s.compareTo(heapThing.get(heapThing.lastIndexOf(s) / 2)) > 0) {
		pushUp(heapThing.lastIndexOf(s));
	    }
	}
    }

    public String remove() {
	return heapThing.remove(heapThing.size() - 1);
    }

    public String peek() {
	return heapThing.get(heapThing.size() - 1);
    }

    public String toString() {
	String out = "[";
	for (int i = 1; i < heapThing.size(); i++) {
	    out += heapThing.get(i) + ", ";
	}
	return out.substring(0, out.length() - 2) + "]";
    }

    public static void main(String[] args) {
	MyHeap test = new MyHeap();
	test.add("potato");
	test.add("potatoa");
	test.add("potatoaa");
	System.out.println(test);
	
    }
}
    
