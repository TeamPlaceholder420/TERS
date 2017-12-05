package Tests;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

import TrafficSystem.MNode;
import TrafficSystem.MPoint;
import TrafficSystem.Route;
import TrafficSystem.TrafficMap;
import UserInterface.Login;
import UserInterface.Main;
import UserInterface.RouteRenderer;
import Util.Logger;;

public class Demo {
	
	static ArrayList<RouteAux> routes = new ArrayList<>();
	public static void main(String[] args) {
		TrafficMap m = new TrafficMap();
		RouteRenderer rr = new RouteRenderer(m);
		Random rand = new Random();
		Main frame = new Main(m);
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
                //frame = new Main(m);
                frame.setVisible(false);
            }
        });
		
		Login login = new Login(frame);
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                //login = new Login(frame);
	                login.setVisible(true);
	            }
	        });
		 
		 
		 
		MPoint p1 = new MPoint(25.308746012313282, 55.417935848236084);
		//Route p = m.getRoute(p1, p2);
		//rr.drawPath(p, p1, p2);
		 m.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(e.isAltDown()) {
				int x = e.getX();
				int y = e.getY();
				
					ICoordinate coord = m.getPosition(x, y);
					MPoint c = new MPoint(coord.getLat(), coord.getLon());
					
					Logger.log(Color.red, "Emergency Registered at (lat=" + c.getLat() + ", lon= " + c.getLon() + ").");
					
					MNode[] nodes = m.getNodes();
					
					int vehindex = Math.abs(rand.nextInt())%nodes.length;
					MNode vehNode = nodes[vehindex];
					
					Logger.log(new Color(200, 200, 100), "Available emergency vehicle found at (lat=" + vehNode.getLat() + ", lon= " + vehNode.getLon() + ").\n"
							+ "Calculating Route...");
					
					Route r = m.getRoute(vehNode, c);
					routes.add(new RouteAux(r, vehNode, c));
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		 
		 Timer t = new Timer(3000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rr.clear();
				for(RouteAux r : routes) {
					if(r.from == null) {
						continue;
					}
					
					r.r.toNext();
					r.from = r.r.getFirst();
					if(r.from == null) {
						Logger.log(new Color(150, 200, 150), "Emergency response successful.");
					}
					else
						rr.drawPath(r.r, r.from, r.to);
				}
				
			}
		});
		t.start();
	}
}

class RouteAux {
	public Route r;
	public MPoint from;
	public MPoint to;
	
	public RouteAux(Route r, MPoint f, MPoint t) {
		this.r = r;
		from = f;
		to = t;
	}
}
