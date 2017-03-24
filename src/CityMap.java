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
		int getNearestIndex(Arraylist list,Intersection src){
			int i=0;
			int a=0;
			int dist=Integer.MAX_VALUE;
			for(dnode node:list){
				int b=((src.coords[0]-node.i.coords[0])^2+(src.coords[1]-node.i.coords[1])^2)^(1/2);
				if b<dist{
					dist=b;
					i=a;
				}
				a=a+1;
			}
			return i;
		}
		void neighbors(dnode node){
			for()
		}
		List unchecked=new Arraylist();
		List checked=new Arraylist();
		for (Intersection i:intersections){
			dnode node=node(i);
			if i==src{
				node.dist=0;
			}
			unchecked.add(0,node);
		}
		while(!unchecked.isEmpty()){
			int index=getNearestIndex(unchecked,src);
			dnode node=unchecked.remove(index);
			checked.add(0,node);
		}
		
	}
	
	
	
}
