package EmergencyResponse;

public abstract class EVehicle {
	
	int priority;
	double x, y; //location
		
	
	
	abstract void requestRoute(); //changes depending on the vehicle's priority if priority routing is used in later iterations
	
	
	public EVehicle(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		priority = 0;
	}
	
	public int getPriority() {
		return priority;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

}
