import java.util.List;


public class CityMap {
	public class Intersection{
		private Road roads[];
		private String name;
		
		public Intersection(){
			//Do something?
		}
	}
	public class Road{
		private int speedLimit;
		private int length; 
		private Intersection end;
		
		public Road(int speedLimit, int length, Intersection end){
			this.speedLimit = speedLimit;
			this.length = length;
			this.end = new Intersection();
			this.end = end;
		}
	}
	
	private Intersection intersections[];
	private Road roads[];
	//private Map<(int,int),Intersection> lookup;
	
	public CityMap(){
		//Create City map, initialize any variables
	}
	
	public void addIntersection(String edge){
		//Use formatting of string to build connections
	}
	Intersection[] public dijkstra(Intersection src,Intersection dst){
		public class dnode{
			Intersection i=new ArrayList();
			int dist=Integer.MAX_VALUE;
			List path;
			dnode(Intersection inter){
				this.i=inter;
			}
		}
		List unchecked=new Arraylist();
		List checked=new Arraylist();
		for (Intersection i:intersections){
			dnode node=node(i);
			if i==src{
				node.dist=0;
			}
			unchecked.add(node)
		}
		while(!unchecked.isEmpty()){
			
		}
		
	}
	
	
	
}
