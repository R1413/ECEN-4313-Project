import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Road {
	private double speedLimit;
	private double length;
	private Intersection end;
	private Lock interlock=new ReentrantLock();
	private Condition intercon=interlock.newCondition();
	private boolean signal;
	private Queue<Vehicle> waitingcars;
	private List<Vehicle> allcars;
	
	public Road(Intersection end, double speedLimit, double length){
		this.end = end;
		this.speedLimit = speedLimit;
		this.length = length;
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
	public void green(){
		signal=false;
		//add some callable to the threadpool
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
	public String advanceOnRoad(Vehicle car){
		double dist=car.advance(length);
		if(dist>0){
			if(signal|(waitingcars.size()>0)){
				waitingcars.add(car);
				car.setLocation(length);
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
