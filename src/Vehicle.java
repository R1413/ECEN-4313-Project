import java.util.*;

public abstract class Vehicle {
	private int length;
	private int speed;
	private int acc;
	private int dec;
	private Stack<String> path;
	private String home;
	private String[] dests;
	private Map<String,Intersection> map;
	
	private VehicleType vehicleType;
	public Vehicle(Map<String,Intersection>mapIn){
		//Do Something
		this.vehicleType = VehicleType.Car;
		map=mapIn;
		
		//Choose vehicle attributes based on vehicle type
		if(vehicleType == VehicleType.Car){
			length = 3; // in meters
			acc = 5; //in meters per second
			dec = acc;
		}
		
		//Chose home and some number of destinations
		Random random = new Random();
		home=map.get(random.nextInt(map.size())).getName();
		dests=new String[random.nextInt(map.size())];
		for(String k:dests){
			k=map.get(random.nextInt(map.size())).getName();
		}
		
		//Choose vehicle behavior based on driving style
		//added later
	}
	

}
