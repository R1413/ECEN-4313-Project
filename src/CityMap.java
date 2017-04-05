import java.util.*;


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
		private Intersection start;
		
		public Road(int speedLimit, int length, Intersection end, Intersection start){
			this.speedLimit = speedLimit;
			this.length = length;
			//this.end = new Intersection();
			this.end = end;
			this.start=start;
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
	
	
	//-----Dijksta's algorithm stuff-----
	class Interwrap{
		ArrayList<Intersection> path;
		final Intersection inter;
		int dist=Integer.MAX_VALUE;
		Interwrap(Intersection i){
			inter=i;
		}
	}
	void initDjk(ArrayList<Interwrap> unchecked, Interwrap current,Intersection src){//initializes dijkstra's algorithm
		for(Intersection inter: this.intersections){
			unchecked.add(new Interwrap(inter));
			if( inter==src){
				int index=unchecked.size()-1;
				unchecked.get(index).dist=0;
				current=unchecked.get(index);
			}
		}
	}
	Interwrap setCurrent(ArrayList<Interwrap> unchecked,Interwrap current){//adds neighbors of the smallest unchecked node
		
		for(Road road:current.inter.roads){//check neighbors of current
			Intersection i;
			if (road.end==current.inter){
				i= road.start;
			}
			else{
				i= road.end;
			}
			for(Interwrap n:unchecked){
				if (n.inter==i){
					
					neighbor(current,n,road.length);
				}
			}
		}
		
		unchecked.remove(current);
		
		//set current to next closest unchecked
		int index=-1;
		int close=Integer.MAX_VALUE;
		for(Interwrap inter:unchecked){
			if (inter.dist<close){
				close=inter.dist;
				index=unchecked.indexOf(inter);
			}
		}
		current=unchecked.get(index);
		return current;
	}
	void neighbor(Interwrap current,Interwrap n,int length){
		//takes total distance to neighboring node and neighboring node
		if (n.dist>current.dist+length){
			n.dist=current.dist+length;
			n.path= new ArrayList<Intersection>(current.path);
			n.path.add(current.inter);
		}
	}
	
	
	public ArrayList<Intersection> dijkstra(Intersection src, Intersection dst){
		//one more time
		Interwrap current=null;
		ArrayList<Interwrap> unchecked=new ArrayList<Interwrap>();
		
		//init
		for(Intersection inter: this.intersections){
			unchecked.add(new Interwrap(inter));
			if( inter==src){
				int index=unchecked.size()-1;
				unchecked.get(index).dist=0;
				current=unchecked.get(index);
			}
		}
		//end init
		
		while(current.inter!=dst){
			current=setCurrent(unchecked, current);
		}
		current.path.add(current.inter);
		return current.path;
	}
	
	
	
//	public List<Intersection> dijkstra(Intersection src,Intersection dst){
//		//lets try again
//		class Interwrap{
//			List<Intersection> path;
//			static Intersection inter;
//			int dist=Integer.MAX_VALUE;
//			Interwrap(Intersection i){
//				inter=i;
//			}
//			
//		}
//		Interwrap current;
//		//ArrayList<Intersection> output=new ArrayList<Intersection>;
//		//List<Interwrap> checked=new List<Interwrap>;
//		List<Interwrap> unchecked=new ArrayList<Interwrap>();
//		
//		void init(){//initializes dijkstra's algorithm
//			for(Intersection inter: this.intersections){
//				unchecked.add(new Interwrap(inter));
//				if( inter==src){
//					int index=unchecked.size()-1;
//					unchecked.get(index).dist=0;
//					current=inter;
//				}
//			}
//		}
//		void neighbor(Interwrap current,Interwrap n){
//			//takes total distance to neighboring node and neighboring node
//			if (n.dist>current.dist){
//				n.dist=dist;
//				n.path= new List(current.path);
//				n.path.add(current.inter);
//			}
//		}
//		
//		void setCurrent(){//adds neighbors of the smallest unchecked node
//			
//			for(Road road:current.inter.roads){//check neighbors of current
//				Intersection i;
//				if (road.end==current.inter){
//					i= road.start;
//				}
//				else{
//					i= road.end;
//				}
//				for(Interwrap n:unchecked){
//					if (n.inter==i){
//						neighbor(current,inter);
//					}
//				}
//			}
//			
//			unchecked.remove(current);
//			
//			//set current to next closest unchecked
//			int index=-1;
//			int close=Integer.MAX_VALUE;
//			for(Interwrap inter:unchecked){
//				if (inter.dist<close){
//					close=inter.dist;
//					index=unchecked.indexOf(inter);
//				}
//			}
//			current=unchecked.get(index);
//		}
//		
//		init();
//		while(current.inter!=dst){
//			setCurrent();
//		}
//		current.path.add(current.inter);
//		return current.path;
//		
//	}
		/*public class dnode{
			Intersection i=new Intersection;
			int dist=Integer.MAX_VALUE;
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
			for(Road r:node.i.road){
				boolean b=true;
				for(dnode node: checked){
					if(r.end==node.i){
						b=false;
						break;
					}
				}
				if(b){
					if (node.dist+r.length<r.end.dist){
						
					}
				}
			}
		}
		List unchecked=new Arraylist();
		List checked=new Arraylist();
		for (Intersection i:intersections){
			dnode node=node(i);
			if i==src{
				node.dist=0;
			}
			unchecked.add(node);
		}
		while(!unchecked.isEmpty()){
			int index=getNearestIndex(unchecked,src);
			dnode node=unchecked.remove(index);
			checked.add(0,node);
		}
		
	}*/
	
	
	
}
