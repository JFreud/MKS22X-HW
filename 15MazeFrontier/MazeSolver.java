public class MazeSolver {

    private Maze maze;
    
    public MazeSolver(String filename) {
    // 	this(filename, false);
    // }
    
    // public MazeSolver(String filename, boolean animate) {
	maze = new Maze(filename);
    }

    
    public void solve() {
	solve(1);
    }

    public void solve (int style) {
	//style is 0-4, where 0-DFS, 1-BFS,2-BestFirst, 3-A*
	if (style == 0) {
	    solveDFS();
	}
	if (style == 1) {
	    solveBFS();
	}
	if (style == 2) {
	    solvePQ(false);
	}
	else {
	    solvePQ(true);
	}
    }

    //trace back function

    private void traceBack(Location loc) {
	Location cur;
	int crow, ccol;
        cur = loc.getPrev();
	while (cur.compareTo(maze.getStart()) != 0){
	    crow = cur.getRow();
	    ccol = cur.getCol();
	    maze.set(crow, ccol, '@');
	    cur = cur.getPrev();
	}
    }
	

    private void solveDFS() {
	Location current;
	int crow, ccol;
	FrontierStack fStack = new FrontierStack();
	int[] dir = {-1, 1};

	
        fStack.add(maze.getStart());

	while (fStack != null) {
	    current = fStack.next();
	    crow = current.getRow();
	    ccol = current.getCol();

	    if (current.compareTo(maze.getEnd()) == 0) {
		traceBack(current);
		return;
	    }
	    else {
		maze.set(crow, ccol, '@');
	    }
		
	    
	    for (int i = 0; i < dir.length; i++) {
		//maybe check if out of bounds
		if (maze.get(crow + dir[i], ccol) != '#' &&
		    maze.get(crow + dir[i], ccol) != '@') {
		    fStack.add(new Location(crow + dir[i], ccol, current, 0, 0, false));
		    maze.set(crow + dir[i], ccol, '?');
		}
		else if (maze.get(crow, ccol + dir[i]) != '#' &&
			 maze.get(crow, ccol + dir[i]) != '@') {
		    fStack.add(new Location(crow, ccol + dir[i], current, 0, 0, false));
		    maze.set(crow, ccol + dir[i], '?');
		}
	    }

	    maze.set(crow, ccol, '.');
	}
	

    }


    private void solveBFS() {
	Location current;
	int crow, ccol;
	FrontierQueue fQueue = new FrontierQueue();
	int[] dir = {-1, 1};

	fQueue.add(maze.getStart());

	while (fQueue != null) {
	    current = fQueue.next();
	    crow = current.getRow();
	    ccol = current.getCol();

	    if (current.compareTo(maze.getEnd()) == 0) {
		traceBack(current);
		return;
	    }
	    else {
		maze.set(crow, ccol, '@');
	    }
		
	    
	    for (int i = 0; i < dir.length; i++) {
		//maybe check if out of bounds
		if (maze.get(crow + dir[i], ccol) != '#' &&
		    maze.get(crow + dir[i], ccol) != '@') {
		    fQueue.add(new Location(crow + dir[i], ccol, current, 0, 0, false));
		    maze.set(crow + dir[i], ccol, '?');
		}
		else if (maze.get(crow, ccol + dir[i]) != '#' &&
			 maze.get(crow, ccol + dir[i]) != '@') {
		    fQueue.add(new Location(crow, ccol + dir[i], current, 0, 0, false));
		    maze.set(crow, ccol + dir[i], '?');
		}
	    }

	    maze.set(crow, ccol, '.');
	}
	
    }

    private void solvePQ(boolean aStar) {
	Location current;
	int crow, ccol;
	FrontierPriorityQueue fPQueue = new FrontierPriorityQueue();

	


    }






}
