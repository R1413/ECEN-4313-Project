import java.util.*;

public abstract class Vehicle {
	private int length;
	private int speed;
	private Stack<String> path;
	private String home;
	private double location;
	
	private VehicleType vehicleType;
	public Vehicle(String h){
		//Do Something
		this.vehicleType = VehicleType.Car;
		
		//Choose vehicle attributes based on vehicle type
		if(vehicleType == VehicleType.Car){
			length = 3; // in meters
		}
		
		//Chose home and some number of destinations
		home=h;
		/*Random random = new Random();
		home=map.get(random.nextInt(map.size())).getName();
		dests=new String[random.nextInt(map.size())];
		for(String k:dests){
			k=map.get(random.nextInt(map.size())).getName();
		}
		*/
		
		//Fill path stack;
		
		//Choose vehicle behavior based on driving style
		//added later
	}
	
	double advance(double roadLen){// changes location and returns distance past end of road vehicle has traveled if any. else returns 0
		location+=speed;
		if(location>roadLen){
			return location-roadLen;
		}
		return 0;
	}
	void setLocation(double newLoc){//when moving car to new road, add previous distance
		location=newLoc;
	}

}
