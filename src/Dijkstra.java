import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {
	Map<String,Intersection> intersections=new HashMap<String,Intersection>();
	private Map<String,Double> distances= new HashMap<String,Double>();
	private Map<String, Double> unchecked=new HashMap<String,Double>();
	private Map<String,String> prev=new HashMap<String,String>();

	public Dijkstra(Map<String,Intersection> input) {
		// TODO Auto-generated constructor stub
		//System.out.println(input.keySet());
		intersections=input;
			for(Map.Entry<String,Intersection> m:intersections.entrySet()){
				distances.put(m.getKey(),Double.MAX_VALUE);
			}
	}
	void findNext(String current){//finds current's neighbors and sets minimum distances. if neighbor hasn't been added, adds them to unchecked. Sets changed neighbors' previous pointer to current.
		//System.out.println(current);
		Intersection inter=intersections.get(current);
		Map<String,Road> node =inter.getConnections();
		Double curDist=distances.get(current);
		for(Map.Entry<String,Road> road:node.entrySet()){
			String key=road.getKey();
			Double newDist= curDist+road.getValue().getLength();
			if (distances.get(key)>newDist){//System.out.println("hi");
				if(distances.get(key).equals(Double.MAX_VALUE)){
					unchecked.put(key, newDist);
				}
				prev.put(key, current);
				distances.put(key, newDist);
			}
		}
	}
	String findMin(Map<String,Double> m){//returns minimum distance
		double minVal=Double.MAX_VALUE;
		String minStr = null;
		for(Map.Entry<String, Double> a:m.entrySet()){
			if(a.getValue()<minVal){
				minVal=a.getValue();
				minStr=a.getKey();
			}
		}
		return minStr;
	}
	
	
	void evaluate(String current){//checks neighbors and removes current from active list.
		findNext(current);
		unchecked.remove(current);
	}
	
	Stack<String> findPath(String start,String end){//returns a stack of string keys to all next intersections on the shortest path
			distances.put(start, (double) 0);
			unchecked.put(start, (double) 0);
			String current=start;
			while(current!=end){
				evaluate(current);
				
				current=findMin(unchecked);//System.out.println(unchecked.keySet());
				
			}
			Stack<String> outStrings = new Stack<String>();
			while(current!=start){
				outStrings.push(current);
				current=prev.get(current);
			}
			return outStrings;
	}
}
