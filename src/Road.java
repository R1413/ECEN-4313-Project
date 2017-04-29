
public class Road {
	private int speedLimit;
	private int length;
	private Intersection end;
	
	public Road(Intersection end, int speedLimit, int length){
		this.end = end;
		this.speedLimit = speedLimit;
		this.length = length;
	}

	public int getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
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
