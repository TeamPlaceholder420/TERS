package Util;

import java.awt.Color;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

import TrafficSystem.TrafficMap;
import UserInterface.Markers.TNode;
import UserInterface.Markers.TRelation;

class TrafficMapEditor implements MouseListener, KeyListener {
	
	TrafficMapEditor instance = null;
	
	TrafficMap map;
	
	ArrayList<TNode> nodes = new ArrayList<>();
	ArrayList<TRelation> relations = new ArrayList<>();
	ArrayList<Integer> trafficlights = new ArrayList<>();
	
	TNode selectedNode = null;
	
	public TrafficMapEditor(JFrame frame, TrafficMap tm) {
		if(instance == null)
			instance = this;
		
		map = tm;
		
		
		
		map.addMouseListener(this);
		frame.addKeyListener(this);
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		ICoordinate m =  map.getPosition(x, y);
		
		System.out.println(m.getLat() + ", " + m.getLon());
		if(e.isAltDown()) {
			//ICoordinate m =  map.getPosition(x, y);
			
			TNode n = new TNode(m.getLat(), m.getLon(), nodes.size());
			map.addMapMarker(n);
			nodes.add(n);
		}
		
		else if(e.isShiftDown()) {
			for(TNode n : nodes) {
				
				if(n.isWithin(map, x, y)) {
					if(selectedNode == null) {
						selectedNode = n;
						n.setColor(Color.red);
						map.repaint();
					} else {
						//ICoordinate m =  map.getPosition(x, y);
						
						TRelation r = new TRelation(map, selectedNode, n);
						relations.add(r);
						map.addMapMarker(r);
						selectedNode.setColor(Color.YELLOW);
						selectedNode = null;
						
					}
				}
					
			}
		}
		
		map.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public void save() {
		
		try 
		 {
			PrintWriter  out = 
		              new PrintWriter ("demo.map", "utf-8");
			out.println(nodes.size());
			for(TNode n : nodes) {
				out.println(n.getLat() + " " + n.getLon());
			}
			
			out.println(trafficlights.size());
			for(Integer i : trafficlights) {
				out.println(i.intValue());
			}
			
			out.println(relations.size());
			for(TRelation r : relations) {
				out.println(r.from.index + " " + r.to.index);
			}
			
			
			
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void load() {
		
		map.removeAllMapMarkers();
		
		try 
		 {
			Scanner in = 
		              new Scanner(new FileInputStream(new File("demo.map")));
			int nodesNum = in.nextInt();
			for(int i  = 0; i < nodesNum; i++) {
				double lat = in.nextDouble();
				double lon = in.nextDouble();
				
				TNode n = new TNode(lat, lon, i);
				nodes.add(n);
				map.addMapMarker(n);
			}
			
			int tNum = in.nextInt();
			for(int i = 0; i < tNum; i++) {
				int from = in.nextInt();
				
				trafficlights.add(from);
			}
			
			int rNum = in.nextInt();
			for(int i = 0; i < rNum; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				
				TRelation r = new TRelation(map, nodes.get(from), nodes.get(to));
				relations.add(r);
				map.addMapMarker(r);
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_F1:
				System.out.println("saving...");
				save();
				break;
			case KeyEvent.VK_F2:
				System.out.println("loading...");
				load();
				break;
			case KeyEvent.VK_T:
				if(selectedNode!= null) {
					
					trafficlights.add(new Integer(selectedNode.index));
					
					selectedNode.setColor(Color.YELLOW);
					selectedNode = null;
				}
				break;
			
		}
		 
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
