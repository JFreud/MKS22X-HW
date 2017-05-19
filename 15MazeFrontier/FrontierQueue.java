import java.util.*;

public class FrontierQueue implements Frontier {

    Queue<Location> fQueue = new Queue<Location>();

    public void add(Location loc) {
	fQueue.add(loc);
    }

    public Location remove() {
	return fQueue.remove();
    }



}
