package TrafficSystem;

public class Road {
	public final static float avgCarLength = 4.5f; //in meters
	
	private int id;
	private Intersection p1, p2;
	
	private boolean oneway;
	private boolean uturnAllowed;
	private int lanes;
	
	private float length; //in meters
	
	private int carCount = 0;
	
	
	public float getCost() {
		return 0;
	};
	
	public float getCongestionRating(){
		
		float maxCars = (length/avgCarLength)*lanes;
		
		return carCount/maxCars;
	}
}
