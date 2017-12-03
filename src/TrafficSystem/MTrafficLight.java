package TrafficSystem;

import java.awt.Color;

public class MTrafficLight extends MNode{
	public MTrafficLight(int id, double x, double y) {
		super(id, x, y);
		// TODO Auto-generated constructor stub
	}

	//Traffic light corresponding to each inRoad
	private TrafficLight[] trafficLights;
	
	public Color getColor() {
		return Color.RED;
	}
}

class TrafficLight {
	enum TLSTATE { RED, YELLOW, GREEN };
	
	private float greenTimer, redTimer;
	private TLSTATE state;
}