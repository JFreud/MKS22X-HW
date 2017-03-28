

public class MyLinkedList {
    private LNode start;
    private int size;

    // public MyLinkedList() {
    // 	start = new LNode();
    // 	size = 1;
    // }
    
    public MyLinkedList(int val) {
	start = new LNode(val);
	size = 1;
    }

    public boolean add(int val) {
	start = new LNode(val, start);
	return true;
    }
    



    private class LNode {
	int hereNum;
	LNode thereNode;

	public LNode(int num, LNode nextNode) {
	    hereNum = num;
	    thereNode = nextNode;
	}

	public LNode (int num) {
	    hereNum = num;
	}
    }
	    

    public static void main(String[] args) {
	MyLinkedList test = new MyLinkedList(10);
    }
	    
}



