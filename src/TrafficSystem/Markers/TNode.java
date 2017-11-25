package TrafficSystem.Markers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Stroke;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;


public class TNode extends MapMarkerDot {

	public TNode(double lat, double lon) {
		super(lat, lon);
		// TODO Auto-generated constructor stub
		
		setColor(Color.YELLOW);
	}


}
