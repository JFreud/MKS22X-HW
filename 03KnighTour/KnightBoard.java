public class KnightBoard {
    private int[][] board;
    private int sizeR, sizeC;

    public KnightBoard(int startingRows, int startingCols) {
	board = int[startingRows][startingCols];
	sizeR = startingRows;
	siceC = startingCols;
    }
    
    private boolean checkOpenFields(int row, int col) {
	 return (board[r+2][c+1] == 0 ||
		 board[r+2][c-1] == 0 ||
		 board[r+1][c+2] == 0 ||
		 board[r+1][c-2] == 0 ||
		 board[r-2][c+1] == 0 ||
		 board[r-2][c-1] == 0 ||
		 board[r-1][c+2] == 0 ||
		 board[r-1][c-2] == 0);
    }

     public void solve() {
	 solveH(0,0,0);
     }

     private boolean solveH (int row, int col, int level) {
	 if (level == sizeR * sizeC) {
	    return true;
	}
	 for (int r = 0; r < board.length; r++) {
	     for (int c =0; c < board[r].length; c++) {
		 if (board[row][col] == 0 && checkOpenFields(row, col)) {
		     board[row][col] = level;
		     if (solveH (r, c, level++)) {
			 return true;
		     }
		     board[row][col] = 0;
		 }
	     }
	 }
     }
		 
	

    public String toString() {
	return "";
    }


}
