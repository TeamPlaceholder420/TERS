package TrafficSystem;

import java.util.ArrayList;

public class Road {
	public final static float avgCarLength = 4.5f; //in meters
	
	private int id;
	private MNode p1, p2;
	
	private double length; //in meters
	private int carCount = 0;
	
	private ArrayList<Vehicle> vehicles = new ArrayList<>();
	
	public Road(MNode from, MNode to) {
		p1 = from;
		p2 = to;
		
		length = p1.getDistance(p2);
	}
	
	public double getCost() {
		double maxCars = (length/avgCarLength);
		
		return maxCars;
	};
	
	
	public void addVehicle(Vehicle v) {
		carCount++;
		
		vehicles.add(v);
	}
	
	public void removeVehicle(Vehicle v) {
		if(vehicles.contains(v)) {
			carCount--;
			vehicles.remove(v);
		}
	}
	
	public double getDistance(MPoint m) {
		double A = p2.getLat() - p1.getLat();
		double B = p2.getLon() - p2.getLon();
		
		double C = -p1.getLat()*A - p1.getLon()*B;
		
		double distance = Math.abs(A*m.getLat() + B*m.getLon() + C);
		distance /= Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
		
		return distance;
	}
	
	public MNode getFrom() {
		return p1;
	}
	
	public MNode getTo() {
		return p2;
	}
	
}
