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
import TrafficSystem.TrafficMap;
import TrafficSystem.Markers.TNode;

public class MainFrame {
	
	private JFrame frame;
	private JPanel mainPanel;
	
	private TrafficMap trafficMap;
	private TrafficMapEditor editor;
	
	public MainFrame(TrafficMap tm) {
		trafficMap = tm;
		
		
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(trafficMap);
		frame.pack();
		
		editor = new TrafficMapEditor(frame, trafficMap);
	}
	
	public static void main(String[] args) {
		TrafficMap tm = new TrafficMap();
		MainFrame mf = new MainFrame(tm);
	}
	
}
