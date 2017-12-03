package UserInterface;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

import TrafficSystem.MPoint;
import TrafficSystem.Route;
import TrafficSystem.TrafficMap;
import UserInterface.Markers.TNode;

public class MainFrame {
	
	private JFrame frame;
	private JPanel mainPanel;
	
	private TrafficMap trafficMap;
	private RouteRenderer pathRenderer;
	private TrafficMapEditor editor;
	
	public MainFrame(TrafficMap tm) {
		trafficMap = tm;
		
		
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(trafficMap);
		frame.pack();
		
		pathRenderer = new RouteRenderer(tm);
		
		MPoint p1 = new MPoint(25.308746012313282, 55.417935848236084);
		MPoint p2 = new MPoint(25.308105873094362, 55.39040565490723);
		Route p = tm.getRoute(p1, p2);
		pathRenderer.drawPath(p, p1, p2);
		editor = new TrafficMapEditor(frame, trafficMap);
		
		frame.repaint();
	}
	
	public static void main(String[] args) {
		TrafficMap tm = new TrafficMap();
		MainFrame mf = new MainFrame(tm);
		
	}
	
}
