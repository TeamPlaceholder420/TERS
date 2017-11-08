package TrafficSystem;

public class Road {
	private int id;
	private Intersection p1, p2;
	
	private boolean oneway;
	private boolean uturnAllowed;
	private int lanes;
	
	
	public float getCost() {
		return 0;
	};
}
