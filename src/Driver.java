import java.util.*;
import java.util.concurrent.*;

public class Driver {

	private static int NUM_THREADS = 1;
	private int NUM_VEHICLES = 20;
	private static Queue<Vehicle> vehicleQueue = new ConcurrentLinkedQueue<Vehicle>();
	public static void main(String[] args) {
		CityMap cityMap = new CityMap("./map.txt");
		Thread[] thread = new Thread[NUM_THREADS];
		for(Thread threadI: thread){
			threadI = new Thread(new Runnable(){
				public void run(){
					Vehicle vehicle = vehicleQueue.poll();
					if(vehicle != null){
						cityMap.getRandomIntersection()
						vehicle.advance(roadLen);
					}
				}
			});
		}
		for(Thread threadI: thread){
			threadI.start();
		}
		for(Thread threadI: thread){
			try {
				threadI.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
