public class FrontierPriorityQueue implements Frontier {

    MyHeap pQueue = new MyHeap(false);

    public void add(Location loc) {
	pQueue.add(loc);
    }

    
    public Location next() {
	return pQueue.remove();
    }

    public boolean isEmpty() {
	return pQueue.size() == 0;
    }

}
