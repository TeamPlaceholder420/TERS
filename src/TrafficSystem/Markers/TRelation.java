package TrafficSystem.Markers;

import java.awt.*;


import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public class TRelation extends MapMarkerDot {
	
	JMapViewer map;
	public TNode from;
	public TNode to;
	
	public TRelation( JMapViewer map, TNode n1, TNode n2) {
		super(Color.BLACK, (n1.getLat() + n2.getLat())/2, (n1.getLon()+n2.getLon())/2);
		// TODO Auto-generated constructor stub
		
		from = n1;
		to = n2;
		
		this.map = map;
	}
	
	@Override
	public void paint(Graphics g, Point position, int radius) {
		// TODO Auto-generated method stub
		
		Point p1 = map.getMapPosition(from.getCoordinate());
		Point p2 = map.getMapPosition(to.getCoordinate());
		
		int sizeH = radius;
        int size = sizeH * 2;

        
        if(p1 != null && p2 != null) {
        
        	g.setColor(getColor());
        	g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        if (getLayer() == null || getLayer().isVisibleTexts()) paintText(g, position);
		
		
		
		//super.paint(g, position, radius);
	}

}
