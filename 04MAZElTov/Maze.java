import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
	String premaze = "";
	Scanner sc;
	try {
        sc = new Scanner(new File(filename));
	while (sc.hasNext()) {
	    premaze += sc.nextLine() + "\n";
	}
	}
	catch (FileNotFoundException e) {
	    System.out.println("Error 404: File Not Found");
	    System.exit(0);
	}

	//System.out.println(premaze);

	String[] mLines = premaze.split("\n");
	maze = new char[mLines.length][mLines[0].length()];

	//System.out.println("row: " + maze.length);
	//System.out.println("column: " + maze.length);

	for (int r = 0; r < maze.length; r++) {
	    System.out.println();
	    char[] thisLine = mLines[r].toCharArray();
	    for (int c = 0; c < maze[r].length; c++) {
		maze[r][c] = thisLine[c];
		//System.out.print(thisLine[c]);
	    }
	}

	
    }
    

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;

            for (int r = 0; r < maze.length; r++) {
		for (int c = 0; c < maze[r].length; c++) {
		    if (maze[r][c] == 'S') {
			startr = r;
			startc = c;
		    }
		}
	    }

            maze[startr][startc] = ' ';
            return solveH(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solveH(int row, int col){
	int[] dir = {-1, 1};
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }
	
	maze[row][col] = '@';
	
	for (int i = 0; i < dir.length; i ++) {
	    if (row + dir[i] >= 0 &&
		row + dir[i] < maze.length) {

		if (maze[row + dir[i]][col] == 'E') {
		    return true;
		}
		
		
		if (maze[row + dir[i]][col] != '#' &&
		    maze [row + dir[i]][col] != '@') {
		    
		    maze[row + dir[i]][col] = '@';
		    if (solveH(row + dir[i], col)) {
			return true;
		    }
		    else {
			maze[row + dir[i]][col] = '.';
		    }
		    
		}
		
	    }

	    if (col + dir[i] >= 0 &&
		col + dir[i] < maze[row].length) {

        	if (maze[row][col + dir[i]] == 'E') {
		    return true;
		}
		
		if (maze[row][col + dir[i]] != '#' &&
		    maze [row][col + dir[i]] != '@') {
		    
		    maze[row][col + dir[i]] = '@';
		    if (solveH(row, col + dir[i])) {
			return true;
		    }
		    else {
			maze[row][col + dir[i]] = '.';
		    }
		    
		}
		
	    }
	}
        return false;
    }

    public String toString() {
	String out = "";
	for (int r = 0; r < maze.length; r++) {
	    out += "\n";
	    for (int c = 0; c < maze[r].length; c++) {
		out += maze[r][c];
	    }
	}
	return out;
    }



    public static void main(String[] args) {
	Maze test = new Maze("data1.dat");
	test.setAnimate(true);
	System.out.println(test.solve());
	Maze test2 = new Maze("data2.dat");
	test2.setAnimate(true);
	//System.out.println(test2);
	System.out.println(test2.solve());
	Maze test3 = new Maze("data3.dat");
	test3.setAnimate(true);
	//System.out.println(test3);
	System.out.println(test3.solve());
    }
}
