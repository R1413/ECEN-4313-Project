import java.util.*;

public class Graph {
	private Map<String, GraphNode> nodeMap;
	private int numNodes;
	
	public Graph(){
		//Initialize Graph
		nodeMap = new TreeMap<String,GraphNode>();
		numNodes = 0;
	}
	
	public void addConnection(String s1, String s2, double weight){
		GraphNode node1;
		GraphNode node2;
		if(nodeMap.containsKey(s1)){
			node1 = nodeMap.get(s1);
		} else {
			node1 = new GraphNode(s1);
			nodeMap.put(s1, node1);
			numNodes++;
		}
		
		if(nodeMap.containsKey(s2)){
			node2 = nodeMap.get(s2);
		} else {
			node2 = new GraphNode(s2);
			nodeMap.put(s2, node2);
			numNodes++;
		}
		
		node1.addConnection(node2, weight);
		node2.addConnection(node1, weight);
	}
	
	public void printGraph(){
		GraphNode[] nodes = new GraphNode[numNodes];
		nodes = nodeMap.values().toArray(new GraphNode[numNodes]);
		GraphNode node = new GraphNode();
		GraphEdge[] edges = new GraphEdge[4];
		for(int i = 0; i < numNodes; i++){
			node = nodes[i];
			edges = node.getEdges();
			System.out.println(node.getLabel());
			for(int j = 0; j < node.getNumEdges(); j++){
				System.out.println("\t" + edges[j].getNode());
			}
		}
	}
	
	public GraphNode[] getPath(String start, String end){
		//Perform Dijkstra's algorithm to find the shortest path
		PriorityQueue<GraphNode> toVisit = new PriorityQueue();
		Map<> visited = new TreeMap();
		GraphNode startNode = nodeMap.get(start);
		GraphNode endNode = nodeMap.get(end);
		
		toVisit.addAll(startNode.getEdges());
	}
}
