
public class Road {
	private double speedLimit;
	private double length;
	private Intersection end;
	
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
	
	public boolean isLocked(){
		return false; ////Needs to be changed
	}
}
