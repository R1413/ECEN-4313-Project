import java.util.*;

public class Vehicle {//make abstract once we have examples
	private int length;
	private int speed=10;
	private Stack<String> path;
	private Stack<String> backup;
	public String home;
	public String dest;
	private double location;
	public int tracking=0;
	
	private VehicleType vehicleType;
	public Vehicle(String h,String d,Stack<String> p){
		//Do Something
		this.vehicleType = VehicleType.Car;
		
		//Choose vehicle attributes based on vehicle type
		if(vehicleType == VehicleType.Car){
			length = 3; // in meters
		}
		
		//Chose home and some number of destinations
		home=h;
		dest=d;
		/*Random random = new Random();
		home=map.get(random.nextInt(map.size())).getName();
		dests=new String[random.nextInt(map.size())];
		for(String k:dests){
			k=map.get(random.nextInt(map.size())).getName();
		}
		*/
		
		//Fill path stack;
		path=p;
		backup=(Stack<String>) p.clone();
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
	String nextRoad(){
		tracking++;
		String str;
		try{str=path.pop();
		}catch(NullPointerException e){
			return null;
		}catch(EmptyStackException e){
			return null;
		}
		return str;
	}
	double getLocation(){
		return location;
	}
	String peakPath(){
		return path.peek();
	}
	void pushPath(String wtf){//I dont know why but I think I need this
		path.add(wtf);
	}
}
