import java.util.HashMap;
import java.util.Map;
import java.util.Queue;



public class Intersection {
	private int SPEEDLIMIT = 40; //In km per hour
	
	private String name;
	private Map<String, Road> connections=new HashMap<String,Road>();
	private int numConnections;	//May be used for something later
	
	
	
	public Intersection(String name){
		this.name = name;
		connections = new HashMap<String,Road>();
		numConnections = 0;
	}
	
	public void addConnection(Intersection connection, double distance){
		//Default speedLimit of SPEEDLIMIT
		if(connections.containsValue(connection)){
			throw new RuntimeException("Connection between " + name  + " and " + connection.getName() + " already exists");
		}
		Road newRoad = new Road(connection, SPEEDLIMIT, distance, connection.getName());
		connections.put(connection.getName(), newRoad);
		
		numConnections++;
	}
	
	public void addConnection(Intersection connection, double distance, double speedLimit){
		//Custom speedLimit
		if(connections.containsValue(connection)){
			throw new RuntimeException("Connection between " + name  + " and " + connection.getName() + " already exists");
		}
		Road newRoad = new Road(connection, speedLimit, distance, connection.getName());
		connections.put(connection.getName(), newRoad);
		numConnections++;
	}
	
	public String getName(){
		return name;
	}
	
	public Road getConnection(String connection){
		//Returns the road associated with a connection
		System.out.println(connection+" "+this.name);
		return connections.get(connection);
	}
	
	public Map<String, Road> getConnections(){
		//Returns the Map of String->Road pairs
		return connections;
	}
	
	public void printConnections(){
		//Prints all entries in the connection map
		for(Map.Entry<String, Road> entry : connections.entrySet()){
			System.out.println("\t" + entry.getKey());
		}
	}
	
	public void redLight(String connection){
		connections.get(connection).red();
		
	}
	public Queue<Vehicle> greenLight(String connection){
		return connections.get(connection).green();
		
	}
}
