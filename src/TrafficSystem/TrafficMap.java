package TrafficSystem;

import java.io.*;
import java.util.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TrafficMap {
	private Intersection[] roadIntersections;
	private Road[] roads;
	
	public TrafficMap() {
		
		System.out.println("Connecting to CRS...");
		CRS crs = new CRS();
		
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
		
	}
	
}

