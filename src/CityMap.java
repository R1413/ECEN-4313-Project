import java.io.*;
import java.util.*;


public class CityMap {
	
	//Fields
	private Map<String,Intersection> intersections;
	private int numIntersections;
	
	//Constructors
	public CityMap(String mapFile){
		intersections = new HashMap<String,Intersection>();
		numIntersections = 0;
		//Create City map, initialize any variables
		Reader filereader = null;
		try {
			filereader = new FileReader(mapFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader in = new BufferedReader( filereader);
		String line;
		String[] splitLine;
		double[] digits = new double[4];
		try {
			while((line = in.readLine()) != null){
				splitLine = line.split("(\\]\\^\\[)|(, )|(\\[|\\])");	//Line is split so that the four digits are indices 1 - 4
				for(int i = 1; i < 5; i++){
					digits[i-1] = Integer.parseInt(splitLine[i]);
				}//Lines split into digits
				
				String name1=Double.toString(digits[0]).concat(",").concat(Double.toString(digits[1]));//name of intersections
				String name2=Double.toString(digits[2]).concat(",").concat(Double.toString(digits[3]));
				double distance = Math.sqrt(Math.pow(digits[0]-digits[2], 2)+ Math.pow(digits[1]-digits[3], 2));
				
				Intersection intersection1, intersection2;
				if(intersections.containsKey(name1)){
					intersection1 = intersections.get(name1);
				} else { 
					intersection1 = new Intersection(name1);
					intersections.put(name1, intersection1);
					numIntersections++;
				}
				if(intersections.containsKey(name2)){
					intersection2 = intersections.get(name2);
				} else { 
					intersection2 = new Intersection(name2);
					intersections.put(name2, intersection2);
					numIntersections++;
				}
				
				intersection1.addConnection(intersection2, distance);
				intersection2.addConnection(intersection1, distance);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Methods
	public void addIntersection(String edge){
		//Use formatting of string to build connections
	}
	
	public void printGraph(){
		for(Map.Entry<String, Intersection> entry : intersections.entrySet()){
			System.out.println(entry.getKey());
			entry.getValue().printConnections();
		}
	}
	
	
	public String getRandomIntersection(){
		Random random =new Random();
		List<String> keys = new ArrayList(intersections.keySet());
		int randomIndex = random.nextInt(keys.size());
		return keys.get(randomIndex);
	}
	
}
