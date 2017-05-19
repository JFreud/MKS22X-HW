import java.util.*;

public class FrontierStack implements Frontier {

    Stack<Location> fStack = new Stack<Location>();


    public void add(Location loc) {
	fStack.push(loc);
    }

    public Location next() {
	return fStack.pop();
    }

}
