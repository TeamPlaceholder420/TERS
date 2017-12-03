package TrafficSystem;

import java.util.ArrayList;

public class Route {
	private ArrayList<MNode> nodes = new ArrayList<>();
	private double totalCost = Double.MAX_VALUE;
	private boolean complete = false;
	private MNode target = null;
	
	public Route(MNode target) {
		this.target = target;
	}
	
	public Route pathCopy() {
		Route p = new Route(target);
		p.nodes = (ArrayList<MNode>) nodes.clone();
		p.totalCost = totalCost;
		p.complete = complete;
		p.target = target;
		
		return p;
	}
	
	public void addNode(MNode node, double cost) {
		if(nodes.size() == 1)
			totalCost = 0;
		
		nodes.add(node);
		totalCost += cost;


	}
	
	public void addCost(double cost) {
		totalCost+=cost;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public ArrayList<MNode> getNodes() {
		return nodes;
	}
}
