package UserInterface;

import javax.swing.*;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

import TrafficSystem.TrafficMap;

public class MainFrame {
	
	private JFrame frame;
	private JPanel mainPanel;
	
	private TrafficMap trafficMap;
	
	public MainFrame(TrafficMap tm) {
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		frame.add(new JMapViewer());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		TrafficMap tm = new TrafficMap();
		MainFrame mf = new MainFrame(tm);
	}
	
}
