
public class RunningMedian {
    IntHeap left,right;
    int size;
    double median;

    public RunningMedian(){
	left = new IntHeap(true);
	right = new IntHeap(false);
	size = left.size() + right.size();
    }


    public void add (int n) {
        size++;
	if (left.size() == 0 && right.size() == 0) {
	    left.add(n);
	    median = n;
	    return;
	}
	if (n <= median) {
	    left.add(n);

	}
	else{
	    right.add(n);
	    
	}
	if (left.size() > right.size() + 1) {
	    right.add(left.remove());
	}
	else if (right.size() > left.size() + 1) {
	    left.add(right.remove());
	}
	median = getMedian();
	//System.out.println("m"+median);

    }

    public double getMedian() {
	//System.out.println("lefttop: " + left.peek());
	//System.out.println("rightop: " + right.peek());
	if (size % 2 == 0) {
	    return (left.peek() + right.peek()) / 2.0;
	}
	else {
	    if (left.size() > right.size()) {
		return left.peek();
	    }
	    else {
		return right.peek();
	    }
	}
    }

    public static void main(String[] args) {
	RunningMedian test = new RunningMedian();
	test.add(7);
	test.add(5);
	test.add(10);
	test.add(22);
	test.add(25);
	test.add(7);
	test.add(1);
	for (int i = 0; i < 100; i++) {
	    test.add((int)(Math.random() * 200000));
	}
	System.out.println(test.getMedian());
    }
}



