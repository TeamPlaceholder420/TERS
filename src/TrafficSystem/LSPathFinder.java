package TrafficSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LSPathFinder implements IPathFinder {

	@Override
	public Route getPath(TrafficMap m, MPoint from, MPoint to) {
		
		MNode[] nodes = m.getNodes();
		//Road[] roads = m.getRoads();
		
		double fromD = nodes[0].getDistance(from);
		MNode fromNode = nodes[0];
		double toD = nodes[0].getDistance(to);
		MNode toNode = nodes[0];
		
		for(MNode n : nodes) {
			double fd = n.getDistance(from);
			double td = n.getDistance(to);
			
			if(fd < fromD) {
				fromD = fd;
				fromNode = n;
			}
			
			if(td < toD) {
				toD = td;
				toNode = n;
			}
		}
		
		HashSet<MNode> visted = new HashSet<>();
		Route p = new Route(toNode);
		p.addNode(fromNode, 0);
		ArrayList<Route> paths = new ArrayList<>();
		
		paths.add(p);
		
		while(!fromNode.equals(toNode)) {
			if(visted.size() == nodes.length)
				break;
			//if(visted.contains(fromNode)) {
			//	p.addCost();
			//}
			
			visted.add(fromNode);
			ArrayList<Road> roads = fromNode.getRoads();

			
			for(int i = 0; i < roads.size(); i++) {
				Road r = roads.get(i);
				double cost = r.getCost();
				
				MNode cnode = r.getFrom();
				if(visted.contains(cnode)) {
					cnode = r.getTo();
					if(visted.contains(cnode))
						continue;
				}
				
				Route np = (Route) p.pathCopy();
				np.addNode(cnode, cost);
				paths.add(np);

				visted.add(cnode);
		
			}
			paths.remove(p);
			double minTotalCost = paths.get(0).getTotalCost();
			for(Route path : paths) {
				if(path.getTotalCost() <= minTotalCost)
					p = path;
			}
			
			ArrayList<MNode> pnodes = p.getNodes();
			fromNode = pnodes.get(pnodes.size()-1);
			
			
			
		}
		
		return p;
	}
	

		
	
}
