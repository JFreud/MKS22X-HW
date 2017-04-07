
//MAKE SURE TO WRITE EXCEPTIONS
public class MyLinkedList {
    private LNode start;
    private LNode end;
    private int size;


    public MyLinkedList() {
     	start = null;
    	end = start;
    	size = 0;
    }
    
    // public MyLinkedList(int val) {
    // 	start = new LNode(val);
    // 	end = start;
    // 	size = 1;
    // }

    public boolean add(int val) {
	// start = new LNode(val, start);
	if (size == 0) {
	    start = new LNode(val);
	    end = start;
	    size++;
	    return true;
	}
	end.next = new LNode(val, null);
	end.next.prev = end;
	//System.out.println(end.next.prev.hereNum);
	end = end.next;
	size++;
	return true;
    }

    public int size() {
	return size;
    }

    public String toString() {
	// if (size == 0) {
	//     return "[]";
	// }
	// String out = "[";
	// LNode current = start;
	// while (current.next != null) {
	//     out += current.hereNum + ", ";
	//     current = current.next;
	// }
	// out += current.hereNum + "]";
	// return out;

	if (size == 0) {
	    return "[]";
	}
	String out = "[";
	LNode current = start;
	while (current.next != null) {
	    if (current.prev == null) {
		out += "(null)";
	    }
	    else {
		out += "(" + current.prev.hereNum + ")";
	    }
	    out += current.hereNum;
	    out += "(" + current.next.hereNum + "), ";
	    current = current.next;
	}
	if (current.prev == null) {
	    out += "(null)";
	}
	else {
	    out += "(" + current.prev.hereNum + ")";
	}
	out += current.hereNum + "(null)]";
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

    public void add(int index, int value) {
	LNode toAdd = start;
	for (int i = 0; i < index - 1; i++) {
	    toAdd = toAdd.next;
	}
	LNode temp = toAdd.next;
	toAdd.next = new LNode (value, temp);
	toAdd.next.prev = toAdd;
	toAdd.next.next.prev = toAdd.next;
	size++;
    }

    public int remove(int index) {
	int retVal;
	if (index >= size) {
	    throw new IndexOutOfBoundsException("no elements");
	}
	if (index == 0) {
	    start.next.prev = null;
	    start = start.next;
	}
	if (index == size - 1) {
	    retVal = end.hereNum;
	    end = end.prev;
	    end.next = null;
	    size--;
	    return retVal;
	}
	LNode track = start;
	for (int i = 0; i < index - 1; i++) {
	    track = track.next;
	}
	retVal = track.next.hereNum;
	track.next = track.next.next;
	System.out.println("next.prev b4:" + track.next.prev.hereNum);
	track.next.prev = track;
	System.out.println("next:" + track.next.hereNum);
	System.out.println("next.prev aft:" + track.next.prev.hereNum);
	size--;
	return retVal;
    }

    public String reverseTest () {
	String out = "[";
	LNode current = end;
	while (current.prev != null) {
	    //System.out.println(current.prev.hereNum);
	    out += current.hereNum + ", ";
	    current = current.prev;
	}
	out += current.hereNum + "]";
	return out;
    }

   
	

    private class LNode {
	int hereNum;
	LNode next;
	LNode prev;

	public LNode(int num, LNode nextNode) {
	    hereNum = num;
	    next = nextNode;
	}

	public LNode (int num) {
	    hereNum = num;
	}

    }
	    

    public static void main(String[] args) {
	MyLinkedList test = new MyLinkedList();
	//System.out.println(test);
	test.add(11);
	test.add(13);
	test.add(0);
	test.add(-5);
	test.add(1000);
	// System.out.println(test);
	// System.out.println(test.reverseTest());
	// System.out.println(test.size());
	// System.out.println(test.reverseTest());
	// System.out.println(test.get(2));
	// System.out.println(test.set(2, 10000));
	// // System.out.println(test.get(2));
	// // System.out.println(test.indexOf(10000));
	// // System.out.println(test.indexOf(103000));
	// // System.out.println(test);
	// test.add(2, 100);
	System.out.println(test);
	System.out.println(test.size());
	test.remove(test.size() - 1);
	System.out.println(test);
	System.out.println(test.size());
	System.out.println(test.reverseTest());
    }
	    
}



