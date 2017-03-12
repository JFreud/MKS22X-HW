import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class USACO {
	private int[][] lake;
	private int elevation;
	private int numSteps;
	private int[][] steps;

    private char[][] pasture;
    private int N;
    private int M;
    private int T;
    private int[] start;
    private int[] end;
    private int[][] ary1;
    private int[][] ary2;
	
    public USACO(){}
    
	public void makelake(String filename){
    	ArrayList<Integer> stuffs=new ArrayList<Integer>();
    	File infile=new File(filename);
    	Scanner inf ;
    	try {
    		inf = new Scanner(infile);
    		while (inf.hasNext()){
    			String token=inf.next();
    			stuffs.add(Integer.parseInt(token));
    		}
    		
    		lake = new int[stuffs.remove(0)][stuffs.remove(0)];
    		elevation = stuffs.remove(0);
    		numSteps = stuffs.remove(0);
    		
    		for (int r=0; r<lake.length; r++){
    			for (int c=0; c<lake[0].length; c++){
    				lake[r][c]=stuffs.remove(0);
    			}
    		}
    		
    		steps = new int[numSteps][3];
    		for (int r=0; r<numSteps; r++){
    			for (int c=0; c<3; c++){
			    if (c!=2){
    				steps[r][c]=stuffs.remove(0)-1;
			    }
			    else{steps[r][c]=stuffs.remove(0);}
    			}
    		}
	    	}
    		catch (FileNotFoundException e) {
    			System.out.println(filename+" does not exist");
			}
	}
	
	public String toString(){
		String x="";
		for (int r=0; r<lake.length; r++){
			for (int c=0; c<lake[0].length; c++){
				x+=lake[r][c]+" ";
			}
			x+="\n";
		}
		return x;
	}
	
	public String toStringSteps(){
		String x="";
		for (int r=0; r<numSteps; r++){
			for (int c=0; c<3; c++){
				x+=steps[r][c]+" ";
			}
			x+="\n";
		}
		return x;
	}


    public int[] takeHighest(int row, int col) {
	int highest = 0;
	int[] returnV = {0,0};
	for (int r = 0; r < 3; r++) {
	    for (int c = 0; c < 3; c++) {
		if (lake[row + r][col + c] > highest) {
		    highest = lake[row + r][col + c];
		    returnV[0] = row + r;
		    returnV[1] = col + c;
		}
	    }
	}
	return returnV;
    }

	
    public int stomp(){
	int[] highestSpot;
	int high;
	for (int i=0; i<numSteps; i++){
	    highestSpot = takeHighest(steps[i][0], steps[i][1]);
	    high = lake[highestSpot[0]][highestSpot[1]];
	    high -= steps[i][2];
	    for (int r=0; r<3; r++){
		for (int c=0; c<3; c++){
		    if (lake[r + steps[i][0]][c + steps[i][1]] > high) {
			lake[r + steps[i][0]][c + steps[i][1]] = high;
		    }
		}
	    }
	}
	for (int r=0; r<lake.length; r++){
	    for (int c=0; c<lake[0].length; c++){
		lake[r][c]-=elevation;
		lake[r][c]*=-1;
	    }
	}
	
	int sum=0;
	for (int r=0; r<lake.length; r++){
		for (int c=0; c<lake[0].length; c++){
			if (lake[r][c]>0){sum+=lake[r][c];}
		}
	}
	return sum*72*72;
    }

    public int bronze (String fileName) {
	makelake(fileName);
	return stomp();
    }


    
    public void cowTravel(String fileName) {
	ArrayList<Integer> inputNums = new ArrayList<Integer>();
	ArrayList<String> field = new ArrayList<String>();
	ArrayList<String> lines = new ArrayList<String>();
	File file = new File(fileName);
	Scanner sc;
	try {
	    // sc = new Scanner(file);
	    // while (sc.hasNextInt()) {
	    // 	inputNums.add(sc.nextInt());
	    // }
	    // sc.useDelimiter("");
	    // while (sc.hasNext()) {
	    // 	field.add(sc.next());
	    // }

	    // int toRemove = field.size() - 8;

	    // inputNums.add(Integer.parseInt(field.remove(toRemove)));
	    //  field.remove(toRemove);
	    //  inputNums.add(Integer.parseInt(field.remove(toRemove)));
	    //  field.remove(toRemove);
	    //  inputNums.add(Integer.parseInt(field.remove(toRemove)));
	    //  field.remove(toRemove);
	    //  inputNums.add(Integer.parseInt(field.remove(toRemove)));

	    sc = new Scanner(file);
	    while (sc.hasNextLine()) {
		lines.add( sc.nextLine());
	    }
	    String thisLine;
	    String[] numLine;
	    for (int line = 0; line < lines.size(); line++) {
		thisLine = lines.get(line);
		thisLine.replaceAll("\\s+","");
		if (line == 0 || line == lines.size() - 1) {
		    numLine = thisLine.split(" ");
		    for (int i = 0; i < numLine.length; i++) {
			inputNums.add(Integer.parseInt(numLine[i]));
		    }
		}
		else {
		    for (int i = 0; i < thisLine.length(); i++) {
			field.add("" + thisLine.charAt(i));
		    }
		}
		    
	    }
		

	     while (field.remove("\n")) {};
	     
	    N = inputNums.remove(0);
	    M = inputNums.remove(0);
	    pasture = new char[N][M];
	    T = inputNums.remove(0);
	    start = new int[2];
	    end = new int[2];
	    start[0] = inputNums.remove(0);
	    start[1] = inputNums.remove(0);
	    end[0] = inputNums.remove(0);
	    end[1] = inputNums.remove(0);

	    ary1 = new int[N][M];
	    ary2 = new int[N][M];
	    for (int r = 0; r < pasture.length; r++) {
		for (int c = 0; c < pasture[r].length; c++) {
		    pasture[r][c] = field.remove(0).charAt(0);
		    if (pasture[r][c] == '*') {
			ary1[r][c] = -1;
			ary2[r][c] = -1;
		    }
		    else {
			ary1[r][c] = 0;
			ary2[r][c] = 0;
		    }
		}
	    }
	    ary1[start[0] - 1][start[1] - 1] = 1;
	    
		}
	catch (FileNotFoundException e) {
	    System.out.println("Error 404: File Not Found");
	    System.exit(0);
	}
    }
    
    public void updateArys() {
	for (int r = 0; r < N; r++) {
	    for (int c = 0; c < M; c++) {
		if (ary1[r][c] > 0) {
		    ary2[r][c] = 0;
		    if (r + 1 >= 0 && r + 1 < N && ary2[r + 1][c] != -1)
		    ary2[r+1][c] += ary1[r][c];
		    if (r - 1 >= 0 && r - 1 < N && ary2[r - 1][c] != -1)
		    ary2[r-1][c] += ary1[r][c];
		    if (c + 1 >= 0 && c + 1 < M && ary2[r][c + 1] != -1)
		    ary2[r][c+1] += ary1[r][c];
		    if (c - 1 >= 0 && c - 1 < M && ary2[r][c - 1] != -1)
		    ary2[r][c-1] += ary1[r][c];
		}
	    }
	}


	for (int r = 0; r < N; r++) {
	    for (int c = 0; c < M; c++) {
		ary1[r][c] = ary2[r][c];
	    }
	}
	
	for (int r = 0; r < N; r++) {
		for (int c = 0; c < M; c++) {
		    if (pasture[r][c] == '*') {
			ary2[r][c] = -1;
		    }
		    else {
			ary2[r][c] = 0;
		    }
		}
	}
    }

    public int silver(String fileName) {
	cowTravel(fileName);
	return silverH(end[0] - 1, end[1] - 1, T);
    }

    public int silverH(int eRow, int eCol, int time) {
	if (time == 0) {
	    return ary1[eRow][eCol];
	}
	updateArys();
	// for (int r = 0; r < N; r++) {
	//     for (int c = 0; c < M; c++) {
	// 	System.out.print(ary1[r][c]);
	//     }
	//     System.out.println();
	// }
	// System.out.println("\n\n");
	return silverH(eRow, eCol, time - 1);
    }
	    

	public static void main(String[] args){
		USACO x= new USACO();
		System.out.println (x.bronze("lake1.txt"));
	        System.out.println(x.silver("ctravel.10.in"));
	}
}
