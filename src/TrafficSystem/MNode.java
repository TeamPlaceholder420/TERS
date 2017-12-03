package TrafficSystem;

import java.util.ArrayList;

public class MNode extends MPoint {
	private int id;
	private ArrayList<Road> roads = new ArrayList<>();
	
	public MNode(int id, double x, double y) {
		super(x, y);
		this.id = id;
		
	}
	
	public float getCost(Road inRoad, Road outRoad) {
		return 0.f;
	};
	
	
	public int getIndex() {
		return id;
	}
	
	
	public void addRoad(Road r) {
		roads.add(r);
	}
	
	public ArrayList<Road> getRoads() {
		return roads;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof MNode))
			return false;
		if(obj == this)
			return true;
		
		MNode n = (MNode) obj;
		if(n.id == this.id)
			return true;
		
		return super.equals(obj);
	}
}