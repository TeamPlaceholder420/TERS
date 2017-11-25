package TrafficSystem;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import TrafficSystem.Markers.TNode;

public class TrafficMap extends JMapViewer {
	private Intersection[] roadIntersections;
	private Road[] roads;
	CRS crs;
	
	public TrafficMap() {
		
		System.out.println("Connecting to CRS...");
		 crs = new CRS();
		
		System.out.println("Requesting map XML file...");
		Document mapXML = crs.getRoadsXML();
		
		System.out.println("Loading map: " + mapXML.getDocumentElement().getAttribute("name"));
		NodeList intscs = mapXML.getElementsByTagName("intersection");
		
		System.out.println("Loading " + intscs.getLength() + " intersections...");
		roadIntersections = new Intersection[intscs.getLength()];
		for(int i = 0; i < intscs.getLength(); i++) {
			Element e = (Element) intscs.item(i);
			int id = Integer.parseInt(e.getAttribute("id"));
			double x = Double.parseDouble(e.getAttribute("x"));
			double y = Double.parseDouble(e.getAttribute("y"));
			
			roadIntersections[i] = new Intersection(id, x, y);
			
			System.out.println("Loaded new intersection. ID: " + id + " X: "  + x + " Y: " + y);
			
		}
		
		
		setDisplayPosition(new MPoint(25.31454590744707, 55.4124641418457), 13);
		
		TrafficMapEditor editor = new TrafficMapEditor(this);
		
		addMouseListener(editor);
		
	}
	
	CRS getCRSInstance() {
		return crs;
	}
	
}

