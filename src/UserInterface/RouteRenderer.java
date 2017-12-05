package UserInterface;

import java.awt.Color;
import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import TrafficSystem.*;
import UserInterface.Markers.*;
import Util.Logger;

public class RouteRenderer {
	
	private TrafficMap map;
	private ArrayList<MapMarker> markers = new ArrayList<>();
	
	public RouteRenderer(TrafficMap map) {
		this.map = map;
	}
	
	public void drawPath(Route p, MPoint start, MPoint end) {
		ArrayList<MNode> nodes = p.getNodes();
		int i = 0;
		MPoint prev = start;
		
		for(MNode n : nodes) {
			MapLineMarker l = new MapLineMarker(map, prev, n, Color.BLUE, 4);
			markers.add(l);
			map.addMapMarker(l);
			
			MapMarkerDot dstart = new MapMarkerDot(start.getLat(), start.getLon());
			dstart.setBackColor(Color.BLUE);
			markers.add(dstart);
			map.addMapMarker(dstart);
			
			if(n instanceof MTrafficLight) {
				MTrafficLight tl = (MTrafficLight) n;
				MapMarkerDot r = new MapMarkerDot(n.getLat(), n.getLon());
				if(i==1) {
					r.setBackColor(Color.green);
					r.setColor(Color.green);
					
					Logger.log(new Color(200, 200, 100), "Traffic light state change to green.");
				}	
				else {
					r.setBackColor(tl.getColor());
					r.setColor(tl.getColor());
				}
				
				markers.add(r);
				map.addMapMarker(r);
			}
			
			prev = n;
			i++;
		}
		
		MapLineMarker l = new MapLineMarker(map, prev, end, Color.BLUE, 4);
		markers.add(l);
		map.addMapMarker(l);
		MapMarkerDot dend = new MapMarkerDot(end.getLat(), end.getLon());
		markers.add(dend);
		map.addMapMarker(dend);
	}
	
	public void clear() {
		for(MapMarker m : markers) {
			map.removeMapMarker(m);
		}
	}
	
}
