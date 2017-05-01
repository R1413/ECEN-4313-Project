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
		System.out.println("advancing "+car);
		if(waiting){
			String result=road.advanceOnInter(car);
			if(result==null){//Finished
				return;
			}
			Road r= road.getEnd().getConnection(result);
			System.out.println(r==null);
			r.addVehicle(car);
			Runnable next=new AdvanceThread(car,false,r,executor);
			executor.execute(next);
		}
		else{
			String result=road.advanceVehicle(car);
			if(result==null){
				Runnable next=new AdvanceThread(car,false,road,executor);
				executor.execute(next);
				return;
			}
			if(result.equals(road.id)) System.out.println(car.toString()+" reached "+road.getEnd());
			else{
				Road r= road.getEnd().getConnection(result);
				Runnable next=new AdvanceThread(car,false,r,executor);
				r.addVehicle(car);
				executor.execute(next);
				return;
			}
		}
	}
}
