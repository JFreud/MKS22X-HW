public class QueenBoard {
    private int[][] board;
    private int solutionCount;
    private boolean works;
    private int bigness;

    QueenBoard (int size) {
	bigness = size;
	board = new int[size][size];
	works = false;
    }

    private void addQueen(int r,int c) {
	board[r][c] = -1;
	for (int col = c + 1 ; col < board.length; col++) {
	    board[r][col] +=1;
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



    public boolean solve() {
	clear();
        boolean returnVal=solveHelper(0);
	return returnVal;
    }

    // private boolean solveHelper(int c) {
	
    // 	boolean solExist = false;
    // 	 if (c >= board.length) {
    // 	     return true;
    // 	}
    // 	for (int r = 0; r < board.length; r++) {
    // 	    if (board[r][c] == 0) {
    // 		addQueen(r,c);
    // 		boolean solution = solveHelper(c + 1);
    // 		if (solution) {
    // 		    solExist = true;
    // 		    if( c == board.length - 1) {
    //        		works = true;
    // 			realBoard = board.clone();
    // 			// System.out.println(board2string(realBoard));
    // 			// System.out.println(board2string(board));
    // 			solutionCount += 1;
    // 		    }
    // 		}
    // 	       removeQueen(r,c);		    
    // 	    }
    // 	}
    // 	return solExist;
    // }


    private boolean solveHelper(int c) {
	if (c >= board.length) {
	    return true;
	}

	for (int r = 0; r < board.length; r++) {
	    //System.out.println(board2string(board));
	    // try {
	    // Thread.sleep(1000);
	    // }
	    // catch (InterruptedException e) {
	    // 	System.out.println("Sleep is healthy");
	    // }

	    if (board[r][c] == 0) {
		addQueen (r, c);
		if (solveHelper(c + 1)) {
		    return true;
		}
		removeQueen(r, c);
	    }
	}
	return false;
    }

    private void clear() {
	board = new int[bigness][bigness];
    }

    public boolean getSolCountH(int c) {
	 boolean solExist = false;
	 if (c >= board.length) {
	     return true;
	}
	for (int r = 0; r < board.length; r++) {
	    if (board[r][c] == 0) {
		addQueen(r,c);
		boolean solution = getSolCountH(c + 1);
		if (solution) {
		    solExist = true;
		    if( c == board.length - 1) {
			//realBoard = board.clone();
			// System.out.println(board2string(realBoard));
			// System.out.println(board2string(board));
			solutionCount += 1;
		    }
		}
	       removeQueen(r,c);		    
	    }
	}
	return solExist;
    }

    public int getSolutionCount() {
	clear();
	solutionCount = 0;
	boolean x = getSolCountH(0);
	if (x) {
	    //clear();
	    //getSolCountH(0);
	    return solutionCount;
	}
	return -1;
    }


    private static String board2string(int[][] ary) {
	String out = "";
    	for (int r = 0; r < ary.length; r ++) {
	    out += "\n";
	    for (int c = 0; c < ary[r].length; c++) {
	        out += ary[r][c] + " ";
	    }
	}
	return out;
    }
    
    public String toString(){
	String out = "";
    	for (int r = 0; r < board.length; r ++) {
	    out += "\n";
	    for (int c = 0; c < board.length; c++) {
	        out += board[r][c] + "     ";
	    }
	}
	return out;
    }


    public static void main(String[] args) {
        QueenBoard test = new QueenBoard(8);
	System.out.println();
	System.out.println();
	System.out.println("8 x 8 board: " + test.solve());
	System.out.println(test);
	System.out.println();
	System.out.println(test.getSolutionCount());
	System.out.println(test);
	System.out.println();
        System.out.println();
        System.out.println();
	QueenBoard test2 = new QueenBoard(3);
	System.out.println("3 x 3 board: " + test2.solve());
	System.out.println(test2);
	QueenBoard test3 = new QueenBoard(10);
	System.out.println();
        System.out.println("10 x 10 board solutions: " + test3.getSolutionCount());
	QueenBoard test4 = new QueenBoard(13);
	System.out.println();
	System.out.println("13 x 13 board solutions: " + test4.getSolutionCount());
	System.out.println();
	System.out.println();
	QueenBoard test5 = new QueenBoard(1);
	System.out.println("1 x 1: " + test.solve() );
	System.out.println();
	System.out.println("num solutions: " + test5.getSolutionCount());
	System.out.println(test5);
    }
}
