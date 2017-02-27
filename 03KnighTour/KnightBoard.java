import java.util.ArrayList;

public class KnightBoard {
    private int[][] board;
    private int sizeR, sizeC;
    private int[][] moves = {{2,1}, {2,-1}, {1,2}, {1,-2}, {-2,1}, {-2,-1}, {-1,2}, {-1,-2}};
    

    
    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	sizeR = startingRows;
	sizeC = startingCols;
    }
    
    private ArrayList<int[]> getOpenFields(int r, int c) {
	ArrayList<int[]> validMoves = new ArrayList<int[]>();
	for (int m = 0; m < moves.length; m++) {
	    if (!(r + moves[m][0] < 0 || c + moves[m][1] < 0 || r + moves[m][0] >= sizeR || c + moves[m][1] >= sizeC)) {
		validMoves.add(moves[m]);
	    }
	}	
	
	return validMoves;
    }


    //  private ArrayList<int[]> getOpenFieldsDeep(int r, int c) {
    // 	ArrayList<int[]> nextOpenFields;
    // 	ArrayList<int[]> validMoves = new ArrayList<int[]>();
    // 	ArrayList<int[]> nextMoves = new ArrayList<int[]>();
    // 	for (int m = 0; m < moves.length; m++) {
    // 	    if (!(r + moves[m][0] < 0 || c + moves[m][1] < 0 || r + moves[m][0] >= sizeR || c + moves[m][1] >= sizeC)) {
		
    // 		nextOpenFields = getOpenFields(r + moves[m][0], c + moves[m][1]);
    // 	        validMoves.add(moves[m]);
    // 		nextMoves.add(nextOpenFields);
    // 	    }
    // 	}	
	
    // 	return validMoves;
    // }

    // private ArrayList<int[]> getOptimizedFields(int r, int c) {
    // 	ArrayList<int[]> validMoves = new ArrayList<int[]>();
    // 	for (int m = 0; m < moves.length; m++) {
    // 	    if (!(r + moves[m][0] < 0 || c + moves[m][1] < 0 || r + moves[m][0] >= sizeR || c + moves[m][1] >= sizeC)) {
    // 		validMoves.add(moves[m]);
    // 	    }
    // 	}	
	
    // 	return validMoves;
    // }


    
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
	
	 ArrayList<int[]> validMoves = getOpenFields(row, col);
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
		
		out += ary.get(i)[p];
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
	KnightBoard test2 = new KnightBoard(7,6);
	test2.solve();
	System.out.println(test2);
    }
}
