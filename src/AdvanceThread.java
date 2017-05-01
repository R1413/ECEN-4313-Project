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
		//System.out.println("advancing "+car.home);
		if(waiting){
			String result=road.advanceOnInter(car);
			
			if(result==null){//Finished
				if(car.dest==road.getEnd().getName()){
					road.removeWaiting(car);
					road.removeRunning(car);
					System.out.println("finished");
				}
				//
				return;
			}
			//System.out.println("asdf "+result);
			Road r= road.getEnd().getConnection(result);
			while(r!=null&&car.getLocation()>r.getLength()){
				if(r.getSignal()||r.isWaiting()){
					r.addWaiting(car);
					return;
				}
				car.setLocation(car.getLocation()-r.getLength());
				result=car.nextRoad();
				r=r.getEnd().getConnection(result);
			}
			if(result==null){//finished
				System.out.println("finished");
				return;
			}
			if(r==null){//wtf???
				car.pushPath(result);
				r=road;
			}
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
			if(result.equals(road.id))
				return;//System.out.println(car.toString()+" stopping "+road.getEnd());
			else{
				Road r= road.getEnd().getConnection(result);
				//System.out.println(road.getEnd().getConnections().keySet());
				//System.out.println("going to "+car.peakPath()+" "+result);
				while(r!=null&&car.getLocation()>r.getLength()){
					if(r.getSignal()||r.isWaiting()){
						r.addWaiting(car);
						return;
					}
					car.setLocation(car.getLocation()-r.getLength());
					result=car.nextRoad();
					r=r.getEnd().getConnection(result);
				}
				if(result==null){//finished
					if(car.dest==road.getEnd().getName()){
						road.removeWaiting(car);
						road.removeRunning(car);
						System.out.println("finished");
					}
					return;
				}
				if(r==null){//wtf???
					car.pushPath(result);
					r=road;
				}
				Runnable next=new AdvanceThread(car,false,r,executor);
				r.addVehicle(car);//result is output of road.advanceVehicle()
				executor.execute(next);
				return;
			}
		}
	}
}
