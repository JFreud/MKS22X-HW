
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

	//System.out.println("m_b"+median);
	if (left.size() > right.size()) {
	    //System.out.println("removed left");
	    right.add(left.remove());
	}
	else if (right.size() > left.size()) {
	    //System.out.println("peek1: " + right.peek());
	    //System.out.println(right);
            int tmp = right.remove();
	    //System.out.println(right);
	    //System.out.println("peek2: " + right.peek());
	    //System.out.println("removed right\nsize:" + right.size());
	    left.add(tmp);
	}
	median = getMedian();
	//System.out.println("m_s"+median);

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
	//System.out.println(test.getMedian()); FIX
        test.add(0);
	test.add(0);
	test.add(8);
	test.add(9);
	test.add(4);
	test.add(30);
	test.add(6);
	test.add(28);

	test.add(16);
	
	
    }
}



