import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class USACO {
	private int[][] lake;
	private int elevation;
	private int numSteps;
	private int[][] steps;
	
    public USACO(){}
    
	public makelake(String filename){
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

	public static void main(String[] args){
		makelake margaret= new makelake("lake1.txt");
		System.out.println(margaret.stomp());
	}
}
