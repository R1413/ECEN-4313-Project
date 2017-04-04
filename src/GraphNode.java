
public class GraphNode {
	private GraphEdge[] edges;
	private int numEdges;
	private String label;
	
	public GraphNode(){
		edges = new GraphEdge[4];
		numEdges = 0;
		this.label = "null";
	}
	
	public GraphNode(String label){
		//Initialize Node
		edges = new GraphEdge[4];
		numEdges = 0;
		this.label = label;
	}
	
	public void addConnection(GraphNode node, double weight){
		edges[numEdges++] = new GraphEdge(node, weight);
	}
	
	public GraphEdge[] getEdges(){
		return edges;
	}
	
	public int getNumEdges(){
		return numEdges;
	}
	
	public String getLabel(){
		return label;
	}
}
