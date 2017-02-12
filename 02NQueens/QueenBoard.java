public class QueenBoard {
    private int[][] board;
    private int[][] realBoard;
    //private list solutions_list
    private int solutionCount;
    private boolean works;

    QueenBoard (int size) {
	board = new int[size][size];
	works = false;
    }

    private void addQueen(int r,int c) {
	board[r][c] = -1;
	for (int col = c + 1 ; col < board.length; col++) {
	    board[r][col] +=1;
	}
	for (int row = r + 1; row < board.length; row++) {
	    board [row][c] +=1;
	}
	int rTL = r - 1, cTL = c - 1,
	    rTR = r - 1, cTR = c + 1,
	    rBL = r + 1, cBL = c - 1,
	    rBR = r + 1, cBR = c + 1;

	while (rTL >= 0 && cTL >= 0) {
	    board[rTL][cTL] +=1;
	    rTL -= 1;
	    cTL -= 1;
	}
	while (rTR >= 0 && cTR < board.length) {
	    board[rTR][cTR] += 1;
	    rTR -=1;
	    cTR +=1;
	}
	while (rBL < board.length && cBL >= 0) {
	    board[rBL][cBL] += 1;
	    rBL += 1;
	    cBL -= 1;
	}
	while (rBR < board.length && cBR < board.length) {
	    board[rBR][cBR] += 1;
	    rBR += 1;
	    cBR += 1;
	}
	
    }

    private void removeQueen(int r, int c) {
	if (board[r][c] != -1) {
	    System.out.println("No queen u dummy");
	}
        board[r][c] = 0;
        for (int col = c + 1; col < board.length; col++) {
	    board [r][col] -=1;
	}
	for (int row = r + 1; row < board.length; row++) {
	    board [row][c] -=1;
	}
	
	int rTL = r - 1, cTL = c - 1,
	    rTR = r - 1, cTR = c + 1,
	    rBL = r + 1, cBL = c - 1,
	    rBR = r + 1, cBR = c + 1;
	
	while (rTL >= 0 && cTL >= 0) {
	    board[rTL][cTL] -=1;
	    rTL -= 1;
	    cTL -= 1;
	}
	while (rTR >= 0 && cTR < board.length) {
	    board[rTR][cTR] -= 1;
	    rTR -=1;
	    cTR +=1;
	}
	while (rBL < board.length && cBL >= 0) {
	    board[rBL][cBL] -= 1;
	    rBL += 1;
	    cBL -= 1;
	}
	while (rBR < board.length && cBR < board.length) {
	    board[rBR][cBR] -= 1;
	    rBR += 1;
	    cBR += 1;
	}
    }

    // private int countQueens() {
    // 	int total = 0;
    // 	for (int r = 0; r < board.length; r++) {
    // 	    for (int c = 0; c < board.length; c++) {
    // 		if (board[r][c] == -1) {
    // 		    total++;
    // 		}
    // 	    }
    // 	}
    // 	return total;
    // }


    public boolean solve() {
	solveHelper(0);
	board = realBoard;
	return works;

    }


    
    private boolean solveHelper(int c) {
	
	boolean solExist = false;
	 if (c >= board.length) {
	     return true;
	}
	for (int r = 0; r < board.length; r++) {
	    // if (board[r][c] == -1) {
	    // 	return solveHelper( c + 1);
	    // }
	    // System.out.println(c);
	    // System.out.println(r);
	    // System.out.println('\n');
	    

	    if (board[r][c] == 0) {
		addQueen(r,c);
		boolean solution = solveHelper(c + 1);
		if (solution) {
		    solExist = true;
		    works = true;
		    if( c == board.length - 1) {
			realBoard = board.clone();
			solutionCount += 1;
		    }
		}
	       removeQueen(r,c);		    
	    }
	}
	return solExist;
    }



    public int getSolutionCount() {
	solutionCount = 0;
	if (solve()) {
	    return solutionCount;
	}
	return -1;
    }


    public String toString(){
	String out = "";
    	for (int r = 0; r < board.length; r ++) {
	    out += "\n";
	    for (int c = 0; c < board.length; c++) {
	        out += board[r][c] + " ";
	    }
	}
	return out;
    }


    public static void main(String[] args) {
        QueenBoard test = new QueenBoard(8);
	System.out.println(test.solve());
	System.out.println(test);
	System.out.println();
	System.out.println(test.getSolutionCount());
	// QueenBoard test2 = new QueenBoard(3);
	// System.out.println( test2.solve());
	// System.out.println(test2);
    }
}
