package TrafficSystem;

class TrafficLightIntsc extends Intersection{
	public TrafficLightIntsc(int id, double x, double y) {
		super(id, x, y);
		// TODO Auto-generated constructor stub
	}

	//Traffic light corresponding to each inRoad
	private TrafficLight[] trafficLights;
}

class TrafficLight {
	enum TLSTATE { RED, YELLOW, GREEN };
	
	private float greenTimer, redTimer;
	private TLSTATE state;
}