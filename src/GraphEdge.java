
public class GraphEdge {
	private GraphNode node;
	private double weight;
	
	public GraphEdge(GraphNode node, double weight){
		//Initialize Edge
		this.node = node;
		this.weight = weight;		
	}
	
	public GraphNode getNode(){
		return node;
	}
	
	public double getWeight(){
		return weight;
	}
}
