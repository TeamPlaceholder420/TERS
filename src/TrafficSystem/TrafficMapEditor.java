package TrafficSystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

import TrafficSystem.Markers.TNode;

class TrafficMapEditor implements MouseListener, KeyListener {
	
	TrafficMap map;
	FileOutputStream out;
	
	ArrayList<TNode> nodes;
	
	public TrafficMapEditor(TrafficMap tm) {
		map = tm;
		
		try {
			out = new FileOutputStream(map.getCRSInstance().getMapFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		
		if(e.isAltDown()) {
			ICoordinate m =  map.getPosition(x, y);
			
			TNode n = new TNode(m.getLat(), m.getLon());
			map.addMapMarker(n);
			nodes.add(n);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void load() {
		
	}
	
	public void save() {
		
	}
	
}
