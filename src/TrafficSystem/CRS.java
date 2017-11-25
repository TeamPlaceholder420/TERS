package TrafficSystem;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.xml.sax.helpers.DefaultHandler;

class CRS {
	
	File file;
	
	public CRS() {
		file = new File("demo.map");

	}
	
	public boolean isConnected() {
		return true;
		
	}

	public Document getRoadsXML() {
		
		try {
		File file = new File("map.xml"); 
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		return doc;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public File getMapFile() {
		return file;
	}
}
