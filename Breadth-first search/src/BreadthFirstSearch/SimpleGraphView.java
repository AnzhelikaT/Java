package BreadthFirstSearch;


import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

public class SimpleGraphView {
	public Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
	public SimpleGraphView () {
		// Add some vertices. 
		g.addVertex((Integer)1);    
		g.addVertex((Integer)2);
		g.addVertex((Integer)3); 
		g.addVertex((Integer)4); 
		g.addVertex((Integer)5); 
		g.addVertex((Integer)6); 
		g.addVertex((Integer)7); 
		g.addVertex((Integer)8); 
		g.addVertex((Integer)9); 
		g.addVertex((Integer)10); 
		g.addVertex((Integer)11); 
		g.addVertex((Integer)12); 
		g.addVertex((Integer)13); 
		// Add some edges.    
		g.addEdge("A", 1, 2); 
		g.addEdge("B", 2, 3);
		g.addEdge("C", 2, 4);
		g.addEdge("D", 3, 5);
		g.addEdge("E", 3, 6);
		g.addEdge("F", 3, 7);
		g.addEdge("G", 4, 8);
		g.addEdge("H", 5, 9);
		g.addEdge("I", 6, 10);
		g.addEdge("J", 6, 11);
		g.addEdge("K", 7, 12);
		g.addEdge("L", 10, 13);
		
	}
}
