import java.util.concurrent.ExecutorService;

public class AdvanceThread implements Runnable{
	Vehicle car;
	
	Road road;
	ExecutorService  executor;
	
	public AdvanceThread(Vehicle c, Road r,ExecutorService  e) {
		// TODO Auto-generated constructor stub
		car=c;
		road=r;
		executor=e;
	}
	
	public void run(){//advance vehicles
		String result=road.advanceVehicle(car);
		if(result.equals(road.id));
		else{
			if(result.equals(null)){
				Runnable next=new AdvanceThread(car,road,executor);
				executor.execute(next);
			}
			else{
				Road r= road.getEnd().getConnection(result);
				Runnable next=new AdvanceThread(car,r,executor);
				r.addVehicle(car);
				executor.execute(next);
			}
		}
	}

}
