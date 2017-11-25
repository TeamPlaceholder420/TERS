package TrafficSystem;

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

}
