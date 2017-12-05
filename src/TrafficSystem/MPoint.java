package TrafficSystem;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

public class MPoint implements ICoordinate {
	
	double lon, lat;
	public MPoint(double lat, double lon) {
		this.lon = lon;
		this.lat = lat;
	}
	
	@Override
	public double getLat() {
		// TODO Auto-generated method stub
		return lat;
	}

	@Override
	public double getLon() {
		// TODO Auto-generated method stub
		return lon;
	}

	@Override
	public void setLat(double l) {
		lat = l;
		
	}

	@Override
	public void setLon(double l) {
		lon = l;
		
	}
	
	public double getDistance(MPoint to) {
		int EarthRadius = 6371;
	    double latd = Math.toRadians(to.lat - lat);
	    double lond = Math.toRadians(to.lon - lon);
	    double a = Math.sin(latd / 2) * Math.sin(latd / 2)
	            + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(to.lat))
	            * Math.sin(lond / 2) * Math.sin(lond / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = EarthRadius * c * 1000;


	    distance = Math.pow(distance, 2);

	    return distance;
		
	}
	
	public Coordinate toCoordinate() {
		return new Coordinate(lat, lon);
	}

}
