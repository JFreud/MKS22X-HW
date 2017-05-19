import java.util.*;

public class FrontierQueue implements Frontier {

    LinkedList<Location> fQueue = new LinkedList<Location>();

    public void add(Location loc) {
	fQueue.add(loc);
    }

    public Location next() {
	return fQueue.remove();
    }



}
