public class MazeSolver {

    private Maze maze;
    
    public MazeSolver(String filename) {
	this(filename, false);
    }
    
    public MazeSolver(String filename, boolean animate) {
	maze = new Maze(filename, animate);
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
	    solveBest();
	}
	else {
	    solveA();
	}
    }

    private void solveDFS() {
	



}


    private void solveBFS() {}

    private void solveBest() {}


    private void solveA() {}





}
