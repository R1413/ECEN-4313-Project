import java.util.Random;

public class ControlLogic {
	
	public ControlLogic() {
		// TODO Auto-generated constructor stub
	}
	public int interControl(String prev,Intersection inter,String r){
		Random random =new Random();
		return random.nextInt(2);
	}

}
