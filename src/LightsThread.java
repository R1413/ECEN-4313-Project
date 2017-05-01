import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class LightsThread implements Runnable{
	Intersection inter;
	int command;
	String road;
	ExecutorService  executor;
	public LightsThread(Intersection i, int c, String r, ExecutorService e) {
		inter=i;
		command=c;
		road=r;
		executor=e;
		// TODO Auto-generated constructor stub
	}
	public void run() {
		// TODO Auto-generated method stub
		if(command==0){
			inter.redLight(road);
		}
		if(command==1){
			Queue<Vehicle> result=inter.greenLight(road);
			Vehicle car;
			car=result.poll();
			while(car != null){
				Runnable next=new AdvanceThread(car,true,inter.getConnection(road),executor);
				executor.execute(next);
				car=result.poll();
			}
		}
	}

}
