package TrafficSystem;

class Intersection {
	private int id;
	private double x, y;
	private Road[] inRoads;
	private Road[] outRoads;
	
	public Intersection(int id, double x, double y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public float getCost(Road inRoad, Road outRoad) {
		return 0.f;
	};
	
}