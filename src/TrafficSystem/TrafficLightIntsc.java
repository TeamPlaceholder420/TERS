package TrafficSystem;

class TrafficLightIntsc extends Intersection{
	private TrafficLight[] trafficLights;
}

class TrafficLight {
	enum TLSTATE { RED, YELLOW, GREEN };
	
	private float greenTimer, redTimer;
	private TLSTATE state;
}