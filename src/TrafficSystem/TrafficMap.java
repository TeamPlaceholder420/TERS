package TrafficSystem;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import Util.Logger;


public class TrafficMap extends JMapViewer {
	private MNode[] nodes;
	private Road[] roads;
	private CRS crs;
	
	private IPathFinder pathFinder = new LSPathFinder();

	public TrafficMap() {
		Logger.log(null, "Connecting to CRS...");
		 crs = new CRS();
		
		Logger.log(null, "Requesting map file...");
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
		Logger.log(Color.BLUE, "Map loading complete.");
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

