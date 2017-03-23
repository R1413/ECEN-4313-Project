import java.util.*;

public abstract class Vehicle {
	private int length;
	private int speed;
	private int acc;
	private int dec;
	
	private VehicleType vehicleType;
	public Vehicle(){
		//Do Something
		this.vehicleType = VehicleType.Car;
		
		//Choose vehicle attributes based on vehicle type
		if(vehicleType == VehicleType.Car){
			length = 3; // in meters
			acc = 5; //in meters per second
			dec = acc;
		}
		
		//Choose vehicle behavior based on driving style
		//added later
	}
	

}
