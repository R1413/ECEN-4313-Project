
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
	
	
	
	
}
