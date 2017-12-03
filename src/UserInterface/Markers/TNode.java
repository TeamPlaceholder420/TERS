package UserInterface.Markers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Stroke;
import java.lang.reflect.GenericArrayType;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;


public class TNode extends MapMarkerDot {
	
	public int index;
	
	public TNode(double lat, double lon, int i) {
		super(lat, lon);
		// TODO Auto-generated constructor stub
		
		setColor(Color.YELLOW);
		index = i;
		
	}
	
	public boolean isWithin(JMapViewer map, int x, int y) {
		Point p = map.getMapPosition(getCoordinate());
		double r = getRadius();
		if(p == null)
			return false;
		if(x <= p.x + r && x >= p.x - r) {
			if(y <= p.y + r && y >= p.y - r) {
				return true;
			}
		}
		
		return false;
	}


}
