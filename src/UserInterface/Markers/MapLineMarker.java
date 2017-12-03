package UserInterface.Markers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import TrafficSystem.MPoint;

public class MapLineMarker extends MapMarkerDot {
	JMapViewer map;
	public MPoint from;
	public MPoint to;
	Color color;
	int lineWidth;
	
	public MapLineMarker( JMapViewer map, MPoint n1, MPoint n2, Color color, int lineWidth) {
		super(color, (n1.getLat() + n2.getLat())/2, (n1.getLon()+n2.getLon())/2);
		// TODO Auto-generated constructor stub
		
		from = n1;
		to = n2;
		
		this.map = map;
		this.color = color;
		this.lineWidth = lineWidth;
	}
	
	@Override
	public void paint(Graphics g, Point position, int radius) {
		// TODO Auto-generated method stub
		
		Point p1 = map.getMapPosition(from.toCoordinate());
		Point p2 = map.getMapPosition(to.toCoordinate());
		
		int sizeH = radius;
        int size = sizeH * 2;

        
        if(p1 != null && p2 != null) {
        	Graphics2D g2 = (Graphics2D) g;
        	g2.setColor(getColor());
        	g2.setStroke(new BasicStroke(lineWidth));
        	g2.draw(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));
        }

        if (getLayer() == null || getLayer().isVisibleTexts()) paintText(g, position);
		
		
		
		//super.paint(g, position, radius);
	}
}
