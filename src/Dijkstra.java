import java.util.Map;
import java.util.Stack;

public class Dijkstra {
	Map<String,Intersection> intersections;
	private Map<String,Integer> distances;
	private Map<String,Integer> unchecked;
	private Map<String,String> prev;

	public Dijkstra(Map<String,Intersection> input) {
		// TODO Auto-generated constructor stub
		intersections=input;
			for(Map.Entry<String,Intersection> m:intersections.entrySet()){
				distances.put(m.getKey(),Integer.MAX_VALUE);
			}
	}
	void findNext(String current){//finds current's neighbors and sets minimum distances. if neighbor hasn't been added, adds them to unchecked. Sets changed neighbors' previous pointer to current.
		Intersection inter=intersections.get(current);
		Map<String,Road> node =inter.getConnections();
		int curDist=distances.get(current);
		for(Map.Entry<String,Road> road:node.entrySet()){
			String key=road.getKey();
			int newDist=curDist+road.getValue().getLength();
			if (distances.get(key)>newDist){
				if(distances.get(key)==Integer.MAX_VALUE){
					unchecked.put(key, newDist);
				}
				prev.put(key, current);
				distances.put(key, newDist);
			}
		}
	}
	String findMin(Map<String,Integer> m){//returns minimum distance
		int minVal=Integer.MAX_VALUE;
		String minStr = null;
		for(Map.Entry<String, Integer> a:m.entrySet()){
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
	
	Stack<String> findPath(String start,String end){
			distances.put(start, 0);
			unchecked.put(start, 0);
			String current=start;
			while(current!=end){
				evaluate(current);
				current=findMin(unchecked);
				
			}
			Stack<String> outStrings = new Stack<String>();
			while(current!=start){
				outStrings.push(current);
				current=prev.get(current);
			}
			return outStrings;
	}
}
