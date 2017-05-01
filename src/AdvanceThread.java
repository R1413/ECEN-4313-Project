import java.util.concurrent.ExecutorService;

public class AdvanceThread implements Runnable{
	Vehicle car;
	boolean waiting;
	Road road;
	ExecutorService  executor;
	
	public AdvanceThread(Vehicle c,boolean w,  Road r,ExecutorService  e) {
		// TODO Auto-generated constructor stub
		car=c;
		waiting=w;
		road=r;
		executor=e;
	}
	
	public void run(){//advance vehicles
		if(waiting){
			String result=road.advanceOnInter(car);
			if(result.equals(null)){//Finished
				return;
			}
			Road r= road.getEnd().getConnection(result);
			Runnable next=new AdvanceThread(car,false,r,executor);
			r.addVehicle(car);
			executor.execute(next);
		}
		else{
			String result=road.advanceVehicle(car);
			if(result.equals(road.id));
			else{
				if(result.equals(null)){
					Runnable next=new AdvanceThread(car,false,road,executor);
					executor.execute(next);
				}
				else{
					Road r= road.getEnd().getConnection(result);
					Runnable next=new AdvanceThread(car,false,r,executor);
					r.addVehicle(car);
					executor.execute(next);
				}
			}
		}
	}

}
