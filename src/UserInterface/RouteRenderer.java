package UserInterface;

import java.awt.Color;
import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import TrafficSystem.*;
import UserInterface.Markers.*;

public class RouteRenderer {
	
	private TrafficMap map;
	private ArrayList<MapMarker> markers = new ArrayList<>();
	
	public RouteRenderer(TrafficMap map) {
		this.map = map;
	}
	
	public void drawPath(Route p, MPoint start, MPoint end) {
		ArrayList<MNode> nodes = p.getNodes();
		System.out.println(nodes.toString());
		int i = 0;
		MPoint prev = start;
		
		for(MNode n : nodes) {
			MapLineMarker l = new MapLineMarker(map, prev, n, Color.BLUE, 4);
			markers.add(l);
			map.addMapMarker(l);
			
			if(n instanceof MTrafficLight) {
				MTrafficLight tl = (MTrafficLight) n;
				MapMarkerDot r = new MapMarkerDot(n.getLat(), n.getLon());
				r.setBackColor(tl.getColor());
				r.setColor(tl.getColor());
				
				markers.add(r);
				map.addMapMarker(r);
			}
			
			prev = n;
			i++;
		}
		
		MapLineMarker l = new MapLineMarker(map, prev, end, Color.BLUE, 4);
		markers.add(l);
		map.addMapMarker(l);
	}
	
}
