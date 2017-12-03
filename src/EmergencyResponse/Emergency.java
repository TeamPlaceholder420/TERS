package EmergencyResponse;

import java.util.Date;

public class Emergency {
	
	
	
	Date date;
	double x,y; //location
	int no_of_involved;
	Type type;
	
	public Emergency(double x, double y, Type type) {
		super();
		this.date = new Date();
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public int getNo_of_involved() {
		return no_of_involved;
	}

	public void setNo_of_involved(int no_of_involved) {
		this.no_of_involved = no_of_involved;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
