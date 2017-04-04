
public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		String n1 = "N1";
		String n2 = "N2";
		String n3 = "N3";
		String n4 = "N4";
//		int e = 0;
		g.addConnection(n1, n2, 10);
		g.addConnection(n2, n3, 12);
		g.addConnection(n3, n1, 20);
		
		g.addConnection(n1, n4, 11);
		g.addConnection(n4, n2, 13);
		g.addConnection(n3, n4, 14);
		
		g.printGraph();
	}

}
