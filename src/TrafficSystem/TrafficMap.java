package TrafficSystem;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import UserInterface.Markers.TNode;
import UserInterface.Markers.TRelation;

public class TrafficMap extends JMapViewer {
	private MNode[] nodes;
	private Road[] roads;
	CRS crs;
	
	private IPathFinder pathFinder = new LSPathFinder();
	
	public TrafficMap() {
		
		System.out.println("Connecting to CRS...");
		 crs = new CRS();
		
		System.out.println("Requesting map XML file...");
		File mapFile = crs.getMapFile();
		try {
		Scanner in;
		
			in = new Scanner(new FileInputStream(mapFile));
		
		int nodesNum = in.nextInt();
		nodes = new MNode[nodesNum];
		for(int i  = 0; i < nodesNum; i++) {
			double lat = in.nextDouble();
			double lon = in.nextDouble();
			
			MNode n = new MNode(i, lat, lon);
			nodes[i] = n;
		}
		
		int tNum = in.nextInt();
		for(int i = 0; i < tNum; i++) {
			int index = in.nextInt();
			double lat = nodes[index].getLat();
			double lon = nodes[index].getLon();
			
			nodes[index] = new MTrafficLight(index, lat, lon);
		}
		
		
		int rNum = in.nextInt();
		roads = new Road[rNum];
		for(int i = 0; i < rNum; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			
			Road r = new Road(nodes[from], nodes[to]);
			roads[i] = r;
			
			nodes[from].addRoad(r);
			nodes[to].addRoad(r);
		}
		
		
		in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDisplayPosition(new MPoint(25.31454590744707, 55.4124641418457), 13);
		
	}
	
	public CRS getCRSInstance() {
		return crs;
	}
	
	public MNode[] getNodes() {
		return nodes;
	}
	
	public Road[] getRoads() {
		return roads;
	}
	
	public Route getRoute(MPoint from, MPoint to) {
		return pathFinder.getPath(this, from, to);
	}
	
}

