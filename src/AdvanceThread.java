import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class AdvanceThread implements Runnable{
	Vehicle car;
	boolean waiting;
	Road road;
	ExecutorService  executor;
	//List<String> trace;
	
	public AdvanceThread(Vehicle c,boolean w,  Road r,ExecutorService  e) {
		// TODO Auto-generated constructor stub
		car=c;
		waiting=w;
		road=r;
		executor=e;
		//trace=new ArrayList<String>(t);
	}
	
	public void run(){//advance vehicles
		//System.out.println("advancing "+car.home);
		String result;
		if(waiting){
			result=road.advanceOnInter(car);
		}
		else{
			result=road.advanceVehicle(car);
		}
		advance(result);
		
	}
	private void advance(String result){
		Road r=road;
		if(result==road.id){//wait at light(or finish if at dest)
			if(car.dest==r.getEnd().getName()){//done
				road.removeWaiting(car);
				road.removeRunning(car);
				//System.out.println("finished");
			}
			return;
		}
		if(result!=null&&result.equals("next")){//if at end of road
			String path=car.nextRoad();
			if(path.equals("finished")){
				road.removeWaiting(car);
				road.removeRunning(car);
				return;
			}
			r=r.getEnd().getConnection(path);
			while(car.getLocation()>r.getLength()&&!r.getSignal()){//keeps vehicle going as far as it can with one move
				System.out.println("dist: "+car.getLocation()+" len: "+r.getLength());
				car.setLocation(car.getLocation()-r.getLength());
				r=r.getEnd().getConnection(car.nextRoad());
				System.out.println(r.id);
			}
			if(r.getSignal()){//If stoped by signal, wait
				car.setLocation(r.getLength());
				r.addWaiting(car);
				return;
			}
			
			if(car.dest==r.getEnd().getName()){//done
				road.removeWaiting(car);
				road.removeRunning(car);
				//System.out.println("finished");	
				return;
			}
		}
		r.addVehicle(car);
		Runnable next=new AdvanceThread(car,false,r,executor);
		executor.execute(next);
	}
}
