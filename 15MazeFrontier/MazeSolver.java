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

	Location current;
	int crow, ccol;
	int[] dir = {-1, 1};
        Frontier structure;
	boolean aStar = false;;

	
	if (style == 0) {
	    structure = new FrontierStack();
	}
	else if (style == 1) {
	    structure = new FrontierQueue();
	}
	else if (style == 2) {
	    structure = new FrontierPriorityQueue();
	}
	else if (style == 3) {
	    structure = new FrontierPriorityQueue();
	    aStar = true;
	}
	else{
	    structure = new FrontierQueue();
	    System.out.println("Invalid Input, use 0,1,2,3, using BFS as default");
	}

	structure.add(maze.getStart());

	while (structure != null) {
	    System.out.println(maze.toString(100));
	    current = structure.next();
	    crow = current.getRow();
	    ccol = current.getCol();

	    if (current.getGoalDist() == 0) {
		// System.out.println(maze.getEnd().getGoalDist());
		// System.out.println(current.getGoalDist());
		// System.out.println(crow);
		// System.out.println(ccol);
		// System.out.println(maze.getEnd().getRow());
		// System.out.println(maze.getEnd().getRow());
		//System.out.println("end");
		traceBack(current);
		return;
	    }
	    else {
		maze.set(crow, ccol, '@');
	    }
		
	    
	    for (int i = 0; i < dir.length; i++) {
		//maybe check if out of bounds

		// System.out.println(maze.getEnd().getRow() - crow +
		// 		   maze.getEnd().getCol() - (ccol + dir[i]));
		
		int startDistR = Math.abs(maze.getStart().getRow() - (crow + dir[i])) +
		    Math.abs(maze.getStart().getCol() - ccol);
		int endDistR = Math.abs(maze.getEnd().getRow() - (crow + dir[i])) +
		    Math.abs(maze.getEnd().getCol() - ccol);
		int startDistC = Math.abs(maze.getStart().getRow() - crow) +
		    Math.abs(maze.getStart().getCol() - (ccol + dir[i]));
		int endDistC = Math.abs(maze.getEnd().getRow() - crow) +
		    Math.abs(maze.getEnd().getCol() - (ccol + dir[i]));
		
		if (maze.get(crow + dir[i], ccol) != '#' &&
		    maze.get(crow + dir[i], ccol) != '@' &&
		    maze.get(crow + dir[i], ccol) != '.') {
		    structure.add(new Location(crow + dir[i], ccol, current, startDistR, endDistR, aStar));
		    maze.set(crow + dir[i], ccol, '?');
		}
		if (maze.get(crow, ccol + dir[i]) != '#' &&
			 maze.get(crow, ccol + dir[i]) != '@' &&
			 maze.get(crow, ccol + dir[i]) != '.') {
		    structure.add(new Location(crow, ccol + dir[i], current, startDistC, endDistC, aStar));
		    maze.set(crow, ccol + dir[i], '?');
		}
	    }

	    maze.set(crow, ccol, '.');
	}

	
    }

    //trace back function

    private void traceBack(Location loc) {
	Location cur;
	int crow, ccol;
	crow = loc.getRow();
	ccol = loc.getCol();
	maze.set(crow, ccol, 'E');
        cur = loc.getPrev();
	while (cur.getStartDist() != 0){
            // System.out.println(crow);
	    // System.out.println(ccol);
	    //System.out.println("tracing");
	    System.out.println(maze.toString(100));
	    //System.out.println(cur.getStartDist());
	    crow = cur.getRow();
	    ccol = cur.getCol();
	    maze.set(crow, ccol, '@');
	    cur = cur.getPrev();
	}
	maze.set(cur.getRow(), cur.getCol(), 'S');
	System.out.println(maze.toString(200));
    }
	

    public String toString() {
	return maze.toString();
    }
    


    public static void main(String[] args) {
	MazeSolver test = new MazeSolver("data3.dat");
	test.solve(2);
	//System.out.println(test);
    }


}
