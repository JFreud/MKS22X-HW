public class Location implements Comparable<Location> {
    private int row,col;
    private int distToGoal;
    private int distToStart;
    private Location previous;
    private boolean aStar; //when true compare prevdist, else best first



    public Location(int r, int c, Location prev, int startDist,
		    int goalDist, boolean isItAStar) {

	row = r;
	col = c;
	distToGoal = goalDist;
	distToStart = startDist;
	previous = prev;
	aStar = isItAStar;
    }

    public int getGoalDist() {
	return distToGoal;
    }

    public int getStartDist() {
	return distToStart;
    }

    public int compareTo(Location other) {
	if (aStar) {
	    return (distToStart + distToGoal) - (other.getStartDist() + other.getGoalDist());
	}
	else {
	    return distToGoal - other.getGoalDist();
	}
    }

}
