import java.util.concurrent.ExecutorService;

public class ControlerThread implements Runnable{
	CityMap map;
	String prev;//message passing between iterations
	ExecutorService executor;
	ControlLogic brain;
	public ControlerThread(CityMap m,String p,ExecutorService e,ControlLogic b) {
		// TODO Auto-generated constructor stub
		map=m;
		prev=p;
		brain=b;
	}

	public void run() {
		// TODO Auto-generated method stub
		//lights first
		Runnable next;
		for(Intersection inter:map.getIntersections().values()){
			for(String road:inter.getConnections().keySet()){
				int command =brain.interControl(prev, inter,road);
				next=new LightsThread(inter, command, road , executor);
				executor.execute(next);
				for(Vehicle car:inter.getConnection(road).getMoving()){
					next=new AdvanceThread(car,false,inter.getConnection(road),executor);
					executor.execute(next);
				}
			}
		}
		next=new ControlerThread(map,null,executor,brain);
		executor.execute(next);
		
		
	}
}
