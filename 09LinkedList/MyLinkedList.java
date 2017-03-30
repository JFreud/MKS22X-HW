

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
	System.out.println(test);
    }
	    
}



