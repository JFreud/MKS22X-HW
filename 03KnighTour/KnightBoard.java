import java.util.ArrayList;

public class KnightBoard {
    private int[][] board;
    private int sizeR, sizeC;
    private int[][] moves = {{2,1}, {2,-1}, {1,2}, {1,-2}, {-2,1}, {-2,-1}, {-1,2}, {-1,-2}};
    // private ArrayList<int[]> [][] validMovesArray = getMovesArray();

    
    public KnightBoard(int startingRows, int startingCols) {
    	board = new int[startingRows][startingCols];
    	sizeR = startingRows;
    	sizeC = startingCols;
    }

    // private ArrayList<int[]> [][] getMovesArray() {
    // 	ArrayList<int[]> [][] validMovesAry = new ArrayList<int[]> [sizeR][sizeC];
    // 	for (int r = 0; r < sizeR; r++) {
    // 	  for (int c = 0; c < sizeC; c++) {
    // 	      validMovesAry[r][c] = getOpenFields(r,c);
    // 	  }
    // 	}
    // 	return validMovesAry;
    // }



    // private ArrayList<int[]> getOpenFieldsFast(int r, int c) {
    // 	return validMovesArray[r][c];
    // }

	  
    private ArrayList<int[]> getOpenFields(int r, int c) {
	ArrayList<int[]> validMoves = new ArrayList<int[]>();
	for (int m = 0; m < moves.length; m++) {
	    if (!(r + moves[m][0] < 0 || c + moves[m][1] < 0 || r + moves[m][0] >= sizeR || c + moves[m][1] >= sizeC)) {
		validMoves.add(moves[m]);
	    }
	}	
	
	return validMoves;
    }

   

    
    public int[][] makeBoardMoves() {
	int[][] boardMove = new int[sizeR][sizeC];
	    for (int r = 0; r < board.length; r++) {
		for (int c = 0; c < board[r].length; c++) {
		    boardMove[r][c] = getOpenFields(r,c).size();
		}
	    }
	return boardMove;
    }

    
    public ArrayList<int[]> sortedMoves(int r, int c) {
    	int min;
    	int[] temp;
    	int[][] boardMove = makeBoardMoves();
    	ArrayList<int[]> moves = getOpenFields(r,c);

    	for (int m = 0; m < moves.size(); m++) {
    	    min = m;
    	    System.out.println(min);
    	    for (int j = m + 1; j < moves.size(); j++){
    		System.out.println(min);
    		if (boardMove[r + moves.get(min)[0]][ c + moves.get(min)[1]] > boardMove[r + moves.get(j)[0]][c + moves.get(j)[1]]) {
    		    min = j;
    		}
    	    }
    	    temp = moves.get(min);
    	    moves.set(min, moves.get(m));
    	    moves.set(m, temp);
    	}
    	return moves;
    }

    

    
     public void solve() {
	 if (!(solveH(0,0,1))) {
	     board = new int[sizeR][sizeC];
	 }
     }


     public void solveFast() {
	 if (!(solveHFast(0,0,1))) {
	     board = new int[sizeR][sizeC];
	 }
     }

     private boolean solveH (int row, int col, int level) {
	 if (level > sizeR * sizeC) {
	    return true;
	}
	
	 ArrayList<int[]> validMoves = getOpenFields(row, col);
	 // System.out.println(arrayToString(validMoves));
	 if (board[row][col] == 0 && getOpenFields(row, col).size() > 0) {
		     board[row][col] = level;
		     for (int m = 0; m < validMoves.size(); m++) {
			
			 level++;
			
			 if (solveH (row + validMoves.get(m)[0], col + validMoves.get(m)[1], level)) {
			     return true;
			 }
			 level--;
		     }
		     board[row][col] = 0;
	 }
	 //System.out.println(level);
	 return false;
     }

     private boolean solveHFast (int row, int col, int level) {
	 if (level > sizeR * sizeC) {
	    return true;
	}
	 //ArrayList<int[]> validMoves = validMovesArray[row][col];
	 ArrayList<int[]> validMoves = sortedMoves(row, col);
	 //System.out.println(arrayToString(validMoves));
	 if (board[row][col] == 0 && getOpenFields(row, col).size() > 0) {
		     board[row][col] = level;
		     for (int m = 0; m < validMoves.size(); m++) {
			 
			 level++;
			
			 if (solveH (row + validMoves.get(m)[0], col + validMoves.get(m)[1], level)) {
			     return true;
			 }
			 level--;
		     }
		     board[row][col] = 0;
	 }
	 //System.out.println(level);
	 return false;
     }
		 
	
    private static String arrayToString(ArrayList<int[]> ary) {
	String out = "";
	for (int i = 0; i < ary.size(); i++) {
	    out += "\n";
	    for (int p = 0; p < ary.get(i).length; p++) {
		
		out += ary.get(i)[p] + " ";
	    }
	}
	return out;
    }

    public static String Board2Print(int[][] ary) {
	String out = "";
	for (int i = 0; i < ary.length; i++) {
	    out += "\n";
	    for (int p = 0; p < ary[i].length; p++) {
	       
		out += ary[i][p] + " ";
	    }
	}
	return out;
    }
	
    public String toString() {
	String out = "";
	for (int r = 0; r < board.length; r++) {
	    out += "\n";
	    for (int c = 0; c < board[r].length; c++) {
		 if (board[r][c] < 10) {
		    out += " " + board[r][c] + " ";
		    }
		else{
		    out += board[r][c] + " ";}
	    }
	}
	return out;
    }

    public static void main(String[] args) {
	KnightBoard test = new KnightBoard(4,3);
	test.solve();
	System.out.println(test);
	KnightBoard test2 = new KnightBoard(4,8);
	test2.solve();
	System.out.println(test2);
	// System.out.println();
	// int[][] moves = test2.makeBoardMoves();
	// System.out.println(test2.Board2Print(moves));
	// KnightBoard test3 = new KnightBoard(6,7);
	// test3.solveFast();
	// System.out.println(test3);
    }
}
