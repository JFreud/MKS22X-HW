public class Driver{

    public static void main(String[]args){
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
