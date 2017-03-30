

public class MyLinkedList {
    private LNode start;
    private LNode end;
    private int size;

    // public MyLinkedList() {
    // 	start = new LNode();
    // 	size = 1;
    // }
    
    public MyLinkedList(int val) {
	start = new LNode(val);
	end = start;
	size = 1;
    }

    public boolean add(int val) {
	// start = new LNode(val, start);
	end.next = new LNode(val); 
	end = end.next;
	size++;
	return true;
    }

    public int size() {
	return size;
    }

    public String toString() {
	String out = "[";
	LNode current = start;
	while (current.next != null) {
	    out += current.hereNum + ", ";
	    current = current.next;
	}
	out += current.hereNum + "]";
	return out;
    }
    
    public int get(int index) {
	LNode toGet = start;
	for (int i = 0; i < index; i++) {
	    toGet = toGet.next;
	}
	return toGet.hereNum;
    }

    public int set(int index, int newVal) {
	LNode toSet = start;
	for (int i = 0; i < index; i++) {
	    toSet = toSet.next;
	}
	int toRet = toSet.hereNum;
	toSet.hereNum = newVal;
	return toRet;
    }

    public int indexOf (int val) {
	LNode toCheck = start;
	for (int i = 0; i < size - 1; i++) {
	    if (toCheck.hereNum == val) {
		return i;
	    }
	    toCheck = toCheck.next;
	}
	return -1;
    }

    private class LNode {
	int hereNum;
	LNode next;

	public LNode(int num, LNode nextNode) {
	    hereNum = num;
	    next = nextNode;
	}

	public LNode (int num) {
	    hereNum = num;
	}
    }
	    

    public static void main(String[] args) {
	MyLinkedList test = new MyLinkedList(10);
	test.add(11);
	test.add(13);
	test.add(0);
	test.add(-5);
	System.out.println(test.size());
	System.out.println(test.get(2));
	System.out.println(test.set(2, 10000));
	System.out.println(test.get(2));
	System.out.println(test.indexOf(10000));
	System.out.println(test.indexOf(103000));
	System.out.println(test);
    }
	    
}



