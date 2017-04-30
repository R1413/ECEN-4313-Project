import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Road {
	private double speedLimit;
	private double length;
	private Intersection end;
	private boolean signal;
	private Queue<Vehicle> waitingcars;
	private List<Vehicle> allcars;
	public String id;
	
	public Road(Intersection end, double speedLimit, double length,String ID){
		this.end = end;
		this.speedLimit = speedLimit;
		this.length = length;
		this.id=ID;
	}

	public double getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Intersection getEnd() {
		return end;
	}

	public void setEnd(Intersection end) {
		this.end = end;
	}
	
	public void red(){
		signal=true;
	}
	public Queue<Vehicle> green(){
		signal=false;
		Queue<Vehicle> waiting=waitingcars;
		waitingcars=new LinkedList<Vehicle>();
		return waiting;
	}
	
	public boolean getSignal() {
		return signal;
	}

	public void setSignal(boolean signal) {
		this.signal = signal;
	}
	public Boolean addVehicle(Vehicle car){
		if(car.getLocation()>length){
			car.setLocation(car.getLocation()-length);
			return false;
		}
		return true;
	}
	public String advanceVehicle(Vehicle car){
		double dist=car.advance(length);
		if(dist>0){
			if(signal|(waitingcars.size()>0)){
				waitingcars.add(car);
				car.setLocation(length);
				return id;
			}
			else{
				car.setLocation(dist);
				allcars.remove(car);
				return car.nextRoad();
			}
		}
		return null;
	}
	public String advanceOnInter(Vehicle car){
		double dist=car.advance(length);
		car.setLocation(dist);
		allcars.remove(car);
		return car.nextRoad();
	}
}
