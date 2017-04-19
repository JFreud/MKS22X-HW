import java.util.*;

public class MyLinkedList implements Iterable<Integer> {
    private LNode start;
    private LNode end;
    private int size;


    public MyLinkedList() {
     	start = null;
    	end = start;
    	size = 0;
    }

    public Iterator<Integer> iterator() {
	return new LinkedListerator();
    }

    private class LinkedListerator implements Iterator<Integer> {
	LNode nextL;

	public LinkedListerator() {
	    nextL = start;
	}

	public boolean hasNext() {
	    if (nextL != null) {
		return true;
	    }
	    return false;
	}

	public Integer next() {
	    if (nextL != null) {
		LNode toRet = nextL;
		nextL = nextL.next;
		return toRet.hereNum;
	    }
	    throw new NoSuchElementException();
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
	    
	
    

    

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
	if (size == 0) {
	    return "[]";
	}
	String out = "[";
	LNode current = start;
	while (current.next != null) {
	    out += current.hereNum + ", ";
	    current = current.next;
	}
	out += current.hereNum + "]";
	return out;

	// if (size == 0) {
	//     return "[]";
	// }
	// String out = "[";
	// LNode current = start;
	// while (current.next != null) {
	//     if (current.prev == null) {
	// 	out += "(null)";
	//     }
	//     else {
	// 	out += "(" + current.prev.hereNum + ")";
	//     }
	//     out += current.hereNum;
	//     out += "(" + current.next.hereNum + "), ";
	//     current = current.next;
	// }
	// if (current.prev == null) {
	//     out += "(null)";
	// }
	// else {
	//     out += "(" + current.prev.hereNum + ")";
	// }
	// out += current.hereNum + "(null)]";
	// return out;
    }
    
    public int get(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode toGet = start;
	for (int i = 0; i < index; i++) {
	    toGet = toGet.next;
	}
	return toGet.hereNum;
    }

    public int set(int index, int newVal) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
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
	for (int i = 0; i < size; i++) {
	    if (toCheck.hereNum == val) {
		return i;
	    }
	    toCheck = toCheck.next;
	}
	return -1;
    }

    public void add(int index, int value) {
	if (index > size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	if (index == size) {
	    add(value);
	    return;
	}
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
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0) {
	    retVal = start.hereNum;
	    start.prev = null;
	    start = start.next;
	    size--;
	    return retVal;
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
	// System.out.println("next.prev b4:" + track.next.prev.hereNum);
	track.next.prev = track;
	// System.out.println("next:" + track.next.hereNum);
	// System.out.println("next.prev aft:" + track.next.prev.hereNum);
	size--;
	return retVal;
    }



   
	

    public class LNode {
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

	public String toString() {
	    return hereNum + "";
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
	// System.out.println(test);
	// System.out.println(test.size());
	// test.remove(test.size() - 1);
	// //test.remove(0);
	// System.out.println(test);
	// System.out.println(test.size());
	// test.remove(0);
	// System.out.println(test);
	// System.out.println(test.size());
	// for (LNode l : test) {
	//     System.out.println(l.hereNum);
	// }

	//System.out.println(test);
	// System.out.println(test.indexOf(11));
	MyLinkedList a= new MyLinkedList();
	System.out.println(a.toString()+"\nSize: "+a.size());//[], size=0
	for(int i=0; i<20; i++){
	    a.add(i);
	    if(a.get(a.size()-1)%2==0){
		//System.out.println(a.size());
		a.remove(a.size()-1);
	    }
	    //System.out.println(a);//Check if all nums arent odd
	}
	
	System.out.println(a+"\nSize: "+a.size());//odds 0-20 in order, size=10
	
	//Testing: set, indexOf, add(i,v); reinforce others
	for(int i=0; i<10; i++){
	    a.set(i,i*100);
	}
	
	System.out.println(a+"\nSize: "+a.size());//mulitples of 100, size=10
	for(int i=0; i<10; i++){
	    a.set(i,a.indexOf(i*100));
	}
	
        System.out.println(a+"\nSize: "+a.size());//0-9 in order, size=10
	a.remove(1);
	a.add(1,1);
	for(int i=0; i<10; i++){
	    a.add(0,i*-1-1);
	}
	a.add(a.size(),10);
	
	System.out.println(a+"\nSize: "+a.size());//-10-10 in order, size=21
	
	//Testing: Iterator
	MyLinkedList data = new MyLinkedList();
	int i = 0;
	while(i < 15){
	    data.add(i);
	    i++;
	}

	System.out.println("\nContents: "+data);
	System.out.println("Standard loop:");

	for(int n = 0; n < data.size(); n++){
	    System.out.print(data.get(n)+" ");
	}
	System.out.println();
	System.out.println("for-each loop:");
	for(Integer s : data){
	    System.out.print(s+" ");
	}
	//should be same
    }
	
}



