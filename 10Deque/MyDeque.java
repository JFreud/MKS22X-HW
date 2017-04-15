import java.util.Arrays;

public class MyDeque {
    String [] deque;
    int front, back, capacity, size;
    
    public MyDeque(int capacity) {
	deque = new String[capacity];
	front = 0;
	back = 1;
	size = 0;
	this.capacity = capacity;
    }

    public void addFirst(String s) {
	if (size == capacity) {
	    resize();
	}
	deque[front] = s;
	front = (front - 1 + capacity) % capacity;
	size++;
    }

    private void resize() {
	String[] temp = new String[capacity * 2];

	int tempi = 0;
	for (int i = 0; i < size; i++) {
	    temp[i] = deque[(front + 1 + i) % capacity];
	}

	for (String s : temp) {
	    System.out.print(s + ",");
	}
	System.out.println();

	deque = new String[temp.length];
	capacity = capacity * 2;
	front = capacity - 1;
	back = size;
	
	for (int i = 0; i < size; i++) {
	    deque[i] = temp[i];
	}

    }


	// String[] temp = new String[capacity * 2];
	// System.out.println("front = " + front);
        // for (String s : deque) {
	//     System.out.print(s + ",");
	// }
	// System.out.println();
	// for (int i = 0; i < size; i++) {
	//     //System.out.println(size);
	//     //System.out.println("next: " + deque[(front - 1 + i) % capacity]);
	//     temp[i] = deque[(front - 1 + i) % capacity];
	// }
	// deque = new String[temp.length];
	// capacity = capacity * 2;
	// front = capacity - 1;
	// back = size;

	// for (int i = 0; i < size; i++) {
	//     deque[i] = temp[i];
	// }
	
	// for (String s : temp) {
	//     System.out.print(s + ",");
	// }
	// System.out.println();
	// deque = Arrays.copyOf(temp, temp.length);

    public void addLast(String s) {
	if (size == capacity) {
	    resize();
	}
	deque[back] = s;
	back = (back + 1) % capacity;
	size++;
    }

    public String removeFirst() {
	int index = (front + 1) % capacity;
	String retVal = deque[index];
	deque[index] = null;
	front = index;
	size--;
	return retVal;
    }

    public String removeLast() {
	int index = (back - 1 + capacity) % capacity;
	String retVal = deque[index];
	deque[index] = null;
	back = index;
	size--;
	return retVal;
    }

    public String getFirst() {
	return deque[(front + 1) % capacity];

    }

    public String getLast() {
	return deque[(back - 1 + capacity) % capacity];
    }

    public String toString() {
	String out = "[";
	for (int i = 0; i < capacity; i++) {
	    out += deque[i] + ",";
	}
	return out.substring(0, out.length() - 1) + "]"; //remove last comma
    }

    public static void main(String[] args) {
	MyDeque test = new MyDeque(10);
	// //System.out.println(test);
	// test.addFirst("two");
	// //System.out.println(test);
	// test.addFirst("one");
	// //System.out.println(test);
	// test.addLast("three");
	// test.addLast("four");
	// // System.out.println(test);
	// // System.out.println(test.getFirst());
	// // System.out.println(test.getLast());
	// System.out.println(test.removeFirst());
	// System.out.println(test.removeLast());
	// // System.out.println();
	// // System.out.println(test.getFirst());
	// // System.out.println(test.getLast());
	// // System.out.println(test);
	// // System.out.println(test.getFirst());
	// // System.out.println(test.getLast());
	// for (int i = 0; i < 15; i++) {
	//     test.addFirst("one hunna");
	// }
	// System.out.println(test);
	// test.addLast("last");
	// test.addFirst("first");
	// System.out.println(test);
        // System.out.println(test.getFirst());
	// System.out.println(test.getLast());
	test.addLast("two");
	test.addLast("three");
	test.addFirst("one");
	System.out.println(test);
	
    }

}
