public class QueenBoard {
    private int[][] board;
    private int solutionCount;

    QueenBoard (int size) {
	board = new int[size][size];
    }

    private void addQueen(int r,int c) {
	board[r][c] = -1;
    }

    private void removeQueen(int r, int c) {
	if (board[r][c] == -1) {
	    board[r][c] = 0;
	}
    }

    private int countQueens() {
	int total = 0;
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		if (board[r][c] == -1) {
		    total++;
		}
	    }
	}
	return total;
    }

	    

    public boolean solve() {
	return solveHelper(0);
    }


    
    public boolean solveHelper(int c) {
	if (countQueens() == board.length) {
	    return true;
	}
	if (row == board.length) {
	    return false;
	}
	for (int r = 0; r < board.length; r++) {

	    if (board[r][c] == 0) {
		addQueen(r,c);
		for (int row = 0; row < board.length; row ++) {
		    if (board[row][c] == -1 && row != r) {
		    removeQueen[r][c];
		    }
		    if (board [r][row] == -1 && row != c) {
		    removeQueen[r][c];
		    }
		}
		checkDiagonals();
		if (!Helper(col + 1)) {
		    removeQueen[r][c];
		}
		if (board[r][c] == -1){
		    return Helper(col + 1);
		}
	    }
	}
	return false;
    }

    public int getSolutionCount(){
    	return -1;
    }

    public String toString(){
    	return "";
    }
}
